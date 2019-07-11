package io.scalajs

import scala.scalajs.js

/**
  * Base trait for classes representing an options instance
  * @author lawrence.daniels@gmail.com
  */
trait FlexibleOptions[T <: js.Any] {

  final implicit def jsDictToOptions[A](options: js.Dictionary[A]): T = options.asInstanceOf[T]

  final implicit def jsObjToOptions(options: js.Object): T = options.asInstanceOf[T]

}
