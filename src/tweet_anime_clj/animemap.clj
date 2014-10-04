(ns tweet-anime-clj.animemap
    (:require [clojure.data.json :as json]
            [postal.core :as postal]))

(def anime (slurp "http://animemap.net/api/table/tokyo.json"))

; today's anime
(def today
  (->> (vec (:item (:response (json/read-str anime :key-fn keyword))))
       (filter #(= (:today %) "1"))))

(defn make-txt [source]
  (str "【" (:station source) "】"
       (:title source)
       " " (:next source)
       " - " (:time source) " 〜"
       "\n"))

(def content (map #(make-txt %) today))
