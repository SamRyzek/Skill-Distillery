# Entity Relationships

* When you learned *Object Oriented Programming*, you saw how objects can contain other objects (or even collections of other objects) as fields.

* Similarly when you were taught SQL, you learned about how to use JOINs to gather data from multiple tables in a single request.

* JPA allows us to combine the principles of *Object Oriented Programming* with the ability to query across SQL tables using Entity Relationships known as *Associations*.

* JPA provides support for seven types of *Associations*.

  * *Associations* can be:

    * one-to-one :

      * *A Customer* ***HAS ONE*** *Address*

    * one-to-many

      * *A Film* ***HAS MANY*** *Languages*

    * many-to-one

      * *Languages* ***HAVE ONE*** *Film*

    * many-to-many

      * *Films* ***HAVE MANY*** *Actors* **AND** *Actors* ***HAVE MANY*** *Films*

  * Direction can be uni-directional or bi-directional.

* There is an annotation for each cardinality type which you apply to the field that holds the related entity.

  * For bi-directional relationships, apply the cardinality annotation to both entities.

### Relationships in our DB & Design Considerations:
Between the customer and address table there is a one-to-one relationship. A single customer contains a single address. Or, looking at it from the other side of the relationship, a single address belongs to single customer. We will map the customer to address relationship shortly.  

Between the address and country there is a many-to-one relationship. Many addresses belong to a single country. Or, looking at it from the other side of the relationship, it is a one-to-many relationship. A single country contains many addresses. We will map the address to country relationship in the next chapter.  

Direction can be unidirectional or bidirectional. For direction it is best to think of the entities, not the database tables. For customer and address should you store an address field in customer? Or, should a customer be stored as a field in address? Or, both? The first and second cases are unidirectional, whereas the last case is bidirectional. Which choice is best is ultimately a design decision based on how you plan to use the data. 

[Previous](README.md) | [Next](one_to_one.md)
