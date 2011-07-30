# clj-ex

The problem is this:

* Java's Exception class can only carry a String as its payload. That is often inadequate. We would like our exceptions to carry anything we tell them to (i.e. an Object).
* In clojure it is difficult to subclass a concrete class - it requires AOT compilation, or mixing Java code into your clojure project, or other shenanigans.

This project aims to be the absolute simplest possible solution to this problem.


## Usage

```clojure
(ns my.ns
  (:import (clj_ex BasicException)))

(try
  (throw (BasicException. {:anything ["whatever" "you" "want"]
                           :message "oops, it's borked!"}))
  (catch BasicException e
    (println e)          ;; #<BasicException clj_ex.BasicException: oops, it's borked!>
    (println (.data e))  ;; {:anything [whatever you want], :message oops, it's borked!}
    ))

```

That's all - just a subclass of Exception that:

* Takes an Object argument to its constructor
* Returns its constructor argument via the `data` method
* Uses the value of `:message` (if supplied) as its message (returned from getMessage and used in toString)

Other higher-level utilities, such as throw/catch macros with destructring, are deliberately omitted. This is just meant to be a building block.


## License

Copyright (C) 2011 Chris Perkins

Distributed under the Eclipse Public License, the same as Clojure.
