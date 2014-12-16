(ns project-euler.problem-0011-test
  (:use
    [clojure.test]
    [midje.sweet]
    [project-euler.problem-0011]))

(fact
  "create-grid given number sequence with leading zeros then returns grid"
  (create-grid "00 01 02 03" 2) => { [0 0] 0
                                     [0 1] 1
                                     [1 0] 2
                                     [1 1] 3})

(fact
  "create-grid given sample data then returns grid"
  (let [ grid (create-grid number-seq-str 20) ]
    (fact
      (get grid [0 0])   => 8
      (get grid [0 19])  => 8
      (get grid [19 0])  => 1
      (get grid [19 19]) => 48)))

(fact
  "windows then seq of offsets of specified size"
  (let [ expected-left-right              [ [0 0]  [1 0] ]
         expected-top-left-bottom-right   [ [0 0]  [1 1] ]
         expected-top-bottom              [ [0 0]  [0 1] ]
         expected-bottom-left-top-right   [ [0 0] [1 -1] ] ]
    (windows 2) => [ expected-left-right
                     expected-top-left-bottom-right
                     expected-top-bottom
                     expected-bottom-left-top-right ]))

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

(fact
  "extract-values then values from grid to fill the windows"
  (into #{} (extract-values test-grid [0 0] test-windows)) => (into #{} '( (0 1 2) (0 5 10) (0 4 8)))
  (into #{} (extract-values test-grid [0 3] test-windows)) => (into #{} '( (3 7 11) (3 6 9) )))

(fact
  "windowed-values then all values that satisfy windows"
  (into #{} (windowed-values test-grid test-windows)) => (into #{}
                                                           '( (0 1 2) (1 2 3) (4 5 6) (5 6 7) (8 9 10) (9 10 11) (12 13 14) (13 14 15)
                                                              (0 4 8) (4 8 12) (1 5 9) (5 9 13) (2 6 10) (6 10 14) (3 7 11) (7 11 15)
                                                              (0 5 10) (4 9 14) (1 6 11) (5 10 15)
                                                              (2 5 8) (6 9 12) (3 6 9) (7 10 13) )))
