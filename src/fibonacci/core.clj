(ns fibonacci.core)

(defn even-sum [& args]
   (reduce + (remove (fn [x] (not (even? x))) args))
  )

(defn fib [max]
  (defn _fib 
    ([] (_fib 1 1 []))
    ([x y result]
      (if (> y max) 
        (concat [y] result)
        (recur y (+ x y) (concat [x] result)))))
  _fib)

(defn -main
    [& args]
    (println  (apply even-sum ((fib 4000000)) )))
