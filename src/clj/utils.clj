(ns clj.utils
  (:require [clj-time.core :as time]
            [clj-time.coerce :as tc]))

(defn current-time []
  "returns unix time"
  (let [moment (tc/to-long (time/now))]
    (int (/ moment 1000))))

(defn parse-int [s]
  "convert string to int"
  (Integer. (re-find  #"\d+" s )))
