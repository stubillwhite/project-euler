(ns project-euler.problem-0003-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0003]))

(fact
  (sort (prime-factors 13195)) => [5 7 13 29])

(fact
  (sort (prime-factors 25)) => [5])