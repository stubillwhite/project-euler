(ns project-euler.problem-0001-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0001]))

(fact
  (multiples-of-three-and-five 10) => 23)

