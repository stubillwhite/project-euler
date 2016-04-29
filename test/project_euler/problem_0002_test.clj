(ns project-euler.problem-0002-test
  (:require [project-euler.problem-0002 :refer :all]
            [clojure.test :refer :all]))

(deftest fibonacci-then-returns-fibonacci-sequence
  (is (= [0 1 1 2 3 5 8 13 21 34 55 89 144]
         (take 13 fibonacci))))
