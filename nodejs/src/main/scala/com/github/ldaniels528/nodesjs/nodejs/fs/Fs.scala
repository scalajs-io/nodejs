package com.github.ldaniels528.nodesjs.nodejs.fs

import scala.scalajs.js

/**
  * File System Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Fs extends js.Object {

  def readFileSync(path: String): js.Any

}
