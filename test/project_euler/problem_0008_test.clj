(ns project-euler.problem-0008-test
  (:use
    [expectations]
    [project-euler.problem-0008]))

(expect 5832 (max-product-of-n-adjacent-digits 4))
