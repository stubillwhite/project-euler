(ns project-euler.problem-0007
  (:require [clojure.math.numeric-tower :as math]))

;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;;
;; What is the 10 001st prime number?

;; Solution
;;
;; Clojure has a primes library sequence, but that's cheating rather. This could be faster if we tested primes as factors
;; rather than all numbers, but then we'd have to hold onto a array of primes. Do it lazily and stateless.

(defn- factor? [x y]
  (zero? (rem x y)))

(defn- prime? [x]
  (let [ limit (math/floor (math/sqrt x)) ]
    (loop [ i 2 ]
      (cond
        (> i limit)   true
        (factor? x i) false
        :else         (recur (inc i))))))

(def primes
  (filter prime? (iterate inc 1)))

(defn calculate-answer []
  (nth primes 10001))
