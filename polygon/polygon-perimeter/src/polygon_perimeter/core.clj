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

(defn append-first-to-end
  "Creates a new seq where the first element is appended to the end"
  [a]
  (let [l (count a)
        l1 (+ l 1)
        c (cycle a)]
    (take l1 c)))

(defn add-distances [ps]
  (let [first-at-end (append-first-to-end ps)
        point-pairs (partition 2 1 first-at-end)
        distances (map distance-mapper point-pairs)]
    (apply + distances)))

(defn str-to-points [str-line]
  (map #(Integer/parseInt %) (str/split str-line #" ")))

(defn run-one-problem [get-line]
  (let [[n] (str-to-points (get-line))]
    (add-distances (repeatedly n #(str-to-points (get-line))))))

(defn run-all [get-line]
  (let [[n] (str-to-points (get-line))]
    (dotimes [i n] (println (run-one-problem get-line)))))

(defn -main
  "Give me a problem in the format of hackerrank input"
  [& args]
  (run-all read-line))
