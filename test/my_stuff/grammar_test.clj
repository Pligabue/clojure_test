(ns my-stuff.grammar-test
  (:require [clojure.test :refer :all]
            [my-stuff.grammar :refer :all]))

(deftest a-test
  (testing "Belongs to grammar - Return value"
    (is (= true (my-stuff.grammar/belongs-to-grammar "aaabbb" ["S" [["S" "ab"] ["S" "aSb"]]])))))

(deftest b-test  
  (testing "Apply rule - Return value"
    (is (= "aaSbb" (my-stuff.grammar/apply-rule "aSb" ["S" "aSb"])))))

(deftest c-test
  (testing "Apply rules to bases - Return value"
    (is 
     (= 
      ["ab" "aSb" nil "aabb" "aaSbb" nil nil nil "ab"] 
      (my-stuff.grammar/apply-rules-to-bases ["S" "aSb" "aB"] [["S" "ab"] ["S" "aSb"] ["B" "b"]])))))