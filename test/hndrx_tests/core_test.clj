(ns hndrx-tests.core-test
  (:require [clojure.test :refer :all]
            [hndrx-tests.core :refer :all]))

(use 'clj-webdriver.taxi)

(defn setup []
  (set-driver! (new-driver {:browser :chrome}))
  (to "http://127.0.0.1:8000"))

(defn teardown []
  (quit))

(defn each-fixture [f]
  (setup)
  (f)
  (teardown))

(defn find-els [sel]
  (css-finder sel))

(defn find-el [sel]
  (first (find-els sel)))

(defn press-enter [sel]
  (send-keys sel (clj-webdriver.core/key-code :enter)))

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
