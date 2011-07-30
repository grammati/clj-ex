(ns clj-ex.core
  (:gen-class
   :extends RuntimeException
   :name clj_ex.BasicException
   :constructors {[Object] [String]}
   :init init
   :state state
   :methods [[data [] Object]]))

(defn -init [data]
  [[(get data :message)] data])

(defn -data [this]
  (.state this))

