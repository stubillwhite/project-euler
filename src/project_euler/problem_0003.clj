(ns project-euler.problem-0003
  (:require [clojure.math.numeric-tower :as math]))

;; The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143?

(defn factors
  ([n]
    (let [ limit   (math/floor (math/sqrt n))
           factor? (fn [x] (zero? (mod n x)))
           dedupe  (fn [x] (sort (into [] (into #{} x)))) ]
      (dedupe
        (apply concat
          (for [x (range 2 (inc limit)) :when (factor? x)] [x (/ n x)]))))))

(defn prime?
  ([n]
    (empty? (factors n))))

(defn prime-factors
  ([n]
    (filter prime? (factors n))))

(defn calculate-answer
  ([]
    (reduce max (prime-factors 600851475143))))
