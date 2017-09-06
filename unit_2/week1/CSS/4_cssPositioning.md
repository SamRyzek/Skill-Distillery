## Positioning Elements

By default a page will be laid out by the browser as a left-to-right, top-to-bottom vertical flow based on the size of content and space available.

### The Box Model

<img src="box-model.jpg" width ="200"/>

Every element is comprised of a box. The box has four components: content, padding, border, and margin. Content has a height and a width property while the rest can be broken down into top/bottom/left/right properties, which set their respective properties in the appropriate direction.

* Padding: Transparent area surrounding the content.
* Border: A border surrounding the padding.
* Margin: Transparent area outside the border.

If you were trying to calculate the total width of an element it would be:
Content(width) + (paddingLeft + paddingRight) + (borderLeft + borderRight) + (marginLeft + marginRight). Height would be the same formula using Content height and the appropriate top and bottom properties of the other elements.

### `position` Property:

Based on the size of each element's box and the space available, the browser computes its normal position in the layout.  Setting the `position` property allows you to move the element in the layout.

With the `position` property set, you can then specify `top`, `left`, `bottom`, and/or `right` properties to choose the element's location.

  * `relative`: Elements are positioned with respect to their normal position. Relative positioning only affects the target element.

  * `absolute`: Elements are positioned using its first ancestor element. If an element does not have an ancestor it is positioned using to the body. Absolute positioning can result in overlapping elements as elements may be placed in the same locations.

  * `fixed`: A fixed element is positioned with respect to the screen and does not move with a page scroll.

### `display` Property

* Display Block: Block level elements behave in a manner similar to ``<h1>-<h6>`` tags as well as the ``<p>`` tag. These elements are formatted as blocks and take up all available width. Also a vertical break is inserted above and below the element.

* Display Inline: Inline elements allow for the creation of linear content. Tags such as ``<a>`` and ``<span>`` abide by this functionality. These elements do not insert vertical breaks before and after the content. They also only take up as much space as is necessary.

* Display Inline-Block: This style creates a box for the element but does not take up all available width. This allows for additional content to flow with surrounding content.

* Display None: Causes an element to take up no space at all. It is not visible to the user when the document renders. This is used in conjunction with JS to hide and unhide content.

### Floating

* Floating: An element can either be floated left or right. Floating an element allows for content to flow along the opposite direction from which the element was floated. Once an element is floated all other elements around it will move with respect to the float. These behavior can be avoided by using the clear property ``clear : both;``.
`
<hr>

[Prev](3_cssSelectors.md) | [Up](../README.md)
