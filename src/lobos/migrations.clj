(ns lobos.migrations
  ;; exclude some clojure built-in symbols so we can use lobos' symbols
  (:refer-clojure :exclude [alter drop bigint boolean char double float time])
  ;; use only defmigraiton macro from lobos
  (:use (lobos [migration :only [defmigration]]
              core
              schema
        ))
)

;; Define database for lobos migrations
(def clogdb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "clogdb"
   :user "clog"
   :password "clogdb"
})

(defmigration add-authors-table
  ;; code to be executed when migrating the schema "up" using "migrate"
  (up [] (create clogdb
            (table :authors (integer :id :primary-key)
                  (varchar :username 100 :unique)
                  (varchar :password 100 :not-null)
                  (varchar :email 255))))
  ;; Down or rollback actions
  (down [] (drop (table :authors))))

(defmigration add-posts-table
  (up [] (create clogdb 
          (table :posts (integer :id :primary-key)
            (varchar :title 250)
            (text :content )
            (boolean :status (default false))
            (timestamp :created (default (now)))
            (timestamp :published)
            (integer :authors [:refer :authors :id] :not-null))))
  (down [] (drop (table :posts))))

