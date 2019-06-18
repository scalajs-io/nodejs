package io.scalajs.npm.nodefetch

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * node-fetch - A light-weight module that brings window.fetch to Node.js
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeFetch extends js.Object {

  /**
    * Asynchronously executes an HTTP request
    * @param url     should be an absolute url, eg http://example.com/
    * @param options the optional settings
    * @return the promise of a [[FetchResponse response]]
    */
  def apply(url: String, options: RequestOptions = js.native): js.Promise[FetchResponse] = js.native

}

/**
  * NodeFetch Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("node-fetch", JSImport.Default)
object NodeFetch extends NodeFetch
