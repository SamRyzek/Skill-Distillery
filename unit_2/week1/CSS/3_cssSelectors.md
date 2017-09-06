## CSS Targeting: Selectors

### Rulesets

There are many ways to target a style rule to an HTML element. The basic format of a targeted element is:

```css
  p {color: red; font-size: 20px}
```

* `p` is the selector, targeting any HTML `<p>` element.
* `color` and `font-size` are properties.
* `red` and `20px` are the values assigned to the properties.
* `color: red;` and `font-size: 20px;` are style rules.
* `p {color: red; font-size: 20px}` is a ruleset.

#### Element

We can apply a ruleset to all tags of a certain type. If we wanted all `<h1>` elements to have red text we could change the color attribute:

```css
h1 {
    color: red;
}
```

The element or elements we are targeting are listed first. This element is then followed by a `{}` similar to a code block. Inside of the curly brackets we can alter properties to whatever we see fit. Each attribute we are altering is listed out in the following format `property-name: value;`. ***Each rule must be terminated with a semicolon***.  We can include as many properties as we want to alter for that element.

#### Class

Any HTML element can have a `class` attribute containing a space-separated list of classes the element belongs to.  Class names are arbitrary:

```html
<h1 class="myCustomClass header textStuff">Text content<h1>
```

The same class can be assigned to multiple elements in a document. This allows you to assign the same stylings to multiple element types.  To select a class for a ruleset, precede a classname with `.`:

```css
.myCustomClass {
  color: red;
  background-color: green;
}
```

#### ID

Any HTML element can have an id attribute:

```html
<h1 id="uniqueID">Text content<h1>
```

IDs need to be unique within the HTML file. They are used to target specific elements within a page. If you want to style one specific `<h1>` tag you could use an id to do so. IDs will become more important to target elements when we get into JS.

To target a ruleset using an ID, precede ID value with `#`.

```css
#uniqueID {
  color: green;
  font-family: verdana;
  font-size: 20px;
}
```

### Combining Selectors

* Element/class: You can specify particular elements of a particular class:

```css
h2.productTitle {
  color: blue;
}
```

* Ancestor/descendant: space-separated elements require the selected element to have particular ancestor elements in the document hierarchy.  This rule selects any list item that is inside a `ul` which itself is inside a `p` paragraph:

```css
p ul li {
  color: green;
}
```

* Parent/child: A greater-than sign, `>`, requires the right-hand element to be the direct child of the left-hand selector.  This rule selects an `h3` element that is nested directly under a `div` element.

``css
div > h3 {
  text-decoration: underline;
}

* Multiple selectors: You can apply a single style rule to a comma-separated list of selectors:

```css
p ul li, div > h3, h2.productTitle {
  background-color: lightgrey;
}
```
### Specificity

In the cascade, more specific selectors have higher precedence than less-specific. The basic selectors above appear in order of specificity:

* Element
* Class
* ID

In addition, combining selectors increases specificity:

```css
div#someClass p {}
```
(Paragraphs nested inside any div with the class `someClass`) is more specific than
```css
div p {}
```
(Paragraphs nested inside any div), which is more specific than
```css
p {}
```
(Any paragraph)

<hr>

[Prev](2_cssHello.md) | [Up](../README.md) | [Next](4_cssPositioning.md)
