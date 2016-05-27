(ns project-euler.problem-0015-test
  (:require [clojure.test :refer :all]
            [project-euler.problem-0015 :refer :all]))

(deftest factorial-then-expected-value
  (is (= 6   (factorial 3)))
  (is (= 24  (factorial 4)))
  (is (= 120 (factorial 5))))
