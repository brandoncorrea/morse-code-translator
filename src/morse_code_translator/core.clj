(ns morse-code-translator.core
  (:use [clojure.string :only [split join trim]]
        [morse-code-translator.morse :only [->morse morse->]]))

(defn- input-loop [f]
  (while true
    (print "> ")
    (flush)
    (println (f (read-line)))))

(defn- delegate-input-loop []
  (println "What would you like to do?")
  (loop [choice ""]
    (cond
      (= choice "1") (input-loop ->morse)
      (= choice "2") (input-loop morse->)
      :else (do (println "1. Translate To Morse Code")
                (println "2. Translate From Morse Code")
                (print "Enter 1 or 2: ")
                (flush)
                (recur (trim (read-line)))))))

(defn -main []
  (println "Morse Code Translator")
  (println "Press CTRL + C to exit")
  (println "----------------------")
  (delegate-input-loop))
