package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.Promise
import scala.scalajs.js

/**
  * File System Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Fs extends js.Object {

  /**
    * Asynchronous close(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.close(fd, callback)
    */
  def close(fd: js.Any, callback: js.Function): Unit = js.native

  /**
    * Synchronous close(2). Returns undefined.
    * @example fs.closeSync(fd)
    */
  def closeSync(fd: js.Any): js.Any = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String, options: js.Any, callback: js.Function): Unit = js.native

  def readFile(file: String, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * If the encoding option is specified then this function returns a string. Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: String, options: js.Any): js.Any = js.native

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
    * @see [[https://nodejs.org/api/fs.html#fs_fs_writefile_file_data_options_callback]]
    */
  def writeFile(file: String, data: js.Any, options: js.Any, callback: js.Function): Unit = js.native

  def writeFile(file: String, data: js.Any, callback: js.Function): Unit = js.native

  /**
    * The synchronous version of fs.writeFile(). Returns undefined.
    * @example fs.writeFileSync(file, data[, options])
    */
  def writeFileSync(file: String, data: js.Any, options: js.Any): js.Any = js.native

}

/**
  * File System Companion
  * @author lawrence.daniels@gmail.com
  */
object Fs {
  type FileError = js.Any

  /**
    * File Access Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait FileAccessOptions extends js.Object {

  }

  /**
    * File Access Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object FileAccessOptions {

    def apply() = {
      val options = makeNew[FileAccessOptions]
      options
    }

  }

  /**
    * File System Enrichment
    * @param fs the given [[Fs file system]] instance
    */
  implicit class FsEnrich(val fs: Fs) extends AnyVal {

    def closeAsync(fd: js.Any) = {
      val promise = Promise[Unit]()
      fs.close(fd, (err: FileError) => {
        if (!isDefined(err)) promise.success({}) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def readFileAsync(file: String) = {
      val promise = Promise[Unit]()
      fs.readFile(file, (err: FileError) => {
        if (!isDefined(err)) promise.success({}) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def readFileAsync(file: String, options: js.Any) = {
      val promise = Promise[Unit]()
      fs.readFile(file, options, (err: FileError) => {
        if (!isDefined(err)) promise.success({}) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def statAsync(path: String) = {
      val promise = Promise[StatTime]()
      fs.stat(path, (err: FileError, stats: StatTime) => {
        if (!isDefined(err)) promise.success(stats) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def writeFileAsync(file: String, data: js.Any, options: js.Any) = {
      val promise = Promise[Unit]()
      fs.writeFile(file, data, options, (err: FileError) => {
        if (!isDefined(err)) promise.success({}) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}
