(ns overtone-practice.overtonepractice20190106
  (use [overtone.core]))

;;sample recorded 2014/01/25 in a studio on W 27th, NYC

(def lunch (load-sample "./resources/IN/lunch.wav")) ;; 95616 frames

(def my-pool (overtone.at-at/mk-pool))


(defsynth slicer [start 0 len 0.25 buff_rate 1] 
  (out 0 (* (env-gen (perc (/ len 2) (/ len 2)) :action 2) 
            (play-buf 2 lunch buff_rate 1 start 1))))    

(defn -main []
  ;;(recording-start "./resources/OUT/overtonepractice_20190106.wav")
  ;;(overtone.at-at/after 3000 #(recording-stop) my-pool)
  (let [sample-len (num-frames lunch)
        tenth (/ sample-len 10)]
   (slicer 0)
   (overtone.at-at/after 250  #(slicer (* tenth 1)) my-pool)
   (overtone.at-at/after 500  #(slicer (* tenth 2)) my-pool)
   (overtone.at-at/after 750  #(slicer (* tenth 3)) my-pool)
   (overtone.at-at/after 1000 #(slicer (* tenth 4)) my-pool)
   (overtone.at-at/after 1250 #(slicer (* tenth 5)) my-pool)
   (overtone.at-at/after 1500 #(slicer (* tenth 6)) my-pool)
   (overtone.at-at/after 1750 #(slicer (* tenth 7)) my-pool)
   (overtone.at-at/after 2000 #(slicer (* tenth 8)) my-pool)
   (overtone.at-at/after 2000 #(slicer (* tenth 9)) my-pool)))

