(ns prime.core)

(defn devisible-by [x y] (= (mod x y) 0))
(defn devisible-by? [y] 
  (fn [arg] (devisible-by arg y)))

(defn eratosfen [maxnum]
  (defn _eratosfen [result e_list]
    (def p (first e_list))
    (if (> (* p p) maxnum)
      result
      (recur (concat [p] result) (remove (devisible-by? p) e_list))))
  (_eratosfen [] (range 2 maxnum)))

(defn find_divider [number p_list]
  (def p (first p_list))
  (if (= (mod number p) 0)
    p
    (recur number (next p_list))
  ))

(defn -main
    [& args]
    (def number (/ 6008514751432 2))
    (println  (find_divider number (eratosfen number))))
