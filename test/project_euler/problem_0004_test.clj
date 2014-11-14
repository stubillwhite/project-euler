(ns project-euler.problem-0004-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0004]))

(fact
  (reduce max (palindromic-numbers two-digit-products)) => 9009)

