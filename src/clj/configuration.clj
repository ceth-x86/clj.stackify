(ns clj.configuration
  (:require [clj.utils :as utils]))

(def ^:const configFileName "last_sync_time")

(defn save-time [value]
  "save value to configuration file; file will be overwritten"
  (spit configFileName value))

(defn read-time []
  "read last sync time from configuration file"
  (let [value (slurp configFileName)]
    (utils/parse-int value)))

(defn init []
  "initilization configuration file"
  (save-time (utils/current-time)))
