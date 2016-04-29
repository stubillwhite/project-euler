(ns project-euler.utils)

(defmacro def- [name & decls]
  (list* `def (with-meta name (assoc (meta name) :private true)) decls))
