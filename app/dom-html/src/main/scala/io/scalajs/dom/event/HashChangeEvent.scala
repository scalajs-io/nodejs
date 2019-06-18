package io.scalajs.dom.event

import io.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Hash Change Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class HashChangeEvent extends Event {

  /**
    * Returns the URL of the document, after the hash has been changed
    */
  def newURL: String = js.native

  /**
    * Returns the URL of the document, before the hash was changed
    */
  def oldURL: String = js.native

}
