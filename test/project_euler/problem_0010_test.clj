(ns project-euler.problem-0010-test
  (:use
    [expectations]
    [project-euler.problem-0010]))

(expect true (prime? 3))

(expect false (prime? 4))
