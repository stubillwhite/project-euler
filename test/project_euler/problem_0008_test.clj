(ns project-euler.problem-0008-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0008]))

(fact
  (max-product-of-n-adjacent-digits 4) => 5832)
