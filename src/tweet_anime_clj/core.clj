(ns tweet-anime-clj.core
  (:require [tweet-anime-clj.animemap :refer :all])
  (:import [twitter4j TwitterFactory Query TwitterException]))

;; tweet (String -> Unit)
(defn tweet [content]
  (let [twitter (. (TwitterFactory.) getInstance)]
    (.updateStatus twitter content)))

(defn get-content-length [content]
  (count content))

(defn is-less-than-140? [content]
  (< count content))

(defn -main []
  (doall (map #(tweet %) content)))
