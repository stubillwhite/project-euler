(ns project-euler.problem-0004-test
  (:use
    [expectations]
    [project-euler.problem-0004]))

(expect 9009 (reduce max (palindromic-numbers two-digit-products)))

