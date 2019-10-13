(ns clj.classificator
  (:require
    [clj.rules :as rules]
    [clojure.set]))

(defn tags-intersection
  "Return intersection between tags of question and check-set parameter
   element: {:id 27715, :tags ['python' 'machine-learning']}
   check-set: ['php' 'django' 'cuda']"
  [element, check-set]
  (clojure.set/intersection (set (:tags element)) check-set))

(defn contain-tag?
  "Check whether the question have specific tag
   tag: 'python'
   question: {:id 27715, :tags ['python' 'machine-learning']}"
  [tag question]
  (boolean (some #(= tag %) (:tags question))))

(defn filter-questions-by-tags-stop-list [stop-list operation questions]
  "Remove questions with tags from stop-list"
  (filter (fn [x] (operation (count (tags-intersection x stop-list)) 0)) questions))

; TODO: create one function
(defn fix-first-nil-values
  "Remove nil values from :second classification"
  [questions]
  (map (fn [x]
         (assoc x :first
                  (if (some? (:first x)) (:first x) "general"))) questions))

(defn fix-second-nil-values
  "Remove nil values from :second classification"
  [questions]
  (map (fn [x]
         (assoc x :second
                  (if (some? (:second x)) (:second x) "general"))) questions))


(defn test-first-level-rule
  "Test rule against the questions
   question: {:id 27715, :tags ['python' 'machine-learning'], :site 'stackoverflow'}
   rule: { :site 'stackoverflow' :include 'python' :result 'python' }"
  [question rule]
  (and
    (or
      (= (:site question) (:site rule))
      (= (:site rule) "*")
      )
    (or
      (contain-tag? (:include rule) question)
      (= (:include rule) "*")
      )
    ))

(defn test-second-level-rule
  "Test rule against the questions
   question: {:id 27715, :tags ['python' 'machine-learning'], :site 'stackoverflow', :first 'python}
   rule: { :site 'stackoverflow', :first 'python' :include 'tenserflow' :result 'machine learning' }"
  [question rule]
  (and
    (= (:first rule) (:first question))
    (or
      (= (:site question) (:site rule))
      (= (:site rule) "*")
      )
    (or
      (contain-tag? (:include rule) question)
      (= (:include rule) "*")
      )
    ))

(defn find-first
  "Returns first element of vector that satisfies a function"
  [test-foo rules]
  (first (filter test-foo rules)))

(defn find-rule-for-question
  "Find first rule that satisfies a question
   rules: first-rules || second-rules
   question: {:id 27715, :tags ['python' 'machine-learning']}, :site 'stackoverflow', [ .. :first 'python' ]"
  [rules question compare-function]
  (let [local-test (partial compare-function question)]
    (find-first local-test rules)))

(defn first-classify-question
  "Add first classification to question
   rules: first-rules
   question: {:id 27715, :tags ['python' 'machine-learning'], :site 'stackoverflow'}
   result {:id 27715, :tags ['python' 'machine-learning']}, :site 'stackoverflow', :first 'python'"
  [rules question]
  (let [rule (find-rule-for-question rules question test-first-level-rule)]
    (assoc question :first (:result rule))))

(defn second-classify-question
  "Add second classification to question
   rules: second-rules
   question: {:id 27715, :tags ['python' 'machine-learning'], :site 'stackoverflow', :first 'python'}
   result {:id 27715, :tags ['python' 'machine-learning']}, :site 'stackoverflow', :first 'python', :second 'ml'"
  [rules question]
  (let [rule (find-rule-for-question rules question test-second-level-rule)]
    (assoc question :second (:result rule))))

(defn first-classify-questions
  "Add first classification to vector of questions"
  [rules questions]
  (map (partial first-classify-question rules) questions))

(defn second-classify-questions
  "Add second classification to vector of questions"
  [rules questions]
  (map (partial second-classify-question rules) questions))


(defn classify [questions]

  (println "Starting classification...")

  (let [stop-tag-questions (filter-questions-by-tags-stop-list rules/stop-list > questions)
        work-questions (filter-questions-by-tags-stop-list rules/stop-list = questions)]

    (println "  stop tag questions: " (count stop-tag-questions))
    (println "  work questions: " (count work-questions))

    (let [classified-questions (->> work-questions
                                    (first-classify-questions rules/first-list)
                                    (second-classify-questions rules/second-list))
          good-classified-questions (filter (fn [q] (some? (:first q))) classified-questions)
          bad-classified-questions (filter (fn [q] (nil? (:first q))) classified-questions)]


      (println "Questions was classificatied:" (count good-classified-questions))
      (println "Questions was skipped:" (count bad-classified-questions))

      (->>
        classified-questions
        (fix-first-nil-values)
        (fix-second-nil-values)))))
