package io.scalajs.npm.express.multer

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Multer Field
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class MulterField(var name: String, var maxCount: Int) extends js.Object

/**
  * Multer Field Companion
  * @author lawrence.daniels@gmail.com
  */
object MulterField {

  def apply(name: String, maxCount: Int) = new MulterField(name, maxCount)

}