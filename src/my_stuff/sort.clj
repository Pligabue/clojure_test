(ns my-stuff.sort
  (:gen-class))

(defn bubble-sort-iter [A i end]
  (let [next (inc i)]
   (if (= next end)
     A
     (let [a (get A i) b (get A next)]
       (if (> a b)
         (recur (assoc A i b next a) next end)
         (recur A next end))))))

(defn _bubble-sort [A end]
  (if (= end 1)
    A
    (recur (bubble-sort-iter A 0 end) (dec end))))

(defn bubble-sort [A]
  (_bubble-sort A (count A)))