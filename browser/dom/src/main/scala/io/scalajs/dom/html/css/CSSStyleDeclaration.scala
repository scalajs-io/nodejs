package io.scalajs.dom.html.css

import CSSStyleDeclaration.CSSPropertyPriority

import scala.scalajs.js

/**
  * The CSS Style Declaration object represents a collection of CSS property-value pairs.
  * @author lawrence.daniels@gmail.com
  * @see http://www.w3schools.com/jsref/obj_cssstyledeclaration.asp
  * @see https://developer.mozilla.org/en-US/docs/Web/API/CSSStyleDeclaration
  */
@js.native
class CSSStyleDeclaration extends js.Object {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * Returns a text representation of the declaration block
    */
  def cssText: String = js.native

  /**
    * Returns the number of properties
    */
  def length: Int = js.native

  /**
    * Returns the containing CssRule
    */
  def parentRule: CSSRule = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    * Gets whether or not the property has the "important" priority
    * @param property the given property name
    */
  def getPropertyPriority(property: String): CSSPropertyPriority = js.native

  /**
    * Gets the property value
    * @param property the given property name
    */
  def getPropertyValue[T <: js.Any](property: String): T = js.native

  /**
    * Gets the property name
    * @param index the index value
    */
  def item[T <: js.Any](index: Int): T = js.native

  /**
    * Gets the removed property value
    * @param property the given property name
    */
  def removeProperty(property: String): js.Any = js.native

  /** *
    * Set a CSS property for an element
    * @param property the given property name
    * @param value    the property value
    * @param priority the priority
    */
  def setProperty(property: String, value: js.Any, priority: CSSPropertyPriority): Unit = js.native

}

/**
  * CSS Style Declaration
  * @author lawrence.daniels@gmail.com
  */
object CSSStyleDeclaration {

  type CSSPropertyPriority = String

  /**
    * CSS Style Declaration Enrichment
    * @param declaration the given [[CSSStyleDeclaration declaration]]
    */
  implicit class CSSStyleDeclarationEnrichment(val declaration: CSSStyleDeclaration) extends AnyVal {

    @inline
    def get[A <: js.Any](index: Int): Option[A] = Option(declaration.item[A](index))

  }

}