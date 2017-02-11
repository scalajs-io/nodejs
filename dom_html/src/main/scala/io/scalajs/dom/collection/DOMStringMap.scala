package io.scalajs.dom.collection

import io.scalajs.dom.DOMString

import scala.scalajs.js

/**
  * DOMStringMap
  * @see https://developer.mozilla.org/en-US/docs/Web/API/DOMStringMap
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DOMStringMap extends js.Object {

  /**
    *
    * @param prop The property for which to retrieve the value.
    * @return The value for the specified property name.
    */
  def getDataAttr(prop: DOMString): DOMString = js.native

  /**
    * The value for the specified property name.
    */
  def hasDataAttr(prop: DOMString): Boolean = js.native

  /**
    * The property for which to check for the existence of a value.
    */
  def removeDataAttr(prop: DOMString): Unit = js.native

  /**
    * The property to remove from the data set.
    */
  def removeProp(attr: js.Any): Unit = js.native

  /**
    * Removes the property from the dataset object. Used to update the dataset object when data-* attribute
    * has been removed from the element.
    */
  def setDataAttr(prop: DOMString, value: DOMString): Unit = js.native

}
