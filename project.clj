(defproject project-euler "0.1.0-SNAPSHOT"

  :description "Clojure solutions to Project Euler problems."

  :url "https://github.com/stubillwhite/project-euler"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html" }

   :repl-options { :port 4555 }

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.async "0.2.374"]
                 [org.clojure/math.numeric-tower "0.0.4"] 

                 ;; Logging
                 [com.taoensso/timbre "4.1.4"]
                 [org.clojure/tools.trace "0.7.9"]
                 
                 [org.jfree/jfreechart "1.0.19"]
                 [org.jfree/jcommon "1.0.23"]]
  
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.10"]
                                  [expectations "2.1.3"]]
                   :source-paths ["dev"]}})
