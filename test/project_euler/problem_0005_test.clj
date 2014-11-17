(ns project-euler.problem-0005-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0005]))

(fact
  (apply lcm (range 1 11)) => 2520)
