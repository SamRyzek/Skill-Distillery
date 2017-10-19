## Delete requests

* DELETE requests are as simple as GETs.  

* There is no data required in the interaction so you only need to provide the id of the entity you are trying to delete in your RESTful uri.  

* DELETEs traditionally return a true/false boolean not an object.  

```javascript
$.ajax({
    type: "DELETE",
    url: "api/quizzes/3",             //destroy quiz with id=3
});
```

[Previous](ajax_put_post.md) | [Next](pokemonCreate.md)
