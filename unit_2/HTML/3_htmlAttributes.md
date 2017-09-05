## HTML

### Attributes
HTML elements can also contain attributes. Think of attributes as Meta information stored within the tag.  When we get into JS you will see that we can create our own custom attributes to store any additional information we think is important. A normal element is structured as follows.

```html
<p>This is an a tag</p>
```

Certain tags have pre set attributes we can use to add functionality to our page. For example, if we wanted to include a link in a page we would use the `<a>` tag. This tag has an attribute, `href`, that allows us to link to a certain page.

```html
<a href="http://www.google.com">Go to google<a>
```

Attributes are defined inside of the opening tag. Attribute names like tag names are case-insensitive.
The value is enclosed in either single or double qoutes.  **There must be no spaces around the `=` sign**. 

When a user clicks on the words "Go to google", the link would cause the page to be directed to google's home page.

Similarly an image tag has a source attribute,`src`, that will load an image from the specified location.

```html
<img src="myPicture.jpg"/>
```

[Prev](2_htmlHelloWorld.md) | [Up](../README.md) | [Next](4_html_glossary.md)
