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

(defn- factors [n]
  (let [ limit   (math/floor (math/sqrt n))
        factor? (fn [x] (zero? (mod n x))) ]
    (into #{}
          (apply concat
                 (for [x (range 2 (inc limit)) :when (factor? x)] [x (/ n x)])))))

(defn- naive-prime? [n]
  (empty? (factors n)))

(defn naive-sum-of-primes-below [n]
  (->> (range 2 (inc n))
       (filter naive-prime?)
       (reduce +)))

;; That's a little slow. we can optimise slightly by exiting the loops as soon as we find any factor, rather than
;; finding all factors and then testing whether the set is empty.

(defn prime? [n]
  (let [ limit   (math/floor (math/sqrt n))
        factor? (fn [x] (zero? (mod n x))) ]
    (not-any? factor? (range 2 (inc limit)))))

(defn sum-of-primes-below [n]
  (->> (range 2 (inc n))
       (filter prime?)
       (reduce +)))

;; Let's visualise that to see how much faster it makes things.
(comment display-graph-of-execution-time
  (range 1 (* 2 1000 100) 10000)
  (data-series "optimised" sum-of-primes-below)
  (data-series "naive"     naive-sum-of-primes-below))

;; That's much faster (down from six seconds to one second for primes below 200000). Calclating the answer takes about
;; twenty seconds now instead of over three minutes. I'm not sure whether there are any mathematical optimisations we
;; can make, though.

(defn calculate-answer []
  (sum-of-primes-below (* 2 1000 1000)))
