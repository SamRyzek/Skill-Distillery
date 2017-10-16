## Walkthrough

We can retrieve all address and a single address by its id. Now lets try to create a new one and persist it to our DB RESTfully.

1: Create a route in your DAO that takes an Address object as an argument. This method should persist the address object, flush the entity manager, and the return the newly created object from the database.
```java
public Address create(Address address){
  em.persist(address);
  em.flush();

  return em.find(Address.class, address.getId());
}
```
2: In your controller write a POST method called create mapped to the route `/api/addresses`. You are going to need to extract the json we send inside of the request from something called the request body. Spring provides us with something called `@RequestBody` which extracts and assigns a string representation of the json into a variable.
```java
@RequestMapping(path="addresses", method=RequestMethod.POST)
public Address create(@RequestBody String jsonAddress){

}
```

3: Use the object mapper we discussed to map this json into an Address Object. The compiler will force you to surround the mapping in a try catch block. Return the newly created address from the controller method.
```java
ObjectMapper mapper = new ObjectMapper();
Address newAddress = null;
try {
  newAddress = mapper.readValue(jsonAddress, Address.class);
} catch (Exception e) {
  e.printStackTrace();
}
return addressDAO.create(newAddress);
```

4: Run the program and hit the route `http://localhost:8080/api/addresses` with a POST request in postman. To add content to the body of a postman request, go to the Body tab, click on raw, and type any valid json into this text area. For our purposes we need to provide a json representation of an address object:
```json
{
  "street": "7400 E Orchard Dr",
  "street2": null,
  "state": "Colorado",
  "city": "Greenwood Village",
  "postalCode": "80210",
  "phone": "(303) 302-5234",
  "country": {
    "countryCode": "US",
    "name": "United States of America"
  }
}
```

[Previous](demo_address_show.md) | [Next](negating_recursive_json.md)
