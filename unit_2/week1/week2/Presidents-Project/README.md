### Presidents Slide Show

#### Overview

In the Presidents Slide Show application you will display a web page with information about a president.  A user should be able to click next and previous buttons to scroll through the presidents in order.  They should also be able to jump to a particular president by entering in their term number.

##### User Story #1

As a user I can enter the presidents term number to view information about the president.

Conditions of satisfaction:
* Make sure to include the name, image, term number, party, and dates in office.
* Make sure to add at least one more interesting piece of data about the president.

##### User Story #2

As a user I can choose the next button to view information about the next president.

Conditions of satisfaction:
* Make sure to handle the last president gracefully.

##### User Story #3

As a user I can choose the previous button to view information about the previous president.

Conditions of satisfaction:
* Make sure to handle the first president gracefully.

##### User Story #4 (Optional)

As a user I can choose to see a filtered list of presidents (for example, only the republicans).

Conditions of satisfaction:
* Make sure the next/previous buttons only navigate through the filtered list.

#### Grading

This is a graded project.  You are expected to have your project completed by noon on Monday.  

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

* President 2 entered, John Adams should display
* Next button clicked, Thomas Jefferson should display
* Previous button clicked, John Adams should display again
* Previous button on George Washington should either be grayed out, scroll to Trump, or work in some other graceful way.
* Next button on Donald Trump should either be grayed out, scroll to Washington, or work in some other graceful way.

If the project does work with all of the above test conditions, you will be given a *1* for this week's project.

If the project does not work with the above test conditions, you will be given a *0* for this week's project.

If you get a zero on the project, you can upgrade to a score of *.5* if you turn in a working project by the start of class the following Monday morning AND notify an instructor that you wish to get partial credit. 

To turn in a project, you must push it to GitHub.  You must also deploy it to your AWS server (we will show you how to do that Monday morning).  You must include a README.md that describes your program and how to access it on AWS.

