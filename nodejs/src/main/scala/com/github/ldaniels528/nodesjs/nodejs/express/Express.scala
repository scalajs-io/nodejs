package com.github.ldaniels528.nodesjs.nodejs.express

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Express Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Express extends js.Object {

  def apply(): Application

  def bodyParser(): Router

  def Router(): Router

  def Router(options: RouterOptions): Router

  def static(root: String): Router

  def static(root: String, options: StaticServeOptions): Router

}
