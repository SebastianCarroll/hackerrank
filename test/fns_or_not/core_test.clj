(ns fns-or-not.core-test
  (:require [clojure.test :refer :all]
            [fns-or-not.core :refer :all]))

(deftest conversion
  (testing "Convert Int string to array of int"
    (is (= [0,1,2] (str-to-ints "0 1 2"))))
  (testing "Convert ints to string from fn input"
    (is (= [0,1,2] (str-to-ints-fn (fn [] "0 1 2")))))
)
(deftest grouping
  (testing "Input grouped on doubles"
    (is (= [["11" "22"]["22"]] (group-over-2 [ "2" "2" "11" "22" "1" "22" ])))
    (is (= [[[1 1] [2 2]][[2 2]]] (group-over-2 [ [2] [2] [1 1] [2 2] [1] [2 2] ])))
    (is (= [["11"]] (grouper [[]] "11")))
    (is (= [["11" "11"]] (grouper [["11"]] "11"))) 
    (is (= [[][]] (grouper [[]] "1"))) 
    (is (= [["11"][]] (grouper [["11"]] "1")))
))

(deftest helper
  (testing "Inserting element into array of arrays"
    (is (= [[] [1]] (push-nested [[] []] 1)))
    (is (= [[1]] (push-nested [[]] 1))))
  (testing "Adding push nested empty helper"
    (is (= [["11"][]] (push-nested-empty [["11"]])))
))

(deftest is-a-fn
  (testing "Check if additional point invalids fn check"
    (is (= {1 2 3 4 2 3} (still-a-fn {1 2 3 4} [2 3])))
    (is (= nil (still-a-fn nil [2 3])))
    (is (= nil (still-a-fn {1 2 3 4} [1 3]))))
  (testing "Check reduce over points and outcome"
    (is (= nil (are-points-a-fn [[1 2][3 4][1 3]]))))
)

(deftest map-output
  (testing "mapping nil - NO else YES"
    (is (= "YES\nNO\nYES" (which-are-fns [[[1 3][2 3]][[1 2][3 4][1 3]][[2 3]]])))
    (is (= "YES" (yes-no {1 2 3 4}))))
)
