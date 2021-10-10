(ns morse-code-translator.morse-spec
  (:require [speclj.core :refer :all]
            [morse-code-translator.morse :refer :all]))

(describe "->morse"
  (it "Empty string translates to an empty string"
    (should= "" (->morse "")))
  (it "Space translates to a forward-slash"
    (should= "/" (->morse " ")))
  (it "Period translates to .-.-.-"
    (should= ".-.-.-" (->morse ".")))
  (it "Exclamation point translates to -.-.--"
    (should= "-.-.--" (->morse "!")))
  (it "@ Translates to .--.-."
    (should= ".--.-." (->morse "@")))
  (it "Comma translates to −−..−−"
    (should= "--..--" (->morse ",")))
  (it "Colon translates to ---..."
    (should= "---..." (->morse ":")))
  (it "Question mark translates to ..--.."
    (should= "..--.." (->morse "?")))
  (it "Apostrophe translates to .----."
    (should= ".----." (->morse "'")))
  (it "Hyphen translates to -....-"
    (should= "-....-" (->morse "-")))
  (it "Forwardslash translates to -..-."
    (should= "-..-." (->morse "/")))
  (it "Left-parentheses translates to -.--."
    (should= "-.--." (->morse "(")))
  (it "Right-parentheses translates to -.--.-"
    (should= "-.--.-" (->morse ")")))
  (it "Double quote translates to .-..-."
    (should= ".-..-." (->morse "\"")))
  (it "Equal sign translates to -...-"
    (should= "-...-" (->morse "=")))
  (it "Plus sign translates to .-.-."
    (should= ".-.-." (->morse "+")))

  (it "Uppercase 'A' translates to .-"
    (should= ".-" (->morse "A")))
  (it "Lowercase 'a' translates to .-"
    (should= ".-" (->morse "a")))
  (it "B translates to -..."
    (should= "-..." (->morse "B")))
  (it "C translates to -.-."
    (should= "-.-." (->morse "C")))
  (it "D translates to -.."
    (should= "-.." (->morse "D")))
  (it "E translates to ."
    (should= "." (->morse "E")))
  (it "F translates to ..-."
    (should= "..-." (->morse "F")))
  (it "G translates to --."
    (should= "--." (->morse "G")))
  (it "H translates to ...."
    (should= "...." (->morse "H")))
  (it "I translates to .."
    (should= ".." (->morse "I")))
  (it "J translates to .---"
    (should= ".---" (->morse "J")))
  (it "K translates to -.-"
    (should= "-.-" (->morse "K")))
  (it "L translates to .-.."
    (should= ".-.." (->morse "L")))
  (it "M translates to --"
    (should= "--" (->morse "M")))
  (it "N translates to -."
    (should= "-." (->morse "N")))
  (it "O translates to ---"
    (should= "---" (->morse "O")))
  (it "P translates to .--."
    (should= ".--." (->morse "P")))
  (it "Q translates to --.-"
    (should= "--.-" (->morse "Q")))
  (it "R translates to .-."
    (should= ".-." (->morse "R")))
  (it "S translates to ..."
    (should= "..." (->morse "S")))
  (it "T translates to -"
    (should= "-" (->morse "T")))
  (it "U translates to ..-"
    (should= "..-" (->morse "U")))
  (it "V translates to ...-"
    (should= "...-" (->morse "V")))
  (it "W translates to .--"
    (should= ".--" (->morse "W")))
  (it "X translates to -..-"
    (should= "-..-" (->morse "X")))
  (it "Y translates to -.--"
    (should= "-.--" (->morse "Y")))
  (it "Z translates to -.-.."
    (should= "--.." (->morse "Z")))

  (it "0 translates to -----"
    (should= "-----" (->morse "0")))
  (it "1 translates to .----"
    (should= ".----" (->morse "1")))
  (it "2 translates to ..---"
    (should= "..---" (->morse "2")))
  (it "3 translates to ...--"
    (should= "...--" (->morse "3")))
  (it "4 translates to ....-"
    (should= "....-" (->morse "4")))
  (it "5 translates to ....."
    (should= "....." (->morse "5")))
  (it "6 translates to -...."
    (should= "-...." (->morse "6")))
  (it "7 translates to --..."
    (should= "--..." (->morse "7")))
  (it "8 translates to ---.."
    (should= "---.." (->morse "8")))
  (it "9 translates to ----."
    (should= "----." (->morse "9")))

  (it "Translates the word, 'Hello'"
    (should= ".... . .-.. .-.. ---" (->morse "Hello")))
  (it "Translates the word, 'Hello, world!'"
    (should= ".... . .-.. .-.. --- --..-- / .-- --- .-. .-.. -.. -.-.--" (->morse "Hello, world!")))
  (it "Translates word with character outside mapping"
    (should= ".... . .-.. .-.. ---" (->morse "#Hello"))))

(describe "morse->"
  (it "Translates an empty string"
    (should= "" (morse-> "")))
  (it "Translates .- to a"
    (should= "a" (morse-> ".-")))
  (it "Translates -... to b"
    (should= "b" (morse-> "-...")))
  (it "Translates to hello"
    (should= "hello" (morse-> ".... . .-.. .-.. ---")))
  (it "Translates to 'hello, world!'"
    (should= "hello, world!" (morse-> ".... . .-.. .-.. --- --..-- / .-- --- .-. .-.. -.. -.-.--"))))
