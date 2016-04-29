(ns project-euler.problem-0003-test
  (:require [project-euler.problem-0003 :refer :all]
            [clojure.test :refer :all]))

(deftest example-input-then-example-output
  (is (= [5 7 13 29])) (sort (prime-factors 13195))
  (is (= [5] (sort (prime-factors 25)))))

