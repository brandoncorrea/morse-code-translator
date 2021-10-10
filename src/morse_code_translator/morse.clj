(ns morse-code-translator.morse
  (:use [clojure.string :only [split join trim]]))

(def ^:private morse-mapping
  {"a" ".-"
   "b" "-..."
   "c" "-.-."
   "d" "-.."
   "e" "."
   "f" "..-."
   "g" "--."
   "h" "...."
   "i" ".."
   "j" ".---"
   "k" "-.-"
   "l" ".-.."
   "m" "--"
   "n" "-."
   "o" "---"
   "p" ".--."
   "q" "--.-"
   "r" ".-."
   "s" "..."
   "t" "-"
   "u" "..-"
   "v" "...-"
   "w" ".--"
   "x" "-..-"
   "y" "-.--"
   "z" "--.."

   "0" "-----"
   "1" ".----"
   "2" "..---"
   "3" "...--"
   "4" "....-"
   "5" "....."
   "6" "-...."
   "7" "--..."
   "8" "---.."
   "9" "----."

   " " "/"
   "." ".-.-.-"
   "," "--..--"
   "!" "-.-.--"
   "?" "..--.."
   "@" ".--.-."
   ":" "---..."
   "'" ".----."
   "-" "-....-"
   "/" "-..-."
   "(" "-.--."
   ")" "-.--.-"
   "\"" ".-..-."
   "=" "-...-"
   "+" ".-.-." })

(defn- mappings-by-value [v]
  (filter #(= v (second %)) morse-mapping))

(defn- char-by-value [v]
  (-> v mappings-by-value ffirst))

(defn ->morse [phrase]
  (trim (join " " (map morse-mapping (split (.toLowerCase phrase) #"")))))

(defn morse-> [code]
  (join (map char-by-value (split code #" "))))
