(ns fns-or-not.core
  (:gen-class))

(defn str-to-ints [str] 
  (map #(Integer/parseInt %) (clojure.string/split str #" ")))

(defn push-nested [vec elem] 
  (conj (pop vec) (conj (peek vec) elem)))

(defn push-nested-empty [vec] 
  (conj vec []))

(defn str-to-ints-fn [source-fn] 
  (str-to-ints (source-fn)))

(defn grouper [acc n] 
  (if (= 2 (count n)) (push-nested acc n) (push-nested-empty acc)))

(defn remove-empty [coll] 
  (filter not-empty coll))

(defn group-over-2 [ns]  
  (remove-empty (reduce grouper [[]] ns)))

(defn still-a-fn [coll p] 
  (if (nil? coll) 
    coll
    (let [[k v] p] 
      (if (contains? coll k) nil (assoc coll k v)))))

(defn are-points-a-fn [points] (reduce still-a-fn {} points))

(defn yes-no [a] 
  (if a "YES" "NO"))

(defn which-are-fns [pps]
  (clojure.string/join "\n" (map yes-no (map are-points-a-fn pps))))

(defn basic-input [fname]
  (line-seq (java.io.BufferedReader. (java.io.FileReader. fname))))

(defn read-all [] 
  (map str-to-ints (line-seq (java.io.BufferedReader. *in*))))

(defn -main
  "Pipe the contents of the file in to see if it works"
  [& args]
  (println (which-are-fns (group-over-2 (read-all))))
)
