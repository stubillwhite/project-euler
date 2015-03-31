(ns project-euler.problem-0009-test
  (:use
    [expectations]
    [project-euler.problem-0009]))

(expect false (pythagorean-triplet? 1 2 3))

(expect true (pythagorean-triplet? 3 4 5))
