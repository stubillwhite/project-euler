(ns project-euler.problem-0001-test
  (:use
    [expectations]
    [project-euler.problem-0001]))

(expect 23 (multiples-of-three-and-five 10))

