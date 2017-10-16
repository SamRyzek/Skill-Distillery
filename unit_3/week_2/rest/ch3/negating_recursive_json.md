# Dealing with Recursive JSON
We can get into situations where our objects have over objects within them. When these objects are translated to json we can get nested json that continuously reference each other. As you can see, it can get a little crazy.

```java
public class User {
    public int userID;
    public String fname;
    public String lname;
    public List<Account> userAccounts;
}

public class Account {
    public int id;
    public String itemName;
    public int balance;
    public User owner;
 }
 ```
 In this example out User will have a list of accounts, which in turn have a user within them... which in turn have a list of accounts. It never ends and will cause your program to hang with a stack overflow error. We have to configure our java classes with a few annotations so that the java can be properly be mapped to json.

##### @JsonManagedReferance
This is the forward part of the reference. Whichever entity that you want the information to be stored inside of will take this side of the relationship.  

##### @JsonBackReferance
This is the back part of the reference. The entity with this annotation will not have the field mapped into json when queried.

We would implement these annotations as follows:

```java
public class User {
    public int userID;
    public String fname;
    public String lname;

    @JsonManagedReferance
    public List<Account> userAccounts;
}

public class Account {
    public int id;
    public String itemName;
    public int balance;

    @JsonBackReference
    public User owner;
 }
 ```

 * If there are multiple references in a single class the annotations can become ambiguous. We can fix this by giving the relationship a `value` property in addition to the annotation.

 ```java
 public class User {
     public int userID;
     public String fname;
     public String lname;

     @JsonManagedReferance(value="userToAccount")
     public List<Account> userAccounts;
 }

 public class Account {
     public int id;
     public String itemName;
     public int balance;

     @JsonBackReference(value="userToAccount")
     public User owner;
  }
  ```

 [Previous](demo_address_create.md) | [Next](demo_film_index.md)
