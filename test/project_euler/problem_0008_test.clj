(ns project-euler.problem-0008-test
  (:require [project-euler.problem-0008 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= 5832 (max-product-of-n-adjacent-digits 4))))



