package io.scalajs.npm.express.csv

import scala.scalajs.js

/**
  * CSV Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CSVResponse extends js.Object {

  def csv[A](values: js.Array[A]): js.Any = js.native

}
