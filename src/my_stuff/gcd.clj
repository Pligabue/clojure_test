(ns my-stuff.gcd
  (:gen-class))

(require '[my-stuff.trial-division :as td])

(defn get-commom-divisors 
  ([a b] (get-commom-divisors (td/trial-division a) (td/trial-division b) 0 0 []))
  ([A B i j acc]
   (let [comp (compare (get A i) (get B j)) a (get A i) b (get B j)]
     (if (or (= a nil) (= b nil))
       acc
       (case comp
         -1 (recur A B (inc i) j acc)
         0 (recur A B (inc i) (inc j) (conj acc a))
         1 (recur A B i (inc j) acc))))))

(defn greatest-commom-denominator [a b]
  (reduce * (get-commom-divisors a b)))