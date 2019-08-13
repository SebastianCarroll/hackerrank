(ns polygon-area.core-test
  (:require [clojure.test :refer :all]
            [polygon-area.core :refer :all]))

(deftest a-test
  (testing "Summing Alternate points"
    (is (= [4 6] (mul-alternate-points [1 2] [3 4])))
    (is (= [4 6] (reduce mul-alternate-points [[1 2] [3 4]])))
    (is (= [4 6] (mul-alternate-points [[1 2] [3 4]])))
    (is (= '((1 2) (2 3) (3 4)) (partition 2 1 [1 2 3 4]))))
  (testing "Summing x and y together"
    (is (= [8 6] (sum-points [1 2] [7 4])))
    (is (= [37 38] (sum-many-points [[1 2] [5 7] [4 6]]))))
  (testing "add together and divide by two"
    (is (= 8 (sum-div [12 4])))))

; 1 2
; 5 7
; 4 6

;7+(5*6)=7+30=37
;(2*5)+(7*4)= 10+28=38
