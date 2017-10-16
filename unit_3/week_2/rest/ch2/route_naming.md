### CRUD with REST

* CRUD stands for CREATE - READ - UPDATE - DELETE regarding data storage and manipulation. A good example for this is Craigslist. You **CREATE** a post, a user **READS** a  post, you can **UPDATE** a post, and you can **DELETE** a post. Over the primary communications protocol of the web, HTTP we can send requests that have meaning to the server. The types of HTTP are as follows:
  * `GET` -> READ
  * `POST` -> CREATE
  * `PUT` -> UPDATE
  * `DELETE` -> DELETE

* For the most part, the different method types are purely semantic. The notable exception to this rule is `GET`. `GET` cannot convey data in the body of a request, and must pass any meta information as part of a URL string instead (e.g. as `@RequestParam`s or `@PathVariable`s).

### CRUD Method Naming
* CRUD and REST are so synonymous, that there is a vocabulary of controller actions that have conventionally been used in conjunction with different actions. Take the following example of a 'Products' resource, and refer to the 'Action' column:

Example of a `ProductsController`:

| Action | HTTP Method | Result (controller#action) | Url Template |
|--------|-------------|----------------------------|--------------|
| INDEX | GET | products#index | /products |
| SHOW | GET | products#show | /products/{id} |
| CREATE | POST | products#create | /products |
| UPDATE | PUT | products#update | /products/{id} |
| DESTROY | DELETE | products#destroy | /products/{id} |

* As this example illustrates, an *index* method would correspond to the path `/products` with a type of `GET`. This method would respond with a list of all of the products.


```java
@RestController
public class ProductsController {
  @Autowired
  ProductDAO dao;

  @RequestMapping(value = "products", method = RequestMethod.GET)
  public List<Product> index() {
    return dao.index();
  }

}
```

* **NOTE** We will mostly be using the `index`, `show`, `create`, `update` and `destroy` methods as they deal exclusively with data.

### Multi Level Resources
Resources can have multiple levels of access to them. In the above example we only concerned ourselves with CRUD for the products themselves. A store like Amazon allows users to post reviews about individual products as well.

Example of “ReviewsController”. Each review corresponds to a product.

| Action | HTTP Method | Result (controller#action) | Url Template |
|--------|-------------|----------------------------|--------------|
| INDEX | GET | reviews#index | /products/{productId}/reviews |
| SHOW | GET | reviews#show | /products/{productId}/reviews/{id} |
| CREATE | POST | reviews#create | /products/{productId}/reviews |
| UPDATE | PUT | reviews#update | /products/{productId}/reviews/{id} |
| DESTROY | DELETE | reviews#destroy | /products/{productId}/reviews/{id} |


[Previous](pingPong.md) | [Next](../ch3/README.md)
