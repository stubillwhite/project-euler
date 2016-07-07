(ns project-euler.problem-0019
  (:require [project-euler.utils :refer [def-]]))

;; You are given the following information, but you may prefer to do some research for yourself.
;; 
;; - 1 Jan 1900 was a Monday.
;;
;; - Thirty days has September,
;;   April, June and November.
;;   All the rest have thirty-one,
;;   Saving February alone,
;;   Which has twenty-eight, rain or shine.
;;   And on leap years, twenty-nine.
;;
;; - A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
;;
;; How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

;; Solution
;;
;; This is trivial if we use the Java Calendar APIs, so let's not do that

(defn- divides? [d m]
  (zero? (rem d m)))

(defn- leap-year? [year]
  (and (divides? year 4)
       (not (divides? year 100))))

(defn- days-in-month [{:keys [month year]}]
  (if (and (= month 2) (leap-year? year))
    29
    (nth [31 28 31 30 31 30 31 31 30 31 30 31] (dec month))))

(def- time-zero
  {:day   :monday
   :date  1
   :month 1
   :year  1900})

(defn- last-day? [{:keys [date] :as calendar}]
  (= (days-in-month calendar) date))

(defn- last-month? [{:keys [month]}]
  (= 12 month))

(defn- inc-day [{:keys [day]}]
  (get {:monday    :tuesday
        :tuesday   :wednesday
        :wednesday :thursday
        :thursday  :friday
        :friday    :saturday
        :saturday  :sunday
        :sunday    :monday}
       day))

(defn- inc-date [{:keys [date] :as calendar}]
  (if (last-day? calendar) 1 (inc date)))

(defn- inc-month [{:keys [month] :as calendar}]
  (if (last-day? calendar)
    (if (last-month? calendar) 1 (inc month))
    month))

(defn- inc-year [{:keys [year] :as calendar}]
  (if (and (last-month? calendar) (last-day? calendar))
    (inc year)
    year))

(defn inc-calendar [{:keys [day date month year] :as calendar}]
  {:day   (inc-day  calendar)
   :date  (inc-date calendar)
   :month (inc-month calendar)
   :year  (inc-year calendar)})

(defn- fields-match? [cal x]
  (= (select-keys x (keys cal)) cal))

(defn calculate-answer []
  (->> (iterate inc-calendar time-zero)
       (drop-while (complement (partial fields-match? {:year 1901})))
       (take-while (complement (partial fields-match? {:year 2001})))
       (filter (partial fields-match? {:date 1 :day :sunday}))
       (count)))
