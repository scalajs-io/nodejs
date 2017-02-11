package io.scalajs.dom.html

import scala.scalajs.js

/**
  * HTML Style
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Style extends js.Object {

  /**
    * Sets or returns the alignment between the lines inside a flexible container when the items do not use all available space
    */
  var alignContent: String = js.native

  /**
    * Sets or returns the alignment for items inside a flexible container
    */
  var alignItems: String = js.native

  /**
    * Sets or returns the alignment for selected items inside a flexible container
    */
  var alignSelf: String = js.native

  /**
    * A shorthand property for all the animation properties below, except the animationPlayState property
    */
  var animation: String = js.native

  /**
    * Sets or returns when the animation will start
    */
  var animationDelay: String = js.native

  /**
    * Sets or returns whether or not the animation should play in reverse on alternate cycles
    */
  var animationDirection: String = js.native

  /**
    * Sets or returns how many seconds or milliseconds an animation takes to complete one cycle
    */
  var animationDuration: String = js.native

  /**
    * Sets or returns what values are applied by the animation outside the time it is executing
    */
  var animationFillMode: String = js.native

  /**
    * Sets or returns the number of times an animation should be played
    */
  var animationIterationCount: String = js.native

  /**
    * Sets or returns a name for the @keyframes animation
    */
  var animationName: String = js.native

  /**
    * Sets or returns the speed curve of the animation
    */
  var animationTimingFunction: js.Function = js.native

  /**
    * Sets or returns whether the animation is running or paused
    */
  var animationPlayState: String = js.native

  /**
    * Sets or returns all the background properties in one declaration
    */
  var background: String = js.native

  /**
    * Sets or returns whether a background-image is fixed or scrolls with the page
    */
  var backgroundAttachment: String = js.native

  /**
    * Sets or returns the background-color of an element
    */
  var backgroundColor: String = js.native

  /**
    * Sets or returns the background-image for an element
    */
  var backgroundImage: String = js.native

  /**
    * Sets or returns the starting position of a background-image
    */
  var backgroundPosition: String = js.native

  /**
    * Sets or returns how to repeat (tile) a background-image
    */
  var backgroundRepeat: String = js.native

  /**
    * Sets or returns the painting area of the background
    */
  var backgroundClip: String = js.native

  /**
    * Sets or returns the positioning area of the background images
    */
  var backgroundOrigin: String = js.native

  /**
    * Sets or returns the size of the background image
    */
  var backgroundSize: String = js.native

  /**
    * Sets or returns whether or not an element should be visible when not facing the screen
    */
  var backfaceVisibility: String = js.native

  /**
    * Sets or returns borderWidth, borderStyle, and borderColor in one declaration
    */
  var border: js.Object = js.native

  /**
    * Sets or returns all the borderBottom* properties in one declaration
    */
  var borderBottom: String = js.native

  /**
    * Sets or returns the color of the bottom border
    */
  var borderBottomColor: String = js.native

  /**
    * Sets or returns the shape of the border of the bottom-left corner
    */
  var borderBottomLeftRadius: String = js.native

  /**
    * Sets or returns the shape of the border of the bottom-right corner
    */
  var borderBottomRightRadius: String = js.native

  /**
    * Sets or returns the style of the bottom border
    */
  var borderBottomStyle: String = js.native

  /**
    * Sets or returns the width of the bottom border
    */
  var borderBottomWidth: String = js.native

  /**
    * Sets or returns whether the table border should be collapsed into a single border, or not
    */
  var borderCollapse: String = js.native

  /**
    * Sets or returns the color of an element's border (can have up to four values)
    */
  var borderColor: String = js.native

  /**
    * A shorthand property for setting or returning all the borderImage* properties
    */
  var borderImage: js.Object = js.native

  /**
    * Sets or returns the amount by which the border image area extends beyond the border box
    */
  var borderImageOutset: String = js.native

  /**
    * Sets or returns whether the image-border should be repeated, rounded or stretched
    */
  var borderImageRepeat: String = js.native

  /**
    * Sets or returns the inward offsets of the image-border
    */
  var borderImageSlice: String = js.native

  /**
    * Sets or returns the image to be used as a border
    */
  var borderImageSource: String = js.native

  /**
    * Sets or returns the widths of the image-border
    */
  var borderImageWidth: String = js.native

  /**
    * Sets or returns all the borderLeft* properties in one declaration
    */
  var borderLeft: String = js.native

  /**
    * Sets or returns the color of the left border
    */
  var borderLeftColor: String = js.native

  /**
    * Sets or returns the style of the left border
    */
  var borderLeftStyle: String = js.native

  /**
    * Sets or returns the width of the left border
    */
  var borderLeftWidth: String = js.native

  /**
    * A shorthand property for setting or returning all the four border*Radius properties
    */
  var borderRadius: String = js.native

  /**
    * Sets or returns all the borderRight* properties in one declaration
    */
  var borderRight: String = js.native

  /**
    * Sets or returns the color of the right border
    */
  var borderRightColor: String = js.native

  /**
    * Sets or returns the style of the right border
    */
  var borderRightStyle: String = js.native

  /**
    * Sets or returns the width of the right border
    */
  var borderRightWidth: String = js.native

  /**
    * Sets or returns the space between cells in a table
    */
  var borderSpacing: String = js.native

  /**
    * Sets or returns the style of an element's border (can have up to four values)
    */
  var borderStyle: String = js.native

  /**
    * Sets or returns all the borderTop* properties in one declaration
    */
  var borderTop: String = js.native

  /**
    * Sets or returns the color of the top border
    */
  var borderTopColor: String = js.native

  /**
    * Sets or returns the shape of the border of the top-left corner
    */
  var borderTopLeftRadius: String = js.native

  /**
    * Sets or returns the shape of the border of the top-right corner
    */
  var borderTopRightRadius: String = js.native

  /**
    * Sets or returns the style of the top border
    */
  var borderTopStyle: String = js.native

  /**
    * Sets or returns the width of the top border
    */
  var borderTopWidth: String = js.native

  /**
    * Sets or returns the width of an element's border (can have up to four values)
    */
  var borderWidth: String = js.native

  /**
    * Sets or returns the bottom position of a positioned element
    */
  var bottom: String = js.native

  /**
    * Sets or returns the behaviour of the background and border of an element at page-break, or,
    * for in-line elements, at line-break.
    */
  var boxDecorationBreak: String = js.native

  /**
    * Attaches one or more drop-shadows to the box
    */
  var boxShadow: String = js.native

  /**
    * Allows you to define certain elements to fit an area in a certain way
    */
  var boxSizing: String = js.native

  /**
    * Sets or returns the position of the table caption
    */
  var captionSide: String = js.native

  /**
    * Sets or returns the position of the element relative to floating objects
    */
  var clear: String = js.native

  /**
    * Sets or returns which part of a positioned element is visible
    */
  var clip: String = js.native

  /**
    * Sets or returns the color of the text
    */
  var color: String = js.native

  /**
    * Sets or returns the number of columns an element should be divided into
    */
  var columnCount: String = js.native

  /**
    * Sets or returns how to fill columns
    */
  var columnFill: String = js.native

  /**
    * Sets or returns the gap between the columns
    */
  var columnGap: String = js.native

  /**
    * A shorthand property for setting or returning all the columnRule* properties
    */
  var columnRule: String = js.native

  /**
    * Sets or returns the color of the rule between columns
    */
  var columnRuleColor: String = js.native

  /**
    * Sets or returns the style of the rule between columns
    */
  var columnRuleStyle: String = js.native

  var columnRuleWidth: String = js.native
  //	Sets or returns the width of the rule between columns
  var columns: String = js.native
  // A shorthand property for setting or returning columnWidth and columnCount
  var columnSpan: String = js.native
  //	Sets or returns how many columns an element should span across
  var columnWidth: String = js.native
  //	Sets or returns the width of the columns
  var content: String = js.native
  //	Used with the :before and :after pseudo-elements, to insert generated content	
  var counterIncrement: String = js.native
  //	Increments one or more counters	
  var counterReset: String = js.native
  //	Creates or resets one or more counters	
  var cursor: String = js.native
  //	Sets or returns the type of cursor to display for the mouse pointer	
  var direction: String = js.native
  //	Sets or returns the text direction	
  var display: String = js.native
  //Sets or returns an element's display type	
  var emptyCells: String = js.native
  //	Sets or returns whether to show the border and background of empty cells, or not	
  var filter: String = js.native
  //	Sets or returns image filters (visual effects, like blur and saturation)
  var flex: String = js.native
  //	Sets or returns the length of the item, relative to the rest
  var flexBasis: String = js.native
  // Sets or returns the initial length of a flexible item
  var flexDirection: String = js.native
  //	Sets or returns the direction of the flexible items
  var flexFlow: String = js.native
  //	A shorthand property for the flexDirection and the flexWrap properties
  var flexGrow: String = js.native
  // Sets or returns how much the item will grow relative to the rest
  var flexShrink: String = js.native
  //	Sets or returns how the item will shrink relative to the rest	
  var flexWrap: String = js.native
  //	Sets or returns whether the flexible items should wrap or not	
  var cssFloat: String = js.native
  //	Sets or returns the horizontal alignment of an element	
  var font: String = js.native
  //	Sets or returns fontStyle, fontVariant, fontWeight, fontSize, lineHeight, and fontFamily in one declaration	
  var fontFamily: String = js.native
  //	Sets or returns the font family for text	
  var fontSize: String = js.native
  //	Sets or returns the font size of the text	
  var fontStyle: String = js.native
  //	Sets or returns whether the style of the font is normal, italic or oblique	
  var fontVariant: String = js.native
  //Sets or returns whether the font should be displayed in small capital letters	
  var fontWeight: String = js.native
  //	Sets or returns the boldness of the font	
  var fontSizeAdjust: String = js.native
  //	Preserves the readability of text when font fallback occurs	
  var fontStretch: String = js.native
  // Selects a normal, condensed, or expanded face from a font family	
  var hangingPunctuation: String = js.native
  //	Specifies whether a punctuation character may be placed outside the line box	
  var height: String = js.native
  //	Sets or returns the height of an element	
  var hyphens: String = js.native
  //	Sets how to split words to improve the layout of paragraphs	
  var icon: String = js.native
  //	Provides the author the ability to style an element with an iconic equivalent	
  var imageOrientation: String = js.native
  //	Specifies a rotation in the right or clockwise direction that a user agent applies to an image	
  var justifyContent: String = js.native
  //	Sets or returns the alignment between the items inside a flexible container when the items do not use all available space.
  var left: String = js.native
  //	Sets or returns the left position of a positioned element	
  var letterSpacing: String = js.native
  //	Sets or returns the space between characters in a text	
  var lineHeight: String = js.native
  //	Sets or returns the distance between lines in a text	
  var listStyle: String = js.native
  //	Sets or returns listStyleImage, listStylePosition, and listStyleType in one declaration	
  var listStyleImage: String = js.native
  //	Sets or returns an image as the list-item marker	
  var listStylePosition: String = js.native
  //	Sets or returns the position of the list-item marker	
  var listStyleType: String = js.native
  //	Sets or returns the list-item marker type	
  var margin: String = js.native
  //	Sets or returns the margins of an element (can have up to four values)	
  var marginBottom: String = js.native
  //	Sets or returns the bottom margin of an element	
  var marginLeft: String = js.native
  //	Sets or returns the left margin of an element	
  var marginRight: String = js.native
  //	Sets or returns the right margin of an element	
  var marginTop: String = js.native
  //	Sets or returns the top margin of an element	
  var maxHeight: String = js.native
  //	Sets or returns the maximum height of an element	
  var maxWidth: String = js.native
  //	Sets or returns the maximum width of an element	
  var minHeight: String = js.native
  //	Sets or returns the minimum height of an element	
  var minWidth: String = js.native
  //	Sets or returns the minimum width of an element	
  var navDown: String = js.native
  //	Sets or returns where to navigate when using the arrow-down navigation key
  var navIndex: String = js.native
  //	Sets or returns the tabbing order for an element
  var navLeft: String = js.native
  //	Sets or returns where to navigate when using the arrow-left navigation key
  var navRight: String = js.native
  //	Sets or returns where to navigate when using the arrow-right navigation key
  var navUp: String = js.native
  //	Sets or returns where to navigate when using the arrow-up navigation key
  var opacity: String = js.native
  //	Sets or returns the opacity level for an element
  var order: String = js.native
  //	Sets or returns the order of the flexible item, relative to the rest
  var orphans: String = js.native
  //	Sets or returns the minimum number of lines for an element that must be left at the bottom of a page when a page break occurs inside an element	
  var outline: String = js.native
  //	Sets or returns all the outline properties in one declaration	
  var outlineColor: String = js.native
  //	Sets or returns the color of the outline around a element	
  var outlineOffset: String = js.native
  //	Offsets an outline, and draws it beyond the border edge
  var outlineStyle: String = js.native
  //	Sets or returns the style of the outline around an element	
  var outlineWidth: String = js.native
  //	Sets or returns the width of the outline around an element	
  var overflow: String = js.native
  //	Sets or returns what to do with content that renders outside the element box	
  var overflowX: String = js.native
  //	Specifies what to do with the left/right edges of the content, if it overflows the element's content area
  var overflowY: String = js.native
  //	Specifies what to do with the top/bottom edges of the content, if it overflows the element's content area
  var padding: String = js.native
  //	Sets or returns the padding of an element (can have up to four values)	
  var paddingBottom: String = js.native
  //	Sets or returns the bottom padding of an element	
  var paddingLeft: String = js.native
  //	Sets or returns the left padding of an element	
  var paddingRight: String = js.native
  //	Sets or returns the right padding of an element	
  var paddingTop: String = js.native
  //Sets or returns the top padding of an element	
  var pageBreakAfter: String = js.native
  //	Sets or returns the page-break behavior after an element	
  var pageBreakBefore: String = js.native
  //	Sets or returns the page-break behavior before an element	
  var pageBreakInside: String = js.native
  //	Sets or returns the page-break behavior inside an element	
  var perspective: String = js.native
  //	Sets or returns the perspective on how 3D elements are viewed
  var perspectiveOrigin: String = js.native
  //	Sets or returns the bottom position of 3D elements
  var position: String = js.native
  //Sets or returns the type of positioning method used for an element (static, relative, absolute or fixed)	
  var quotes: String = js.native
  //	Sets or returns the type of quotation marks for embedded quotations	
  var resize: String = js.native
  //	Sets or returns whether or not an element is resizable by the user
  var right: String = js.native
  //	Sets or returns the right position of a positioned element	
  var tableLayout: String = js.native
  //	Sets or returns the way to lay out table cells, rows, and columns	
  var tabSize: String = js.native
  // Sets or returns the length of the tab-character
  var textAlign: String = js.native
  //	Sets or returns the horizontal alignment of text	
  var textAlignLast: String = js.native
  //	Sets or returns how the last line of a block or a line right before a forced line break is aligned when text-align is "justify"
  var textDecoration: String = js.native
  //	Sets or returns the decoration of a text	
  var textDecorationColor: String = js.native
  //	Sets or returns the color of the text-decoration
  var textDecorationLine: String = js.native
  //	Sets or returns the type of line in a text-decoration
  var textDecorationStyle: String = js.native
  //	Sets or returns the style of the line in a text decoration
  var textIndent: String = js.native
  //	Sets or returns the indentation of the first line of text	
  var textJustify: String = js.native
  //	Sets or returns the justification method used when text-align is "justify"
  var textOverflow: String = js.native
  //	Sets or returns what should happen when text overflows the containing element
  var textShadow: String = js.native
  //	Sets or returns the shadow effect of a text
  var textTransform: String = js.native
  //	Sets or returns the capitalization of a text	
  var top: String = js.native
  //	Sets or returns the top position of a positioned element	
  var transform: String = js.native
  //	Applies a 2D or 3D transformation to an element
  var transformOrigin: String = js.native
  //	Sets or returns the position of transformed elements
  var transformStyle: String = js.native
  //	Sets or returns how nested elements are rendered in 3D space
  var transition: String = js.native
  //	A shorthand property for setting or returning the four transition properties
  var transitionProperty: String = js.native
  //	Sets or returns the CSS property that the transition effect is for
  var transitionDuration: String = js.native
  //	Sets or returns how many seconds or milliseconds a transition effect takes to complete
  var transitionTimingFunction: String = js.native
  //	Sets or returns the speed curve of the transition effect
  var transitionDelay: String = js.native
  //	Sets or returns when the transition effect will start
  var unicodeBidi: String = js.native
  //	Sets or returns whether the text should be overridden to support multiple languages in the same document	
  var verticalAlign: String = js.native
  //	Sets or returns the vertical alignment of the content in an element	
  var visibility: String = js.native
  //	Sets or returns whether an element should be visible	
  var whiteSpace: String = js.native
  //	Sets or returns how to handle tabs, line breaks and whitespace in a text	
  var width: String = js.native
  //	Sets or returns the width of an element	
  var wordBreak: String = js.native
  //	Sets or returns line breaking rules for non-CJK scripts
  var wordSpacing: String = js.native
  //	Sets or returns the spacing between words in a text	
  var wordWrap: String = js.native
  //	Allows long, unbreakable words to be broken and wrap to the next line
  var widows: String = js.native
  //	Sets or returns the minimum number of lines for an element that must be visible at the top of a page

  /**
    * Sets or returns the stack order of a positioned element
    */
  var zIndex: String = js.native

}
