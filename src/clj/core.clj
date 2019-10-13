(ns clj.core
  (:require [clojure.string :as str]
            [clj-http.client :as client]
            [clojure.data.json :as json]
            [clj.utils :as utils]
            [clj.configuration :as config]
            [clj.classificator :as classificator]))

; TODO: move key to environment variables
(def ^:const stackKey "fynFeDpzL1maIki1j1eLQw((")
(def ^:const baseUrl "https://api.stackexchange.com/2.2/questions?page=%d&pagesize=100&fromdate=%d&order=asc&sort=creation&site=%s&key=%s")

; Fetch questions
(defn fetch-json [url]
  "fetch internet page by url and return JSON"
  (let [data (client/get url)
        body (get data :body)]

    (json/read-str body)))

(defn fetch-questions [page from site accum]
  "recursive function to get questions"
  (let [url (format baseUrl page from site stackKey)
        json-content (fetch-json url)
        questions (get json-content "items")
        has_more (get json-content "has_more")]

    (println (format "Fetching page %d (has_more=%b)" page has_more))

    (cond
      (= has_more true) (fetch-questions (+ page 1) from site (concat accum questions))
      :else (concat accum questions))
    ))

; TODO: refactore (partial function)
(defn transform-data [element]
  "Present questions from site like this:
  {:id 27715, :tags ['python' 'machine-learning'], :site 'stackoverflow}"
  {:id (get element "question_id"), :tags (get element "tags"),
   :site (get element "site"), :title (get element "title"), :score (get element "score"),
   :link (get element "link"), :creation_date (get element "creation_date")})

(defn get-questions []
  (let [from (config/read-time)
        now (utils/current-time)]

    (println from)
    (config/save-time now)

    (->> (fetch-questions 1 from "stackoverflow" (vector))
         (map #(assoc % "site" "stackoverflow"))
         (map transform-data))))
