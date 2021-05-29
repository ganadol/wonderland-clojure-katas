(ns wonderland-number.finder)

(def wonderland-number-range (range 100000 1000000 1))

(defn hasAllTheSameDigits [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(defn is-wonderland-number? [n]
  (if (= 6 (count (str n)))
    (every? #(hasAllTheSameDigits n (* % n)) '(2 3 4 5 6))
    false))

(defn wonderland-number []
  (loop [l wonderland-number-range]
    (if (is-wonderland-number? (first l))
      (first l)
      (recur (rest l)))))
