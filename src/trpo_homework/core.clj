(ns trpo-homework.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn get_perm [perm chars]
  (for [x perm
        y chars
        :when (not (= (first x) y))]
    (flatten (conj x y))))

(defn print_perm [n chars]
  (loop [perm (into [] (map vector chars))
         i 0]
    (if (= i (- n 1))
      perm
      (recur (get_perm perm chars)
             (inc i)))))