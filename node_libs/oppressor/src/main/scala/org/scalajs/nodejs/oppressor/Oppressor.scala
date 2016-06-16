package org.scalajs.nodejs.oppressor

import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.stream.{Duplex, Readable}

import scala.scalajs.js

/**
  * Oppressor - streaming http compression response negotiator
  * @author lawrence.daniels@gmail.com
  * @see [[https://github.com/substack/oppressor]]
  * @version 0.0.1
  */
@js.native
trait Oppressor extends NodeModule {

  /**
    * Return a duplex stream that will be compressed with gzip, deflate, or no compression depending on the
    * accept-encoding headers sent.
    *
    * oppressor will emulate calls to http.ServerResponse methods like writeHead() so that modules like filed that
    * expect to be piped directly to the response object will work.
    */
  def apply(readable: Readable): Duplex = js.native

}

/**
  * Oppressor Companion
  * @author lawrence.daniels@gmail.com
  */
object Oppressor {

  /**
    * Convenience method for retrieving the 'oppressor' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Oppressor instance
    */
  def apply()(implicit require: NodeRequire) = require[Oppressor]("oppressor")

}