(ns hndrx-tests.monologue-tests
  (:require [clojure.test :refer :all]
            [clj-webdriver.taxi :refer :all]
            [hndrx-tests.utils :refer :all]))

(defn setup []
  (set-driver! (new-driver {:browser :chrome}))
  (to "http://127.0.0.1:8000"))

(defn teardown []
  (quit))

(defn each-fixture [f]
  (setup)
  (f)
  (teardown))

(deftest header-contains-project-name
  (is (text (find-el "h1"))
      "Hndrx"))

(deftest role-is-undecided
  (is (text (find-el "#role"))
      "Undecided"))

(deftest i-can-send-message-to-myself
  (let [message "Hello, world!"]
    (input-text "#message" message)
    (press-enter "#message")
    (is (.contains (text (find-el "#messages li"))
                   message))))

(use-fixtures :each each-fixture)
