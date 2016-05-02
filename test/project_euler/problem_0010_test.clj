(ns project-euler.problem-0010-test
  (:require [project-euler.problem-0010 :refer :all]
            [clojure.test :refer :all]))

(deftest prime?-given-non-prime-then-true
  (is (= true (prime? 3))))

(deftest prime?-given-non-prime-then-false
  (is (= false (prime? 4))))
