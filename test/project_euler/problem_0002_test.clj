(ns project-euler.problem-0002-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0002]))

(fact
  (take 13 fibonacci) => [0 1 1 2 3 5 8 13 21 34 55 89 144])

