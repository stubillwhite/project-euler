(ns project-euler.problem-0024-test
  (:use
   [expectations]
   [project-euler.problem-0024]))

(expect [2 1 0] (nth-permutation (range 3) 6))
