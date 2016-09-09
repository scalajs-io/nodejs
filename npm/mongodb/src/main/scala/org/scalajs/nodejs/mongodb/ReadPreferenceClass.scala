package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.util.ScalaJsHelper._
import scala.scalajs.js

/**
  * Represents the ReadPreference class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ReadPreferenceClass extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  val PRIMARY: String = js.native
  val PRIMARY_PREFERRED: String = js.native
  val SECONDARY: String = js.native
  val SECONDARY_PREFERRED: String = js.native
  val NEAREST: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def isValid(mode: String): Boolean = js.native

}

/**
  * ReadPreference class singleton
  * @author lawrence.daniels@gmail.com
  */
object ReadPreferenceClass {

  /**
    * ReadPreference class extensions
    * @param `class` the given [[ReadPreferenceClass class instance]]
    */
  implicit class ReadPreferenceClassExtensions(val `class`: ReadPreferenceClass) extends AnyVal {

    def apply(mode: String, tags: js.Any = null) = `class`.New[ReadPreference](mode, tags)

  }

}