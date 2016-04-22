package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.stream.{Readable, Writable}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * File System Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Fs extends NodeModule {

  /**
    * Tests a user's permissions for the file specified by path. mode is an optional integer that specifies
    * the accessibility checks to be performed. The following constants define the possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values.
    * <ul>
    * <li>fs.F_OK - File is visible to the calling process. This is useful for determining if a file exists,
    * but says nothing about rwx permissions. Default if no mode is specified.</li>
    * <li>fs.R_OK - File can be read by the calling process.</li>
    * <li>fs.W_OK - File can be written by the calling process.</li>
    * <li>fs.X_OK - File can be executed by the calling process. This has no effect on Windows (will behave like fs.F_OK).</li>
    * </ul>
    * @example fs.access(path[, mode], callback)
    */
  def access(path: String, mode: String, callback: js.Function): Unit = js.native

  /**
    * Tests a user's permissions for the file specified by path. mode is an optional integer that specifies
    * the accessibility checks to be performed. The following constants define the possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values.
    * <ul>
    * <li>fs.F_OK - File is visible to the calling process. This is useful for determining if a file exists,
    * but says nothing about rwx permissions. Default if no mode is specified.</li>
    * <li>fs.R_OK - File can be read by the calling process.</li>
    * <li>fs.W_OK - File can be written by the calling process.</li>
    * <li>fs.X_OK - File can be executed by the calling process. This has no effect on Windows (will behave like fs.F_OK).</li>
    * </ul>
    * @example fs.access(path[, mode], callback)
    */
  def access(path: String, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: String, mode: String): js.Any = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: String): js.Any = js.native

  /**
    * Asynchronous close(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.close(fd, callback)
    */
  def close(fd: FileDescriptor, callback: js.Function): Unit = js.native

  /**
    * Synchronous close(2). Returns undefined.
    * @example fs.closeSync(fd)
    */
  def closeSync(fd: FileDescriptor): js.Any = js.native

  /**
    * Returns a new ReadStream object. (See Readable Stream).vBe aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: String, options: FileInputOptions): Readable = js.native

  /**
    * Returns a new WriteStream object.
    * @example fs.createWriteStream(path[, options])
    * @see [[Writable]]
    */
  def createWriteStream(path: String, options: FileOutputOptions): Writable = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String, options: FileInputOptions, callback: js.Function): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * If the encoding option is specified then this function returns a string. Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: String, options: FileInputOptions): js.Any = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * If the encoding option is specified then this function returns a string. Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: String): js.Any = js.native

  /**
    * Asynchronous rename(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rename(oldPath, newPath, callback)
    */
  def rename(oldPath: String, newPath: String, callback: js.Function): Unit = js.native

  /**
    * Synchronous rename(2). Returns undefined.
    * @example fs.renameSync(oldPath, newPath)
    */
  def renameSync(oldPath: String, newPath: String): js.Any = js.native

  /**
    * Asynchronous stat(2). The callback gets two arguments (err, stats) where stats is a fs.Stats object.
    * See the fs.Stats section for more information.
    * @example fs.stat(path, callback)
    */
  def stat(path: String, callback: js.Function): StatTime = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: js.Any, options: FileOutputOptions, callback: js.Function): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: js.Any, callback: js.Function): Unit = js.native

  /**
    * The synchronous version of fs.writeFile(). Returns undefined.
    * @example fs.writeFileSync(file, data[, options])
    */
  def writeFileSync(file: String, data: js.Any, options: FileOutputOptions): js.Any = js.native

}

/**
  * File System Companion
  * @author lawrence.daniels@gmail.com
  */
object Fs {

  /**
    * File System Extensions
    * @param fs the given [[Fs file system]] instance
    */
  implicit class FsExtensions(val fs: Fs) extends AnyVal {

    def closeAsync(fd: FileDescriptor) = toFuture[js.Any](fs.close(fd, _))

    def readFileAsync(file: String) = toFuture[js.Any](fs.readFile(file, _))

    def readFileAsync(file: String, options: FileInputOptions) = toFuture[js.Any](fs.readFile(file, options, _))

    def statAsync(path: String) = toFuture[StatTime](fs.stat(path, _))

    def writeFileAsync(file: String, data: js.Any, options: FileOutputOptions) = toFuture[js.Any](fs.writeFile(file, data, _))

  }

}
