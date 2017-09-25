# Self Reference

* A data item within a table may have a reference back to another row in the same table.

  * This can be loosely described as a parent/child relationship.

* For example, a supervisor, who is a member of a company’s staff, would supervise multiple other staff members.

  * This is a many-to-one relationship where the objects stored in the many and in the one are the same datatype (sometimes this is referred to as a polymorphic association).

* Model this type of relationship with an `@ManyToOne` over the parent field and an `@OneToMany` over the child collection field.

```java
@Entity
public class Staff {
  //...
  @ManyToOne
  @JoinColumn(name="supervisor_id")
  private Staff supervisor;

  @OneToMany(mappedBy="supervisor")
  private List<Staff> employees;
  //...
}
```

### Hands On:
1: Model the supervisor relationship in the *Staff* entity. Don’t forget to add gets/sets for both new fields.

Write tests in *StaffTest* to ensure that the associations are returning the correct objects. (***HINT***: Be sure the staff member you are querying has a supervisor)
