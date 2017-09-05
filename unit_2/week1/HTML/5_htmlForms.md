## HTML Forms

A large part of the web is dealing with forms. Forms provide an interface for a user to provide input. Think about how many Signup, login, shipping, billing pages you have filled out in your life.

#### The form element
* Forms consist of a few key elements, the first being:
```HTML
<form>
</form>
```
* This form tag provides an encapsulated area in which you can add fields that pertain only to that one form.
* multiple forms can exist on a single page.

#### Inputs
* Input fields are exactly what they sound like, areas for user input.
* The input tag looks like this `<input>`
* Input tags are only using inside of an encapsulating `<form>` tag
* There are however multiple types of input tag, checkboxes, buttons, dates, radio buttons are all rendered with the same `<input>` tag. The browser uses the 'type' attribute assigned to the tag to know what to render. A few of the attribute options are listed below:
  * button
  * **checkbox**
  * **date**
  * email
  * **hidden**
  * month
  * password
  * **radio**
  * **submit**
  * **text**

```HTML
<form>
  <input type="text"/>
  <input type="date"/>
  <input type="submit"/>
</form>
```

[Prev](4_html_glossary.md) | [Up](../README.md)

