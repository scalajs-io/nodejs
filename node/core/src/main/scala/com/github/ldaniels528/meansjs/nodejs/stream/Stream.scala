package com.github.ldaniels528.meansjs.nodejs.stream

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Stream extends NodeModule {

  def Readable: js.Function0[Readable] = js.native

  def Writable: js.Function0[Writable] = js.native

}
