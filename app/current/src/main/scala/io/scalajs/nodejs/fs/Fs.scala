package io.scalajs.nodejs
package fs

import com.thoughtworks.{enableIf, enableMembersIf}
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray
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
  */
@js.native
trait Fs extends IEventEmitter with FSConstants {

  /**
    * Returns an object containing commonly used constants for file system operations
    * @return an [[FSConstants object]] containing commonly used constants for file system operations
    */
  def constants: FSConstants = js.native

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
    * <li>[[FSConstants.R_OK]] - File can be read by the calling process.</li>
    * <li>[[FSConstants.W_OK]] - File can be written by the calling process.</li>
    * <li>[[FSConstants.X_OK]] - File can be executed by the calling process. This has no effect on Windows (will behave like [[F_OK]]).</li>
    * </ul>
    * @param path     the path (Buffer | String)
    * @param mode     the optional mode
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: Path, mode: FileMode, callback: FsCallback0): Unit = js.native

  /**
    * Tests a user's permissions for the file specified by path. mode is an optional integer that specifies
    * the accessibility checks to be performed. The following constants define the possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values.
    * <ul>
    * <li>fs.F_OK - File is visible to the calling process. This is useful for determining if a file exists,
    * but says nothing about rwx permissions. Default if no mode is specified.</li>
    * <li>[[FSConstants.R_OK]] - File can be read by the calling process.</li>
    * <li>[[FSConstants.W_OK]] - File can be written by the calling process.</li>
    * <li>[[FSConstants.X_OK]] - File can be executed by the calling process. This has no effect on Windows (will behave like [[F_OK]]).</li>
    * </ul>
    * @param path     the path (Buffer | String)
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: Path, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @param path the path (Buffer | String)
    * @param mode the optional mode
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: Path, mode: FileMode = js.native): Unit = js.native

  /**
    * Asynchronously append data to a file, creating the file if it does not yet exist. data can be a string or a buffer.
    * @param file     the filename or file descriptor (Buffer | String | Number)
    * @param data     the data to append (Buffer | String)
    * @param options  the [[FileAppendOptions optional append settings]]
    * @param callback the callback function
    * @example fs.appendFile(file, data[, options], callback)
    */
  def appendFile(file: Path | FileDescriptor,
                 data: Buffer | String,
                 options: FileAppendOptions,
                 callback: FsCallback0): Unit = js.native

  /**
    * Asynchronously append data to a file, creating the file if it does not yet exist. data can be a string or a buffer.
    * @param path     the filename or file descriptor (Buffer | String | Number)
    * @param data     the data to append (Buffer | String)
    * @param callback the callback function
    * @example fs.appendFile(file, data[, options], callback)
    */
  def appendFile(path: Path | FileDescriptor, data: Buffer | String, callback: FsCallback0): Unit = js.native

  /**
    * The synchronous version of fs.appendFile().
    * @param path    the filename or file descriptor (Buffer | String | Number)
    * @param data    the data to append (Buffer | String)
    * @param options the [[FileAppendOptions optional append settings]]
    * @return undefined.
    */
  def appendFileSync(path: Path | FileDescriptor, data: Buffer | String, options: FileAppendOptions = js.native): Unit =
    js.native

  /**
    * Asynchronous chmod(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the file or directory path (Buffer | String)
    * @param mode     the file or directory mode
    * @param callback the completion callback.
    */
  def chmod(path: Path, mode: FileMode, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous chmod(2).
    * @param path the file or directory path (Buffer | String)
    * @param mode the file or directory mode
    * @return undefined.
    */
  def chmodSync(path: Path, mode: FileMode): Unit = js.native

  /**
    * Asynchronous chown(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the file or directory path (Buffer | String)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    */
  def chown(path: Path, uid: UID, gid: GID, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous chown(2).
    * @param path the file or directory path (Buffer | String)
    * @param uid  the user ID
    * @param gid  the group ID
    * @return undefined.
    */
  def chownSync(path: Path, uid: UID, gid: GID): Unit = js.native

  /**
    * Asynchronous close(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.close(fd, callback)
    */
  def close(fd: FileDescriptor, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous close(2).
    * @return undefined.
    * @example fs.closeSync(fd)
    */
  def closeSync(fd: FileDescriptor): Unit = js.native

  /**
    * Asynchronously copies src to dest. By default, dest is overwritten if it already exists. No arguments other
    * than a possible exception are given to the callback function. Node.js makes no guarantees about the atomicity
    * of the copy operation. If an error occurs after the destination file has been opened for writing, Node.js will
    * attempt to remove the destination.
    *
    * flags is an optional integer that specifies the behavior of the copy operation. The only supported flag is
    * fs.constants.COPYFILE_EXCL, which causes the copy operation to fail if dest already exists.
    * @param src      the source filename to copy
    * @param dest     the  destination filename of the copy operation
    * @param flags    the modifiers for copy operation. Default: 0
    * @param callback the callback function
    * @example {{{ fs.copyFile(src, dest[, flags], callback) }}}
    */
  def copyFile(src: Path, dest: Path, flags: Flags, callback: FsCallback0): Unit =
    js.native

  /**
    * Asynchronously copies src to dest. By default, dest is overwritten if it already exists. No arguments other
    * than a possible exception are given to the callback function. Node.js makes no guarantees about the atomicity
    * of the copy operation. If an error occurs after the destination file has been opened for writing, Node.js will
    * attempt to remove the destination.
    *
    * flags is an optional integer that specifies the behavior of the copy operation. The only supported flag is
    * fs.constants.COPYFILE_EXCL, which causes the copy operation to fail if dest already exists.
    * @param src      the source filename to copy
    * @param dest     the  destination filename of the copy operation
    * @param callback the callback function
    * @example {{{ fs.copyFile(src, dest[, flags], callback) }}}
    */
  def copyFile(src: Path, dest: Path, callback: FsCallback0): Unit = js.native

  /**
    * Synchronously copies src to dest. By default, dest is overwritten if it already exists.
    *
    * Node.js makes no guarantees about the atomicity of the copy operation. If an error occurs after the destination
    * file has been opened for writing, Node.js will attempt to remove the destination.
    *
    * flags is an optional integer that specifies the behavior of the copy operation. The only supported flag is
    * fs.constants.COPYFILE_EXCL, which causes the copy operation to fail if dest already exists.
    * @param src   the source filename to copy
    * @param dest  the  destination filename of the copy operation
    * @param flags the modifiers for copy operation. Default: 0
    * @example {{{ fs.copyFileSync(src, dest[, flags]) }}}
    */
  def copyFileSync(src: Path, dest: Path, flags: Flags): Unit = js.native

  /**
    * Returns a new ReadStream object. (See Readable Stream). Be aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @param path    the path (Buffer | String)
    * @param options the optional stream options
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: Path, options: FileInputOptions = js.native): ReadStream =
    js.native

  /**
    * Returns a new WriteStream object.
    * @param path    the path (Buffer | String)
    * @param options the optional stream options
    * @example fs.createWriteStream(path[, options])
    */
  def createWriteStream(path: Path, options: FileOutputOptions = js.native): WriteStream =
    js.native

  /**
    * fs.exists() should not be used to check if a file exists before calling fs.open(). Doing so introduces a race
    * condition since other processes may change the file's state between the two calls. Instead, user code should
    * call fs.open() directly and handle the error raised if the file is non-existent.
    * @example fs.existsSync(path)
    */
  def existsSync(path: Path): Boolean = js.native

  /**
    * Asynchronous fchmod(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.fchmod(fd, mode, callback)
    */
  def fchmod(fd: FileDescriptor, mode: FileMode, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous fchmod(2).
    * @return undefined.
    * @example fs.fchmodSync(fd, mode)
    */
  def fchmodSync(fd: FileDescriptor, mode: FileMode): Unit = js.native

  /**
    * Asynchronous fchown(2). No arguments other than a possible exception are given to the completion callback.
    * @param fd       the file descriptor
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    */
  def fchown(fd: FileDescriptor, uid: UID, gid: GID, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous fchown(2).
    * @param fd   the file descriptor
    * @param uid  the user ID
    * @param gid  the group ID
    *
    */
  def fchownSync(fd: FileDescriptor, uid: UID, gid: GID): Unit = js.native

  /**
    * Asynchronous fdatasync(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.fdatasync(fd, callback)
    */
  def fdatasync(fd: FileDescriptor, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous fdatasync(2).
    * @return undefined.
    * @example fs.fdatasyncSync(fd)
    */
  def fdatasyncSync(fd: FileDescriptor): Unit = js.native

  /**
    * Asynchronous fstat(2). The callback gets two arguments (err, stats) where stats is an fs.Stats object.
    * fstat() is identical to stat(), except that the file to be stat-ed is specified by the file descriptor fd.
    * @param fd       the file descriptor
    * @param callback the completion callback.
    */
  def fstat(fd: FileDescriptor, callback: FsCallback1[Stats]): Unit = js.native

  def fstat(fd: FileDescriptor, options: StatOptions, callback: FsCallback1[Stats]): Unit = js.native

  /**
    * Synchronous fstat(2).
    * @param fd the file descriptor
    * @return an instance of [[fs.Stats]].
    */
  def fstatSync(fd: FileDescriptor, options: StatOptions = js.native): Stats = js.native

  /**
    * Asynchronous fsync(2). No arguments other than a possible exception are given to the completion callback.
    * @param fd       the file descriptor
    * @param callback the completion callback.
    */
  def fsync(fd: FileDescriptor, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous fsync(2).
    * @return undefined.
    * @param fd the file descriptor
    */
  def fsyncSync(fd: FileDescriptor): Unit = js.native

  /**
    * Asynchronous ftruncate(2). No arguments other than a possible exception are given to the completion callback.
    * If the file referred to by the file descriptor was larger than length bytes, only the first length bytes will be
    * retained in the file.
    * @param fd       the file descriptor
    * @param callback the completion callback.
    */
  def ftruncate(fd: FileDescriptor, callback: FsCallback0): Unit = js.native

  /**
    * Asynchronous ftruncate(2). No arguments other than a possible exception are given to the completion callback.
    * If the file referred to by the file descriptor was larger than length bytes, only the first length bytes will be
    * retained in the file.
    * @param fd       the file descriptor
    * @param length   the desired length
    * @param callback the completion callback.
    */
  def ftruncate(fd: FileDescriptor, length: Int, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous ftruncate(2).
    * @param fd     the file descriptor
    * @param length the desired length
    * @return undefined.
    */
  def ftruncateSync(fd: FileDescriptor, length: Int = 0): Unit = js.native

  /**
    * Change the file timestamps of a file referenced by the supplied file descriptor.
    * @example fs.futimes(fd, atime, mtime, callback)
    */
  def futimes(fd: FileDescriptor, atime: Time, mtime: Time, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.futimes().
    * @return undefined.
    * @example fs.futimesSync(fd, atime, mtime)
    */
  def futimesSync(fd: FileDescriptor, atime: Time, mtime: Time): Unit = js.native

  /**
    * Asynchronous lchmod(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.lchmod(path, mode, callback)
    */
  def lchmod(path: Path, mode: FileMode, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous lchmod(2).
    * @param path the path (Buffer | String)
    * @param mode the mode (Integer)
    * @return undefined.
    * @example fs.lchmodSync(path, mode)
    */
  def lchmodSync(path: Path, mode: FileMode): Unit = js.native

  /**
    * Asynchronous lchown(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the path (Buffer | String)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    * @example fs.lchown(path, uid, gid, callback)
    */
  def lchown(path: Path, uid: UID, gid: GID, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous chown(2).
    * @param path the path (Buffer | String)
    * @param uid  the user ID
    * @param gid  the group ID
    * @return undefined.
    */
  def lchownSync(path: Path, uid: UID, gid: GID): Unit = js.native

  /**
    * Asynchronous link(2). No arguments other than a possible exception are given to the completion callback.
    * @param existingPath the existing path
    * @param newPath      the new path
    * @param callback     the completion callback.
    * @example fs.link(srcpath, dstpath, callback)
    */
  def link(existingPath: Path, newPath: Path, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous link(2).
    * @param existingPath the existing path
    * @param newPath      the new path
    * @return undefined.
    */
  def linkSync(existingPath: Path, newPath: Path): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def lstat(path: Path, options: StatOptions, callback: FsCallback1[Stats]): Unit = js.native

  /**
    * Asynchronous lstat(2).
    * lstat() is identical to stat(), except that if path is a symbolic link, then the link itself is stat-ed,
    * not the file that it refers to.
    * @param path     the path (Buffer | String)
    * @param callback The callback gets two arguments (err, stats) where stats is a fs.Stats object.
    */
  def lstat(path: Path, callback: FsCallback1[Stats]): Unit = js.native

  /**
    * Synchronous lstat(2).
    * @param path the path (Buffer | String)
    * @return an instance of [[fs.Stats]].
    */
  def lstatSync(path: Path): Stats = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def lstatSync(path: Path, options: StatOptions): Stats = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback.
    * mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: Path, mode: FileMode, callback: FsCallback0): Unit = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback.
    * mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def mkdir(path: Path, mode: MkdirOptions, callback: FsCallback0): Unit = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback.
    * mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: Path, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous mkdir(2).
    * @param path the path
    * @param mode the mode
    */
  def mkdirSync(path: Path, mode: FileMode = js.native): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def mkdirSync(path: Path, mode: MkdirOptions): Unit = js.native

  /**
    * Creates a unique temporary directory.
    * Generates six random characters to be appended behind a required prefix to create a unique temporary directory.
    * The created folder path is passed as a string to the callback's second parameter.
    * The optional options argument can be a string specifying an encoding, or an object with an
    * encoding property specifying the character encoding to use.
    * @param prefix   the prefix
    * @param options  the optional encoding setting
    * @param callback the callback
    * @example fs.mkdtemp(prefix[, options], callback)
    */
  def mkdtemp(prefix: String, options: String | FileEncodingOptions, callback: FsCallback1[String]): Unit =
    js.native

  /**
    * Creates a unique temporary directory.
    * Generates six random characters to be appended behind a required prefix to create a unique temporary directory.
    * The created folder path is passed as a string to the callback's second parameter.
    * The optional options argument can be a string specifying an encoding, or an object with an
    * encoding property specifying the character encoding to use.
    * @param prefix   the prefix
    * @param callback the callback
    * @example fs.mkdtemp(prefix[, options], callback)
    */
  def mkdtemp(prefix: String, callback: FsCallback1[String]): Unit = js.native

  /**
    * The synchronous version of fs.mkdtemp(). Returns the created folder path.
    * The optional options argument can be a string specifying an encoding, or an object with
    * an encoding property specifying the character encoding to use.
    * @param prefix  the prefix
    * @param options the optional encoding setting
    */
  def mkdtempSync(prefix: String, options: String | FileEncodingOptions = js.native): String = js.native

  /**
    * Asynchronous file open. See open(2).
    * @param path     the path (Buffer | String)
    * @param flags    flags can be:
    *                 <ul>
    *                 <li>'r' - Open file for reading. An exception occurs if the file does not exist.</li>
    *                 <li>'r+' - Open file for reading and writing. An exception occurs if the file does not exist.</li>
    *                 <li>'rs+' - Open file for reading and writing in synchronous mode.
    *                 Instructs the operating system to bypass the local file system cache.
    *                 This is primarily useful for opening files on NFS mounts as it allows you to skip
    *                 the potentially stale local cache. It has a very real impact on I/O performance
    *                 so don't use this flag unless you need it.
    *                 Note that this doesn't turn fs.open() into a synchronous blocking call.
    *                 If that's what you want then you should be using fs.openSync()</li>
    *                 <li>'w' - Open file for writing. The file is created (if it does not exist) or truncated (if it exists).</li>
    *                 <li>'wx' - Like 'w' but fails if path exists.</li>
    *                 <li>'w+' - Open file for reading and writing. The file is created (if it does not exist) or truncated (if it exists).</li>
    *                 <li>'wx+' - Like 'w+' but fails if path exists.</li>
    *                 <li>'a' - Open file for appending. The file is created if it does not exist.</li>
    *                 <li>'ax' - Like 'a' but fails if path exists.</li>
    *                 <li>'a+' - Open file for reading and appending. The file is created if it does not exist.</li>
    *                 <li>'ax+' - Like 'a+' but fails if path exists.</li>
    *                 </ul>
    * @param mode     sets the file mode (permission and sticky bits), but only if the file was created.
    *                 It defaults to 0666, readable and writable.
    * @param callback the callback gets two arguments (err, fd)
    * @example fs.open(path, flags[, mode], callback)
    */
  def open(path: Path, flags: Flags, mode: FileMode, callback: FsCallback1[FileDescriptor]): Unit =
    js.native

  /**
    * Asynchronous file open. See open(2).
    * @param path     the path (Buffer | String)
    * @param flags    flags can be:
    *                 <ul>
    *                 <li>'r' - Open file for reading. An exception occurs if the file does not exist.</li>
    *                 <li>'r+' - Open file for reading and writing. An exception occurs if the file does not exist.</li>
    *                 <li>'rs+' - Open file for reading and writing in synchronous mode.
    *                 Instructs the operating system to bypass the local file system cache.
    *                 This is primarily useful for opening files on NFS mounts as it allows you to skip
    *                 the potentially stale local cache. It has a very real impact on I/O performance
    *                 so don't use this flag unless you need it.
    *                 Note that this doesn't turn fs.open() into a synchronous blocking call.
    *                 If that's what you want then you should be using fs.openSync()</li>
    *                 <li>'w' - Open file for writing. The file is created (if it does not exist) or truncated (if it exists).</li>
    *                 <li>'wx' - Like 'w' but fails if path exists.</li>
    *                 <li>'w+' - Open file for reading and writing. The file is created (if it does not exist) or truncated (if it exists).</li>
    *                 <li>'wx+' - Like 'w+' but fails if path exists.</li>
    *                 <li>'a' - Open file for appending. The file is created if it does not exist.</li>
    *                 <li>'ax' - Like 'a' but fails if path exists.</li>
    *                 <li>'a+' - Open file for reading and appending. The file is created if it does not exist.</li>
    *                 <li>'ax+' - Like 'a+' but fails if path exists.</li>
    *                 </ul>
    * @param callback the callback gets two arguments (err, fd)
    * @example fs.open(path, flags[, mode], callback)
    */
  def open(path: Path, flags: Flags, callback: FsCallback1[FileDescriptor]): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def open(path: Path, callback: FsCallback1[FileDescriptor]): Unit = js.native

  /**
    * Synchronous version of fs.open().
    * @param path  the path (Buffer | String)
    * @param flags the flags
    * @param mode  the file mode
    * @return an integer representing the file descriptor.
    * @example fs.openSync(path, flags[, mode])
    */
  def openSync(path: Path, flags: Flags, mode: FileMode = js.native): FileDescriptor = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def openSync(path: Path): FileDescriptor = js.native

  /**
    * Read data from the file specified by fd.
    * @param fd       is the file descriptor
    * @param buffer   is the buffer that the data will be written to.
    * @param offset   is the offset in the buffer to start writing at.
    * @param length   is an integer specifying the number of bytes to read.
    * @param position is an integer specifying where to begin reading from in the file. If position is null,
    *                 data will be read from the current file position.
    * @param callback the callback is given the three arguments, (err, bytesRead, buffer).
    */
  def read(fd: FileDescriptor,
           buffer: Buffer,
           offset: Int | Null,
           length: Int | Null,
           position: Int | Null,
           callback: FsCallback2[Int, Buffer]): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def read(fd: FileDescriptor,
           buffer: BufferLike,
           offset: Int | Null,
           length: Int | Null,
           position: Int | Null,
           callback: FsCallback2[Int, Buffer]): Unit = js.native

  /**
    * Synchronous version of fs.read().
    * @param fd       is the file descriptor
    * @param buffer   is the buffer that the data will be written to.
    * @param offset   is the offset in the buffer to start writing at.
    * @param length   is an integer specifying the number of bytes to read.
    * @param position is an integer specifying where to begin reading from in the file. If position is null,
    *                 data will be read from the current file position.
    * @return the number of bytesRead.
    */
  def readSync(fd: FileDescriptor, buffer: Buffer, offset: Int, length: Int, position: Int): Int = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def readSync(fd: FileDescriptor, buffer: BufferLike, offset: Int, length: Int, position: Int): Int = js.native

  /**
    * Asynchronous readdir(3). Reads the contents of a directory.
    * @param path     the path (Buffer | String)
    * @param options  the optional options argument can be a string specifying an encoding,
    *                 or an object with an encoding property specifying the character encoding
    *                 to use for the filenames passed to the callback. If the encoding is set
    *                 to 'buffer', the filenames returned will be passed as Buffer objects.
    * @param callback the callback gets two arguments (err, files) where files is an array
    *                 of the names of the files in the directory excluding '.' and '..'.
    * @example fs.readdir(path[, options], callback)
    */
  def readdir(path: Path, options: String | FileEncodingOptions, callback: FsCallback1[ReaddirArrays]): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def readdir(path: Path, options: ReaddirOptions, callback: FsCallback1[ReaddirArrays2]): Unit = js.native

  /**
    * Asynchronous readdir(3). Reads the contents of a directory.
    * @param path     the path (Buffer | String)
    * @param callback the callback gets two arguments (err, files) where files is an array
    *                 of the names of the files in the directory excluding '.' and '..'.
    * @example fs.readdir(path[, options], callback)
    */
  def readdir(path: Path, callback: FsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Synchronous readdir(3).
    * @param path    the path (Buffer | String)
    * @param options the optional options argument can be a string specifying an encoding,
    *                or an object with an encoding property specifying the character encoding
    *                to use for the filenames passed to the callback. If the encoding is set
    *                to 'buffer', the filenames returned will be passed as Buffer objects.
    * @return an array of filenames excluding '.' and '..'.
    */
  def readdirSync(path: Path, options: String | ReaddirOptions = js.native): js.Array[String] = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @param file     filename or file descriptor
    * @param options  the optional settings
    * @param callback The callback is passed two arguments (err, data), where data is the contents of the file.
    *                 If no encoding is specified, then the raw buffer is returned.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: Path | FileDescriptor, options: ReadFileOptions, callback: FsCallback1[Output]): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @param file     filename or file descriptor
    * @param encoding the encoding (default = null)
    * @param callback The callback is passed two arguments (err, data), where data is the contents of the file.
    *                 If no encoding is specified, then the raw buffer is returned.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: Path | FileDescriptor, encoding: String, callback: FsCallback1[String]): Unit =
    js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @param file     filename or file descriptor
    * @param callback The callback is passed two arguments (err, data), where data is the contents of the file.
    *                 If no encoding is specified, then the raw buffer is returned.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: Path | FileDescriptor, callback: FsCallback1[Buffer]): Unit = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * @param file     filename or file descriptor <String> | <Buffer> | <Integer>
    * @param encoding the optional encoding <Object> | <String>
    * @return the contents of the file. If the encoding option is specified then this function returns a string.
    *         Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: Path | FileDescriptor, encoding: String): String = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * @param file    filename or file descriptor <String> | <Buffer> | <Integer>
    * @param options the optional encoding <Object> | <String>
    * @return the contents of the file. If the encoding option is specified then this function returns a string.
    *         Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: Path | FileDescriptor, options: ReadFileOptions = js.native): Output = js.native

  /**
    * Synchronous version of fs.readFile.
    * @param file filename or file descriptor <String> | <Buffer> | <Integer>
    * @return the contents of the file. If the encoding option is specified then this function returns a string.
    *         Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: Path | FileDescriptor): Buffer = js.native

  /**
    * Asynchronous readlink(2).
    * If the encoding is set to 'buffer', the link path returned will be passed as a Buffer object.
    * @param path     the path (Buffer | String)
    * @param options  the optional options argument can be a string specifying an encoding, or an object
    *                 with an encoding property specifying the character encoding to use for the link path
    *                 passed to the callback.
    * @param callback the callback gets two arguments (err, linkString).
    * @example fs.readlink(path[, options], callback)
    */
  def readlink(path: Path, options: String | FileEncodingOptions, callback: FsCallback1[Output]): Unit =
    js.native
  def readlink(path: Path, callback: FsCallback1[String]): Unit = js.native

  /**
    * Synchronous readlink(2).
    * @param path    the path (Buffer | String)
    * @param options the optional options argument can be a string specifying an encoding,
    *                or an object with an encoding property specifying the character encoding
    *                to use for the link path passed to the callback. If the encoding is set
    *                to 'buffer', the link path returned will be passed as a Buffer object.
    * @return the symbolic link's string value.
    */
  def readlinkSync(path: Path, options: String | FileEncodingOptions): Output = js.native
  def readlinkSync(path: Path): String                                        = js.native

  /**
    * Asynchronous realpath(2).
    * May use process.cwd to resolve relative paths.
    * @param path     the path
    * @param options  The optional options argument can be a string specifying an encoding, or an object with
    *                 an encoding property specifying the character encoding to use for the path passed to the callback.
    * @param callback The callback gets two arguments (err, resolvedPath).
    *                 If the encoding is set to 'buffer',
    *                 the path returned will be passed as a Buffer object.
    * @example fs.realpath(path[, options], callback)
    */
  def realpath(path: Path, options: String | FileEncodingOptions, callback: FsCallback1[Output]): Unit =
    js.native

  /**
    * Asynchronous realpath(2). The callback gets two arguments (err, resolvedPath).
    * May use process.cwd to resolve relative paths.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the path passed to the callback. If the encoding is set to 'buffer',
    * the path returned will be passed as a Buffer object.
    * @example fs.realpath(path[, options], callback)
    */
  def realpath(path: Path, callback: FsCallback1[String]): Unit = js.native

  /**
    * Synchronous realpath(3).
    * Only paths that can be converted to UTF8 strings are supported.
    * The optional options argument can be a string specifying an encoding, or an object with an
    * encoding property specifying the character encoding to use for the returned value. If the
    * encoding is set to 'buffer', the path returned will be passed as a Buffer object.
    * @return the resolved path.
    * @example fs.realpathSync(path[, options])
    */
  def realpathSync(path: Path, options: FileEncodingOptions = js.native): Output = js.native
  def realpathSync(path: Path): String                                           = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  val realpath: RealpathObject = js.native

  /**
    * Asynchronous rename(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rename(oldPath, newPath, callback)
    */
  def rename(oldPath: Path, newPath: Path, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous rename(2).
    * @return undefined.
    * @example fs.renameSync(oldPath, newPath)
    */
  def renameSync(oldPath: Path, newPath: Path): Unit = js.native

  /**
    * Asynchronous rmdir(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rmdir(path, callback)
    */
  def rmdir(path: Path, callback: FsCallback0): Unit = js.native

  /**
    * Asynchronous rmdir(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rmdir(path, callback)
    */
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def rmdir(path: Path, options: RmdirOptions, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous rmdir(2rmdir).
    * @return undefined.
    * @example fs.rmdirSync(path)
    */
  def rmdirSync(path: Path): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def rmdirSync(path: Path, options: RmdirOptions): Unit = js.native

  /**
    * Asynchronous stat(2). The callback gets two arguments (err, stats) where stats is a [[fs.Stats]] object.
    * See the fs.Stats section for more information.
    * @example fs.stat(path, callback)
    */
  def stat(path: Path, callback: FsCallback1[Stats]): Stats = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def stat(path: Path, options: StatOptions, callback: FsCallback1[Stats]): Stats = js.native

  /**
    * Synchronous stat(2). Returns an instance of [[fs.Stats]].
    * @example fs.statSync(path)
    */
  def statSync(path: Path): Stats = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def statSync(path: Path, options: StatOptions): Stats = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: Path, path: Path, `type`: String, callback: FsCallback0): Unit =
    js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: Path, path: Path, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous symlink(2).
    * @return undefined.
    * @example fs.symlinkSync(target, path[, type])
    */
  def symlinkSync(target: Path, path: Path, `type`: String = js.native): Unit =
    js.native

  /**
    * Asynchronous truncate(2). No arguments other than a possible exception are given to the completion callback.
    * A file descriptor can also be passed as the first argument. In this case, fs.ftruncate() is called.
    * @param path     the path  <String> | <Buffer>
    * @param length   the length
    * @param callback the completion callback.
    * @example fs.truncate(path, length, callback)
    */
  def truncate(path: Path, length: Int, callback: FsCallback0): Unit = js.native
  def truncate(path: Path, callback: FsCallback0): Unit              = js.native

  /**
    * Synchronous truncate(2).
    * In this case, fs.ftruncateSync() is called.
    * @param path   the path or file descriptor - <String> | <Buffer> | <Integer>
    * @param length the length
    * @return undefined.
    * @example fs.truncateSync(path, length)
    */
  def truncateSync(path: Path, length: Int = js.native): Unit = js.native

  /**
    * Asynchronous unlink(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.unlink(path, callback)
    */
  def unlink(path: Path, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous unlink(2).
    * @return undefined.
    * @example fs.unlinkSync(path)
    */
  def unlinkSync(path: Path): Unit = js.native

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
  def unwatchFile(path: Path, listener: FsCallback0 = js.native): Unit = js.native

  /**
    * Change file timestamps of the file referenced by the supplied path.
    *
    * Note: the arguments atime and mtime of the following related functions does follow the below rules:
    *
    * If the value is a numberable string like '123456789', the value would get converted to corresponding number.
    * If the value is NaN or Infinity, the value would get converted to Date.now().
    * @example fs.utimes(path, atime, mtime, callback)
    */
  def utimes(path: Path, atime: Time, mtime: Time, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous version of fs.utimes().
    * @return undefined.
    * @example fs.utimesSync(path, atime, mtime)
    */
  def utimesSync(path: Path, atime: Time, mtime: Time): Unit = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory.
    * The returned object is a [[fs.FSWatcher]].
    *
    * The second argument is optional. If options is provided as a string, it specifies the encoding.
    * Otherwise options should be passed as an object.
    *
    * The listener callback gets two arguments (event, filename). event is either 'rename' or 'change', and filename
    * is the name of the file which triggered the event.
    * @param filename the filename (Buffer | String)
    * @param options  the [[FSWatcherOptions optional settings]]
    * @param listener the callback function
    * @return a [[FSWatcher]]
    * @example fs.watch(filename[, options][, listener])
    */
  def watch(filename: Path, options: FSWatcherOptions, listener: js.Function2[EventType, String, Any]): FSWatcher =
    js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory.
    * The returned object is a [[fs.FSWatcher]].
    *
    * The second argument is optional. If options is provided as a string, it specifies the encoding.
    * Otherwise options should be passed as an object.
    *
    * The listener callback gets two arguments (event, filename). event is either 'rename' or 'change', and filename
    * is the name of the file which triggered the event.
    * @param filename the filename (Buffer | String)
    * @param listener the listener callback gets two arguments (eventType, filename).
    *                 eventType is either 'rename' or 'change',
    *                 and filename is the name of the file which triggered the event.
    * @return a [[FSWatcher]]
    * @example fs.watch(filename[, options][, listener])
    */
  def watch(filename: Path, listener: js.Function2[EventType, String, Any]): FSWatcher = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory.
    * The returned object is a [[fs.FSWatcher]].
    *
    * The second argument is optional. If options is provided as a string, it specifies the encoding.
    * Otherwise options should be passed as an object.
    *
    * The listener callback gets two arguments (event, filename). event is either 'rename' or 'change', and filename
    * is the name of the file which triggered the event.
    * @param filename the filename (Buffer | String)
    * @param options  the [[FSWatcherOptions optional settings]]
    * @return a [[FSWatcher]]
    * @example fs.watch(filename[, options][, listener])
    */
  def watch(filename: Path, options: FSWatcherOptions = js.native): FSWatcher = js.native

  /**
    * Watch for changes on filename. The callback listener will be called each time the file is accessed.
    *
    * The options argument may be omitted. If provided, it should be an object. The options object may contain
    * a boolean named persistent that indicates whether the process should continue to run as long as files are
    * being watched. The options object may specify an interval property indicating how often the target should
    * be polled in milliseconds. The default is { persistent: true, interval: 5007 }.
    * @param filename the filename (Buffer | String)
    * @param options  the [[FSWatcherOptions optional settings]]
    * @param listener the callback
    */
  def watchFile(filename: Path, options: FileWatcherOptions, listener: js.Function2[Stats, Stats, Any]): Unit =
    js.native

  /**
    * Watch for changes on filename. The callback listener will be called each time the file is accessed.
    *
    * The options argument may be omitted. If provided, it should be an object. The options object may contain
    * a boolean named persistent that indicates whether the process should continue to run as long as files are
    * being watched. The options object may specify an interval property indicating how often the target should
    * be polled in milliseconds. The default is { persistent: true, interval: 5007 }.
    * @param filename the filename (Buffer | String)
    * @param listener the callback
    */
  def watchFile(filename: Path, listener: js.Function2[Stats, Stats, Any]): Unit = js.native

  /**
    * Write buffer to the file specified by fd.
    * <p><b>Note</b>: that it is unsafe to use fs.write multiple times on the same file without waiting for the callback.
    * For this scenario, fs.createWriteStream is strongly recommended.</p>
    * <p>On Linux, positional writes don't work when the file is opened in append mode. The kernel ignores the
    * position argument and always appends the data to the end of the file.</p>
    * @param fd       the file descriptor
    * @param buffer   the buffer containing the data to write
    * @param offset   determines the part of the buffer to be written, and length is an integer specifying
    *                 the number of bytes to write.
    * @param length   the optional length of the data to write
    * @param position refers to the offset from the beginning of the file where this data should be written.
    *                 If typeof position !== 'number', the data will be written at the current position. See pwrite(2).
    * @param callback will be given three arguments (err, written, buffer) where written specifies how many
    *                 bytes were written from buffer.
    * @example {{{ fs.write(fd, buffer[, offset[, length[, position]]], callback) }}}
    **/
  def write(fd: FileDescriptor,
            buffer: typedarray.Uint8Array,
            offset: Int | Null,
            length: Int | Null,
            position: Int | Null,
            callback: FsCallback2[Int, Buffer]): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def write(fd: FileDescriptor,
            buffer: BufferLike,
            offset: Int | Null,
            length: Int | Null,
            position: Int | Null,
            callback: FsCallback2[Int, Buffer]): Unit = js.native

  /**
    * Write string to the file specified by fd. If string is not a string, then the value will be coerced to one.
    * Unlike when writing buffer, the entire string must be written. No substring may be specified.
    * This is because the byte offset of the resulting data may not be the same as the string offset.
    * Note that it is unsafe to use fs.write multiple times on the same file without waiting for the callback.
    * For this scenario, fs.createWriteStream is strongly recommended.
    * On Linux, positional writes don't work when the file is opened in append mode. The kernel ignores the
    * position argument and always appends the data to the end of the file.
    * @param fd       the file descriptor
    * @param string   the data to write
    * @param position refers to the offset from the beginning of the file where this data should be written.
    *                 If typeof position !== 'number' the data will be written at the current position. See pwrite(2).
    * @param encoding is the expected string encoding.
    * @param callback will receive the arguments (err, written, string) where written specifies how many bytes
    *                 the passed string required to be written. Note that bytes written is not the same as
    *                 string characters. See Buffer.byteLength.
    * @example {{{ fs.write(fd, string[, position[, encoding]], callback) }}}
    */
  def write(fd: FileDescriptor,
            string: String,
            position: Int,
            encoding: String,
            callback: FsCallback2[Int, String]): Unit                                                    = js.native
  def write(fd: FileDescriptor, string: String, position: Int, callback: FsCallback2[Int, String]): Unit = js.native
  def write(fd: FileDescriptor, string: String, callback: FsCallback2[Int, String]): Unit                = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: typedarray.Uint8Array, options: FileWriteOptions, callback: FsCallback0): Unit =
    js.native
  def writeFile(file: String, data: typedarray.Uint8Array, callback: FsCallback0): Unit = js.native
  def writeFile(file: String, data: String, options: FileWriteOptions, callback: FsCallback0): Unit =
    js.native
  def writeFile(file: String, data: String, callback: FsCallback0): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def writeFile(file: String, data: BufferLike, options: FileWriteOptions, callback: FsCallback0): Unit =
    js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def writeFile(file: String, data: BufferLike, callback: FsCallback0): Unit = js.native

  /**
    * The synchronous version of fs.writeFile().
    * @return undefined.
    * @example fs.writeFileSync(file, data[, options])
    */
  def writeFileSync(file: Path | FileDescriptor,
                    data: typedarray.Uint8Array,
                    options: FileWriteOptions = js.native): Unit =
    js.native
  def writeFileSync(file: Path | FileDescriptor, data: String, options: FileWriteOptions): Unit =
    js.native
  def writeFileSync(file: Path | FileDescriptor, data: String): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def writeFileSync(file: Path | FileDescriptor, data: BufferLike, options: FileWriteOptions): Unit =
    js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def writeFileSync(file: Path | FileDescriptor, data: BufferLike): Unit = js.native

  /**
    * Write buffer to the file specified by fd.
    * @param fd       the given file descriptor
    * @param buffer   the given [[Buffer buffer]]
    * @param offset   determines the part of the buffer to be written, and length is an integer specifying
    *                 the number of bytes to write.
    * @param length   the optional length of the data to write
    * @param position refers to the offset from the beginning of the file where this data should be written.
    * @example {{{ fs.writeSync(fd, buffer[, offset[, length[, position]]]) }}}
    */
  def writeSync(fd: FileDescriptor,
                buffer: typedarray.Uint8Array,
                offset: Int,
                length: Int,
                position: Int = js.native): Unit =
    js.native
  def writeSync(fd: FileDescriptor, buffer: typedarray.Uint8Array, offset: Int): Unit                  = js.native
  def writeSync(fd: FileDescriptor, buffer: typedarray.Uint8Array): Unit                               = js.native
  def writeSync(fd: FileDescriptor, buffer: BufferLike, offset: Int, length: Int, position: Int): Unit = js.native
  def writeSync(fd: FileDescriptor, buffer: BufferLike, offset: Int, length: Int): Unit                = js.native
  def writeSync(fd: FileDescriptor, buffer: BufferLike, offset: Int): Unit                             = js.native
  def writeSync(fd: FileDescriptor, buffer: BufferLike): Unit                                          = js.native

  /**
    * Write string to the file specified by fd.
    * @param fd       the given file descriptor
    * @param data     the given string
    * @param position refers to the offset from the beginning of the file where this data should be written.
    * @param encoding is the expected string encoding.
    * @example {{{ fs.writeSync(fd, string[, position[, encoding]]) }}}
    */
  def writeSync(fd: FileDescriptor, data: String, position: Int, encoding: String): Unit = js.native
  def writeSync(fd: FileDescriptor, data: String, position: Int): Unit                   = js.native
  def writeSync(fd: FileDescriptor, data: String, encoding: String): Unit                = js.native
  def writeSync(fd: FileDescriptor, data: String): Unit                                  = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writev(fd: FileDescriptor,
             buffers: js.Array[typedarray.ArrayBufferView],
             position: Int,
             fsCallback2: FsCallback2[Int, js.Array[typedarray.ArrayBufferView]]): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writevSync(fd: FileDescriptor, buffers: js.Array[typedarray.ArrayBufferView], position: Int = js.native): Unit =
    js.native
}

/**
  * File System Singleton
  */
@js.native
@JSImport("fs", JSImport.Namespace)
object Fs extends Fs {

  @enableMembersIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  @js.native
  trait FsPromises extends js.Object {
    def access(path: Path, mode: FileMode): js.Promise[Unit] = js.native

    def appendFile(file: Path | FileDescriptor,
                   data: String | Buffer,
                   options: FileAppendOptions | String = js.native): js.Promise[Unit] = js.native

    def chmod(path: Path, mode: FileMode): js.Promise[Unit]                                = js.native
    def chown(path: Path, uid: UID, gid: GID): js.Promise[Unit]                            = js.native
    def copyFile(src: Path, target: Path, flag: Int): js.Promise[Unit]                     = js.native
    def lchmod(path: Path, mode: FileMode): js.Promise[Unit]                               = js.native
    def lchown(path: Path, uid: UID, gid: GID): js.Promise[Unit]                           = js.native
    def link(existingPath: Path, newPath: Path): js.Promise[Unit]                          = js.native
    def lstat(path: Path, options: StatOptions): js.Promise[Stats]                         = js.native
    def mkdir(path: Path, options: MkdirOptions = js.native): js.Promise[Unit]             = js.native
    def mkdir(path: Path, mode: FileMode): js.Promise[Unit]                                = js.native
    def mkdtemp(prefix: String, options: FileEncodingOptions): js.Promise[String]          = js.native
    def mkdtemp(prefix: String, encoding: String = js.native): js.Promise[String]          = js.native
    def open(path: Path, flags: Flags, mode: FileMode = js.native): js.Promise[FileHandle] = js.native
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    def open(path: Path): js.Promise[FileHandle]                                                             = js.native
    def readdir(path: Path, options: ReaddirOptions): js.Promise[js.Array[String] | js.Array[Dirent]]        = js.native
    def readdir(path: Path, options: String | FileEncodingOptions = js.native): js.Promise[js.Array[String]] = js.native
    def readlink(path: Path): js.Promise[String]                                                             = js.native
    def readlink(path: Path, options: String | FileEncodingOptions): js.Promise[Output]                      = js.native
    def rename(oldPath: Path, newPath: Path): js.Promise[Unit]                                               = js.native
    def rmdir(path: Path): js.Promise[Unit]                                                                  = js.native
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    def rmdir(path: Path, options: RmdirOptions): js.Promise[Unit]                      = js.native
    def stat(path: Path, options: StatOptions = js.native): js.Promise[Stats]           = js.native
    def symlink(target: Path, path: Path, `type`: String = js.native): js.Promise[Unit] = js.native
    def truncate(path: Path, length: Int = js.native): js.Promise[Unit]                 = js.native
    def unlink(path: Path): js.Promise[Unit]                                            = js.native
    def utimes(path: Path, atime: Time, mtime: Time): js.Promise[Unit]                  = js.native
    def writeFile(file: Path | FileHandle, data: String | BufferLike, options: FileWriteOptions): js.Promise[Unit] =
      js.native
  }

  @enableMembersIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  @js.native
  trait FileHandle extends js.Object {
    val fd: FileDescriptor = js.native

    def appendFile(data: String | Buffer, options: FileAppendOptions = js.native): js.Promise[Unit] = js.native
    def chmod(mode: FileMode): js.Promise[Unit]                                                     = js.native
    def chown(uid: UID, gid: GID): js.Promise[Unit]                                                 = js.native
    def close(): js.Promise[Unit]                                                                   = js.native
    def datasync(): js.Promise[Unit]                                                                = js.native
    def read[T <: js.typedarray.TypedArray[_, _]](buffer: T,
                                                  offset: Int | Null,
                                                  length: Int | Null,
                                                  position: Int | Null): js.Promise[BufferIOResult[T]] = js.native
    def readFile(): js.Promise[Buffer]                                                                 = js.native
    def readFile(encoding: String): js.Promise[String]                                                 = js.native
    def readFile(options: ReadFileOptions): js.Promise[Output]                                         = js.native
    def stat(): js.Promise[Stats]                                                                      = js.native
    def stat(options: StatOptions): js.Promise[Stats]                                                  = js.native
    def sync(): js.Promise[Unit]                                                                       = js.native
    def truncate(): js.Promise[Unit]                                                                   = js.native
    def truncate(length: Int): js.Promise[Unit]                                                        = js.native
    def utimes(atime: Time, mtime: Time): js.Promise[Unit]                                             = js.native
    def write[T <: js.typedarray.TypedArray[_, _]](buffer: T,
                                                   offset: Int | Null,
                                                   length: Int | Null,
                                                   position: Int | Null): js.Promise[BufferIOResult[T]] = js.native
    def write(buffer: js.typedarray.DataView,
              offset: Int | Null,
              length: Int | Null,
              position: Int | Null): js.Promise[BufferIOResult[js.typedarray.DataView]]                   = js.native
    def write(string: String, position: Int | Null, encoding: String): js.Promise[BufferIOResult[String]] = js.native
    def writeFile(data: String | BufferLike, options: FileWriteOptions): js.Promise[Unit]                 = js.native
    def writeFile(data: String | BufferLike): js.Promise[Unit]                                            = js.native
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    def writev(buffers: js.Array[js.typedarray.ArrayBufferView], position: Int | Null): js.Promise[Unit] = js.native
  }

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  val promises: FsPromises = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  @js.native
  class Dirent() extends js.Object {
    def isBlockDevice(): Boolean     = js.native
    def isCharacterDevice(): Boolean = js.native
    def isDirectory(): Boolean       = js.native
    def isFIFO(): Boolean            = js.native
    def isFile(): Boolean            = js.native
    def isSocket(): Boolean          = js.native
    def isSymbolicLink(): Boolean    = js.native
    val name: String | Buffer        = js.native
  }
}

@js.native
trait BufferIOResult[T] extends js.Object {
  val bytesRead: Int = js.native
  val buffer: T      = js.native
}

/**
  * File Append Options
  */
class FileAppendOptions(val encoding: js.UndefOr[String] = js.undefined,
                        val mode: js.UndefOr[FileMode] = js.undefined,
                        val flag: js.UndefOr[String] = js.undefined)
    extends js.Object

/**
  * File Encoding Options
  */
class FileEncodingOptions(val encoding: js.UndefOr[String] = js.undefined) extends js.Object

class ReaddirOptions(val encoding: js.UndefOr[String] = js.undefined,
                     val withFileTypes: js.UndefOr[Boolean] = js.undefined)
    extends js.Object

class ReadFileOptions(val encoding: js.UndefOr[String] = js.undefined, val flag: js.UndefOr[String] = js.undefined)
    extends js.Object

class FileInputOptions(val flags: js.UndefOr[String] = js.undefined,
                       val encoding: js.UndefOr[String] = js.undefined,
                       val fd: js.UndefOr[FileDescriptor] = js.undefined,
                       val mode: js.UndefOr[FileMode] = js.undefined,
                       val autoClose: js.UndefOr[Boolean] = js.undefined,
                       val emitClose: js.UndefOr[Boolean] = js.undefined,
                       val start: js.UndefOr[Int] = js.undefined,
                       val end: js.UndefOr[Int] = js.undefined,
                       val highWaterMark: js.UndefOr[Int] = js.undefined)
    extends js.Object

class FileOutputOptions(val flags: js.UndefOr[String] = js.undefined,
                        val defaultEncoding: js.UndefOr[String] = js.undefined,
                        val fd: js.UndefOr[FileDescriptor] = js.undefined,
                        val mode: js.UndefOr[FileMode] = js.undefined,
                        val autoClose: js.UndefOr[Boolean] = js.undefined,
                        val emitClose: js.UndefOr[Boolean] = js.undefined,
                        val start: js.UndefOr[Int] = js.undefined)
    extends js.Object

/**
  * File Watcher Options
  * @param persistent <Boolean>
  * @param interval   <Integer>
  */
class FileWatcherOptions(val persistent: js.UndefOr[Boolean] = js.undefined,
                         val interval: js.UndefOr[Int] = js.undefined)
    extends js.Object

class StatOptions(val bigint: js.UndefOr[Boolean] = js.undefined) extends js.Object

class MkdirOptions(val recursive: js.UndefOr[Boolean] = js.undefined, val mode: js.UndefOr[FileMode] = js.undefined)
    extends js.Object

class RmdirOptions(var emfileWait: js.UndefOr[Int] = 1000,
                   var maxBusyTries: js.UndefOr[Int] = 3,
                   var recursive: js.UndefOr[Boolean] = js.undefined)
    extends js.Object

@js.native
trait RealpathObject extends js.Object {
  def native(path: Path, options: FileEncodingOptions, callback: FsCallback1[Output]): Unit = js.native
  def native(path: Path, encoding: String, callback: FsCallback1[Output]): Unit             = js.native
  def native(path: Path, callback: FsCallback1[String]): Unit                               = js.native
}
