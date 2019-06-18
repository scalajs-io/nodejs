package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport}

/**
  * Read Preference
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "ReadPreference")
class ReadPreference(val mode: ReadPreferenceMode,
                     val tags: js.Any = js.native) extends js.Object {
  val _type: String = js.native

}

/**
  * Read Preference Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("ReadPreference")
object ReadPreference extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  val PRIMARY: ReadPreferenceMode = js.native
  val PRIMARY_PREFERRED: ReadPreferenceMode = js.native
  val SECONDARY: ReadPreferenceMode = js.native
  val SECONDARY_PREFERRED: ReadPreferenceMode = js.native
  val NEAREST: ReadPreferenceMode = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def isValid(mode: ReadPreferenceMode): Boolean = js.native

}
