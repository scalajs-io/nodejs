package org.scalajs.nodejs.htmlparser2

import org.scalajs.nodejs.errors

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Parser Handler
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
abstract class ParserHandler extends js.Object {

  /**
    * @example onattribute(<str> name, <str> value)
    */
  def onattribute: js.Function2[String, String, Any] = null

  /**
    * @example oncdataend()
    */
  def oncdataend: js.Function0[Any] = null

  /**
    * @example oncdatastart()
    */
  def oncdatastart: js.Function0[Any] = null

  /**
    * @example onclosetag(<str> name)
    */
  def onclosetag: js.Function1[String, Any] = null

  /**
    * @example oncomment(<str> data)
    */
  def oncomment: js.Function1[String, Any] = null

  /**
    * oncommentend()
    */
  def oncommentend: js.Function0[Any] = null

  /**
    * @example onend()
    */
  def onend: js.Function0[Any] = null

  /**
    * @example onerror(<err> error)
    */
  def onerror: js.Function1[errors.Error, Any] = null

  /**
    * @example onopentag(<str> name, <obj> attributes)
    */
  def onopentag: js.Function2[String,  js.Dictionary[String], Any] = null

  /**
    * @example onopentagname(<str> name)
    */
  def onopentagname: js.Function1[String, Any] = null

  /**
    * @example onprocessinginstruction(<str> name, <str> data)
    */
  def onprocessinginstruction: js.Function2[String, String, Any] = null

  /**
    * @example onreset()
    */
  def onreset: js.Function0[Any] = null

  /**
    * @example ontext(<str> text)
    */
  def ontext: js.Function1[String, Any] = null

}