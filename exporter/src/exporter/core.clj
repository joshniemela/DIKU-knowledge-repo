(ns exporter.core
  (:require [clojure.string :as s]
            [clojure.java.io :as io]
            [clojure.java.shell :as shell])
  (:gen-class))


; open Bases.md

(defn normalise [s]
  ; lowercase and remove spaces
  (-> s
      (s/lower-case)
      (s/replace #"\s" "")))

; All links of the form [name...]([[link-name]]) are replaced by [name...](#link-name)
(defn format-aliased-links [s]
  (let [re #"\[([^\]]+)\]\(\[\[([^\]]+)\]\]\)"
        ; first group is name, second group is link
        f (fn [[_ name link]]
            (str "[" name "](#" (normalise link) ")"))]
    (s/replace s re f)))

(defn format-links [s]
  (let [re #"\[\[([^\]]+)\]\]"]
    ; Convert [[name]] to [name](#name)
    (s/replace s re (fn [[_ name]] (str "[" name "](#" (normalise name) ")")))))

(defn format-tags [s]
  ; anything of the form #tag is replaced by [tag](#tag)
  (let [re #" \#\[\[([^\]]+)\]\]| \#([^\s]+)"
        f (fn [[_ tag]]
            (str "[" tag "](#" (normalise tag) ")"))]
    (s/replace s re f)))

(defn format-md [s]
  (-> s
      format-aliased-links
      format-links))


(defn add-header [s note-name]
  (str "# " note-name "\n" "[" note-name "]: #"
       note-name "\n\n" s))

(defn process-file [file]
  (let [s (slurp file)
        name (first (s/split file #"\."))]
    (-> s
        (add-header name)
        format-md
        ; add \pagebreak at the end
        (str "\n\n\\pagebreak\n\n"))))

(defn merge-all-files [files]
  (->> files
       (map process-file)
       (apply str)))

; Find all markdown files and return only their names
(defn markdowns [path]
  (let [files (map str (.list (io/file path)))]
    (filter #(re-matches #".*\.md" %) files)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [mds (markdowns ".")
        out (merge-all-files mds)]
    ; spit out, then run pandoc, then delete
    (spit "notes.md" out)
    (shell/sh "pandoc" "-V" "colorlinks=true" "-o" "notes.pdf" "notes.md")
    (shell/sh "rm" "notes.md")
    (shutdown-agents)))
