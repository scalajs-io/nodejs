package io.scalajs.npm.cheerio

import io.scalajs.dom.Node
import io.scalajs.jquery.{JQuery, Selector}

import scala.scalajs.js

/**
  * Cheerio JQuery Implementation
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CheerioJQuery extends JQuery {

  /**
    * Retrieves the jQuery object for the given document
    * @param node the given [[Node node]]
    * @return the [[CheerioJQueryElement jQuery element]]
    */
  override def apply(node: Node): CheerioJQueryElement = js.native

  /**
    * Retrieves the jQuery object for the given selector
    * @param selector A string containing a selector expression to match elements against.
    * @return the [[CheerioJQueryElement jQuery element]]
    */
  override def apply(selector: Selector): CheerioJQueryElement = js.native

  /**
    * Sometimes you need to work with the top-level root element. To query it, you can use $.root().
    */
  def root(): CheerioJQueryElement = js.native

}
