(ns hndrx-tests.utils
  (:require [clj-webdriver.taxi :refer :all]))

(defn find-els
  ([sel] (find-els *driver* sel))
  ([driver sel] (css-finder driver sel)))

(defn find-el
  ([sel] (find-el *driver* sel))
  ([driver sel] (first (find-els driver sel))))

(defn press-enter [sel]
  (send-keys sel (clj-webdriver.core/key-code :enter)))
