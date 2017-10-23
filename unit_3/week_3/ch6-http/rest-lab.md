# REST Lab

This lab will have you create a database to support a REST API for your todos.

We will also create support for users (which we will use later), because it will be easier to do it now then update it later.

### Part 1 : Make a Database
1: Create a `user` table as follows:

```bash
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| email    | varchar(255) | NO   |     | NULL    |                |
| password | varchar(255) | NO   |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
```

2: Create a `todo` table as follows:

```bash
+---------------+--------------+------+-----+---------------------+-----------------------------+
| Field         | Type         | Null | Key | Default             | Extra                       |
+---------------+--------------+------+-----+---------------------+-----------------------------+
| id            | int(11)      | NO   | PRI | NULL                | auto_increment              |
| task          | varchar(55)  | NO   |     | NULL                |                             |
| description   | text         | YES  |     |                     |                             |
| completed     | tinyint(1)   | YES  |     | 0                   |                             |
| user_id       | int(11)      | NO   | MUL | NULL                |                             |
| due_date      | varchar(50)  | YES  |     | NULL                |                             |
| complete_date | varchar(50)  | YES  |     | NULL                |                             |
| created_at    | timestamp    | NO   |     | 0000-00-00 00:00:00 |                             |
| updated_at    | timestamp    | NO   |     | 0000-00-00 00:00:00 | on update CURRENT_TIMESTAMP |
+---------------+--------------+------+-----+---------------------+-----------------------------+
```

### Part 2 : Make a [JPA Project][jpa]
1: Create a JPA project that will be used by the MVC project for DATA when providing a REST API

  * you'll need a [persistence.xml][pers]

2: Create a `User` entity which maps the `user` table from MySQL.

3: Create a `Todo` entity which maps the `todo` table from MySQL.

4: Test that your configuration is working, create at least one User and some todos for that user.

### Part 3 : Create a DAO to Modify Data

The following is just a suggestion for a DAO Interface.

***NOTE*** In this implemenation, instead of handling the object mapping in the controller you will delegate that responsibility to the DAO to keep your controller skinny.

```java
package data;

import java.util.Set;

import entities.Todo;

public interface TodoDAO {
  public Set<Todo> index(int uid);

  public Todo show(int uid, int tid);

  public Todo create(int uid, String todoJson);

  public Todo update(int uid, int tid, String todoJson);

  public Boolean destroy(int uid, int tid);
}

```

### Part 4 : Create and Expose a RESTful Routes to perform CRUD on todos

Example of what you controller methods could look like.

* ***NOTE***: This is an interface, you do not HAVE to use/implement this interface, it is simply here for guidance.

```java
public interface TodoControllerI {
//    GET /user/{uid}/todo
    public Collection<Todo> index(HttpServletRequest req, HttpServletResponse res, int uid);

//    GET /user/{uid}/todo/{tid}
    public Todo show(HttpServletRequest req, HttpServletResponse res, int uid, int tid);

//    POST /user/{uid}/todo
    public Todo create(HttpServletRequest req, HttpServletResponse res, int uid, String todoJson);

//    PUT /user/{uid}/todo/{tid}
    public Todo update(HttpServletRequest req, HttpServletResponse res, int uid, int tid, String todoJson);

//    DELETE /user/{uid}/todo/{tid}
    public Boolean destroy(HttpServletRequest req, HttpServletResponse res, int uid,int tid);
}
```

#### [Prev](pokemon-lab.md) | [Next](lab.md)

[jpa]:https://github.com/SkillDistillery/SD9/blob/master/unit_2/week4/ch1/dependencies_gradle.md
[pers]:https://github.com/SkillDistillery/SD9/blob/master/unit_2/week4/ch1/persistence_xml.md
