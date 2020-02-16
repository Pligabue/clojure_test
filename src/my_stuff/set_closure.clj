(ns my-stuff.set-closure
  (:gen-class))

(require '[clojure.string :as str])

(defn split-every-2 [array, split]
  (if (< (count array) 2)
    split
    (recur (subvec array 2) (conj split [(first array) (second array)]))))

(defn parsed_input []
  (let [input (read-line)]
    (split-every-2 (vec (remove str/blank? (str/split input #"[^a-zA-Z0-9]+"))) [])))

(defn _reflexive [array, appended]
  (let [pair (first array)] 
    (if (empty? array) 
      (vec (distinct appended))
      (recur 
        (subvec array 1) 
        (conj appended [(first pair) (first pair)] [(second pair) (second pair)])))))

(defn reflexive [A]
  (_reflexive A A))

(defn _pair-append-transitive [pair array appended]
  (if (empty? array)
    (vec (distinct appended))
    (let [second_pair (first array)]
      (if (= (second pair) (first second_pair))
        (recur pair (subvec array 1) (conj appended [(first pair) (second second_pair)]))
        (recur pair (subvec array 1) appended)))))

(defn _transitive [array appended node_num]
  (if (empty? array)
    appended
    (let [pair_appended (_pair-append-transitive (first array) appended appended)]
      (recur (subvec pair_appended node_num) pair_appended (inc node_num)))))

(defn transitive [A]
  (_transitive A A 0))

(defn reflexive-and-transitive [A]
  (reflexive (transitive A)))

(defn A [] (parsed_input))

(defn -main [& args]
  (print "Relacao binaria: ")
  (flush)
  (print "Fecho reflexivo e transitivo desta relacao: {")
  (let [closure (reflexive-and-transitive (A))]
    (doseq [pair closure]
      (print (format " (%s, %s)" (first pair) (second pair))))
    (println " }")
    closure))