(ns overtone-practice.overtonepractice20190106b
  (use [overtone.core]))

;;sample recorded 2014/01/25 in a studio on W 27th, NYC

(def lunch (load-sample "./resources/IN/lunch.wav")) ;; 95616 frames

(def my-pool (overtone.at-at/mk-pool))


(defsynth slicer [start 0 len 0.25 buff_rate 1] 
  (out 0 (* (env-gen (perc (/ len 2) (/ len 2)) :action 2) 
            (play-buf 2 lunch buff_rate 1 start 1))))    

(defn -main []
  ;;(recording-start "./resources/OUT/overtonepractice_20190106b.wav")
  ;;(overtone.at-at/after 3000 #(recording-stop) my-pool)
  (let [grain-count 80
        sample-len (num-frames lunch)
        grain-len-samples (/ sample-len grain-count)
        grain-len-secs (/ grain-len-samples 44100)
        grain-len-ms  (* grain-len-secs 1000)
        grain-interval (* grain-len-ms 0.5)]
    (for [i (range grain-count)]
     (overtone.at-at/after (* i grain-interval)  #(slicer (* grain-len-samples i) grain-len-secs 1) my-pool))))
   

