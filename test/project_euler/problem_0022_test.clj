(ns project-euler.problem-0022-test
  (:require [project-euler.problem-0022 :refer :all]
            [clojure.test :refer :all]))

(deftest score-name-given-sample-input-then-expected-result
  (is (= (score-name "COLIN") 53)))

