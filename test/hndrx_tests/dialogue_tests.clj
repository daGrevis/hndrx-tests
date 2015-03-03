(ns hndrx-tests.dialogue-tests
  (:require [clojure.test :refer :all]
            [clj-webdriver.taxi :refer :all]
            [hndrx-tests.utils :refer :all]))

(def BASE-URL "http://127.0.0.1:8000")

(deftest two-people-can-message-each-other
  (let [driver1 (new-driver {:browser :chrome})]
    (to driver1 BASE-URL)
    (println (text (find-el driver1 "#peer-id")))
    (quit driver1)))
