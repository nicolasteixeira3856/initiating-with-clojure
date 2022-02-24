(ns projeto.core
  (:require [clojure.data.json :as json]
            [clojure.string :as str]))

;(defn soma [a b]
;  (+ a b))
;
;(+ 1 2)
;
;[6 "test" 9 {"nome" "Nicolas"}]
;{"nome" "Nicolas"
; "list" '(6 "test" 9)}
;'(6 "test" 9)
;#{1 2 3 1}
;
;(def nomee "Nicolas")
;
;nomee
;
;:casa
;
;(def pessoa {:nome "Nicolas" :idade 23 "cidade" "Curitiba"})
;
;(get pessoa "cidade")
;(:nome pessoa)

(def url "https://raw.githubusercontent.com/jeffreylancaster/game-of-thrones/master/data/characters.json")

(def content (slurp url))

;(defn nutella [k]
;  keyword)

(keyword "asdfsdaf")
(def characters (:characters (json/read-str content
                                            :key-fn
                                            keyword)))

(count characters)

(take 3 characters)

(reverse (sort (set (map :characterName characters))))

(defn pessoa-nome [personagem]
  (str/upper-case (:characterName personagem)))

(map pessoa-nome characters)

(filter (fn [character]
          (clojure.string/starts-with? character "King"))
        (map :characterName characters))
