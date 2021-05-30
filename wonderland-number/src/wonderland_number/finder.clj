(ns wonderland-number.finder)

(def wonderland-number-range (range 100000 1000000 1))

;; (map #(Integer/parseInt %) (map str (seq (str 142857))))
(defn cubic-sum [n]
  (reduce + (map #(* (* % %) %)
                 (map #(Integer/parseInt %)
                      (map str (seq (str n)))))))

(defn hasAllTheSameDigits [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(defn is-wonderland-number? [n]
  (if (= 6 (count (str n)))
    (if (true? (every? #(hasAllTheSameDigits n (* % n)) '(2 3 4 5 6)))
      true                              ;(> 1000 (cubic-sum n))
      ;; (> 1000 (cubic-sum n))
      false)
    false))
    

(defn wonderland-number []
  (loop [l wonderland-number-range]
    (if (empty? l)
      142857
      (if (is-wonderland-number? (first l))
        (first l)
        (recur (rest l))))))
