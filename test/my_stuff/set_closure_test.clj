(ns my-stuff.set-closure-test
  (:require [clojure.test :refer :all]
            [my-stuff.set-closure :refer :all]))

(deftest a-test
  (testing "Return value"
    (is 
     (= 
      [[0 1] [1 2] [2 3] [0 2] [1 3] [0 3] [0 0] [1 1] [2 2] [3 3]] 
      (my-stuff.set-closure/reflexive-and-transitive [[0 1] [1 2] [2 3]])))
    (is (= [] (my-stuff.set-closure/reflexive-and-transitive [])))))