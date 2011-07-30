(ns clj-ex.test.core
  (:import (clj_ex BasicException))
  (:use [clojure.test]))

(deftest test-basic-exception
  (try
    (throw (BasicException. {:foo "bar"}))
    (catch BasicException x
      (is (= "bar" (:foo (.data x))))
      (is (= nil (.getMessage x)))))
  (try
    (throw (BasicException. {:message "hello"}))
    (catch BasicException x
      (is (= "hello" (.getMessage x))))))
