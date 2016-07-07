(ns project-euler.problem-0019-test
  (:require [project-euler.problem-0019 :refer :all]
            [clojure.test :refer :all]))

(def time-zero
  {:day   :monday
   :date  1
   :month 1
   :year  1900})

(defn- calendar [day date month year]
  {:day   day
   :date  date
   :month month
   :year  year})

(deftest inc-calendar-given-day-update-then-increments
  (is (= (inc-calendar (calendar :monday 1 1 1990)) (calendar :tuesday 2 1 1990)))
  (is (= (inc-calendar (calendar :sunday 7 1 1990)) (calendar :monday  8 1 1990))))

(deftest inc-calendar-given-month-update-then-increments
  (is (= (inc-calendar (calendar :monday 31 1  1990)) (calendar :tuesday 1 2  1990)))
  (is (= (inc-calendar (calendar :monday 28 2  1990)) (calendar :tuesday 1 3  1990)))
  (is (= (inc-calendar (calendar :monday 31 3  1990)) (calendar :tuesday 1 4  1990)))
  (is (= (inc-calendar (calendar :monday 30 4  1990)) (calendar :tuesday 1 5  1990)))
  (is (= (inc-calendar (calendar :monday 31 5  1990)) (calendar :tuesday 1 6  1990)))
  (is (= (inc-calendar (calendar :monday 30 6  1990)) (calendar :tuesday 1 7  1990)))
  (is (= (inc-calendar (calendar :monday 31 7  1990)) (calendar :tuesday 1 8  1990)))
  (is (= (inc-calendar (calendar :monday 31 8  1990)) (calendar :tuesday 1 9  1990)))
  (is (= (inc-calendar (calendar :monday 30 9  1990)) (calendar :tuesday 1 10 1990)))
  (is (= (inc-calendar (calendar :monday 31 10 1990)) (calendar :tuesday 1 11 1990)))
  (is (= (inc-calendar (calendar :monday 30 11 1990)) (calendar :tuesday 1 12 1990)))
  (is (= (inc-calendar (calendar :monday 31 12 1990)) (calendar :tuesday 1 1  1991))))

(deftest inc-calendar-given-leap-year-then-increments
  (is (= (inc-calendar (calendar :monday  28 2 2004)) (calendar :tuesday   29 2 2004)))
  (is (= (inc-calendar (calendar :tuesday 29 2 2004)) (calendar :wednesday  1 3 2004))))

(deftest inc-calendar-given-non-leap-year-then-increments
  (is (= (inc-calendar (calendar :monday  28 2 2000)) (calendar :tuesday 1 3 2000))))
