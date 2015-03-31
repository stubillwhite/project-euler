(ns project-euler.problem-0006-test
  (:use
    [expectations]
    [project-euler.problem-0006]))

(expect 385 (sum-of-squares 10))

(expect 3025 (square-of-sum 10))
