package io.scalajs.npm.memoryfs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.fs.{FileIOError, ReadStream, Stats, WriteStream}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * webpack/memory-fs - A simple in-memory filesystem. Holds data in a javascript object.
  * @see https://www.npmjs.com/package/memory-fs
  * @version 0.3.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("memory-fs", JSImport.Namespace)
class MemoryFileSystem(data: js.Any) extends js.Object {

  def this() = this(null)

  def createReadStream(path: String, options: js.Any): ReadStream = js.native

  def createWriteStream(path: String, options: js.Any): WriteStream = js.native

  def exists(path: String, callback: js.Function2[FileIOError, Boolean, Any]): Unit = js.native

  def existsSync(path: String): Boolean = js.native

  def mkdirp(path: String, callback: js.Function1[FileIOError, Any]): Unit = js.native

  def mkdirpSync(path: String): Unit = js.native

  def readdir(path: String, callback: js.Function2[FileIOError, js.Array[String], Any]): Unit = js.native

  def readdirSync(path: String): js.Array[String] = js.native

  def readFile(path: String, optArg: js.Any, callback: js.Function2[FileIOError, Buffer, Any]): Unit = js.native

  def readFile(path: String, callback: js.Function2[FileIOError, Buffer, Any]): Unit = js.native

  def readFileSync(path: String): Buffer = js.native

  def rmdir(path: String, callback: js.Function1[FileIOError, Any]): Unit = js.native

  def rmdirSync(path: String): Unit = js.native

  def stat(path: String, callback: js.Function2[FileIOError, Stats, Any]): Unit = js.native

  def statSync(path: String): Stats = js.native

  def unlink(path: String, callback: js.Function1[FileIOError, Any]): Unit = js.native

  def unlinkSync(path: String): Unit = js.native

  def writeFile(path: String, content: String, encoding: String, callback: js.Function1[FileIOError, Any]): Unit = js.native

  def writeFile(path: String, content: String, callback: js.Function1[FileIOError, Any]): Unit = js.native

  def writeFile(path: String, content: Buffer, callback: js.Function1[FileIOError, Any]): Unit = js.native

  def writeFileSync(path: String, data: Buffer): Unit = js.native

  def writeFileSync(path: String, data: String, encoding: String = null): Unit = js.native

}