(ns project-euler.problem-0010
  (:use
    [project-euler.charting :only [display-graph-of-execution-time graph data-series add-data-series]])
  (:require
    [clojure.math.numeric-tower :as math]))

;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;; 
;; Find the sum of all the primes below two million.

;; Solution
;;
;; We'll reuse the primes test from problem 0003

(defn factors
  ([n]
    (let [ limit   (math/floor (math/sqrt n))
           factor? (fn [x] (zero? (mod n x))) ]
      (into #{}
        (apply concat
          (for [x (range 2 (inc limit)) :when (factor? x)] [x (/ n x)]))))))

(defn naive-prime?
  ([n]
    (empty? (factors n))))

(defn naive-sum-of-primes-below
  ([n]
    (->> (range 2 (inc n))
      (filter naive-prime?)
      (reduce +))))

;; That's a little slow. we can optimise slightly by exiting the loops as soon as we find any factor, rather than
;; finding all factors and then testing whether the set is empty.

(defn prime?
  ([n]
    (let [ limit   (math/floor (math/sqrt n))
           factor? (fn [x] (zero? (mod n x))) ]
      (not-any? factor? (range 2 (inc limit))))))

(defn sum-of-primes-below
  ([n]
    (->> (range 2 (inc n))
      (filter prime?)
      (reduce +))))

;; That's not actually much faster. Charting the execution times of the two attempts shows that there isn't much between
;; them for this particular range.

;; TODO Move inputs as a parameter
(let [inputs (range 1 (* 2 1000 100) 10000)]
  (display-graph-of-execution-time
    (data-series "optimised" sum-of-primes-below inputs)
    (data-series "naive"     sum-of-primes-below inputs)))
