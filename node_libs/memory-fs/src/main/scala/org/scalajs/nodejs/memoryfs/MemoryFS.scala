package org.scalajs.nodejs
package memoryfs

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

  /**
    * Convenience method for retrieving the file system module
    * @param require the implicit [[NodeRequire require function]]
    * @return the file system instance
    */
  def apply()(implicit require: NodeRequire) = require[MemoryFS]("memory-fs")

}