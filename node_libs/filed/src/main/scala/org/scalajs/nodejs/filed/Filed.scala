package org.scalajs.nodejs
package filed

import org.scalajs.nodejs.stream.Writable

import scala.scalajs.js

/**
  * filed - Simplified file library.
  * @version 0.1.0
  * @see [[https://www.npmjs.com/package/filed]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Filed extends NodeModule {

  /**
    * Filed does a lazy stat call so you can actually open a file and begin writing to it and if the file isn't
    * there it will just be created.
    */
  def apply(file: String): Writable = js.native

}

/**
  * Filed Companion
  * @author lawrence.daniels@gmail.com
  */
object Filed {

  /**
    * Convenience method for retrieving the 'filed' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Filed instance
    */
  def apply()(implicit require: NodeRequire) = require[Filed]("filed")

}