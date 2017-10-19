## CRUD with AJAX  
For the following examples lets assume we have an API configured following proper REST protocol with these routes.
* GET `api/employee`- returns all the employees  
* PUT `api/employee/{id}`- updates the employee with the provided id  
* POST `api/employee`- creates a new employee  
* DELETE `api/employee/{id}`- removes the employee with the provided id  

### Ajax GET
```javascript
$.ajax({
    type: "GET",
    url: "api/employee",
    dataType: "json",
});
```

Would retrieve all employees stored in the database and call a function `displayEmployees()`

### Ajax PUT
```javascript
var person = {fname: "Charles", lname: "Johnson"};

$.ajax({
    type: "PUT",
    url: "api/employee/6",
    dataType: "json",
    contentType: 'application/json',
    data: JSON.stringify(person),
});
```

Would edit the employee with id 6. Their first and last names would be changed to Charles and Johnson respectively.

### Ajax POST
```javascript
var person = {fname: "Peter", lname: "Smith"};

$.ajax({
   type: "POST",
   url: "api/employee",
   dataType: "json",
   contentType: 'application/json',
   data: JSON.stringify(person),
});
```
Would create a new employee with the name Peter Smith.

### Ajax DELETE
```javascript
$.ajax({
    type: "DELETE",
    url: "api/employee/6",
    dataType: "json",
});
```

Would delete the employee with id 6.

[Previous](pokemonDelete.md) | [Next](ajax_extras.md)
