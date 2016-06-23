package org.scalajs.nodejs.memoryfs

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.fs.{FileIOError, ReadStream, Stats, WriteStream}

import scala.scalajs.js

/**
  * Memory File System 
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MemoryFileSystem extends js.Object {

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

/**
  * MemoryFileSystem singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
object MemoryFileSystem extends MemoryFileSystemClass