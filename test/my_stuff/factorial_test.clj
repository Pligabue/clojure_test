(ns my-stuff.factorial-test
  (:require [clojure.test :refer :all]
            [my-stuff.factorial :refer :all]))

(deftest a-test
  (testing "Return value" 
    (is (= 51090942171709440000N (my-stuff.factorial/factorial 21)))
    (is (= 1 (my-stuff.factorial/factorial 0)))))

(deftest b-test
  (testing "Wrong inputs"
    (is (= -1 (my-stuff.factorial/factorial -1)))))