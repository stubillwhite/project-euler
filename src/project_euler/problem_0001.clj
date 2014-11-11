(ns project-euler.problem-0001)

(defn multiples-of-three-and-five
  ([limit]
    (reduce + (distinct
                (concat
                  (for [x (range 0 limit 3)] x)
                  (for [x (range 0 limit 5)] x))))))
