(ns project-euler.problem-0002-test
  (:use
    [expectations]
    [project-euler.problem-0002]))

(expect [0 1 1 2 3 5 8 13 21 34 55 89 144] (take 13 fibonacci))

