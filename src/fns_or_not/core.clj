(ns fns-or-not.core
  (:gen-class))

(defn str-to-ints [str] (map #(Integer/parseInt %) (clojure.string/split str #" ")))

(defn push-nested [vec elem] (conj (pop vec) (conj (peek vec) elem)))
(defn push-nested-empty [vec] (conj vec []))
(defn str-to-ints-fn [source-fn] (str-to-ints (source-fn)))
(defn grouper [acc n] (if (= 2 (count n)) (push-nested acc n) (push-nested-empty acc)))
(defn remove-empty [coll] (filter not-empty coll))
(defn group-over-2 [ns] (remove-empty (reduce grouper [[]] ns)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
