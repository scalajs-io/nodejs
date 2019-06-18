package io.scalajs.npm

import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * node-fetch package object
  * @author lawrence.daniels@gmail.com
  */
package object nodefetch {

  type Headers = js.Dictionary[String]

  /**
    * Node Fetch Header Extensions
    * @param headers the [[Headers headers]]
    */
  final implicit class NodeFetchHeaderExtensions(val headers: Headers) extends AnyVal {

    @inline
    def raw(): js.Dictionary[js.Any] = headers.dynamic.raw().asInstanceOf[js.Dictionary[js.Any]]

  }

}
