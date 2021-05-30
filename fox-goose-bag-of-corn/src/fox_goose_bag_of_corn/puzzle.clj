(ns fox-goose-bag-of-corn.puzzle)

;; (def start-pos [[[:fox :goose :corn :you] [:boat] []])
(def start-pos [[[:fox :goose :corn :you] [:boat] []]
                [[:fox :corn] [:boat :you :goose] []]
                [[:fox :corn] [:boat :you] [:goose]]
                [[:fox] [:boat :you :corn] [:goose]]
                [[:fox] [:boat :you :goose] [:corn]]
                [[:goose] [:boat :you :fox] [:corn]]
                [[:goose] [:boat :you] [:corn :fox]]
                [[] [:boat :you :goose] [:corn :fox]]
                [[] [:boat :you] [:corn :fox :goose]]
                [[] [:boat] [:you :corn :fox :goose]]
                ])

;; (def land (first (first start-pos)))

;; (def boat (second (first start-pos)))

;; (def boat (last (first start-pos)))

;; (defn on-the-boat [x]
  

(defn river-crossing-plan []
  start-pos)
