package org.scalajs.nodejs
package stream

import scala.scalajs.js

/**
  * Stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Stream extends NodeModule {

  def PassThrough: js.Function0[PassThrough] = js.native

  def Readable: js.Function0[Readable] = js.native

  def Writable: js.Function0[Writable] = js.native

}

/**
  * Stream Companion
  * @author lawrence.daniels@gmail.com
  */
object Stream {

  /**
    * Convenience method for retrieving the stream module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Stream instance
    */
  def apply()(implicit require: NodeRequire) = require[Stream]("stream")

}