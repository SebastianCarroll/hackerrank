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
    (is (= 4 (minus-div2 12 4)))
    (is (= 4 (minus-div2 [12 4]))))
  (testing "append the first element to the end of an array"
    (is (= [12 4 12] (loop1 [12 4])))
    (is (= [12 4 7 12] (loop1 [12 4 7]))))
  (testing "final test given points return area"
    ; 0 0
    ; 1 1 | 0 0 
    ; 1 0 | 0 1
    ; 0 0 | 0 0
    ;       0 1
    ;       (0-1)/2 = 0.5
    (is (= 0.5 (poly-area [[0 0] [1 1] [1 0]])))
    (is (= 60 (poly-area
               [[-3 -2]
                [-1 4]
                [6 1]
                [3 10]
                [-4 9]])))))


; 1 2
; 5 7
; 4 6

;7+(5*6)=7+30=37
;(2*5)+(7*4)= 10+28=38

; -3 -2
; -1 4    2 -12
; 6 1    24  -1
; 3 10    3  60
; -4 9  -40  27
; [-3 -2] -27   8

5
-3 -2
-1 4
6 1
3 10
-4 9