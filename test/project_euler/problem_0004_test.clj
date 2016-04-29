(ns project-euler.problem-0004-test
  (:require [project-euler.problem-0004 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= 9009 (reduce max (palindromic-numbers two-digit-products)))))
