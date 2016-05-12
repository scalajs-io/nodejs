package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.nodejs.fs.Fs.FileDescriptor
import com.github.ldaniels528.meansjs.nodejs.stream.{Readable, Writable}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.language.implicitConversions
import scala.scalajs.js

/**
  * NodeJS File System module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Fs extends NodeModule with EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * File is visible to the calling process. This is useful for determining if a file exists, but says
    * nothing about rwx permissions. Default if no mode is specified.
    */
  val F_OK: Int = js.native

  /**
    * File can be read by the calling process.
    */
  val R_OK: Int = js.native

  /**
    * File can be written by the calling process.
    */
  val W_OK: Int = js.native

  /**
    * File can be executed by the calling process. This has no effect on Windows (will behave like fs.[[F_OK]]).
    */
  val X_OK: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Tests a user's permissions for the file specified by path. mode is an optional integer that specifies
    * the accessibility checks to be performed. The following constants define the possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values.
    * <ul>
    * <li>fs.F_OK - File is visible to the calling process. This is useful for determining if a file exists,
    * but says nothing about rwx permissions. Default if no mode is specified.</li>
    * <li>fs.[[R_OK]] - File can be read by the calling process.</li>
    * <li>fs.[[W_OK]] - File can be written by the calling process.</li>
    * <li>fs.[[X_OK]] - File can be executed by the calling process. This has no effect on Windows (will behave like fs.[[F_OK]]).</li>
    * </ul>
    * @param path     the path (String | Buffer)
    * @param mode     the optional mode
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: String, mode: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Tests a user's permissions for the file specified by path. mode is an optional integer that specifies
    * the accessibility checks to be performed. The following constants define the possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values.
    * <ul>
    * <li>fs.F_OK - File is visible to the calling process. This is useful for determining if a file exists,
    * but says nothing about rwx permissions. Default if no mode is specified.</li>
    * <li>fs.[[R_OK]] - File can be read by the calling process.</li>
    * <li>fs.[[W_OK]] - File can be written by the calling process.</li>
    * <li>fs.[[X_OK]] - File can be executed by the calling process. This has no effect on Windows (will behave like fs.[[F_OK]]).</li>
    * </ul>
    * @param path     the path (String | Buffer)
    * @param mode     the optional mode
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: Buffer, mode: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Tests a user's permissions for the file specified by path. mode is an optional integer that specifies
    * the accessibility checks to be performed. The following constants define the possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values.
    * <ul>
    * <li>fs.F_OK - File is visible to the calling process. This is useful for determining if a file exists,
    * but says nothing about rwx permissions. Default if no mode is specified.</li>
    * <li>fs.[[R_OK]] - File can be read by the calling process.</li>
    * <li>fs.[[W_OK]] - File can be written by the calling process.</li>
    * <li>fs.[[X_OK]] - File can be executed by the calling process. This has no effect on Windows (will behave like fs.[[F_OK]]).</li>
    * </ul>
    * @param path     the path (String | Buffer)
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: String, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Tests a user's permissions for the file specified by path. mode is an optional integer that specifies
    * the accessibility checks to be performed. The following constants define the possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values.
    * <ul>
    * <li>fs.F_OK - File is visible to the calling process. This is useful for determining if a file exists,
    * but says nothing about rwx permissions. Default if no mode is specified.</li>
    * <li>fs.[[R_OK]] - File can be read by the calling process.</li>
    * <li>fs.[[W_OK]] - File can be written by the calling process.</li>
    * <li>fs.[[X_OK]] - File can be executed by the calling process. This has no effect on Windows (will behave like fs.[[F_OK]]).</li>
    * </ul>
    * @param path     the path (String | Buffer)
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: Buffer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @param path the path (String | Buffer)
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: String): js.Any = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @param path the path (String | Buffer)
    * @param mode the optional mode
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: String, mode: Integer): js.Any = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @param path the path (String | Buffer)
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: Buffer): js.Any = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @param path the path (String | Buffer)
    * @param mode the optional mode
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: Buffer, mode: Integer): js.Any = js.native

  /**
    * Asynchronous close(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.close(fd, callback)
    */
  def close(fd: FileDescriptor, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Synchronous close(2). Returns undefined.
    * @example fs.closeSync(fd)
    */
  def closeSync(fd: FileDescriptor): js.Any = js.native

  /**
    * Returns a new ReadStream object. (See Readable Stream).vBe aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @param path the path (String | Buffer)
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: String): Readable = js.native

  /**
    * Returns a new ReadStream object. (See Readable Stream).vBe aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @param path    the path (String | Buffer)
    * @param options the optional stream options
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: String, options: FileInputOptions): Readable = js.native

  /**
    * Returns a new ReadStream object. (See Readable Stream).vBe aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @param path the path (String | Buffer)
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: Buffer): Readable = js.native

  /**
    * Returns a new ReadStream object. (See Readable Stream).vBe aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @param path    the path (String | Buffer)
    * @param options the optional stream options
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: Buffer, options: FileInputOptions): Readable = js.native

  /**
    * Returns a new WriteStream object.
    * @param path the path (String | Buffer)
    * @example fs.createWriteStream(path[, options])
    * @see [[Writable]]
    */
  def createWriteStream(path: String): Writable = js.native

  /**
    * Returns a new WriteStream object.
    * @param path    the path (String | Buffer)
    * @param options the optional stream options
    * @example fs.createWriteStream(path[, options])
    * @see [[Writable]]
    */
  def createWriteStream(path: String, options: FileOutputOptions): Writable = js.native

  /**
    * Returns a new WriteStream object.
    * @param path the path (String | Buffer)
    * @example fs.createWriteStream(path[, options])
    * @see [[Writable]]
    */
  def createWriteStream(path: Buffer): Writable = js.native

  /**
    * Returns a new WriteStream object.
    * @param path    the path (String | Buffer)
    * @param options the optional stream options
    * @example fs.createWriteStream(path[, options])
    * @see [[Writable]]
    */
  def createWriteStream(path: Buffer, options: FileOutputOptions): Writable = js.native

  /**
    * Asynchronous fdatasync(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.fdatasync(fd, callback)
    */
  def fdatasync(fd: FileDescriptor, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Synchronous fdatasync(2). Returns undefined.
    * @example fs.fdatasyncSync(fd)
    */
  def fdatasyncSync(fd: FileDescriptor): js.Any = js.native

  /**
    * Change the file timestamps of a file referenced by the supplied file descriptor.
    * @example fs.futimes(fd, atime, mtime, callback)
    */
  def futimes(fd: FileDescriptor, atime: Integer, mtime: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Synchronous version of fs.futimes(). Returns undefined.
    * @example fs.futimesSync(fd, atime, mtime)
    */
  def futimesSync(fd: FileDescriptor, atime: Integer, mtime: Integer): js.Any = js.native

  /**
    * Asynchronous lchmod(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.lchmod(path, mode, callback)
    */
  def lchmod(path: Buffer, mode: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous lchmod(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.lchmod(path, mode, callback)
    */
  def lchmod(path: String, mode: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Synchronous lchmod(2). Returns undefined.
    * @example fs.lchmodSync(path, mode)
    */
  def lchmodSync(path: String, mode: Integer): js.Any = js.native

  /**
    * Asynchronous lchown(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the path (String | Buffer)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    * @example fs.lchown(path, uid, gid, callback)
    */
  def lchown(path: String, uid: Integer, gid: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous lchown(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the path (String | Buffer)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    * @example fs.lchown(path, uid, gid, callback)
    */
  def lchown(path: Buffer, uid: Integer, gid: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous link(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.link(srcpath, dstpath, callback)
    */
  def link(srcpath: Buffer, dstpath: Buffer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous link(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.link(srcpath, dstpath, callback)
    */
  def link(srcpath: Buffer, dstpath: String, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous link(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.link(srcpath, dstpath, callback)
    */
  def link(srcpath: String, dstpath: Buffer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous link(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.link(srcpath, dstpath, callback)
    */
  def link(srcpath: String, dstpath: String, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback. mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: Buffer, mode: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback. mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: String, mode: Integer, callback: js.Function1[js.Error, Any]): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String, options: FileInputOptions, callback: js.Function2[js.Error, _ <: js.Any, Any]): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String, options: String, callback: js.Function2[js.Error, _ <: js.Any, Any]): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String, callback: js.Function2[js.Error, _ <: js.Any, Any]): Unit = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * If the encoding option is specified then this function returns a string. Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: String, encoding: String, options: FileInputOptions): String = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * If the encoding option is specified then this function returns a string. Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: String, encoding: String): String = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * If the encoding option is specified then this function returns a string. Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: String, options: FileInputOptions = null): Buffer = js.native

  /**
    * Asynchronous realpath(2). The callback gets two arguments (err, resolvedPath).
    * May use process.cwd to resolve relative paths.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the path passed to the callback. If the encoding is set to 'buffer',
    * the path returned will be passed as a Buffer object.
    * @example fs.realpath(path[, options], callback)
    */
  def realpath(path: String, options: FileEncodingOptions, callback: js.Function): Unit = js.native

  /**
    * Asynchronous realpath(2). The callback gets two arguments (err, resolvedPath).
    * May use process.cwd to resolve relative paths.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the path passed to the callback. If the encoding is set to 'buffer',
    * the path returned will be passed as a Buffer object.
    * @example fs.realpath(path[, options], callback)
    */
  def realpath(path: String, callback: js.Function): Unit = js.native

  /**
    * @example fs.realpathSync(path[, options])
    */
  def realpathSync(path: String, options: FileEncodingOptions = null): js.Any = js.native

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
    * Asynchronous rmdir(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rmdir(path, callback)
    */
  def rmdir(path: Buffer, callback: js.Function): Unit = js.native

  /**
    * Asynchronous rmdir(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rmdir(path, callback)
    */
  def rmdir(path: String, callback: js.Function): Unit = js.native

  /**
    * Synchronous rmdir(2). Returns undefined.
    * @example fs.rmdirSync(path)
    */
  def rmdirSync(path: Buffer): js.Any = js.native

  /**
    * Synchronous rmdir(2). Returns undefined.
    * @example fs.rmdirSync(path)
    */
  def rmdirSync(path: String): js.Any = js.native

  /**
    * Asynchronous stat(2). The callback gets two arguments (err, stats) where stats is a fs.[[Stats]] object.
    * See the fs.Stats section for more information.
    * @example fs.stat(path, callback)
    */
  def stat(path: Buffer, callback: js.Function): StatTime = js.native

  /**
    * Asynchronous stat(2). The callback gets two arguments (err, stats) where stats is a fs.[[Stats]] object.
    * See the fs.Stats section for more information.
    * @example fs.stat(path, callback)
    */
  def stat(path: String, callback: js.Function): StatTime = js.native

  /**
    * Synchronous stat(2). Returns an instance of fs.[[Stats]].
    * @example fs.statSync(path)
    */
  def statSync(path: Buffer): StatTime = js.native

  /**
    * Synchronous stat(2). Returns an instance of fs.[[Stats]].
    * @example fs.statSync(path)
    */
  def statSync(path: String): StatTime = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: Buffer, path: Buffer, `type`: String, callback: js.Function): js.Any = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: Buffer, path: String, `type`: String, callback: js.Function): js.Any = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: String, path: Buffer, `type`: String, callback: js.Function): js.Any = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: String, path: String, `type`: String, callback: js.Function): js.Any = js.native

  /**
    * Synchronous symlink(2). Returns undefined.
    * @example fs.symlinkSync(target, path[, type])
    */
  def symlinkSync(target: Buffer, path: Buffer, `type`: String): js.Any = js.native

  /**
    * Synchronous symlink(2). Returns undefined.
    * @example fs.symlinkSync(target, path[, type])
    */
  def symlinkSync(target: Buffer, path: String, `type`: String): js.Any = js.native

  /**
    * Synchronous symlink(2). Returns undefined.
    * @example fs.symlinkSync(target, path[, type])
    */
  def symlinkSync(target: String, path: Buffer, `type`: String): js.Any = js.native

  /**
    * Synchronous symlink(2). Returns undefined.
    * @example fs.symlinkSync(target, path[, type])
    */
  def symlinkSync(target: String, path: String, `type`: String): js.Any = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory. The returned object is a fs.[[FSWatcher]].
    *
    * The second argument is optional. If options is provided as a string, it specifies the encoding. Otherwise options
    * should be passed as an object.
    *
    * The listener callback gets two arguments (event, filename). event is either 'rename' or 'change', and filename
    * is the name of the file which triggered the event.
    * @example fs.watch(filename[, options][, listener])
    */
  def watch(filename: String, options: FSWatcherOptions, listener: js.Function): Unit = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory. The returned object is a fs.[[FSWatcher]].
    *
    * The second argument is optional. If options is provided as a string, it specifies the encoding. Otherwise options
    * should be passed as an object.
    *
    * The listener callback gets two arguments (event, filename). event is either 'rename' or 'change', and filename
    * is the name of the file which triggered the event.
    * @example fs.watch(filename[, options][, listener])
    */
  def watch(filename: String, listener: js.Function): Unit = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory. The returned object is a fs.[[FSWatcher]].
    *
    * The second argument is optional. If options is provided as a string, it specifies the encoding. Otherwise options
    * should be passed as an object.
    *
    * The listener callback gets two arguments (event, filename). event is either 'rename' or 'change', and filename
    * is the name of the file which triggered the event.
    * @example fs.watch(filename[, options][, listener])
    */
  def watch(filename: String, options: FSWatcherOptions = null): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: Buffer, options: FileOutputOptions, callback: js.Function): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: String, options: FileOutputOptions, callback: js.Function): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: Buffer, callback: js.Function): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: String, callback: js.Function): Unit = js.native

  /**
    * The synchronous version of fs.writeFile(). Returns undefined.
    * @example fs.writeFileSync(file, data[, options])
    */
  def writeFileSync(file: String, data: Buffer, options: FileOutputOptions): js.Any = js.native

  /**
    * The synchronous version of fs.writeFile(). Returns undefined.
    * @example fs.writeFileSync(file, data[, options])
    */
  def writeFileSync(file: String, data: String, options: FileOutputOptions): js.Any = js.native

}

/**
  * File System Companion
  * @author lawrence.daniels@gmail.com
  */
object Fs {

  /**
    * Represents a file descriptor
    */
  type FileDescriptor = Integer

  /**
    * File System Extensions
    * @param fs the given [[Fs file system]] instance
    */
  implicit class FsExtensions(val fs: Fs) extends AnyVal {

    @inline
    def accessFuture(path: String) = futureCallbackE0[js.Error](fs.access(path, _))

    @inline
    def accessFuture(path: String, mode: Integer) = futureCallbackE0[js.Error](fs.access(path, mode, _))

    @inline
    def accessFuture(path: Buffer) = futureCallbackE0[js.Error](fs.access(path, _))

    @inline
    def accessFuture(path: Buffer, mode: Integer) = futureCallbackE0[js.Error](fs.access(path, mode, _))

    @inline
    def closeFuture(fd: FileDescriptor) = futureCallbackE0[js.Error](fs.close(fd, _))

    @inline
    def fdatasyncFuture(fd: FileDescriptor) = futureCallbackE0[js.Error](fs.fdatasync(fd, _))

    @inline
    def futimesFuture(fd: FileDescriptor, atime: Integer, mtime: Integer) = futureCallbackE0[js.Error](fs.futimes(fd, atime, mtime, _))

    @inline
    def lchmodFuture(path: String, mode: Integer) = futureCallbackE0[js.Error](fs.lchmod(path, mode, _))

    @inline
    def lchownFuture(path: String, uid: Integer, gid: Integer) = futureCallbackE0[js.Error](fs.lchown(path, uid, gid, _))

    @inline
    def linkFuture(srcpath: Buffer, dstpath: Buffer) = futureCallbackE0[js.Error](fs.link(srcpath, dstpath, _))

    @inline
    def linkFuture(srcpath: Buffer, dstpath: String) = futureCallbackE0[js.Error](fs.link(srcpath, dstpath, _))

    @inline
    def linkFuture(srcpath: String, dstpath: Buffer) = futureCallbackE0[js.Error](fs.link(srcpath, dstpath, _))

    @inline
    def linkFuture(srcpath: String, dstpath: String) = futureCallbackE0[js.Error](fs.link(srcpath, dstpath, _))

    @inline
    def mkdirFuture(path: Buffer, mode: Integer) = futureCallbackE0[js.Error](fs.mkdir(path, mode, _))

    @inline
    def mkdirFuture(path: String, mode: Integer) = futureCallbackE0[js.Error](fs.mkdir(path, mode, _))

    @inline
    def readFileFuture(file: String, options: FileInputOptions = null) = futureCallbackE1[js.Error, js.Any](fs.readFile(file, options, _))

    @inline
    def renameFuture(oldPath: String, newPath: String) = futureCallbackE0[js.Error](fs.rename(oldPath, newPath, _))

    @inline
    def realpathFuture(path: String, options: FileEncodingOptions = null) = futureCallbackE0[js.Error](fs.realpath(path, options, _))

    @inline
    def rmdirFuture(path: Buffer) = futureCallbackE0[js.Error](fs.rmdir(path, _))

    @inline
    def rmdirFuture(path: String) = futureCallbackE0[js.Error](fs.rmdir(path, _))

    @inline
    def statFuture(path: String) = futureCallbackE1[js.Error, StatTime](fs.stat(path, _))

    @inline
    def watchFuture(filename: String, options: FSWatcherOptions = null) = {
      futureCallbackA2[String, String](fs.watch(filename, options, _))
    }

    @inline
    def writeFileFuture(file: String, data: Buffer, options: FileOutputOptions = null) = {
      futureCallbackE0[js.Error](fs.writeFile(file, data, options, _))
    }

  }

}
