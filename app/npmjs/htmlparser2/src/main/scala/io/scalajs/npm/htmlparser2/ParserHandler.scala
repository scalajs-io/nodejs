package io.scalajs.npm.htmlparser2

import io.scalajs.nodejs.Error

import scala.scalajs.js


/**
  * Parser Handler
  * @author lawrence.daniels@gmail.com
  */

abstract class ParserHandler extends js.Object {

  /**
    * @example onattribute(<str> name, <str> value)
    */
  def onattribute(name: String, value: String): Unit = {}

  /**
    * @example oncdataend()
    */
  def oncdataend(): Unit = {}

  /**
    * @example oncdatastart()
    */
  def oncdatastart(): Unit = {}

  /**
    * @example onclosetag(<str> name)
    */
  def onclosetag(name: String): Unit = {}

  /**
    * @example oncomment(<str> data)
    */
  def oncomment(data: String): Unit = {}

  /**
    * oncommentend()
    */
  def oncommentend(): Unit = {}

  /**
    * @example onend()
    */
  def onend(): Unit = {}

  /**
    * @example onerror(<err> error)
    */
  def onerror(error: Error): Unit = {}

  /**
    * @example onopentag(<str> name, <obj> attributes)
    */
  def onopentag(name: String, attributes: js.Dictionary[String]): Unit = {}

  /**
    * @example onopentagname(<str> name)
    */
  def onopentagname(name: String): Unit = {}

  /**
    * @example onprocessinginstruction(<str> name, <str> data)
    */
  def onprocessinginstruction(name: String, data: String): Unit = {}

  /**
    * @example onreset()
    */
  def onreset(): Unit = {}

  /**
    * @example ontext(<str> text)
    */
  def ontext(text: String): Unit = {}

}