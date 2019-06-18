package io.scalajs.dom.html.css

import scala.scalajs.js

/**
  * The CSSRule interface represents a single CSS rule.
  * @author lawrence.daniels@gmail.com
  * @see https://developer.mozilla.org/en-US/docs/Web/API/CssRule
  * @see https://developer.mozilla.org/en-US/docs/Web/API/CssRule#Type_constants
  */
@js.native
trait CSSRule extends js.Object {

  /**
    * Represents the textual representation of the rule, e.g. "h1,h2 { font-size: 16pt }" or "@import 'url'".
    * To access or modify parts of the rule (e.g. the value of "font-size" in the example) use the properties
    * on the specialized interface for the rule's type.
    */
  def cssText: String = js.native

  /**
    * Read only: Returns the containing rule, otherwise null. E.g. if this rule is a style rule inside
    * an @media block, the parent rule would be that CSSMediaRule.
    */
  def parentRule: CSSRule = js.native

  /**
    * Read only: Returns the CSSStyleSheet object for the style sheet that contains this rule CSSRule.
    */
  def parentStyleSheet: CSSStyleSheet = js.native

  /**
    * Read only: One of the Type constants indicating the type of CSS rule.
    */
  def `type`: CSSRule = js.native

}
