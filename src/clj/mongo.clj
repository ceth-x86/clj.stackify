(ns clj.mongo
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.operators :refer :all]))

; TODO: environment variables
(def ^:const host "192.168.1.71")
(def ^:const port 27017)
(def ^:const db-name "stack")

(defn get-connection []
  (let [conn (mg/connect { :host host :port port })]
    (mg/get-db conn db-name)))

(def db (get-connection))

(defn find-by-id [id]
  (mc/find-by-id db "questions" id))

(defn insert-question [question]
  (let [doc (assoc question :_id (:id question))
        not_exist (nil? (find-by-id (:id question)))]
    (if not_exist (mc/insert db "questions" doc))))

(defn insert-questions [questions]
  (doseq [q questions] (insert-question q)))

(defn sections []
  (mc/aggregate db "questions" [{$group {:_id "$first" :count {$sum 1}}}] :cursor {:batch-size 100}))

(defn sub-sections [section]
  (mc/aggregate db "questions" [{$match { :first section }},
                                {$group { :_id "$second" :count {$sum 1} }}] :cursor {:batch-size 100}))
