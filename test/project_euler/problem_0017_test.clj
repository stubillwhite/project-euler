(ns project-euler.problem-0017-test
  (:require [project-euler.problem-0017 :refer :all]
            [clojure.test :refer :all]))

(deftest num-to-words-given-sample-input-then-sample-output
  (is (= (num-to-words 1)   "one"))
  (is (= (num-to-words 2)   "two"))
  (is (= (num-to-words 3)   "three"))
  (is (= (num-to-words 4)   "four"))
  (is (= (num-to-words 5)   "five"))
  (is (= (num-to-words 115) "one hundred and fifteen"))
  (is (= (num-to-words 342) "three hundred and forty-two")))

(deftest number-letter-counts-given-sample-input-then-sample-output
  (is (= (number-letter-counts 1)   3))
  (is (= (number-letter-counts 2)   3))
  (is (= (number-letter-counts 3)   5))
  (is (= (number-letter-counts 4)   4))
  (is (= (number-letter-counts 5)   4))
  (is (= (number-letter-counts 115) 20))
  (is (= (number-letter-counts 342) 23)))

(deftest num-to-words-given-one-digit-number-then-words
  (is (= "zero"  (num-to-words 0)))
  (is (= "one"   (num-to-words 1)))
  (is (= "three" (num-to-words 3)))
  (is (= "nine"  (num-to-words 9))))

(deftest num-to-words-given-teen-number-then-words
  (is (= "ten"      (num-to-words 10)))
  (is (= "thirteen" (num-to-words 13)))
  (is (= "nineteen" (num-to-words 19))))

(deftest num-to-words-given-two-digit-number-then-words
  (is (= "twenty"       (num-to-words 20)))
  (is (= "twenty-three" (num-to-words 23)))
  (is (= "forty-two"    (num-to-words 42))))

(deftest num-to-words-given-three-digit-number-then-words
  (is (= "one hundred"                    (num-to-words 100)))
  (is (= "one hundred and three"          (num-to-words 103)))
  (is (= "three hundred and twenty-three" (num-to-words 323))))

(deftest num-to-words-given-four-digit-number-then-word
  (is (= "one thousand" (num-to-words 1000))))
