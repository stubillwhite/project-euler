(ns project-euler.problem-0001-test
  (:require [project-euler.problem-0001 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= 23 (multiples-of-three-and-five 10))))


