(ns alphabet-cipher.coder
  (:require [clojure.string :refer [index-of]]))

(def alphabet-count 26)
;; (def alphabet-range  (take alphabet-count (iterate #(char (+ 1 (int %))) \a)))
(def alphabet-range (map char (range (int \a) (+ (int \z) 1) 1)))

(defn get-alphabet-index [x]
  (- (int x) (int \a)))

(defn get-alphabet-cycle [start-ch]
  (take-last alphabet-count 
             (take (+ (get-alphabet-index start-ch) alphabet-count) (cycle alphabet-range))))

;; (defn get-alphabet-cycle [start-ch]
;;   (take alphabet-count (iterate #(char (+ 1 (int %))) start-ch)))

;; (partition 2 (interleave (seq "meetmebythetree") (cycle (seq "scones"))))

;; (defn encode [keyword message]
;;   (apply #(nth (get-alphabet-cycle (first %)) (get-alphabet-index (second %)))
;;        (partition 2 (interleave (seq message) (cycle (seq keyword))))))


(defn pair-key-message [keyword message]
  (partition 2 (interleave (seq message) (cycle (seq keyword)))))

;; (= message "meetmebythetree")
;; (= keyword "scones") 
;; (= (encode keyword message) "egsgqwtahuiljgs")
(defn encode [keyword message]
  (apply str 
         (map #(nth (get-alphabet-cycle (first %)) (get-alphabet-index (second %)))
              (pair-key-message keyword message))))

;; (= message "egsgqwtahuiljgs")
;; (= keyword "scones") 
;; (= (decode "scones" "egsgqwtahuiljgs") "meetmebythetree")
(defn decode [keyword message]
  (apply str
         (map #(nth (get-alphabet-cycle \a) 
                    (mod (+ (- alphabet-count (get-alphabet-index (second %)))
                            (get-alphabet-index (first %))) alphabet-count))
              (pair-key-message keyword message))))
              
(defn get-index-alphabet-cycle [ch cy]
  (index-of (apply str cy) ch))

(defn split-in-two [s]
  (let [mid (/ (count s) 2)]
    (split-at mid s)))

;; 두개의 문자열을 비교하며 뒤에서 부터 잘라낸다.
(defn get-key-string[s]
  (loop [origin s target s]
    (let [left  (apply str (first (split-in-two target)))
          right (apply str (second (split-in-two target)))]
      (if (empty? target)
        origin
        (if (and (= left right) (not (= (first (split-in-two left))
                                        (second (split-in-two left)))))
          left
          (recur origin (apply str (drop-last target))))))))

(defn decipher [cipher message]
  (get-key-string
   (apply str
          (map #(nth (get-alphabet-cycle \a)
                     (get-index-alphabet-cycle (second %) (get-alphabet-cycle (first %))))
               (partition 2 (interleave (seq message) (seq cipher)))))))
