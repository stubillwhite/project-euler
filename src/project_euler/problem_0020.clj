(ns project-euler.problem-0020)

;; n! means n × (n − 1) × ... × 3 × 2 × 1
;; 
;; For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
;; and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
;; 
;; Find the sum of the digits in the number 100!

(defn- factorial [n]
  (reduce * (range (bigint 1) (bigint (inc n)))))

(defn- sum-of-digits [n]
  (reduce + (map (fn [x] (Long/valueOf (str x)))
                 (seq (str n)))))

(defn sum-of-factorial-digits [n]
  "Returns the sum of the digits of n!"
  (sum-of-digits (factorial n)))

(defn calculate-answer []
  (sum-of-factorial-digits 100))

