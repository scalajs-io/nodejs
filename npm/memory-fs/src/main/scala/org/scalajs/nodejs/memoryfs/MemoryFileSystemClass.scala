package org.scalajs.nodejs.memoryfs

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Memory File System class representation
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MemoryFileSystemClass extends js.Object

/**
  * MemoryFileSystemClass Companion
  * @author lawrence.daniels@gmail.com
  */
object MemoryFileSystemClass {

  /**
    * Memory File System Class Extensions
    * @param class the given [[MemoryFileSystemClass memory file system class]]
    */
  implicit class MemoryFileSystemClassExtensions(val `class`: MemoryFileSystemClass) extends AnyVal {

    /**
      * Default Constructor
      * @example new MemoryFileSystem()
      */
    def apply() = `class`.New[MemoryFileSystem]()

    /**
      * Constructor
      * @example new MemoryFileSystem(data)
      */
    def apply(data: js.Any) = `class`.New[MemoryFileSystem](data)

  }

}