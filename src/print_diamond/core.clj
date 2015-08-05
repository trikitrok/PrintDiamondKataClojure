(ns print-diamond.core)

(defn- char-range [start end]
  (map char (range (int start) (inc (int end)))))

(def ^:private alphabet (map str (char-range \A \Z)))

(defn build-line-to-be-repeated [letter]
  (let [letters-until (concat (take-while #(not= % letter) alphabet) [letter])]
    (apply str (concat (reverse (drop 1 letters-until)) letters-until))))

(defn substitute-spaces [line letter]
  (apply str (map #(if (= (str %) letter) letter "_") line)))

(defn lines-number-in-uppper-triangle [letter]
  (inc (.indexOf alphabet letter)))

(defn upper-diamond-lines [letter]
  (let [line (build-line-to-be-repeated letter)
        times (lines-number-in-uppper-triangle letter)]
    (map substitute-spaces (repeat times line) (take times alphabet))))

(defn diamond-lines [letter]
  (let [upper-part (upper-diamond-lines letter)]
    (concat upper-part (reverse (drop-last upper-part)))))

(defn print-diamond [letter]
  (clojure.string/join "\n" (diamond-lines letter)))