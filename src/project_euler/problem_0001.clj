(ns project-euler.problem-0001)

;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
;; multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.

;; Solution
;;
;; I can't see any way to do this more efficiently than just brute force.

(defn multiples-of-three-and-five
  ([limit]
    (reduce + (distinct
                (concat
                  (for [x (range 0 limit 3)] x)
                  (for [x (range 0 limit 5)] x))))))

(defn calculate-answer
  ([]
    (multiples-of-three-and-five 1000)))

