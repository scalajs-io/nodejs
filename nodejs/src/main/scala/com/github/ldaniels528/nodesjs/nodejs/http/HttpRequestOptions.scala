package com.github.ldaniels528.nodesjs.nodejs.http

import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Http Request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpRequestOptions extends js.Object {
  var port: js.UndefOr[Int]
  var hostname: js.UndefOr[String]
  var method: js.UndefOr[String]
  var path: js.UndefOr[String]
}

/**
  * Http Request Companion
  * @author lawrence.daniels@gmail.com
  */
object HttpRequestOptions {

  def apply(port: js.UndefOr[Int] = js.undefined,
            hostname: js.UndefOr[String] = js.undefined,
            method: js.UndefOr[String] = js.undefined,
            path: js.UndefOr[String] = js.undefined) = {
    val options = makeNew[HttpRequestOptions]
    options.port = port
    options.hostname = hostname
    options.method = method
    options.path = path
    options
  }

}