## HTML
* An HTML directive or tag consists of a tag name, with optional attributes, contained within angle brackets (<>).
  * Tags are human-readable and embedded in the text they mark up.
  *  Browsers interpret the tags and render the content accordingly.
    * Browsers ignore any tags they don't understand
  * Between the tags are the text content of the page.
  * Tag names are not case-sensitive, unless the page declares it is using **xhtml**, the XML version of HTML.
  * All white space in text - spaces, tabs, newlines, etc. is discarded by the browser as it decides how to render the text.
* A tag is either empty (standalone) or non-empty.
* An empty tag's presence represents the content to include.

  ```html
  <hr /> <!-- Draw a horizontal rule (line) here -->
  ```
  <hr /> <!-- Draw a horizontal rule (line) here -->
* An non-empty tag determines how to treat the text between it and its closing tag.

  ```html
  <p>This is a paragraph, to be rendered with blank lines above and below.</p>
  ```
  <p>This is a paragraph, to be rendered with blank lines above and below.</p>
* `href` anchor tags produce a clickable (or otherwise activated) hyperlink to another page or resource, thus creating hypertext.

  ```html
  Read the <a href="/content/fullstory/42.html">Full story</a>.
  ```
  Read the <a href="/content/fullstory/42.html">Full story</a>.


<hr>
The structure of an HTML document consists of:
<br>
<kbd>
<b>&lt;!DOCTYPE html&gt;<br />
&lt;html&gt;<br />
&lt;head&gt;<br />
&lt;title&gt;</b>This is my web page<b>&lt;/title&gt;<br />
&lt;/head&gt;<br />
&lt;body&gt;</b><br />
&lt;h1&gt;This is the main header of my page&lt;/h1&gt;<br />
&lt;hr /&gt;<br />
&lt;p&gt;This is the first paragraph of my page content.<br />
Extra &nbsp;&nbsp;&nbsp;&nbsp;blanks&nbsp;&nbsp;&nbsp; <br />
and newlines<br /><br />
will be discarded, and the browser will flow the text according<br \>
to the tags (and stylesheet directives, if present).&lt;/p&gt;<br />
<b>&lt;/body&gt;<br />
&lt;/html&gt;</b>
</kbd>

Early versions of HTML focused on formatting text, originally for scientific publications with titles, sections, subheads, paragraphs, quotations, lists, and the like. Tags were created for defining appearance and layout: a \<center\> tag instructing the browser to horizontally center everything enclosed; a \<font\> tag specifying basic properties (typeface, relative size, color, etc.) of the enclosed text - but separate \<b\> and \<i\> tags for bold and italic text. The syntax of HTML was somewhat loose and informal, and browsers were expected to be forgiving of things like unclosed or improperly-nested tags. HTML focused on formatting content for human readers, and all layout and styling was done with HTML tags and attributes.

As the web grew rapidly in the early 1990s and HTML evolved, new tags proliferated, each with its own attributes for controlling their specific styling options, making it harder for authors to learn and for browsers to keep up with in implementation. Web proponents saw a need to separate document presentation from document content, and out of several competing ideas CSS (Cascading Style Sheets) emerged. Styling attributes and tags began to disappear from HTML, with pages instead accompanied by embedded or separately referenced stylesheets that instruct the browser to select certain elements and apply style rules to them. CSS and HTML have evolved side-by-side ever since.

The forgiving nature of HTML browsers, and the resulting sloppy structure of much early web content, made it difficult to write programs to reliably and meaningfully parse and search web pages. Early on, as the web was just beginning to develop, Tim Berners-Lee and others proposed moving toward a markup, and a web, which defined not the superficial appearance of text in a browser, but which described the meaning of the content, and in a way easy to parse by programs as well: the Semantic Web. The success of this vision is debatable but out of it grew some important standards including XML (eXtensible Markup Language), a more rigidly-defined syntax that can be reliably parsed and navigated by programs, and HTML5 which defines new structural markups and browser capabilities.

[Prev](WorldWideWeb.md) | [Up](../README.md) | [Next](UriUrl.md)
