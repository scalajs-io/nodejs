package com.github.ldaniels528.meansjs.nodejs.bodyparser

import com.github.ldaniels528.meansjs.nodejs.express.Router

import scala.scalajs.js

/**
  * Express Body Parser
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BodyParser extends js.Object {

  def json(): Router

  def urlencoded(): Router

  def urlencoded(options: BodyParserOptions): Router

}
