(ns clj.stackify
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj.configuration :as config]
            [clj.core :as core]
            [clj.classificator :as classificator]
            [clj.mongo :as mongo])
  (:gen-class))

(def cli-options
  [["-h" "--help"]])

(defn -main [& args]
  (let [options (parse-opts args cli-options)
        argument ((:arguments options) 0)]

    (case argument
      "init" (config/init)
      "get" ( ->> (core/get-questions)
                  (classificator/classify)
                  (mongo/insert-questions)))
    ))
