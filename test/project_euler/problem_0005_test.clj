(ns project-euler.problem-0005-test
  (:use
    [expectations]
    [project-euler.problem-0005]))

(expect 2520 (apply lcm (range 1 11)))
