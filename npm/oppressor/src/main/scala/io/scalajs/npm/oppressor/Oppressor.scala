package io.scalajs.npm.oppressor

import io.scalajs.nodejs.stream.{Duplex, Readable}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Oppressor - streaming http compression response negotiator
  * @version 0.0.1
  * @see [[https://github.com/substack/oppressor]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("oppressor", JSImport.Namespace)
object Oppressor extends js.Object {

  /**
    * Return a duplex stream that will be compressed with gzip, deflate, or no compression depending on the
    * accept-encoding headers sent.
    *
    * oppressor will emulate calls to http.ServerResponse methods like writeHead() so that modules like filed that
    * expect to be piped directly to the response object will work.
    */
  def apply(readable: Readable): Duplex = js.native

}
