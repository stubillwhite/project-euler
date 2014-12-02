(ns project-euler.problem-0009-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0009]))

(fact
  (pythagorean-triplet? 1 2 3) => false
  (pythagorean-triplet? 3 4 5) => true)
