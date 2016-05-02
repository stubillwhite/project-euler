(ns project-euler.problem-0009)

;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; 
;; a^2 + b^2 = c^2
;;
;; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;; 
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.

;; Solution
;;
;; Usual brute-force method first. We can cut down the number of numbers to check because a < b < c and they must sum to
;; 1000

(defn- square [x] (* x x))

(defn pythagorean-triplet? [a b c]
  (= (+ (square a) (square b)) (square c)))

(defn calculate-answer []
  (for [ a (range 1 999)
        b (range a 999)
        c (range b 999)
        :when (and (= (+ a b c) 1000) (pythagorean-triplet? a b c))]
    [a b c]))

;; This takes a while, though.
;;
;; Looking around, it seems that Pythagorean triplets can be generated using the following formula:
;;
;;   a = k(m^2 - n^2)
;;   b = k(2mn)
;;   c = k(m^2 + n^2)
;;
;;   Where m > n
;;
;; We do know that a + b + c is 1000, but I can't see how we might solve find k, m, and n. I'm not sure how to do better
;; with this particular problem. We can quit early when we find the first answer (the solution above will spin for the
;; other values of a b c and do nothing) but that doesn't reduce the time appreciably.

