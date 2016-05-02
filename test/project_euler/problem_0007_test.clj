(ns project-euler.problem-0007-test
  (:require [project-euler.problem-0007 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= 13 (nth primes 6))))


