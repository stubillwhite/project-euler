(ns project-euler.problem-0022
  (:require [clojure-csv.core :as csv]))

;; Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first
;; names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply
;; this value by its alphabetical position in the list to obtain a name score.
;; 
;; For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the
;; 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
;; 
;; What is the total of all the name scores in the file?

(defn- parse-line [s]
  (first (csv/parse-csv s)))

(defn- lazy-read-lines [rdr]
  (lazy-seq
    (if-let [line (.readLine rdr)]
      (cons line (lazy-read-lines rdr))
      (do (.close rdr) nil))))

(defn- parse-file [file]
  (let [rdr (clojure.java.io/reader file)]
    (apply concat (map parse-line (lazy-read-lines rdr)))))

(defn score-name [s]
  (reduce + (map (fn [x] (inc (- (int x) (int \A)))) (seq s))))

(defn calculate-answer []
  (->> (parse-file "src/project_euler/problem_0022_names.txt")
       (sort)
       (map-indexed (fn [idx s] (* (inc idx) (score-name s))))
       (reduce +)))

