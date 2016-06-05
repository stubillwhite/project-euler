(ns project-euler.problem-0017
  (:require [project-euler.utils :refer [def-]]
            [clojure.string :as string]))

;; If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
;; letters used in total.
;; 
;; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
;; 
;; NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one
;; hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British
;; usage.

(def- units-names
  {0  "zero"
   1  "one"
   2  "two"
   3  "three"
   4  "four"
   5  "five"
   6  "six"
   7  "seven"
   8  "eight"
   9  "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"})

(def- tens-names
  {10 "ten"
   20 "twenty"
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"})

(defn- convert-less-than-one-hundred
  [num]
  (let [tens  (quot num 10)
        units (rem num 10)]
    (if (< num 20)
      (get units-names num)
      (str (get tens-names (* 10 tens))
           (when (pos? units) (str "-" (get units-names units)))))))

(defn- convert-less-than-one-thousand [num]
  (let [hundreds  (quot num 100)
        remainder (rem num 100)]
    (str
     (when (pos? hundreds) (str (convert-less-than-one-hundred hundreds) " hundred"))
     (when (and (pos? hundreds) (pos? remainder)) " and ")
     (when (pos? remainder) (convert-less-than-one-hundred remainder)))))

(defn num-to-words
  [num]
  (if (zero? num)
    "zero"
    (let [thousands (quot num 1000)
          remainder (rem num 1000)]
      (str
       (when (pos? thousands) (str (num-to-words thousands) " thousand"))
       (when (pos? remainder) (convert-less-than-one-thousand remainder))))))

(defn strip-non-letters [s]
  (->> (vec s)
       (filter (fn [x] (Character/isLetter x)))
       (apply str)))

(defn number-letter-counts [n]
  (count (strip-non-letters (num-to-words n))))

(defn calculate-answer []
  (reduce + (map number-letter-counts (range 1 1001))))
