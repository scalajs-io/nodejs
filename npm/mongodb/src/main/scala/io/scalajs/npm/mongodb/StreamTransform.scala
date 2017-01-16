package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Stream Transform
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class StreamTransform extends js.Object {
  var transform: js.Function = _
}

/**
  * Stream Transform
  * @author lawrence.daniels@gmail.com
  */
object StreamTransform {

  def apply(transform: js.Function) = {
    val options = new StreamTransform()
    options.transform = transform
    options
  }

}