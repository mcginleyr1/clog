(ns clog.templates
  (:use [net.cgrand.enlive-html]))

(deftemplate home-page "home.html" []
  [:title] (content "Clog - the clojure blog engine!"))


