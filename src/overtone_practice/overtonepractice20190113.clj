(ns overtone-practice.overtonepractice20190113
  (use [overtone.core]))

(defn -main []
  ;;SCBook Pg 4
  ;;(definst bloop [] (sin-osc (+ (* (lf-noise0 12) 600) 1000) 0.3))
  ;;(definst bloop [] (-> (lf-noise0 12) (* 600) (+ 1000) (sin-osc 0.3))
  
  ;;SCBOOK Pg 5
  ;;(definst bloop [] (rlpf (dust 12) (+ (* (lf-noise0 4) 1500) 1600) 0.02))
  (definst bloop [] (rlpf (dust 12) (-> (lf-noise0 4) (* 1500) (+ 1600)) 0.02))
  (bloop))
