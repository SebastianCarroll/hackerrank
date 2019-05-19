(ns polygon-perimeter.core-test
  (:require [clojure.test :refer :all]
            [polygon-perimeter.core :refer :all]))

(deftest a-test
  (testing "Distance between points"
    (is (= 1.0 (distance [0 1] [0 0])))
    (is (= 2.0 (distance [0 0] [2 0])))))