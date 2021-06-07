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

(defn get-on-a-boat [pos target]
  (push (second pos) target))

(defn get-off-the-boat [pos target]
  (pop (second pos) target))

(defn landing-on-the-island [pos target]
  (push (last pos) target))

(defn out-off-the-island [pos target]
  (pop (last pos) target))

(defn landing-on-land [pos target]
  (push (first pos) target))

(defn out-off-the-land [pos target]
  (pop (first pos) target))

;; (defn cur-pos [pos]
;;   (let [step (count pos) cur-pos (last pos)]
;;     (cond (= step 1) (conj pos 
          

(defn make-plan [])

(defn river-crossing-plan []
  start-pos)
