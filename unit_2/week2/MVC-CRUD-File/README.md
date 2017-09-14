## Spring MVC C.R.U.D.

It's time at last to put those web skills you've been learning to use!  

### Overview
We are going to have you create a CRUD application, completely from scratch, in order to get a handle on what in the hell you've been doing this week.  The goal here is to get comfortable with building a web app, not persisting the data. We can however use the DAO pattern we have seen over the past two weeks to mimic the functionality of a database, and implement a simple form of file persistence

### The Application
The goal here is to have you implement C.R.U.D. (Create, Read, Update, Delete), which is some of the most common behavior on the web.  It represents the states of persistence that almost every application has ([further reading for those interested][crudwiki]). Usually CRUD is associated with a database, but we don't want you worrying about one of those, so we are just going to use an array or map for persistence, and save its contents to a file.

Your application should adhere to the MVC pattern. Benefits of the MVC pattern is similar to that of encapsulation. There is a separation of concerns between the individual elements that make up the model, view, and controller respectively. Changing code in one has no affect on the code in the others. Their interactions are discussed below.

#### MVC Elements
* The Model: Houses the data being used in the interaction. The data is received via the controller and passed on to the view.

* The View: Is what is displayed in the browser. For our purposes this will be a JSP or HTML document. These documents manipulate the models data and give it a user facing display.

* The Controller: The controller manages all of these interactions. It manipulates the model and passes this changed data to an appropriate view.

<img src="MVC.png" width ="300"/>

Below are a list of project starting points you can choose from:
* A media application (Music, Movies, Video Games).
* A sports application.
* A restaurant menu system.
* An inventory management system.

### Expectations
A finalized version of your project is due Monday. Your app must be built using the Spring framework that we have discussed over the course of the week. When finished you also need to deploy the WAR to your AWS EC2 hos and add a link to the project via your resume website.

#### Grading

This is a graded project. You are expected to have your project completed by 11 am on Monday.

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

* Create, Read, Update, and Delete functionality work with one of your objects through a web GUI.
* The project must be deployed to your AWS EC2 instance
* The project must be added to your github account with a README.md spelling out:
  * Who did the project?  
  * What was the project?  
  * What technologies did you use?  
  * What future feature sets you would like to add?  
  * Any stumbling points you encountered?  

If the project does not work with the above test conditions, you will be given a 0 for this week's project.

If you get a zero on the project, you can upgrade to a score of .5 if you turn in a working project by the start of class the following Monday morning AND notify an instructor that you wish to get partial credit.

**Be prepared to discuss your project with the class in a concise 5 minute presentation.**

#### Stretch goals

* Have nested CRUD. That being an object that has an object inside of it that can be created, read, updated, and deleted.

### Resources
You can find a collection of Spring [resources][resources] in the link provided. The resources are organized by category. In addition there are files to help you with your project set up in the XMLConfig repository a link to it is provided [here](../XMLConfig).



[resources]:https://github.com/SkillDistillery/SD-Core/wiki/Tutorials-and-References
[crudwiki]:https://en.wikipedia.org/wiki/Create,_read,_update_and_delete
