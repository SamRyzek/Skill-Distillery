# Labs

0: Create a file in the client package named `JPQLLab` (this is where you will complete the following:

1: Create a program that uses JPQL to retrieve all Customers in the
database whose id is between 100 and 110. Output their first name, last
name, and email. (Hint: You can use the `BETWEEN` reserved word in JPQL
just like SQL.)

2: Modify your previous solution, use a parameter to set both the minimum
and maximum ids instead of hard-coding them into the query String.

3: Refactor your program into an instance method in the *JPQLLab* class named `getRangeOfCustomers`.

  * the method should take two arguments (minId, maxId), both ints

  * return the correct list of Customers given these inputs

  * Create a new class in the *test* directory named *JPQLTest*

    * write a test to ensure that `getRangeOfCustomers` retrieves *Customer* objects within the correct range

4: Write a method in the *JPQLLab* class named `getCustomerByName`.

  * the method takes two Strings as an argument (fname,lname)

  * return either a single Customer object...or null

  * write a test to ensure that a *Customer* can be retrieved (choose a customer that exists to test)

5: Write a method in the *JPQLLab* class named `getStoresByState`.

  * the method takes a single String as an argument (state)

  * return a list of stores

  * query for the state of "Washington"

  * Write a test to ensure that your method is working

6: Write a method in the *JPQLLab* class named `getRentalsForCustomerWithCustomerId`.

  * the method takes a single int as an argument (id)

  * return a list of rentals associated with the customer of the provided id

  * Write a test to ensure that the rentals are retrieved (and that the correct number of rentals are retrieved)

[Previous](query_parameters.md) | [Next](../ch6)
