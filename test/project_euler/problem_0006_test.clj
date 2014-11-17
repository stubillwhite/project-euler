(ns project-euler.problem-0006-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0006]))

(fact
  (sum-of-squares 10) => 385)

(fact
  (square-of-sum 10) => 3025)
