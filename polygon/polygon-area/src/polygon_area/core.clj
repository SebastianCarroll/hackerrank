(ns polygon-area.core
  (:gen-class))

(require '[clojure.string :as str])

; Input format
; 4
; 0 0
; 0 1
; 1 1
; 1 0

(defn map-to-ints [str-array] 
  (map #(Integer/parseInt %) str-array))

(defn sum-alternate-points [x y] 
  (let [[x1 x2] x
        [y1 y2] y]
    [(* x1 y2) (* y1 x2)]))

(defn sum-points [points])

(defn sum-many-points [points]
  (let [pairs (partition 2 1 points)
        [xsum ysum ] ]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; readline and convert to int
  ; range over that and map readline onto it
  ; split convert each of those strings to int pair
  ; reduce over those pairs and add up x1*y2, y1*x2
  ; multiply and divide
  (let [num-points (Integer/parseInt (read-line))
        str-points (repeatedly num-points #(str/split (read-line) #" "))
        int-points (map map-to-ints str-points)
        ]
  (println int-points) ))
