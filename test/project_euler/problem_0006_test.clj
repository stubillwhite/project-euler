(ns project-euler.problem-0006-test
  (:require [project-euler.problem-0006 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= 385 (sum-of-squares 10)))
  (is (= 3025 (square-of-sum 10))))

