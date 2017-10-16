## Labs

The next feature we want to implement is adding questions and answers to our quizzes.  

1: Build the Question and Answer SQL tables. They should follow this format:  
* Question
  * id
  * quiz_id
  * questionText
* Answer
  * id
  * question_id
  * answerText
  * isCorrect

2: In your JPA project, create a Question entity:  
  * id  
  * questionText  

  Also create a Answer entity with the following fields:  
  * id  
  * answerText  
  * isCorrect  

3: Do to our database design we know that an Answer has a foreign key (question_id) that defines a `@OneToMany` bi directional relationship between Question and Answer.

Create a bi-directional, one-to-Many relationship between your Question and Answer entities.

* Modify Question, add a field of type Set<Answer> annotated with @OneToMany, and set the mappedBy element to the corresponding field in Answer.

* As a bi-directional relationship, the Answer entity must also be updated. Add a field of type Question, annotate it with @ManyToOne and @JoinColumn.

* Also, add get and set methods in each class for the new fields.

4: Similarly we are going to need to create a bi-directional, many-to-one relationship between your Quiz and Question entities.

* Modify Quiz, add a field of type Set<Question> annotated with @OneToMany, and set the mappedBy element to the corresponding field in Question.

* As a bi-directional relationship, the Question entity must also be updated. Add a field of type Question, annotate it with @ManyToOne and @JoinColumn.

* Also, add get and set methods in each class for the new fields.

**We use a set in these relationships to eliminate the possibility of duplicated objects**

5: Using the dump file provided to you populate for db with a few example question and answers.

* In your JPAQuiz project test directory, write an additional jUnit test in your QuizTest.java file to see if you are able to query the db and retrieve a Collection of questions.

6: That should be all the set up on the JPA side of things. Lets now look back at our QuizController class in our Spring Rest project. We are going to need to implement the three remaining methods from out Controller and DAO Interfaces.
* The routes are as follows:  

  `GET quizzes/{id}/questions`  - Gets all questions for a quiz  
  `POST quizzes/{id}/questions` - Adds a question to a quiz  
  `DELETE quizzes/{id}/questions/{questId}` - Deletes a question from a quiz  

* The manipulation of questions and answers will be done in our QuizController class. We are never going to add questions or answers that don't belong to a quiz therefore they wont need separate DAO's or CRUD at the entity level.  

* The reason we have separate routes to access the questions is so we adhere to proper RESTful implementation and design resource specific routes. When we uery for a Quiz, we should not be returned the entire entity, but rather just the id and the name properties. To access the list of questions associated with that Quiz, we need to hit the designated route, `GET quizzes/{id}/questions`.

7: To accomplish our above goals we will need to add some additional Jackson annotations on our entities.

* In your JPAQuiz build.gradle file include the Jackson-annotations dependency:
```    
compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version: '2.8.5'
```

* Place an `@JsonIgnore` on the Set of Question objects in your Quiz class. This will cause any serialization or deserialization to ignore this field in json.

* Similarly ignore the Quiz field in your Question object.

* It makes sense to have a Question object contain a collection of Answers for an individual collection so we do not want to ignore this field. Instead,
  * Place an `@JsonManagedReference` annotation on the Question side of this relationship.
  * Place an `@JsonBackReference` annotation on the Answer side of this relationship.


8: Test your basic routes for Quiz CRUD, they should work just as before.
* Implement the 3 remaining controller and dao methods.  
  * For your showQuestions method you will need to implement a JOIN FETCH between Question and Answers to avoid any Lazy loading issues.  

9: Once you have completed this you API is finished you should have the endpoints:  

* `GET api/ping` : for debugging and testing  
* `GET api/quiz/` : get all quizzes  
* `GET api/quiz/{id}` : get a quiz by an id  
* `POST api/quiz/` : create a new quiz  
* `PUT api/quiz/{id}` : update a quiz  
* `DELETE api/quiz/{id}` : delete a quiz by id  
* `GET api/quiz/{id}/questions` : get all questions for a quiz  
* `POST api/quiz/{id}/questions` : create a question for a quiz by id  
* `DELETE api/quiz/{id}/questions/{q_id}` : deletes a question from a quiz by id  


[Previous](quiz_crud.md) | [Next](../ch5/README.md)
