(ns project-euler.problem-0003-test
  (:use
    [expectations]
    [project-euler.problem-0003]))

(expect [5 7 13 29] (sort (prime-factors 13195)))

(expect [5] (sort (prime-factors 25)))
