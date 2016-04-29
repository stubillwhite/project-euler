(ns user
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application."
  (:require [clojure
             [pprint :refer [pprint print-table]]
             [reflect :refer [reflect]]
             [repl :refer [apropos dir doc find-doc pst source]]
             [set :as set]
             [stacktrace :refer [print-stack-trace]]
             [string :as str]
             [test :as test]]
            [clojure.java
             [io :as io]
             [javadoc :refer [javadoc]]]
            [clojure.tools.namespace.repl :refer [refresh refresh-all]]
            [clojure.tools.trace :refer [trace-ns untrace-ns]]
            [project-euler
             [charting :as charting]
             [system :as system]]))

(defn print-methods [x]
  "Print the methods on x."
  (print-table
   (sort-by :name (filter :exception-types (:members (reflect x))))))

(defn print-memory-usage []
  (let [runtime (Runtime/getRuntime)
        total   (.totalMemory runtime)
        free    (.freeMemory runtime)]
    (println (format"Used %,d bytes, Free %,d bytes, Total %,d bytes"
                    free (- total free) total))))

(def system
  "A Var containing an object representing the application under development."
  nil)

(defn init
  "Creates and initializes the system under development in the Var #'system."
  []
  (alter-var-root #'system
    (constantly (system/system))))

(defn start
  "Starts the system running, updates the Var #'system."
  []
  (alter-var-root #'system system/start))

(defn stop
  "Stops the system if it is currently running, updates the Var #'system."
  []
  (alter-var-root #'system
    (fn [s] (when s (system/stop s)))))

(defn go
  "Initializes and starts the system running."
  []
  (init)
  (start)
  :ready)

(defn reset
  "Stops the system, reloads modified source files, and restarts it."
  []
  (stop)
  (refresh :after 'user/go))
