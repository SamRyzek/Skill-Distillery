## Presidents Lab

In this lab you will use Java's file I/O API to create an application that reads data from a file and writes data back out.

* Create a class called President.  It should have fields for termNumber, firstName, middleName, lastName, startYear, endYear, and party.   Add in appropriate constructors, gets/sets, and a toString() method. 

* In a separate file, create a program with a main that calls a method to read in the file [presidents.csv](presidents.csv) and parses the data into an ArrayList of President objects.  The method should return the List of Presidents.  

* Create another method in the same class as #2 to print the presidents.  The method should accept a List of President objects as a parameter and use a for each loop to display each president.  

* Write filter methods that given a List of presidents, return another List with the following filter criteria applied: a) Return a List of presidents who are members of the Whig party. b) Return a List of presidents who have a middle name c) Return a List of presidents who served for less than four years.  d) Return a List of presidents whose last name starts with ‘R’.  e) Be creative and filter by something else. 

* Add an additional method (or two) to write out a new file for each presidential party.  The file should contain the first name and last name of each president that belonged to that party each on its own line.

* Read in [presidents.txt](presidents.txt) instead of [presidents.csv](presidents.csv).  The text file is not as normalized, so it will present parsing challenges.
