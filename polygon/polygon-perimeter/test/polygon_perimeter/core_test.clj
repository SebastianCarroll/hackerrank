(ns polygon-perimeter.core-test
  (:require [clojure.test :refer :all]
            [polygon-perimeter.core :refer :all]))

(defn fuzzy= [tolerance x y]
  (let [diff (Math/abs (- x y))]
    (< diff tolerance)))

(deftest a-test
  (testing "Distance between points"
    (is (= 1.0 (distance [0 1] [0 0])))
    (is (= 2.0 (distance [0 0] [2 0])))
    (is (= 0.0 (distance [1 1] [1 1])))
    ; (sqrt 4 + 4) = 2.8284
    (is (fuzzy= 0.0001 2.8284 (distance [0 0] [2 2])))
    ))