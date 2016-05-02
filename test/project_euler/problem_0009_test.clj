(ns project-euler.problem-0009-test
  (:require [project-euler.problem-0009 :refer :all]
            [clojure.test :refer :all]))

(deftest pythagorean-triplet?-given-non-triplet-then-false
  (is (= false (pythagorean-triplet? 1 2 3))))

(deftest pythagorean-triplet?-given-triplet-then-true
  (is (= true (pythagorean-triplet? 3 4 5))))
