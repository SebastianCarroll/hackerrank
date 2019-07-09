(ns polygon-area.core-test
  (:require [clojure.test :refer :all]
            [polygon-area.core :refer :all]))

(deftest a-test
  (testing "Summing Alternate points"
    (is (= [4 6] (sum-alternate-points [1 2] [3 4])))
    (is (= [4 6] (reduce sum-alternate-points [[1 2] [3 4]])))
    (is (= [42 38] (reduce sum-alternate-points [[1 2][5 7][4 6]])))))

; 1 2
; 5 7
; 4 6

;7+(5*6)=7+36=42
;(2*5)+(7*4)= 10+28=38
