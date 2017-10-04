(ns trpo-homework.core)

(def ^:const intervals_number 10)

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

(defn trapeze_method [func point]
  (let [step (/ point intervals_number)]          ;; step = (b - a)/N
    (loop [i 1
           sum (* 1/2 (+ (func 0) (func point)))] ;; sum = 0.5 * (f(0) + f(point))
      (if (= i intervals_number)
        (* step sum)
        (recur (inc i)
               (+ sum (func (* step i))))))))     ;; sum += func(step * i)

(defn trapeze_method_memoize [func point]
  (let [step (/ point intervals_number)
        func_memoize (memoize func)]          ;; step = (b - a)/N
    (loop [i 1
           sum (* 1/2 (+ (func 0) (func point)))] ;; sum = 0.5 * (f(0) + f(point))
      (if (= i intervals_number)
        (* step sum)
        (recur (inc i)
               (+ sum (func (* step i))))))))     ;; sum += func(step * i)

(defn check_times []
  (time (trapeze_method (fn [x] x) 10))
  (time (trapeze_method (fn [x] x) 20))
  (time (trapeze_method (fn [x] x) 30))
  (time (trapeze_method (fn [x] x) 30))
  (time (trapeze_method_memoize (fn [x] x) 10))
  (time (trapeze_method_memoize (fn [x] x) 20))
  (time (trapeze_method_memoize (fn [x] x) 30))
  (time (trapeze_method_memoize (fn [x] x) 30)))