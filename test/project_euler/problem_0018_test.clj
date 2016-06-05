(ns project-euler.problem-0018-test
  (:require [project-euler.problem-0018 :refer :all]
            [clojure.test :refer :all]))

(def example-triangle
  [[3]
   [7 4]
   [2 4 6]
   [8 5 9 3]])

(deftest maximal-route-given-sample-input-then-sample-output
  (is (= (maximal-route example-triangle) 23)))

