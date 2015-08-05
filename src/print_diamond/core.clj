(ns print-diamond.core)

(defn- char-range [start end]
  (map char (range (int start) (inc (int end)))))

(def ^:private alphabet (map str (char-range \A \Z)))

(defn- spaces [n]
  (clojure.string/join (repeat n "_")))

(defn- current-line [letter pos given-letter-pos]
  (let [spaces-side (spaces (- given-letter-pos pos))
        spaces-middle (spaces (dec (* 2 pos)))]
    (if (= letter "A")
      (str spaces-side letter spaces-side)
      (str spaces-side letter spaces-middle letter spaces-side))))

(def ^:private previous-lines take)

(defn- diamond-lines [pos lines middle-line]
  (clojure.string/join
    "\n"
    (concat (previous-lines pos lines)
            [middle-line]
            (reverse (previous-lines pos lines)))))

(defn print-diamond [letter]
  (let [letter-pos (.indexOf alphabet letter)]
    (loop [letters alphabet lines [] pos 0]
      (let [current-letter (first letters)
            new-line (current-line current-letter pos letter-pos)]
        (if (= letter current-letter)
          (diamond-lines pos lines new-line)
          (recur (rest letters)
                 (conj lines new-line)
                 (inc pos)))))))