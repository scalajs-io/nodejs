package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Enumeration categorizing operational modes of pointers.
  *
  * PointerType values represent valid bitmasks.
  * For example, a value representing both Mouse and Touch devices
  * can be expressed as PointerMode.CURSOR | PointerMode.CONTACT.
  *
  * Values may be added for future mode categorizations.
  */
@js.native
@JSName("Phaser.PointerMode")
class PointerMode() extends js.Object

/**
  * Pointer Mode Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.PointerMode")
object PointerMode extends js.Object {

  /**
    * A 'CONTACT' pointer has an active cursor that only tracks movement when actived; notably this is a touch-style input.
    */
  val CONTACT: Int = js.native

  /**
    * A 'CURSOR' is a pointer with a passive cursor such as a mouse, touchpad, watcom stylus, or even TV-control arrow-pad.
    *
    * It has the property that a cursor is passively moved without activating the input.
    * This currently corresponds with Phaser.Pointer#isMouse property.
    */
  val CURSOR: Int = js.native

}