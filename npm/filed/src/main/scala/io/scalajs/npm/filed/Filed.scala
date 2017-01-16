package io.scalajs.npm.filed

import io.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Simplified file library.
  * @version 0.1.0
  * @see https://www.npmjs.com/package/filed
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("filed", JSImport.Namespace)
object Filed extends js.Object {

  /**
    * Filed does a lazy stat call so you can actually open a file and begin writing to it and if the file isn't
    * there it will just be created.
    */
  def apply(file: String): Readable with Writable = js.native

}
