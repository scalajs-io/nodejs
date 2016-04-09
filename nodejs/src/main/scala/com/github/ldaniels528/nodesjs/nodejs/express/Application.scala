package com.github.ldaniels528.nodesjs.nodejs.express

import com.github.ldaniels528.nodesjs.nodejs.net.Server

import scala.scalajs.js

/**
  * Express Application
  * @author lawrence.daniels@gmail.com
  * @see [[http://expressjs.com/en/api.html]]
  */
@js.native
trait Application extends Router {

  ////////////////////////////////////////////////////
  //      Properties
  ////////////////////////////////////////////////////

  var locals: js.Dynamic

  ////////////////////////////////////////////////////
  //    Functions
  ////////////////////////////////////////////////////

  def configure(init: js.Function): Unit

  def disable(name: String): Unit

  def disabled(name: String): Boolean

  def enable(name: String): Unit

  def enabled(name: String): Boolean

  def engine(name: String, value: js.Any): Unit

  //def get[T <: js.Any](name: String, callbacks: js.Function*): js.UndefOr[T]

  def listen(port: Int, callback: js.Function): Server

  def on(mount: String, callback: js.Function): Unit

  def set(name: String, value: js.Any): Unit

  def use(path: String, router: Router): Unit

  def use(router: Router): Unit

}

/**
  * Application Companion
  * @author lawrence.daniels@gmail.com
  */
object Application {

  def __dirname = js.Dynamic.global.__dirname.asInstanceOf[js.UndefOr[String]]

}
