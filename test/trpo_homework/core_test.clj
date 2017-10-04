(ns trpo-homework.core-test
  (:require [clojure.test :refer :all]
            [trpo-homework.core :refer :all]))

(deftest get_perm_test
  (testing "Testing get_perm"
    (is (=
          (get_perm [[1] [2] [3]] [1 2 3])
          '((1 2) (1 3) (2 1) (2 3) (3 1) (3 2))
        )
    )
  )
)

(deftest print_perm_test
  (testing "Testing print_perm"
    (is (=
          (print_perm 2 [1 2 3])
          '((1 2) (1 3) (2 1) (2 3) (3 1) (3 2))
        )
    )
  )
)

(deftest trapeze_method_test
  (testing "Testing trapeze_method")
    (is (=
        (trapeze_method (fn [x] x) 2)
        2))
  (is (=
        (trapeze_method (fn [x] x) 3)
        9/2))
  (is (<
        (Math/abs
          (-
            (trapeze_method
              (fn [x] (Math/cos x))
              3.14159265359)
            (Math/sin 3.14159265359))) ;; abs(trapeze_method(x-> cos(x), PI) - sin(PI))
        0.000001)))