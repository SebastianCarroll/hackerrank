(ns polygon-perimeter.core
  (:gen-class))

(require '[clojure.string :as str])

(defn distance [p1 p2] 
  (let [[p1x p1y] p1
        [p2x p2y] p2
        dx (- p2x p1x)
        dy (- p2y p1y)]
    (Math/sqrt (+ (* dx dx) (* dy dy)))))

(defn str-to-points [str-line]
  (map #(Integer/parseInt %) (str/split str-line #" ")))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
