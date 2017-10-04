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

