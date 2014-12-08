(ns project-euler.charting
  (:import
    [org.jfree.ui ApplicationFrame]
    [org.jfree.chart ChartFactory ChartPanel]
    [org.jfree.chart.plot PlotOrientation]
    [org.jfree.data.xy DefaultXYDataset]
    [java.awt.event WindowAdapter]
    [javax.swing JFrame]))

(defn graph
  ([]
    {
      :title     "Project Euler chart"
      :x-label   "X"
      :y-label   "Time (ms)"
      :data-sets [] }))

(defn add-data-set
  ([graph data-set]
    (update-in graph [:data-sets] (fn [x] (cons data-set x)))))

(def sample-graph
  (-> (graph)
    (add-data-set 
      { :label "x^3"
        :data  (for [x (range -10 10)] [x (+ (* x x x) (* 5 x x) (* 2 x) -10)]) })))

(defn- convert-data
  ([data]
    (let [ single-stream (apply concat data)
           separate-streams [ (vec (take-nth 2 single-stream))
                              (vec (take-nth 2 (rest single-stream)))] ]
      (into-array (map double-array separate-streams)))))

(defn- create-dataset
  ([{:keys [data-sets]}]
    (let [xy-dataset (DefaultXYDataset.)]
      (doall
        (for [ds data-sets]
          (doto xy-dataset
            (.addSeries (:label ds) (convert-data (:data ds))))))
      xy-dataset)))

(defn- create-line-chart
  ([{:keys [title x-label y-label] :as graph}]
    (ChartFactory/createXYLineChart
      title
      x-label
      y-label
      (create-dataset graph)
      PlotOrientation/VERTICAL,
      true,
      true,
      false)))

(defn- create-content-pane
  ([graph]
    (ChartPanel.
      (doto (create-line-chart graph)))))

(defn- create-graph
  ([{:keys [title] :as graph}]
    (let [frame (JFrame. title)]
      (doto frame
        (.setSize 500 500)
        (.setVisible true)
        (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE)
        (.setContentPane (create-content-pane graph))
        (.pack)))))

(defn- time-ms
  ([f & args]
    (let [ start  (System/nanoTime)
           result (apply f args)
           end    (System/nanoTime) ]
      (/ (double (- end start)) 1000000.0))))


(defn graph-execution-time
  ([f data]
    (create-graph
      (-> (graph)
        (add-data-set
          { :label "Foo"
            :data  (map (fn [x] [x (time-ms f x)]) data)})))))


(comment graph-execution-time
  (fn [x] (Thread/sleep (* x 1000))) (range 3))


;(def g (create-graph graph))

;(create-dataset graph)

;(.dispose g)


