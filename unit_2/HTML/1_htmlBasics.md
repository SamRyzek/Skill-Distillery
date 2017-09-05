## HTML

### Overview
HTML is a markup language we will be using to display information via web browsers to a user. Tim Berners-Lee originally invented HTML as a medium to share academic papers with his peers. All HTML documents follow the same base structure. They are written inside of files with the `.html` extension.

#### Structure
```HTML
<!DOCTYPE html>
<html>
<head>
  <title>Page Title</title>
</head>
<body>

</body>
</html>
```

The head of the document contains meta information about the document that is being displayed. The body contains all of the visible elements the user can interact with on a page. This is where we will be adding HTML elements to the document.

### Elements
HTML elements or tags are keywords wrapped in angle brackets. Most elements require an opening and closing tag. The closing tag adds a `/` in front of the final keyword.

```html
<h1>Hello</h1>
```
* `<h1>`: opening tag of type h1.
* `Hello`: the tags content. This is what will be rendered to the screen.
* `</h1>`: closing tag. Must match the type of the opening tag, h1.

If you forget an end tag, some browsers may not be able to properly interpret your document. Because HTML is so forgiving, the browser will attempt to render the content anyway. This can result in elements being unexpectedly nester or some other bizarre behavior.
```html
<h1>Hello
```

#### Empty tags
Some elements do not require an opening and closing tag. If an element is not going to have content inside of it, it may be an indicator that you do not need a closing tag. A break tag, which inserts an empty line at that location, can simply be added as `<br>`.

Other examples of this are image tags or form inputs:
```html
<img src="myPicture.jpg">
<input type="submit" value"SUBMIT">
```

#### Nested elements
Some html elements are required to be nested. When building a list for example you have the options of a numbered, ordered list, or bulleted, unordered list. Theres tags are `<ol>` and `<ul>` respectively. When building one of these elements the list type element wraps the content that will be inside of the list. Each `<li>` below is a bullet point.


```html
<ul>
  <li>Andrew</li>
  <li>Kris</li>
  <li>Steve</li>  
  <li>Rob</li>
</ul>
```
Yeilds:
* Andrew
* Kris
* Steve
* Rob  

```html
<ol>
  <li>Andrew</li>
  <li>Kris</li>
  <li>Steve</li>  
  <li>Rob</li>
</ol>
```

Yeilds:  
1. Andrew  
2. Kris  
3. Steve  
4. Rob   

[Prev](README.md) | [Up](../README.md) | [Next](2_htmlHelloWorld.md)
