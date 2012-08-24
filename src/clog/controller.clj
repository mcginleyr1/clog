(ns clog.controller
  (:use clog.templates
        clog.models
        ring.util.response))

(defn index
  "Index page handler"
  [req]
  (->> (home-page) response))

