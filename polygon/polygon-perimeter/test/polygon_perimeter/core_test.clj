(ns polygon-perimeter.core-test
  (:require [clojure.test :refer :all]
            [polygon-perimeter.core :refer :all]))

(defn fuzzy= [tolerance x y]
  (let [diff (Math/abs (- x y))]
    (< diff tolerance)))

(deftest distance-function
  (testing "Distance between points"
    (is (= 1.0 (distance [0 1] [0 0])))
    (is (= 2.0 (distance [0 0] [2 0])))
    (is (= 0.0 (distance [1 1] [1 1])))
    ; (sqrt 4 + 4) = 2.8284
    (is (fuzzy= 0.0001 2.8284 (distance [0 0] [2 2]))))
  (testing "Distance between points using mapper"
    (is (= 1.0 (distance-mapper [[0 1] [1 1]])))
    (is (= 6.0 (distance-mapper [[0 7] [0 1]])))))

(deftest partition-test-fn
  (testing "partition works as expected"
    (is (= [[1 2][2 3][3 4]] (partition 2 1 [1 2 3 4])))))

(deftest cycle-with-append-first-elem
  (testing "can cycle array to append first element to end"
    (is (= [1 2 3 4 1] (append-first-to-end [1 2 3 4])))))

(deftest add-distance-points
  (testing "Distance between point links"
    (is (= 2.0 (add-distances [[0 1] [0 0]])))
    (is (= 4.0 (add-distances [[0 0] [0 1] [1 1] [1 0]])))))

(deftest str-to-points-test
  (testing "converting strings from stdin to points"
    (is (= [0 0] (str-to-points "0 0")))
    (is (= [0 2] (str-to-points "0 2")))))

(defn gen-input
  "Test function to mimic calling read-line repeatedly in the main program"
  [values] 
  (let [atom-values (atom values)]
    (fn [] 
      (let [head (first @atom-values)
            tail (rest @atom-values)]
        (do 
          (swap! atom-values rest)
          head)))))

(deftest test-gen-fn
  (testing "Can gen fn take an seq and return each elem when called"
    (is (= '(1 2 3) (repeatedly 3 (gen-input [1 2 3]) )))))

(def capture
  (let [counter (atom 0)]
    (fn [] 
      (do 
        (swap! counter inc) 
        @counter))))

(deftest run-single-prob-test
  (testing "Can run single problem with input fn supplied"
    (is (= 4.0 (run-one-problem (gen-input ["4" "0 0" "0 1" "1 1" "1 0"]))))))

(deftest run-main-problems-test
  (testing "Can run all problems as given off the 'command line'"
    ; nil here as it is a dotimes currently which returns null
    ; not a real test
    (is (= nil (run-all (gen-input ["1" "4" "0 0" "0 1" "1 1" "1 0"]))))))