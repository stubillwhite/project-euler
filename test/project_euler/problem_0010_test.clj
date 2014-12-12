(ns project-euler.problem-0010-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0010]))

(fact
  (prime? 3) => true
  (prime? 4) => false)
