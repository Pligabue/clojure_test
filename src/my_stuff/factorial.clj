(ns my-stuff.factorial
  (:gen-class))

(defn _factorial [n acc]
  (if (<= n 1)
    acc
    (recur (dec n) (* n acc))))

(defn factorial [n]
  (if (or (float? n) (neg? n))
    -1
    (_factorial (biginteger n) 1)))