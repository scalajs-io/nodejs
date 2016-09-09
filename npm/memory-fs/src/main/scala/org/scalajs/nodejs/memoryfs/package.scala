package org.scalajs.nodejs

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.fs.{FileIOError, Stats}
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * memory-fs package object
  * @author lawrence.daniels@gmail.com
  */
package object memoryfs {

  /**
    * Memory File System Extensions
    * @param fs the given [[MemoryFileSystem memory file system]]
    */
  final implicit class MemoryFileSystemExtensions(val fs: MemoryFileSystem) extends AnyVal {

    @inline
    def existsFuture(path: String) = futureCallbackE1[FileIOError, Boolean](fs.exists(path, _))

    @inline
    def mkdirpFuture(path: String) = futureCallbackE0[FileIOError](fs.mkdirp(path, _))

    @inline
    def readdirFuture(path: String) = futureCallbackE1[FileIOError, js.Array[String]](fs.readdir(path, _))

    @inline
    def readFileFuture(path: String, optArg: js.Any = null) = futureCallbackE1[FileIOError, Buffer](fs.readFile(path, optArg, _))

    @inline
    def rmdirFuture(path: String) = futureCallbackE0[FileIOError](fs.rmdir(path, _))

    @inline
    def statFuture(path: String) = futureCallbackE1[FileIOError, Stats](fs.stat(path, _))

    @inline
    def unlinkFuture(path: String) = futureCallbackE0[FileIOError](fs.unlink(path, _))

    @inline
    def writeFileFuture(path: String, content: String, encoding: String = null) = futureCallbackE0[FileIOError](fs.writeFile(path, content, encoding, _))

    @inline
    def writeFileFuture(path: String, content: Buffer) = futureCallbackE0[FileIOError](fs.writeFile(path, content, _))

  }

}
