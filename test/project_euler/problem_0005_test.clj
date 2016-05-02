(ns project-euler.problem-0005-test
  (:require [project-euler.problem-0005 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= 2520 (apply lcm (range 1 11)))))
