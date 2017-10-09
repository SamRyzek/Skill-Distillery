# Key - Value Pairs
> ... hashes, maps, dictionaries, objects...whatever you want to call them

### 0 : You have been provided with several data points:

* ips : an array of comma seperated IP addresses

* states : an object containing many objects representing US States

* commit : an object from the github api representing a commit

### 1 : Modify the following function...

...such that it will return an object representing a state from the 'states' object when it's abbreviation is provided

```js
var getStateByAbbr = function(abbr) {
/************************* Your Solution *************************/


/*****************************************************************/
}
console.log(getStateByAbbr('CO'))
```

### 2 : Modify the following function...

...to return the name of the capital of the state by it's abbreviation

```js
var getStateCapitalByAbbr = function(abbr) {
/************************* Your Solution *************************/


/*****************************************************************/
}
console.log(getStateCapitalByAbbr('CO'))
```

### 3 : Return an array of state objects within some distance of a provided latitude and longitude

```js
var getStatesWithinDegreesOfLatLong = function(lat,long,distance) {
/************************* Your Solution *************************/


/*****************************************************************/
}
console.log(getStatesWithinDegreesOfLatLong(33,-112,10))
```

### 4 : Modify the following 'countProperties' function ...  
  
...Use the for...in loop to count the number of properties in the provided object.

```js
var countProperties = function(obj) {
/************************* Your Solution *************************/


/*****************************************************************/
};
console.log(countProperties(states));
```

### 5 : Return an object. The properties of the object should be the unique IP addresses ... 

...and the values should be the number of times that that IP address made a request

```js
var logAccessByIp = function(ips) {
/************************* Your Solution *************************/



/*****************************************************************/
};
console.log(logAccessByIp(ips));
```

### 6 : Use the provided commit JSON to format and return a new object like the following:

```js
{
  committer : "The committer's name",
  timestamp : "The date the commit was authored",
  msg : "The commit message",
  sha : "The commit's sha"
}
```

```js
var formatGithubCommit = function(commit) {
/************************* Your Solution *************************/



/*****************************************************************/
};
console.log(formatGithubCommit(commit));
```

##### [Prev](../README.md) | [Next](../../ch5/README.md)
