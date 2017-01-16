package io.scalajs.dom.collection

import io.scalajs.collection.{Iterator, JsCollection}
import io.scalajs.dom.Node

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.annotation.{JSBracketAccess, ScalaJSDefined}

/**
  * JavaScript HTML DOM Node List
  * @see http://www.w3schools.com/js/js_htmldom_nodelist.asp
  * @see https://developer.mozilla.org/en-US/docs/Web/API/NodeList
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeList[A] extends JsCollection[A] {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the length of the list
    * @return the length of the list
    */
  override def length: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the element at the specified index
    * @param index the specified index
    * @return the [[Node element]] at the specified index
    */
  @JSBracketAccess
  override def apply(index: Int): A = js.native

  /**
    * Set the element at the given index.
    * @param index the position of the Node to be set.
    * @param value the value to set.
    */
  @JSBracketAccess
  def update(index: Int, value: A): Unit = js.native

  /**
    * Returns an iterator allowing to go through all key/value pairs contained in this object
    */
  def entries(): Iterator[NodeList.EntrySet[A]] = js.native

  /**
    * The forEach() method of the NodeList interface calls the callback given in parameter once for each value pair
    * in the list, in insertion order.
    */
  def forEach(callback: js.Function): Unit = js.native

  /**
    * Returns an item in the list by its index, or null if the index is out-of-bounds; can be used as an alternative
    * to simply accessing nodeList[idx] (which instead returns  undefined when idx is out-of-bounds).
    * @return an item in the list by its index
    */
  def item(index: Int): A = js.native

  /**
    * The NodeList.keys() method returns an iterator allowing to go through all keys contained in this object.
    * The keys are unsigned integer.
    * @return
    */
  def keys(): Iterator[Int] = js.native

  /**
    * The NodeList.values() method returns an iterator allowing to go through all values contained in this object.
    * The values are Node objects.
    * @return
    */
  def values(): Iterator[A] = js.native

}

/**
  * NodeList Companion
  * @author lawrence.daniels@gmail.com
  */
object NodeList {

  /**
    * NodeList Enrichment
    * @param nodeList the given [[NodeList node list]]
    */
  implicit class NodeListEnrichment[A](val nodeList: NodeList[A]) extends AnyVal {

    @inline
    def foreach(f: A => Any): Unit = nodeList.values().foreach(f)

    @inline
    def get(index: Int): Option[A] = Option(nodeList.item(index))

    @inline
    def toJSArray: js.Array[A] = nodeList.values().toJSArray

    @inline
    def toSeq: Seq[A] = nodeList.values().toSeq

  }

  @ScalaJSDefined
  class EntrySet[+A](val key: Int, val value: A) extends js.Object

}