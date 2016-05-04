package com.github.ldaniels528.meansjs.nodejs.filed

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.stream.Writable

import scala.scalajs.js

/**
  * filed - Simplified file library.
  * @author lawrence.daniels@gmail.com
  * @see [[https://www.npmjs.com/package/filed]]
  */
@js.native
trait Filed extends NodeModule {

  /**
    * Filed does a lazy stat call so you can actually open a file and begin writing to it and if the file isn't
    * there it will just be created.
    */
  def apply(file: String): Writable = js.native

}
