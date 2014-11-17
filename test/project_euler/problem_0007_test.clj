(ns project-euler.problem-0007-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0007]))

(fact
  (nth primes 6) => 13)
