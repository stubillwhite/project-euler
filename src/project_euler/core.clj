(ns project-euler.core
  (:require
    [taoensso.timbre :as timbre]))

(timbre/refer-timbre)

(defn foo
  ([x] 
    (+ x 1)))
