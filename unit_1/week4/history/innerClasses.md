## Sorting and Filtering with Inner Classes

### Objectives
* Use member classes, local classes, and anonymous classes for sorting and filtering lists..

### Overview
The `President` class includes appropriate fields, getters and setters, and a constructor that takes all fields.  It also implements `Comparable<President>`, overriding `compareTo()` to set the natural sort order using term number.

The file _presidents.tsv_ consists of records with tab-separated fields.  _PresidentApp.java_ has a method that parses this file, creating an ArrayList of President objects.  Its `printPresidents()` method takes `List<President>` and prints it using `President`'s `toString()`.

### Requirements

#### Sorting
* Create a method that returns a list of presidents sorted by party and term number.  Use a **member class** that implements Comparator<President>.  Pass the original list to this method, and print the resulting list.

* Create a method that returns a list of presidents sorted by the reason they left office, then by term number.  Use a **local class** for the comparator.  Pass the original list to this method, and print the resulting list.

* Create a method that returns a list of presidents sorted by last name.  Use an **anonymous class** for the comparator.  Pass the original list to this method, and print the resulting list.

* Use an anonymous class to print a list of presidents sorted by length of term.

* Use an anonymous class to print a list of presidents whose terms started in the 19th century.

#### Filtering
The `PresidentMatcher` interface defines the boolean method `matches()`, which takes a string and a `President` reference.  The `PresidentPartyMatcher` example returns true if the string matches the president's party (ignoring case).

In `PresidentApp`, the `filter()` method takes a string and a `PresidentMatcher` implementation, returning a list containing presidents for which the matcher's `matches()` method returns true.

* Use `PresidentPartyMatcher` and the `filter()` method to print a list of Whig presidents.

* Define a **member class** that implements PresidentMatcher, with `matches()` returning true if the president's first name starts with the string passed in.

* Use a **local** (in `start()`) implementation of PresidentMatcher that matches presidents based on why they left office.  Print the list of presidents who left when their term ended.

* Use `filter()` and **anonymous** `PresidentMatcher` implementations to print lists of Presidents:
  * Whose last names start with "C".
  * Whose party contains the string "Democrat".
  * Who died in office
  * Who won only a single election.
