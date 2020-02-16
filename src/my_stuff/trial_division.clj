(ns my-stuff.trial-division
  (:gen-class))

(defn _trial-division-div-bigger-than-two [n div list]
  (if (<= n 1)
    list
    (if (not= 0 (rem n div))
      (recur n (+ div 2) list)
      (recur (/ n div) div (conj list div)))))

(defn _trial-division-div-equals-two [n list]
  (if (<= n 1)
    list
    (if (not= 0 (rem n 2))
      (_trial-division-div-bigger-than-two n 3 list)
      (recur (/ n 2) (conj list 2)))))

(defn trial-division [n]
  (if (float? n)
    []
    (_trial-division-div-equals-two n [])))
