(ns alphabet-cipher.coder)

(def alphabet-count 26)
(def alphabet-range  (take alphabet-count (iterate #(char (+ 1 (int %))) \a)))

(defn get-alphabet-num [x]
  (loop [x x l alphabet-range cnt 0]
    (if (= x (first l))
      cnt
      (recur x (rest l) (inc cnt)))))

(defn get-alphabet-cycle [start-ch]
  (take-last alphabet-count 
             (take (+ (get-alphabet-num start-ch) alphabet-count) (cycle alphabet-range))))

;; test
(def A (get-alphabet-cycle \a))         ;0
(def B (get-alphabet-cycle \b))         ;1
(def C (get-alphabet-cycle \c))         ;2
(def D (get-alphabet-cycle \d))         ;3
(def E (get-alphabet-cycle \e))         ;4
(def F (get-alphabet-cycle \f))         ;5
(def G (get-alphabet-cycle \g))         ;6
(def H (get-alphabet-cycle \h))         ;7
(def I (get-alphabet-cycle \i))         ;8
(def J (get-alphabet-cycle \j))         ;9
(def K (get-alphabet-cycle \k))         ;10
(def L (get-alphabet-cycle \l))         ;11
(def M (get-alphabet-cycle \m))         ;12
(def N (get-alphabet-cycle \n))         ;13
(def O (get-alphabet-cycle \o))         ;14
(def P (get-alphabet-cycle \p))         ;15
(def Q (get-alphabet-cycle \q))         ;16
(def R (get-alphabet-cycle \r))         ;17
(def S (get-alphabet-cycle \s))         ;18
(def T (get-alphabet-cycle \t))         ;19
(def U (get-alphabet-cycle \u))         ;20
(def V (get-alphabet-cycle \v))         ;21
(def W (get-alphabet-cycle \w))         ;22
(def X (get-alphabet-cycle \x))         ;23
(def Y (get-alphabet-cycle \y))         ;24
(def Z (get-alphabet-cycle \z))         ;25


;; (partition 2 (interleave (seq "meetmebythetree") (cycle (seq "scones"))))

(defn encode [keyword message]
  
  )

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

