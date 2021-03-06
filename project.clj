(defproject project-euler "0.1.0-SNAPSHOT"

  :description "Clojure solutions to Project Euler problems."

  :url "https://github.com/stubillwhite/project-euler"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html" }

  :repl-options {:port 4555}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.2.391"]
                 [org.clojure/math.numeric-tower "0.0.4"] 
                 [clojure-csv/clojure-csv "2.0.2"]
                 
                 ;; Logging
                 [com.taoensso/timbre "4.7.4"]
                 [org.clojure/tools.trace "0.7.9"]

                 ;; Analysing execution time
                 [org.jfree/jfreechart "1.0.19"]
                 [org.jfree/jcommon "1.0.23"]
                 [com.taoensso/tufte "1.0.2"]]
  
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.10"]]
                   :source-paths ["dev"]}})
