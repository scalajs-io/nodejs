package io.scalajs.dom.html

import io.scalajs.collection.Iterator
import io.scalajs.dom.USVString

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The URLSearchParams interface defines utility methods to work with the query string of a URL.
  *
  * An object implementing URLSearchParams can directly be used in a for...of structure, instead of
  * entries(): for (var p of mySearchParams) is equivalent to for (var p of mySearchParams.entries()).
  * @param init A USVString or a URLSearchParams instance.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/URLSearchParams
  * @author lawrence.daniels@gmail.com
  */
@js.native
class URLSearchParams(init: USVString | URLSearchParams) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Appends a specified key/value pair as a new search parameter.
    * @param name  The name of the parameter to append.
    * @param value The value of the parameter to append.
    */
  def append(name: String, value: String): Unit = js.native

  /**
    * Deletes the given search parameter, and its associated value, from the list of all search parameters.
    * @param name The name of the parameter to be deleted.
    */
  def delete(name: String): Unit = js.native

  /**
    * Returns an iterator allowing to go through all key/value pairs contained in this object.
    * @return an [[Iterator]]
    */
  def entries(): Iterator[js.Array[String]] = js.native

  /**
    * The get() method of the URLSearchParams interface returns the first value associated to the given search parameter.
    * @param name The name of the parameter to return.
    * @return A [[USVString]].
    */
  def get(name: String): USVString = js.native

  /**
    * Returns all the values association with a given search parameter.
    * @param name The name of the parameter to return.
    * @return An array of [[USVString]]s.
    */
  def getAll(name: String): js.Array[USVString] = js.native

  /**
    * Returns a Boolean indicating if such a search parameter exists.
    * @param name The name of the parameter to find.
    * @return true, if such a search parameter exists.
    */
  def has(name: String): Boolean = js.native

  /**
    * Returns an iterator allowing to go through all keys of the key/value pairs contained in this object.
    * @return Returns an [[Iterator]].
    */
  def keys(): Iterator[String] = js.native

  /**
    * Sets the value associated to a given search parameter to the given value.
    * If there were several values, delete the others.
    * @param name  The name of the parameter to set.
    * @param value The value of the parameter to set.
    */
  def set(name: String, value: String): Unit = js.native

  /**
    * Returns an iterator allowing to go through all values of the key/value pairs contained in this object.
    * @return Returns an [[Iterator]].
    */
  def values(): Iterator[String] = js.native

}
