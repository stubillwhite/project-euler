(ns project-euler.problem-0007-test
  (:use
    [expectations]
    [project-euler.problem-0007]))

(expect 13 (nth primes 6))
