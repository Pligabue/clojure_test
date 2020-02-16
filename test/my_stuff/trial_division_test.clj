(ns my-stuff.trial-division-test
  (:require [clojure.test :refer :all]
            [my-stuff.trial-division :refer :all]))

(deftest a-test
  (testing "Return value"
    (is (= [7 7 107 1453 275027 376841] (my-stuff.trial-division/trial-division 789548751542452853)))))

(deftest b-test
  (testing "Return value on invalid input"
    (is (= [] (my-stuff.trial-division/trial-division 1)))
    (is (= [] (my-stuff.trial-division/trial-division 0)))
    (is (= [] (my-stuff.trial-division/trial-division -1)))
    (is (= [] (my-stuff.trial-division/trial-division 10.0)))))
