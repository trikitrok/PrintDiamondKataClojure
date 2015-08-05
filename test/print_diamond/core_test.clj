(ns print-diamond.core-test
  (:use midje.sweet)
  (:require [print-diamond.core :refer [print-diamond]]))

(facts
  "about printing diamonds"

  (print-diamond "A") => "A"

  (print-diamond "B") => "_A_\nB_B\n_A_"

  (print-diamond "C") => "__A__\n_B_B_\nC___C\n_B_B_\n__A__"

  (print-diamond "D") => "___A___\n__B_B__\n_C___C_\nD_____D\n_C___C_\n__B_B__\n___A___")