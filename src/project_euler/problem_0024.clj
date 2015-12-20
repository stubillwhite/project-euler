(ns project-euler.problem-0024
  (:require [clojure.math.numeric-tower :as math]
            [project-euler.charting :refer [display-graph-of-execution-time graph data-series add-data-series]]
            [taoensso.timbre :as timbre]))

;; A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2,
;; 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The
;; lexicographic permutations of 0, 1 and 2 are:
;; 
;;    012   021   102   120   201   210
;; 
;; What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

;; Solution
;;
;; There's a very clear example here: http://www.nayuki.io/page/next-lexicographical-permutation-algorithm
;;
;;     Initial sequence                                       0  1  2   5  3  3  0
;;     Find longest non-increasing suffix                     0  1  2  [5  3  3  0]
;;     Identify pivot                                         0  1 (2) [5  3  3  0]
;;     Find rightmost successor to the pivot in the suffix    0  1 (2) [5  3 (3) 0]
;;     Swap with the pivot                                    0  1 (3) [5  3 (2) 0]
;;     Reverse the suffix                                     0  1  3  [0  2  3  5]
;;     Done                                                   0  1  3   0  2  3  5 

(timbre/refer-timbre)

(defn suffix-index
  ([sequence]
   (loop [i (dec (count sequence))]
     (if (or (= i 0) (< (nth sequence (dec i)) (nth sequence i)))
       i
       (recur (dec i))))))

(defn successor-index
  ([pivot-index suffix-index sequence]
   (let [pivot (nth sequence pivot-index)
         succ  (->> (drop suffix-index sequence)
                    (filter (fn [x] (> x pivot)))
                    (reduce min))]
     (loop [i (dec (count sequence))]
       (if (= succ (nth sequence i))
         i
         (recur (dec i)))))))

(defn swap
  ([sequence a b]
   (let [s (vec sequence)]
     (assoc s
            a (s b)
            b (s a)))))

(defn sort-suffix
  ([sequence n]
   (concat
    (take n sequence)
    (sort (drop n sequence)))))

(defn next-permutation
  ([sequence]
   (let [suffix-index (suffix-index sequence)]
     (when (not (zero? suffix-index))
       (let [pivot-index     (dec suffix-index)
             successor-index (successor-index pivot-index suffix-index sequence)]
         (sort-suffix (swap sequence pivot-index successor-index) suffix-index))))))

(defn permutations
  ([sequence]
   (take-while (complement nil?)
               (iterate next-permutation (sort sequence)))))

(defn answer
  ([]
   (nth (permutations (range 10)) (dec 1000000))))
