package io.scalajs.nodejs.fs

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.stream.{Readable, Writable}
import io.scalajs.nodejs.FileDescriptor

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * File I/O is provided by simple wrappers around standard POSIX functions. To use this module do require('fs').
  * All the methods have asynchronous and synchronous forms.
  *
  * The asynchronous form always takes a completion callback as its last argument. The arguments passed to the
  * completion callback depend on the method, but the first argument is always reserved for an exception. If the
  * operation was completed successfully, then the first argument will be null or undefined.
  *
  * When using the synchronous form any exceptions are immediately thrown. You can use try/catch to handle exceptions
  * or allow them to bubble up.
  * @version 6.2.1
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Fs extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      File Access Constants
  //
  //      The following constants are meant for use with fs.access().
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * File is visible to the calling process. This is useful for determining if a file exists, but says
    * nothing about rwx permissions. Default if no mode is specified.
    */
  val F_OK: FileMode = js.native

  /**
    * File can be read by the calling process.
    */
  val R_OK: FileMode = js.native

  /**
    * File can be written by the calling process.
    */
  val W_OK: FileMode = js.native

  /**
    * File can be executed by the calling process. This has no effect on Windows (will behave like fs.[[F_OK]]).
    */
  val X_OK: FileMode = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      File Open Constants
  //
  //      The following constants are meant for use with fs.open().
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Flag indicating to open a file for read-only access.
    */
  val O_RDONLY: Int = js.native

  /**
    * Flag indicating to open a file for write-only access.
    */
  val O_WRONLY: Int = js.native

  /**
    * Flag indicating to open a file for read-write access.
    */
  val O_RDWR: Int = js.native

  /**
    * Flag indicating to create the file if it does not already exist.
    */
  val O_CREAT: Int = js.native

  /**
    * Flag indicating that opening a file should fail if the O_CREAT flag is set and the file already exists.
    */
  val O_EXCL: Int = js.native

  /**
    * Flag indicating that if path identifies a terminal device, opening the path shall not cause that terminal to
    * become the controlling terminal for the process (if the process does not already have one).
    */
  val O_NOCTTY: Int = js.native

  /**
    * Flag indicating that if the file exists and is a regular file, and the file is opened successfully for write
    * access, its length shall be truncated to zero.
    */
  val O_TRUNC: Int = js.native

  /**
    * Flag indicating that data will be appended to the end of the file.
    */
  val O_APPEND: Int = js.native

  /**
    * Flag indicating that the open should fail if the path is not a directory.
    */
  val O_DIRECTORY: Int = js.native

  /**
    * Flag indicating reading accesses to the file system will no longer result in an update to the atime information
    * associated with the file. This flag is available on Linux operating systems only.
    */
  val O_NOATIME: Int = js.native

  /**
    * Flag indicating that the open should fail if the path is a symbolic link.
    */
  val O_NOFOLLOW: Int = js.native

  /**
    * Flag indicating that the file is opened for synchronous I/O.
    */
  val O_SYNC: Int = js.native

  /**
    * Flag indicating to open the symbolic link itself rather than the resource it is pointing to.
    */
  val O_SYMLINK: Int = js.native

  /**
    * When set, an attempt will be made to minimize caching effects of file I/O.
    */
  val O_DIRECT: Int = js.native

  /**
    * Flag indicating to open the file in nonblocking mode when possible.
    */
  val O_NONBLOCK: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      File Type Constants
  //
  //      The following constants are meant for use with the fs.Stats object's mode
  //      property for determining a file's type.
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Bit mask used to extract the file type code.
    */
  val S_IFMT: FileType = js.native

  /**
    * File type constant for a regular file.
    */
  val S_IFREG: FileType = js.native

  /**
    * File type constant for a directory.
    */
  val S_IFDIR: FileType = js.native

  /**
    * File type constant for a character-oriented device file.
    */
  val S_IFCHR: FileType = js.native

  /**
    * File type constant for a block-oriented device file.
    */
  val S_IFBLK: FileType = js.native

  /**
    * File type constant for a FIFO/pipe.
    */
  val S_IFIFO: FileType = js.native

  /**
    * File type constant for a symbolic link.
    */
  val S_IFLNK: FileType = js.native

  /**
    * File type constant for a socket.
    */
  val S_IFSOCK: FileType = js.native


  /////////////////////////////////////////////////////////////////////////////////
  //      Classes
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * TODO find documentation
    */
  def FSWatcher: js.Function1[String, FSWatcher] = js.native

  /**
    * TODO find documentation
    */
  def ReadStream: js.Function1[String, ReadStream] = js.native

  /**
    * TODO find documentation
    */
  def WriteStream: js.Function1[String, WriteStream] = js.native

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
  def access(path: String | Buffer, mode: FileMode, callback: js.Function): Unit = js.native

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
  def access(path: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @param path the path (String | Buffer)
    * @param mode the optional mode
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: String | Buffer, mode: FileMode = null): Unit = js.native

  /**
    * Asynchronously append data to a file, creating the file if it does not yet exist. data can be a string or a buffer.
    * @param file     the filename or file descriptor (String | Buffer | Number)
    * @param data     the data to append (String | Buffer)
    * @param options  the optional append options
    * @param callback the callback function
    * @example fs.appendFile(file, data[, options], callback)
    */
  def appendFile(file: String | Buffer | Int, data: String | Buffer, options: AppendOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * Asynchronously append data to a file, creating the file if it does not yet exist. data can be a string or a buffer.
    * @param file     the filename or file descriptor (String | Buffer | Number)
    * @param data     the data to append (String | Buffer)
    * @param callback the callback function
    * @example fs.appendFile(file, data[, options], callback)
    */
  def appendFile(file: String | Buffer | Int, data: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Asynchronous close(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.close(fd, callback)
    */
  def close(fd: FileDescriptor, callback: js.Function): Unit = js.native

  /**
    * Synchronous close(2). Returns undefined.
    * @example fs.closeSync(fd)
    */
  def closeSync(fd: FileDescriptor): Unit = js.native

  /**
    * Returns a new ReadStream object. (See Readable Stream).vBe aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @param path    the path (String | Buffer)
    * @param options the optional stream options
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: String | Buffer, options: FileInputOptions | RawOptions = js.native): Readable = js.native

  /**
    * Returns a new WriteStream object.
    * @param path    the path (String | Buffer)
    * @param options the optional stream options
    * @example fs.createWriteStream(path[, options])
    * @see [[Writable]]
    */
  def createWriteStream(path: String | Buffer, options: FileOutputOptions | RawOptions = js.native): Writable = js.native

  /**
    * Test whether or not the given path exists by checking with the file system. Then call the callback argument with
    * either true or false.
    * @example fs.exists('/etc/passwd', (exists) => { ... })
    */
  @deprecated("Use fs.stat() or fs.access() instead.", since = "1.0.0")
  def exists(path: String, callback: js.Function): Unit = js.native

  /**
    * fs.exists() should not be used to check if a file exists before calling fs.open(). Doing so introduces a race
    * condition since other processes may change the file's state between the two calls. Instead, user code should
    * call fs.open() directly and handle the error raised if the file is non-existent.
    * @example fs.existsSync(path)
    */
  @deprecated("Use fs.statSync() or fs.accessSync() instead.", since = "1.0.0")
  def existsSync(path: String): Boolean = js.native

  /**
    * Asynchronous fchmod(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.fchmod(fd, mode, callback)
    */
  def fchmod(fd: FileDescriptor, mode: FileMode, callback: js.Function): Unit = js.native

  /**
    * Synchronous fchmod(2). Returns undefined.
    * @example fs.fchmodSync(fd, mode)
    */
  def fchmodSync(fd: FileDescriptor, mode: FileMode): Unit = js.native

  /**
    * Asynchronous fdatasync(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.fdatasync(fd, callback)
    */
  def fdatasync(fd: FileDescriptor, callback: js.Function): Unit = js.native

  /**
    * Synchronous fdatasync(2). Returns undefined.
    * @example fs.fdatasyncSync(fd)
    */
  def fdatasyncSync(fd: FileDescriptor): Unit = js.native

  /**
    * Change the file timestamps of a file referenced by the supplied file descriptor.
    * @example fs.futimes(fd, atime, mtime, callback)
    */
  def futimes(fd: FileDescriptor, atime: Integer, mtime: Integer, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.futimes(). Returns undefined.
    * @example fs.futimesSync(fd, atime, mtime)
    */
  def futimesSync(fd: FileDescriptor, atime: Integer, mtime: Integer): Unit = js.native

  /**
    * Asynchronous lchmod(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.lchmod(path, mode, callback)
    */
  def lchmod(path: String | Buffer, mode: FileMode, callback: js.Function): Unit = js.native

  /**
    * Synchronous lchmod(2). Returns undefined.
    * @param path the path (String | Buffer)
    * @param mode the mode (Integer)
    * @example fs.lchmodSync(path, mode)
    */
  def lchmodSync(path: String | Buffer, mode: FileMode): Unit = js.native

  /**
    * Asynchronous lchown(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the path (String | Buffer)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    * @example fs.lchown(path, uid, gid, callback)
    */
  def lchown(path: String | Buffer, uid: Integer, gid: Integer, callback: js.Function): Unit = js.native

  /**
    * Synchronous chown(2). Returns undefined.
    * @param path the path (String | Buffer)
    * @param uid  the user ID
    * @param gid  the group ID
    */
  def lchownSync(path: String | Buffer, uid: Integer, gid: Integer): Unit = js.native

  /**
    * Asynchronous link(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.link(srcpath, dstpath, callback)
    */
  def link(srcpath: String | Buffer, dstpath: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback. mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: String | Buffer, mode: FileMode | js.Any, callback: js.Function): Unit = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback. mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String, options: FileInputOptions | RawOptions | String, callback: js.Function): Unit = js.native

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
  def readFileSync(file: String, encoding: String, options: FileInputOptions | RawOptions): String = js.native

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
  def readFileSync(file: String, options: FileInputOptions | RawOptions = js.native): Buffer = js.native

  /**
    * Asynchronous realpath(2). The callback gets two arguments (err, resolvedPath).
    * May use process.cwd to resolve relative paths.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the path passed to the callback. If the encoding is set to 'buffer',
    * the path returned will be passed as a Buffer object.
    * @example fs.realpath(path[, options], callback)
    */
  def realpath(path: String, options: FileEncodingOptions | RawOptions, callback: js.Function): Unit = js.native

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
  def realpathSync(path: String, options: FileEncodingOptions | RawOptions = js.native): String = js.native

  /**
    * Asynchronous rename(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rename(oldPath, newPath, callback)
    */
  def rename(oldPath: String, newPath: String, callback: js.Function): Unit = js.native

  /**
    * Synchronous rename(2). Returns undefined.
    * @example fs.renameSync(oldPath, newPath)
    */
  def renameSync(oldPath: String, newPath: String): Unit = js.native

  /**
    * Asynchronous rmdir(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rmdir(path, callback)
    */
  def rmdir(path: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Synchronous rmdir(2). Returns undefined.
    * @example fs.rmdirSync(path)
    */
  def rmdirSync(path: String | Buffer): Unit = js.native

  /**
    * Asynchronous stat(2). The callback gets two arguments (err, stats) where stats is a fs.[[Stats]] object.
    * See the fs.Stats section for more information.
    * @example fs.stat(path, callback)
    */
  def stat(path: String | Buffer, callback: js.Function): Stats = js.native

  /**
    * Synchronous stat(2). Returns an instance of fs.[[Stats]].
    * @example fs.statSync(path)
    */
  def statSync(path: String | Buffer): Stats = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: String | Buffer, path: String | Buffer, `type`: String, callback: js.Function1[FileIOError, Any]): Unit = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: String | Buffer, path: String | Buffer, callback: js.Function1[FileIOError, Any]): Unit = js.native

  /**
    * Synchronous symlink(2). Returns undefined.
    * @example fs.symlinkSync(target, path[, type])
    */
  def symlinkSync(target: String | Buffer, path: String | Buffer, `type`: String = null): Unit = js.native

  /**
    * Asynchronous unlink(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.unlink(path, callback)
    */
  def unlink(path: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Synchronous unlink(2). Returns undefined.
    * @example fs.unlinkSync(path)
    */
  def unlinkSync(path: String | Buffer): Unit = js.native

  /**
    * Stop watching for changes on filename. If listener is specified, only that particular listener is removed.
    * Otherwise, all listeners are removed and you have effectively stopped watching filename.
    *
    * Calling fs.unwatchFile() with a filename that is not being watched is a no-op, not an error.
    *
    * Note: fs.watch() is more efficient than fs.watchFile() and fs.unwatchFile(). fs.watch() should be used instead of
    * fs.watchFile() and fs.unwatchFile() when possible.
    * @example fs.unwatchFile(filename[, listener])
    */
  def unwatchFile(filename: String | Buffer, listener: js.Function = null): Unit = js.native

  /**
    * Change file timestamps of the file referenced by the supplied path.
    *
    * Note: the arguments atime and mtime of the following related functions does follow the below rules:
    *
    * If the value is a numberable string like '123456789', the value would get converted to corresponding number.
    * If the value is NaN or Infinity, the value would get converted to Date.now().
    * @example fs.utimes(path, atime, mtime, callback)
    */
  def utimes(path: String | Buffer, atime: Int, mtime: Int, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.utimes(). Returns undefined.
    * @example fs.utimesSync(path, atime, mtime)
    */
  def utimesSync(path: String | Buffer, atime: Int, mtime: Int): Unit = js.native

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
  def watch(filename: String, options: FSWatcherOptions | RawOptions, listener: js.Function): Unit = js.native

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
  def watch(filename: String, options: FSWatcherOptions | RawOptions = js.native): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: String | Buffer, options: FileOutputOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * The synchronous version of fs.writeFile(). Returns undefined.
    * @example fs.writeFileSync(file, data[, options])
    */
  def writeFileSync(file: String, data: String | Buffer, options: FileOutputOptions | RawOptions = js.native): Unit = js.native

}

/**
  * File System Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("fs", JSImport.Namespace)
object Fs extends Fs