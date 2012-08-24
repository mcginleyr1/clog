(ns clog.models
  (:use korma.db
        korma.core))

(defdb clogdb
  {:classname "org.postgresql.Driver"
    :subprotocol "postgresql"
    :subname "clogdb"
    :user "clog"
    :password "clog"})

(defentity authors)
(defentity posts)
