(ns project-euler.problem-0005)

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;;
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

;; Solution
;;
;; Just need to find the least common multiple of all the numbers.

(defn gcd
  ([a b]
    (if (= b 0)
      a
      (recur b (rem a b)))))

(defn lcm
  ([a b]
    (/ (* a b) (gcd a b)))
  ([a b & rest]
    (reduce lcm (lcm a b) rest)))

(defn calculate-answer
  ([]
    (apply lcm (range 1 21))))

