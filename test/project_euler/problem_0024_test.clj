(ns project-euler.problem-0024-test
  (:require [project-euler.problem-0024 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= [2 1 0] (nth-permutation (range 3) 6))))
