## CSS Basics

Cascading Style Sheets (CSS) allow us to separate visual presentation of an HTML page from the page content.

Every element of an HTML document has many CSS properties that determine its visual presentation and positioning.  There are hundreds of CSS properties, some generic, some specific to certain types of HTML elements like images or tables.

A CSS rule has the form:

```css
property-name: property value;
```

### Applying styles

To apply a style, you can use:

1. Inline styles: any HTML element can have a `style` attribute in its opening tag, containing a list of CSS properties (style rules):
   
   ```html
   <p style="font-family: cursive; text-decoration: underline;">Lorem ipsum ...</p>
   ```
   However, this defeats a primary purpose of CSS, which is to separate all styling from the HTML content.  You should never use inline styles.

2. Internal stylesheet:  in the head of your HTML page, you can use the `<style>` tag to enclose a list of style rulesets:
   
   ```html
   <html>
   <head><title>My Page</title>
     <style type="text/css">
     p {
         font-family: cursive;
         text-decoration: underline;
     }
     </style>
   </head>
   <body> ...
   ```
   While this disentangles the style rules from the HTML tags, it still requires editing the HTML page source to change presentation.  This can be cumbersome if the HTML is actually generated dynamically by program code.

3. External stylesheet: place CSS rulesets in one or more separate stylesheet files (by convention named with the `.css` extension, and use the `<link>` tag to associate them with the HTML:
   
   myStyles.css:
   ```css
   p {
         font-family: cursive;
         text-decoration: underline;
   }
   ```
   
   index.html:
   ```html
   <html>
   <head><title>My Page</title>
     <link rel="stylesheet" type="text/css" href="myStyles.css">
   </head>
   <body> ...
   ```

### The Cascade

As the page author you can link multiple stylesheets to your page.  In addition, each browser (*user agent*) has its own prebuilt stylesheet that defines default styles for all elements. Finally,  a user can apply their own stylesheet to your page (for example, someone with a visual impairment might style all text for size and contrast).  When multiple stylesheets try to set the same style property, the values [*cascade*][MDNCascade] in order of:

* Importance: a style rule can be marked as `!important` to give it higher priority.

* Specificity: the most specific selector has higher priority than less-specific selectors (more on selectors coming up...)

* Order of appearance: The order in which the browser encountered the rules.
  * Browser (user-agent) stylesheet rules.
  * Author style rules:
    * Internal and external stylesheets, in the order they appear in they appear in the document.
    * Inline styles (which we won't use).
  * User style rules (these are not very common).

#### Inheritance

In the absence of a specific rule, many CSS properties are inherited from parent elements.

<hr>

[Prev](README.md) | [Up](../README.md) | [Next](2_cssHello.md)

[BuildingYourFirstWebPage]: http://learn.shayhowe.com/html-css/building-your-first-web-page/
[MDNCascade]: https://developer.mozilla.org/en-US/docs/Web/CSS/Cascade
