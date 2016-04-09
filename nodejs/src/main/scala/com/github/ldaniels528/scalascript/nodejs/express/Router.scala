package com.github.ldaniels528.nodesjs.nodejs.express

import scala.scalajs.js

/**
  * Express Router
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Router extends js.Object {

  def all(path: String, callback: js.Function*)

  def param(callback: js.Function): Unit

  def param(name: String, callback: js.Function): Unit

  def param(names: js.Array[String], callback: js.Function): Unit

  ////////////////////////////////////////////////////
  //    HTTP Method-related Functions
  ////////////////////////////////////////////////////

  def delete(path: String, callback: js.Function): Unit

  def get(path: String, callback: js.Function): Unit

  def post(path: String, callback: js.Function): Unit

  def put(path: String, callback: js.Function): Unit

}
