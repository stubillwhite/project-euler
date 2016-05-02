(ns project-euler.problem-0006)

;; The sum of the squares of the first ten natural numbers is,
;;
;; 1^2 + 2^2 + ... + 10^2 = 385
;;
;; The square of the sum of the first ten natural numbers is,
;;
;; (1 + 2 + ... + 10)^2 = 552 = 3025
;;
;; Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
;; 3025 − 385 = 2640.
;;
;; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the
;; sum.

;; Solution
;;
;; I remember the sum of the natural numbers from high school as being a triangular number, the formula for which is:
;;
;;   n(n+1) / 2
;;
;; Sum of the squares I had to Google for, but the formula is simple:
;;
;;   (n(n+1)(2n+1)) / 6 

(defn- square [x]
  (* x x))

(defn square-of-sum [n]
  (square
   (/ (* n (+ n 1)) 2)))

(defn sum-of-squares [n]
  (/ (* n (+ n 1) (+ (* 2 n) 1)) 6))

(defn difference [n]
  (- (square-of-sum n) (sum-of-squares n)))

(defn calculate-answer []
  (difference 100))
