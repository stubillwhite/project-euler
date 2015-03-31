(ns project-euler.problem-0011-test
  (:use
    [expectations]
    [project-euler.problem-0011]))

;; create-grid given number sequence with leading zeros then returns grid
(expect
  { [0 0] 0
    [0 1] 1
    [1 0] 2
    [1 1] 3}
  (create-grid "00 01 02 03" 2))

;; create-grid given sample data then returns grid
(expect
  (more->
    8  (get [0 0])
    8  (get [0 19])
    1  (get [19 0])
    48 (get [19 19]))
  (create-grid number-seq-str 20))

;; windows then seq of offsets of specified size
(expect
  [ [ [0 0]  [1 0] ]   ;; left-right
    [ [0 0]  [1 1] ]   ;; top-left-bottom-right
    [ [0 0]  [0 1] ]   ;; top-bottom
    [ [0 0] [1 -1] ] ] ;; bottom-left-top-right
  (windows 2))

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

;; extract-values then values from grid to fill the windows
(expect
  (into #{} '((0 1 2) (0 5 10) (0 4 8)))
  (into #{} (extract-values test-grid [0 0] test-windows)))

(expect
  (into #{} '((3 7 11) (3 6 9) ))
  (into #{} (extract-values test-grid [0 3] test-windows)))

;; windowed-values then all values that satisfy windows
(expect
  (into #{}
    '( (0 1 2) (1 2 3) (4 5 6) (5 6 7) (8 9 10) (9 10 11) (12 13 14) (13 14 15)
       (0 4 8) (4 8 12) (1 5 9) (5 9 13) (2 6 10) (6 10 14) (3 7 11) (7 11 15)
       (0 5 10) (4 9 14) (1 6 11) (5 10 15)
       (2 5 8) (6 9 12) (3 6 9) (7 10 13) ))
  (into #{} (windowed-values test-grid test-windows)))

