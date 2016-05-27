(ns project-euler.problem-0016
  (:require [clojure.math.numeric-tower :refer [expt]]))

;; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;;
;; What is the sum of the digits of the number 2^1000?

;; Solution
;;
;; Can't see any faster way to do this than the obvious...

(defn- char-to-long [x] (Long. (str x)))

(defn calculate-answer []
  (reduce + (map char-to-long (vec (str (expt 2 1000))))))


