(ns project-euler.charting
  (:require
    [clojure.core.async :refer [chan go go-loop <! >! mult tap <!! >!! close! pipe onto-chan timeout alt! alts!]]
    [taoensso.timbre :as timbre])
  (:import
    [org.jfree.ui ApplicationFrame]
    [org.jfree.chart ChartFactory ChartPanel]
    [org.jfree.chart.plot PlotOrientation]
    [org.jfree.data.xy XYSeries XYSeriesCollection]
    [java.awt.event WindowAdapter]
    [javax.swing JFrame]))

(timbre/refer-timbre)

(defn graph
  "Returns a graph with the specified title and labels"
  ([title x-label y-label & data-series]
    { :title       title
      :x-label     x-label
      :y-label     y-label
      :data-series [] }))

(defn data-series
  "Returns a data series with the specified label, function, and inputs."
  ([label f inputs]
    { :label  label
      :f      f
      :inputs inputs }))

(defn add-data-series
  "Returns a graph with the data-series added."
  ([graph data-series]
    (update-in graph [:data-series] (fn [x] (cons data-series x)))))

(defn- create-content-view
  "Returns the GUI components for the graph content panel."
  ([{:keys [title x-label y-label] :as graph} dataset]
    (ChartPanel.
      (ChartFactory/createXYLineChart
        title
        x-label
        y-label
        dataset
        PlotOrientation/VERTICAL,
        true,
        true,
        false))))

(defn- create-graph-view
  "Returns the GUI components for the graph."
  ([{:keys [title x-label y-label data-series]}]
    (let [ dataset (XYSeriesCollection.)
           content (create-content-view graph dataset)
           gui     (doto (JFrame. title)
                     (.setSize 500 500)
                     (.setVisible true)
                     (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE)
                     (.setContentPane content)
                     (.pack)) ]
      { :gui     gui
        :dataset dataset })))

(defn- pipe-to
  "Pipe the outputs of channel ch to function f."
  ([ch f]
    (go-loop []
      (when-let [x (<! ch)]
        (f x)
        (recur)))))

(defn- plot-points
  "Plots the points in the data set asynchronously."
  ([dataset {:keys [label f inputs] :as data-series}]
    (let [ series    (XYSeries. label)
           ch        (chan)
           add-point (fn [[x y]] (doto series (.add x y))) ]
      (doto dataset (.addSeries series))
      (pipe-to ch add-point)
      (doall (map (fn [x] (>!! ch [(double x) (double (f x))])) inputs)))))

(defn- plot-series
  "Plots all data series in graph to graph-view."
  ([{:keys [data-series] :as graph} {:keys [dataset] :as graph-view}]
    (for [ds data-series]
      (plot-points dataset ds))))

(defn display-graph
  "Displays a graph."
  ([graph]
    (plot-series graph (create-graph-view graph))))

(defmacro time-ms
  "Returns the time to execute expr."
  ([expr]
    `(let [ start#   (System/nanoTime)
            result#  ~expr
            end#     (System/nanoTime) ]
       (/ (double (- end# start#)) 1000000.0))))

(defn- decorate-with-execution-time-recorders
  "Modify the graph functions to return time to execute rather than data value."
  ([{:keys [data-series] :as graph}]
    (assoc graph :data-series
      (for [ds data-series]
        (assoc ds :f (fn [& args] (time-ms (apply (:f ds) args))))))))

(defn display-graph-of-execution-time
  "Displays a graph of execution time of the specified data series"
  ([& data-series]
    (let [ empty-graph (graph "Project Euler chart" "Input" "Execution time (ms)")
           graph       (reduce (fn [g ds] (add-data-series g ds)) empty-graph data-series)]
      (-> graph
        (decorate-with-execution-time-recorders)
        (display-graph)))))



                                        


