(ns clj.stackify
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj.configuration :as config])
  (:gen-class))

(def cli-options
  [["-h" "--help"]])

(defn -main [& args]
  (let [options (parse-opts args cli-options)
        argument ((:arguments options) 0)]

    (case argument
      "init" (config/init))
    ))
