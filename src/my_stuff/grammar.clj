(ns my-stuff.grammar
  (:gen-class))

(require '[clojure.string :as str])

(defn apply-rule [base rule]
  (if (str/includes? base (first rule))
    (str/replace base (re-pattern (first rule)) (second rule))))

(defn apply-rules-to-bases [bases rules]
  (vec (for [base bases
             rule rules]
    (apply-rule base rule))))

(defn filter-by-size [bases size]
  (vec 
   (distinct
    (remove (fn [s] (or (> (count s) size) (nil? s))) bases))))

(defn contains-string [sample-string all-strings]
  (boolean (seq (filter (fn [s] (= sample-string s)) all-strings))))

(defn belongs-to-grammar 
  ([sample-string grammar] (belongs-to-grammar sample-string grammar [(first grammar)] 0))
  ([sample-string grammar all-strings position]
   (let [new-changes (filter-by-size (apply-rules-to-bases (subvec all-strings position) (second grammar)) (count sample-string))
         new-all-strings (vec (concat all-strings new-changes))
         new-position (count all-strings)]
     (if (= new-all-strings all-strings)
       (contains-string sample-string all-strings)
       (recur sample-string grammar new-all-strings new-position)))))


