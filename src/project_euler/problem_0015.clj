(ns project-euler.problem-0015)

;; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6
;; routes to the bottom right corner.
;; 
;; How many such routes are there through a 20×20 grid?

;; Solution
;;
;; This is just the number of distinct permutations of the moves right (R) and down (D) to get from top left to bottom
;; right. So for a 2x2 grid this is:
;;
;;     RRDD RDRD RDDR DRRD DRDR DDRR
;;
;; The formula to calculate this is
;;
;;     (x + y + ...)! / (x! * y! * ...)
;;
;; Where x and y and ... are the number of distinct tokens. So for 2x2
;;
;;     (2 + 2)! / (2! * 2!) == 6

(defn factorial [n]
  (reduce * (range (bigint 1) (bigint (inc n)))))

(defn routes-through-grid [n m]
  (/ (factorial (+ n m))
     (* (factorial n) (factorial m))))

(defn calculate-answer []
  (routes-through-grid 20 20))
