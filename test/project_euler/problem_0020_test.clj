(ns project-euler.problem-0020-test
  (:require [project-euler.problem-0020 :refer :all]
            [clojure.test :refer :all]))

(deftest sum-of-factorial-digits-given-sample-input-then-expected-result
  (is (= (sum-of-factorial-digits 10) 27)))
