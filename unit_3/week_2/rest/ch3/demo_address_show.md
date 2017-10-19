## Walkthrough

We have an index route working that returns all the addresses in our database. But what if we want a single addresses by its id.

1: Create a second method in your DAO that retrieves a single Address by its id. Assume the id is going to be passed into the method as a parameter.
```java
public Address show(int id){
  return em.find(Address.class, id);
}
```

2: In your controller create a second method called show. This method will take a path of `/api/addresses/{id}` where is the {id} is a URI parameter (PathVariable).
```java
@RequestMapping(path="addresses/{id}", method=RequestMethod.GET)
public Address show(@PathVariable int id){
  return addressDAO.show(id);
}
```

3: Run the program and hit the route `http://localhost:8080/RESTVideoStore/api/addresses/1` in postman. View the returned json data. Your should get
```json
{
  "id": 1,
  "street": "47 MySakila Drive",
  "street2": null,
  "stateProvince": "Alberta",
  "city": "Lethbridge",
  "postalCode": "",
  "phone": "",
  "country": {
    "countryCode": "CA",
    "name": "Canada"
  }
}
```

[Previous](demo_address_index.md) | [Next](demo_address_create.md)
