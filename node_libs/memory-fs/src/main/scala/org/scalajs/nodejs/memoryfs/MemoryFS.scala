package org.scalajs.nodejs.memoryfs

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * webpack/memory-fs - A simple in-memory filesystem. Holds data in a javascript object.
  * @see [[https://www.npmjs.com/package/memory-fs]]
  * @version 0.3.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MemoryFS extends NodeModule with MemoryFileSystemClass

/**
  * MemoryFS Companion
  * @author lawrence.daniels@gmail.com
  */
object MemoryFS {

  def apply()(implicit require: NodeRequire) = require[MemoryFS]("memory-fs")

}