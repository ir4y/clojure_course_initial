(ns fibonacci.core)

(defn even-sum [& args]
   (reduce + (map (fn [x]
                    (if (= (mod x 2) 0)
                    x
                    0)) 
            args))
  )


(defn fib [max]
  (defn _fib 
    ([] (_fib 1 1 ))
    ([x y]
      (if (> y max) 
        [y] 
        (concat [x]  (_fib y (+ x y))))))
  _fib)



(defn -main
    [& args]
    (println  (apply even-sum ((fib 4000000)) )))

