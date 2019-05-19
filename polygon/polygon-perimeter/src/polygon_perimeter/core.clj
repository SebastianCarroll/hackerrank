(ns polygon-perimeter.core
  (:gen-class))

(require '[clojure.string :as str])

(defn distance [p1 p2]
  (let [[p1x p1y] p1
        [p2x p2y] p2
        dx (- p2x p1x)
        dy (- p2y p1y)]
    (Math/sqrt (+ (* dx dx) (* dy dy)))))

(defn distance-mapper
  "Exists to convert the inputs expected by distance"
  [p]
  (let [[p1 p2] p]
    (distance p1 p2)))

(defn add-distances [ps] 
  (let [parts (partition 2 1 ps)
        distances (map distance-mapper parts)]
    (apply + distances)))

(defn str-to-points [str-line]
  (map #(Integer/parseInt %) (str/split str-line #" ")))

(defn run-one-problem [get-line]
  (let [[n] (str-to-points (get-line))]
    (do
      (println (str "Running problem. Found input: " n))
      (dotimes [i n] (println n)))))

(defn run-all [get-line] 
  (let [[n] (str-to-points (get-line))]
    (do
      (println n)
      (dotimes [i n] (run-one-problem get-line)))))

(defn -main
  "Give me a problem in the format of hackerrank input"
  [& args]
  (run-all read-line))
