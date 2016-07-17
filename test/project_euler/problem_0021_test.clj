(ns project-euler.problem-0021-test
  (:require [project-euler.problem-0021 :refer :all]
            [clojure.test :refer :all]))

(deftest sum-of-proper-divisors-given-sample-input-then-expected-result
  (is (= (sum-of-proper-divisors 284) 220))
  (is (= (sum-of-proper-divisors 220) 284)))

