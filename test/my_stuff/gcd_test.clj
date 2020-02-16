(ns my-stuff.gcd-test
  (:require [clojure.test :refer :all]
            [my-stuff.gcd :refer :all]))

(deftest a-test
  (testing "Common divisors"
    (is (= [2 2 2 3] (my-stuff.gcd/get-commom-divisors 192 360)))))

(deftest b-test
  (testing "Greatest common denominator"
    (is (= 24 (my-stuff.gcd/greatest-commom-denominator 192 360)))))