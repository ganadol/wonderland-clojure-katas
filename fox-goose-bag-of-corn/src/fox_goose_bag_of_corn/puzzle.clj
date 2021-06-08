(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(def dest-pos [[[:fox :goose :corn :you] [:boat] []] ;1
               [[:fox :corn] [:boat :you :goose] []] ;2
               [[:fox :corn] [:boat] [:you :goose]]  ;3
               [[:fox :corn] [:boat :you] [:goose]]  ;4
               [[:fox :corn :you] [:boat] [:goose]]  ;5
               [[:fox] [:boat :you :corn] [:goose]]  ;6
               [[:fox] [:boat] [:you :corn :goose]]  ;7
               [[:fox] [:boat :you :goose] [:corn]]  ;8
               [[:fox :you :goose] [:boat] [:corn]]  ;9
               [[:goose] [:boat :you :fox] [:corn]]  ;10
               [[:goose] [:boat] [:corn :you :fox]]  ;11
               [[:goose] [:boat :you] [:corn :fox]]  ;12
               [[:goose :you] [:boat] [:corn :fox]]  ;13
               [[] [:boat :you :goose] [:corn :fox]] ;14
               [[] [:boat] [:you :corn :fox :goose]] ;15
               ])

;; (def land (first (first start-pos)))

;; (def boat (second (first start-pos)))

;; (def boat (last (first start-pos)))


(defn pop [seq target]
  (vec (disj (set seq) target)))

(defn push [seq target]
  (conj seq target))

(defn get-boat [pos]
  (second pos))

(defn get-land [pos]
  (first pos))

(defn get-island [pos]
  (last pos))

(defn put-target [pos a b]
  (if (nil? b)
    (push pos a)
    (push (push pos a) b)))

(defn pop-target [pos a b]
  (if (nil? b)
    (pop pos a)
    (pop (pop pos a) b)))


(defn pop-land [pos a b]
  (pop-target (get-land pos) a b))

(defn put-land [pos a b]
  (put-target (get-land pos) a b))

(defn pop-boat [pos a b]
  (pop-target (get-boat pos) a b))

(defn put-boat [pos a b]
  (put-target (get-boat pos) a b))

(defn pop-island [pos a b]
  (pop-target (get-island pos) a b))

(defn put-island [pos a b]
  (put-target (get-island pos) a b))

(defn run-plan [pos land boat island]
  (conj pos (-> [] (conj land) (conj boat) (conj island))))

(defn current-pos [pos]
  (let [step (count pos) cur-pos (last pos)]
    (cond (or (= step 1) (= step 13))
          (current-pos (run-plan pos (pop-land cur-pos :you :goose)
                                 (put-boat cur-pos :you :goose)
                                 (get-island cur-pos)))
          
          (or (= step 2) (= step 14))
          (current-pos (run-plan pos (get-land cur-pos)
                                 (pop-boat cur-pos :you :goose)
                                 (put-island cur-pos :you :goose)))
          
          (or (= step 3) (= step 11))
          (current-pos (run-plan pos (get-land cur-pos)
                                 (put-boat cur-pos :you nil)
                                 (pop-island cur-pos :you nil)))
          
          (or (= step 4) (= step 12))
          (current-pos (run-plan pos (put-land cur-pos :you nil)
                                 (pop-boat cur-pos :you nil)
                                 (get-island cur-pos)))
          
          (= step 5)
          (current-pos (run-plan pos (pop-land cur-pos :you :corn)
                                 (put-boat cur-pos :you :corn)
                                 (get-island cur-pos)))
          
          (= step 6)
          (current-pos (run-plan pos (get-land cur-pos)
                                 (pop-boat cur-pos :you :corn)
                                 (put-island cur-pos :you :corn)))
          
          (= step 7)
          (current-pos (run-plan pos (get-land cur-pos)
                                 (put-boat cur-pos :you :goose)
                                 (pop-island cur-pos :you :goose)))
          
          (= step 8)
          (current-pos (run-plan pos (put-land cur-pos :you :goose)
                                 (pop-boat cur-pos :you :goose)
                                 (get-island cur-pos)))
          
          (= step 9)
          (current-pos (run-plan pos (pop-land cur-pos :you :fox)
                                 (put-boat cur-pos :you :fox)
                                 (get-island cur-pos)))
          
          (= step 10)
          (current-pos (run-plan pos (get-land cur-pos)
                                 (pop-boat cur-pos :you :fox)
                                 (put-island cur-pos :you :fox)))
          :else pos)))
          
(defn river-crossing-plan []
  (current-pos start-pos))
