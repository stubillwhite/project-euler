(ns project-euler.problem-0021
  (:require [clojure.math.numeric-tower :refer [floor sqrt]]))

;; Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
;;
;; If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable
;; numbers.
;; 
;; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The
;; proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
;; 
;; Evaluate the sum of all the amicable numbers under 10000.

;; Solution
;; 
;; Brute force with a little memoization to avoid recalculating the sum of divisors for numbers we've already checked.

(defn- proper-divisors [n]
  (let [limit           (floor (sqrt n))
        divides-evenly? (fn [x] (zero? (mod n x)))]
    (into #{1}
          (apply concat
                 (for [x (range 2 (inc limit)) :when (divides-evenly? x)] [x (/ n x)])))))

(defn sum-of-proper-divisors-impl [n]
  (reduce + (proper-divisors n)))

(def sum-of-proper-divisors
  (memoize sum-of-proper-divisors-impl))

(defn- amicable? [a]
  (let [b (sum-of-proper-divisors a)]
    (and (not (= a b)) (= a (sum-of-proper-divisors b)))))

(defn calculate-answer []
  (reduce + (filter amicable? (range 10000))))
