(ns project-euler.problem-0011-test
  (:require [project-euler.problem-0011 :refer :all]
            [clojure.test :refer :all]))

(deftest create-grid-given-seq-with-leading-zeros-then-grid
  (is (= {[0 0] 0
          [0 1] 1
          [1 0] 2
          [1 1] 3}
         (create-grid "00 01 02 03" 2))))

(deftest create-grid-given-sample-data-then-grid
  (let [result (create-grid number-seq-str 20)]
    (is (= 8  (get result [0 0])))
    (is (= 8  (get result [0 19])))
    (is (= 1  (get result [19 0])))
    (is (= 48 (get result [19 19])))))

(def expected-offsets
  [[[0 0] [1 0]]  ;; left-right
   [[0 0] [1 1]]  ;; top-left-bottom-right
   [[0 0] [0 1]]  ;; top-bottom
   [[0 0] [1 -1]] ;; bottom-left-top-right
   ])

(deftest windows-then-seq-of-offsets
  (is (= expected-offsets (windows 2))))

;; Test grid
;;
;; 12 13 14 15
;; 08 09 10 11
;; 04 05 06 07 
;; 00 01 02 03

(def test-grid
  (create-grid (apply str (interleave (range 16) (repeat " "))) 4))

(def test-windows
  (windows 3))

(deftest extract-values-given-test-grid-then-expected-windowed-values
  (is (= (into #{} '((0 1 2) (0 5 10) (0 4 8)))
         (into #{} (extract-values test-grid [0 0] test-windows))))
  (is (= (into #{} '((3 7 11) (3 6 9) ))
         (into #{} (extract-values test-grid [0 3] test-windows)))))

(deftest windowed-values-then-all-values-that-satisfy-windows
  (is (= (into #{}
               '( (0 1 2) (1 2 3) (4 5 6) (5 6 7) (8 9 10) (9 10 11) (12 13 14) (13 14 15)
                 (0 4 8) (4 8 12) (1 5 9) (5 9 13) (2 6 10) (6 10 14) (3 7 11) (7 11 15)
                 (0 5 10) (4 9 14) (1 6 11) (5 10 15)
                 (2 5 8) (6 9 12) (3 6 9) (7 10 13) ))
         (into #{} (windowed-values test-grid test-windows)))))

