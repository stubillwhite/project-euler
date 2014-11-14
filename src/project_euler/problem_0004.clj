(ns project-euler.problem-0004
  (:require [clojure.math.numeric-tower :as math]))

;; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is
;; 9009 = 91 × 99.
;;
;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindromic-number?
  ([x]
    (= (seq (str x)) (reverse (str x)))))

(def two-digit-products
  (for [ x (range 10 100)
         y (range 10 100) ]
    (* x y)))

(def three-digit-products
  (for [ x (range 100 1000)
         y (range 100 1000) ]
    (* x y)))

(defn palindromic-numbers
  ([s]
    (filter palindromic-number? s)))

(defn calculate-answer
  ([]
    (reduce max (palindromic-numbers three-digit-products))))
