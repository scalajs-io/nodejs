package io.scalajs.nodejs
package fs

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}
import scala.scalajs.js.typedarray.Uint8Array
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
    * @param path     the path (Buffer | String)
    * @param mode     the optional mode
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: Buffer | String, mode: FileMode, callback: FsCallback0): Unit = js.native

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
    * @param path     the path (Buffer | String)
    * @param callback is a callback function that is invoked with a possible error argument. If any of the accessibility
    *                 checks fail, the error argument will be populated.
    * @example fs.access(path[, mode], callback)
    */
  def access(path: Buffer | String, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous version of fs.access(). This throws if any accessibility checks fail, and does nothing otherwise.
    * @param path the path (Buffer | String)
    * @param mode the optional mode
    * @example fs.accessSync(path[, mode])
    */
  def accessSync(path: Buffer | String, mode: FileMode = js.native): Unit = js.native

  /**
    * Asynchronously append data to a file, creating the file if it does not yet exist. data can be a string or a buffer.
    * @param file     the filename or file descriptor (Buffer | String | Number)
    * @param data     the data to append (Buffer | String)
    * @param options  the [[FileAppendOptions optional append settings]]
    * @param callback the callback function
    * @example fs.appendFile(file, data[, options], callback)
    */
  def appendFile(file: Buffer | FileDescriptor | String,
                 data: Buffer | String,
                 options: FileAppendOptions | RawOptions,
                 callback: FsCallback0): Unit = js.native

  /**
    * Asynchronously append data to a file, creating the file if it does not yet exist. data can be a string or a buffer.
    * @param file     the filename or file descriptor (Buffer | String | Number)
    * @param data     the data to append (Buffer | String)
    * @param callback the callback function
    * @example fs.appendFile(file, data[, options], callback)
    */
  def appendFile(file: Buffer | FileDescriptor | String,
                 data: Buffer | String,
                 callback: FsCallback0): Unit = js.native

  /**
    * The synchronous version of fs.appendFile().
    * @param file    the filename or file descriptor (Buffer | String | Number)
    * @param data    the data to append (Buffer | String)
    * @param options the [[FileAppendOptions optional append settings]]
    * @return undefined.
    */
  def appendFileSync(file: Buffer | FileDescriptor | String,
                     data: Buffer | String,
                     options: FileAppendOptions | RawOptions = js.native): Unit = js.native

  /**
    * Asynchronous chmod(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the file or directory path (Buffer | String)
    * @param mode     the file or directory mode
    * @param callback the completion callback.
    */
  def chmod(path: Buffer | String, mode: FileMode, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous chmod(2).
    * @param path the file or directory path (Buffer | String)
    * @param mode the file or directory mode
    * @return undefined.
    */
  def chmodSync(path: Buffer | String, mode: FileMode): Unit = js.native

  /**
    * Asynchronous chown(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the file or directory path (Buffer | String)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    */
  def chown(path: Buffer | String, uid: UID, gid: GID, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous chown(2).
    * @param path the file or directory path (Buffer | String)
    * @param uid  the user ID
    * @param gid  the group ID
    * @return undefined.
    */
  def chownSync(path: Buffer | String, uid: UID, gid: GID): Unit = js.native

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
    * Returns a new ReadStream object. (See Readable Stream). Be aware that, unlike the default value
    * set for highWaterMark on a readable stream (16 kb), the stream returned by this method has a
    * default value of 64 kb for the same parameter.
    * @param path    the path (Buffer | String)
    * @param options the optional stream options
    * @example fs.createReadStream(path[, options])
    */
  def createReadStream(path: Buffer | String, options: FileInputOptions | RawOptions = js.native): ReadStream = js.native

  /**
    * Returns a new WriteStream object.
    * @param path    the path (Buffer | String)
    * @param options the optional stream options
    * @example fs.createWriteStream(path[, options])
    */
  def createWriteStream(path: Buffer | String, options: FileOutputOptions | RawOptions = js.native): WriteStream = js.native

  /**
    * Test whether or not the given path exists by checking with the file system. Then call the callback argument with
    * either true or false.
    * @example fs.exists('/etc/passwd', (exists) => { ... })
    */
  @deprecated("Use fs.stat() or fs.access() instead.", since = "1.0.0")
  def exists(path: String, callback: js.Function1[Boolean, Any]): Unit = js.native

  /**
    * fs.exists() should not be used to check if a file exists before calling fs.open(). Doing so introduces a race
    * condition since other processes may change the file's state between the two calls. Instead, user code should
    * call fs.open() directly and handle the error raised if the file is non-existent.
    * @example fs.existsSync(path)
    */
  def existsSync(path: String): Boolean = js.native

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
    * @param path     the file or directory path (Buffer | String)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    */
  def fchown(path: Buffer | String, uid: UID, gid: GID, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous fchown(2).
    * @param path the file or directory path (Buffer | String)
    * @param uid  the user ID
    * @param gid  the group ID
    * @return undefined.
    *
    */
  def fchownSync(path: Buffer | String, uid: UID, gid: GID): Unit = js.native

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
  def fstat(fd: FileDescriptor, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous fstat(2). Returns an instance of fs.Stats.
    * @param fd the file descriptor
    */
  def fstatSync(fd: FileDescriptor): Unit = js.native

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
    * If the file referred to by the file descriptor was larger than len bytes, only the first len bytes will be
    * retained in the file.
    * @param fd       the file descriptor
    * @param len      the desired length
    * @param callback the completion callback.
    */
  def ftruncate(fd: FileDescriptor, len: Double, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous ftruncate(2).
    * @param fd  the file descriptor
    * @param len the desired length
    * @return undefined.
    */
  def ftruncateSync(fd: FileDescriptor, len: Double): Unit = js.native

  /**
    * Change the file timestamps of a file referenced by the supplied file descriptor.
    * @example fs.futimes(fd, atime, mtime, callback)
    */
  def futimes(fd: FileDescriptor, atime: Integer, mtime: Integer, callback: js.Function): Unit = js.native

  /**
    * Synchronous version of fs.futimes().
    * @return undefined.
    * @example fs.futimesSync(fd, atime, mtime)
    */
  def futimesSync(fd: FileDescriptor, atime: Integer, mtime: Integer): Unit = js.native

  /**
    * Asynchronous lchmod(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.lchmod(path, mode, callback)
    */
  def lchmod(path: Buffer | String, mode: FileMode, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous lchmod(2).
    * @param path the path (Buffer | String)
    * @param mode the mode (Integer)
    * @return undefined.
    * @example fs.lchmodSync(path, mode)
    */
  def lchmodSync(path: Buffer | String, mode: FileMode): Unit = js.native

  /**
    * Asynchronous lchown(2). No arguments other than a possible exception are given to the completion callback.
    * @param path     the path (Buffer | String)
    * @param uid      the user ID
    * @param gid      the group ID
    * @param callback the completion callback.
    * @example fs.lchown(path, uid, gid, callback)
    */
  def lchown(path: Buffer | String, uid: UID, gid: GID, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous chown(2).
    * @param path the path (Buffer | String)
    * @param uid  the user ID
    * @param gid  the group ID
    * @return undefined.
    */
  def lchownSync(path: Buffer | String, uid: UID, gid: GID): Unit = js.native

  /**
    * Asynchronous link(2). No arguments other than a possible exception are given to the completion callback.
    * @param existingPath the existing path
    * @param newPath      the new path
    * @param callback     the completion callback.
    * @example fs.link(srcpath, dstpath, callback)
    */
  def link(existingPath: Buffer | String, newPath: Buffer | String, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous link(2).
    * @param existingPath the existing path
    * @param newPath      the new path
    * @return undefined.
    */
  def linkSync(existingPath: Buffer | String, newPath: Buffer | String): Unit = js.native

  /**
    * Asynchronous lstat(2).
    * lstat() is identical to stat(), except that if path is a symbolic link, then the link itself is stat-ed,
    * not the file that it refers to.
    * @param path     the path (Buffer | String)
    * @param callback The callback gets two arguments (err, stats) where stats is a fs.Stats object.
    */
  def lstat(path: Buffer | String, callback: FsCallback1[Stats]): Unit = js.native

  /**
    * Synchronous lstat(2).
    * @param path the path (Buffer | String)
    * @return an instance of fs.Stats.
    */
  def lstatSync(path: Buffer | String): Stats = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback.
    * mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: Buffer | String, mode: FileMode | js.Any, callback: FsCallback0): Unit = js.native

  /**
    * Asynchronous mkdir(2). No arguments other than a possible exception are given to the completion callback.
    * mode defaults to 0o777.
    * @example fs.mkdir(path[, mode], callback)
    */
  def mkdir(path: Buffer | String, callback: FsCallback0): Unit = js.native

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
  def mkdtemp(prefix: String,
              options: String | FileEncodingOptions | RawOptions,
              callback: FsCallback1[String]): Unit = js.native

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
  def mkdtempSync(prefix: String,
                  options: String | FileEncodingOptions | RawOptions = js.native): String = js.native

  /**
    * Synchronous mkdir(2).
    * @param path the path
    * @param mode the mode
    */
  def mkdirSync(path: Buffer | String, mode: FileMode = js.native): Unit = js.native

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
  def open(path: Buffer | String, flags: Flags, mode: FileMode, callback: FsCallback1[FileDescriptor]): Unit = js.native

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
  def open(path: Buffer | String, flags: Flags, callback: FsCallback1[FileDescriptor]): Unit = js.native

  /**
    * Synchronous version of fs.open().
    * @param path  the path (Buffer | String)
    * @param flags the flags
    * @param mode  the file mode
    * @return an integer representing the file descriptor.
    * @example fs.openSync(path, flags[, mode])
    */
  def openSync(path: Buffer | String, flags: Flags, mode: FileMode = js.native): FileDescriptor = js.native

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
           offset: Int,
           length: Int,
           position: Int,
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
  def readSync(fd: FileDescriptor, buffer: Buffer, offset: Int, length: Int, position: Int): Buffer = js.native

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
  def readdir(path: Buffer | String,
              options: String | FileEncodingOptions | RawOptions,
              callback: FsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Asynchronous readdir(3). Reads the contents of a directory.
    * @param path     the path (Buffer | String)
    * @param callback the callback gets two arguments (err, files) where files is an array
    *                 of the names of the files in the directory excluding '.' and '..'.
    * @example fs.readdir(path[, options], callback)
    */
  def readdir(path: Buffer | String, callback: FsCallback1[js.Array[String]]): Unit = js.native

  /**
    * Synchronous readdir(3).
    * @param path    the path (Buffer | String)
    * @param options the optional options argument can be a string specifying an encoding,
    *                or an object with an encoding property specifying the character encoding
    *                to use for the filenames passed to the callback. If the encoding is set
    *                to 'buffer', the filenames returned will be passed as Buffer objects.
    * @return an array of filenames excluding '.' and '..'.
    */
  def readdirSync(path: Buffer | String,
                  options: String | FileEncodingOptions | RawOptions = js.native): js.Array[String] = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @param file     filename or file descriptor
    * @param options  the optional settings
    * @param callback The callback is passed two arguments (err, data), where data is the contents of the file.
    *                 If no encoding is specified, then the raw buffer is returned.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: String,
               options: String | FileInputOptions | RawOptions | String,
               callback: FsCallback1[js.Any]): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @param file     filename or file descriptor
    * @param encoding the encoding (default = null)
    * @param callback The callback is passed two arguments (err, data), where data is the contents of the file.
    *                 If no encoding is specified, then the raw buffer is returned.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: Buffer | FileDescriptor | String,
               encoding: String,
               callback: FsCallback1[String]): Unit = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    * @param file     filename or file descriptor
    * @param callback The callback is passed two arguments (err, data), where data is the contents of the file.
    *                 If no encoding is specified, then the raw buffer is returned.
    * @example fs.readFile(file[, options], callback)
    */
  def readFile(file: Buffer | FileDescriptor | String, callback: FsCallback1[Buffer]): Unit = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * @param file     filename or file descriptor <String> | <Buffer> | <Integer>
    * @param encoding the optional encoding <Object> | <String>
    * @return the contents of the file. If the encoding option is specified then this function returns a string.
    *         Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: Buffer | FileDescriptor | String, encoding: String): String = js.native

  /**
    * Synchronous version of fs.readFile. Returns the contents of the file.
    * @param file    filename or file descriptor <String> | <Buffer> | <Integer>
    * @param options the optional encoding <Object> | <String>
    * @return the contents of the file. If the encoding option is specified then this function returns a string.
    *         Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: Buffer | FileDescriptor | String, options: FileInputOptions | RawOptions = js.native): js.Any = js.native

  /**
    * Synchronous version of fs.readFile.
    * @param file filename or file descriptor <String> | <Buffer> | <Integer>
    * @return the contents of the file. If the encoding option is specified then this function returns a string.
    *         Otherwise it returns a buffer.
    * @example fs.readFileSync(file[, options])
    */
  def readFileSync(file: Buffer | FileDescriptor | String): Buffer = js.native

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
  def readlink(path: Buffer | String,
               options: String | FileEncodingOptions | RawOptions,
               callback: js.Function2[FileIOError, String, Any]): Unit = js.native

  /**
    * Synchronous readlink(2).
    * @param path    the path (Buffer | String)
    * @param options the optional options argument can be a string specifying an encoding,
    *                or an object with an encoding property specifying the character encoding
    *                to use for the link path passed to the callback. If the encoding is set
    *                to 'buffer', the link path returned will be passed as a Buffer object.
    * @return the symbolic link's string value.
    */
  def readlinkSync(path: Buffer | String,
                   options: String | FileEncodingOptions | RawOptions = js.native): String = js.native

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
  def realpath(path: Buffer | String,
               options: FileEncodingOptions | String | RawOptions,
               callback: FsCallback1[String]): Unit = js.native

  /**
    * Asynchronous realpath(2). The callback gets two arguments (err, resolvedPath).
    * May use process.cwd to resolve relative paths.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the path passed to the callback. If the encoding is set to 'buffer',
    * the path returned will be passed as a Buffer object.
    * @example fs.realpath(path[, options], callback)
    */
  def realpath(path: Buffer | String, callback: FsCallback1[String]): Unit = js.native

  /**
    * Synchronous realpath(3).
    * Only paths that can be converted to UTF8 strings are supported.
    * The optional options argument can be a string specifying an encoding, or an object with an
    * encoding property specifying the character encoding to use for the returned value. If the
    * encoding is set to 'buffer', the path returned will be passed as a Buffer object.
    * @return the resolved path.
    * @example fs.realpathSync(path[, options])
    */
  def realpathSync(path: Buffer | String,
                   options: FileEncodingOptions | String | RawOptions = js.native): String = js.native

  /**
    * Asynchronous rename(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rename(oldPath, newPath, callback)
    */
  def rename(oldPath: String, newPath: String, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous rename(2).
    * @return undefined.
    * @example fs.renameSync(oldPath, newPath)
    */
  def renameSync(oldPath: String, newPath: String): Unit = js.native

  /**
    * Asynchronous rmdir(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.rmdir(path, callback)
    */
  def rmdir(path: Buffer | String, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous rmdir(2).
    * @return undefined.
    * @example fs.rmdirSync(path)
    */
  def rmdirSync(path: Buffer | String): Unit = js.native

  /**
    * Asynchronous stat(2). The callback gets two arguments (err, stats) where stats is a fs.[[Stats]] object.
    * See the fs.Stats section for more information.
    * @example fs.stat(path, callback)
    */
  def stat(path: Buffer | String, callback: FsCallback1[Stats]): Stats = js.native

  /**
    * Synchronous stat(2). Returns an instance of fs.[[Stats]].
    * @example fs.statSync(path)
    */
  def statSync(path: Buffer | String): Stats = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: Buffer | String,
              path: Buffer | String,
              `type`: String,
              callback: FsCallback0): Unit = js.native

  /**
    * Asynchronous symlink(2). No arguments other than a possible exception are given to the completion callback.
    * The type argument can be set to 'dir', 'file', or 'junction' (default is 'file') and is only available on Windows
    * (ignored on other platforms). Note that Windows junction points require the destination path to be absolute.
    * When using 'junction', the target argument will automatically be normalized to absolute path.
    * @example fs.symlink(target, path[, type], callback)
    */
  def symlink(target: Buffer | String,
              path: Buffer | String,
              callback: FsCallback0): Unit = js.native

  /**
    * Synchronous symlink(2).
    * @return undefined.
    * @example fs.symlinkSync(target, path[, type])
    */
  def symlinkSync(target: Buffer | String, path: Buffer | String, `type`: String = js.native): Unit = js.native

  /**
    * Asynchronous truncate(2). No arguments other than a possible exception are given to the completion callback.
    * A file descriptor can also be passed as the first argument. In this case, fs.ftruncate() is called.
    * @param path     the path  <String> | <Buffer>
    * @param length   the length
    * @param callback the completion callback.
    * @example fs.truncate(path, len, callback)
    */
  def truncate(path: Buffer | FileDescriptor | String, length: Int, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous truncate(2).
    * In this case, fs.ftruncateSync() is called.
    * @param path   the path or file descriptor - <String> | <Buffer> | <Integer>
    * @param length the length
    * @return undefined.
    * @example fs.truncateSync(path, len)
    */
  def truncateSync(path: Buffer | FileDescriptor | String, length: Int): Unit = js.native

  /**
    * Asynchronous unlink(2). No arguments other than a possible exception are given to the completion callback.
    * @example fs.unlink(path, callback)
    */
  def unlink(path: Buffer | String, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous unlink(2). 
    * @return undefined.
    * @example fs.unlinkSync(path)
    */
  def unlinkSync(path: Buffer | String): Unit = js.native

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
  def unwatchFile(filename: Buffer | String, listener: FsCallback0 = js.native): Unit = js.native

  /**
    * Change file timestamps of the file referenced by the supplied path.
    *
    * Note: the arguments atime and mtime of the following related functions does follow the below rules:
    *
    * If the value is a numberable string like '123456789', the value would get converted to corresponding number.
    * If the value is NaN or Infinity, the value would get converted to Date.now().
    * @example fs.utimes(path, atime, mtime, callback)
    */
  def utimes(path: Buffer | String, atime: Int, mtime: Int, callback: FsCallback0): Unit = js.native

  /**
    * Synchronous version of fs.utimes().
    * @return undefined.
    * @example fs.utimesSync(path, atime, mtime)
    */
  def utimesSync(path: Buffer | String, atime: Int, mtime: Int): Unit = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory.
    * The returned object is a fs.[[FSWatcher]].
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
  def watch(filename: Buffer | String,
            options: FSWatcherOptions | RawOptions,
            listener: js.Function2[EventType, String, Any]): FSWatcher = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory.
    * The returned object is a fs.[[FSWatcher]].
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
  def watch(filename: Buffer | String, listener: js.Function2[EventType, String, Any]): FSWatcher = js.native

  /**
    * Watch for changes on filename, where filename is either a file or a directory.
    * The returned object is a fs.[[FSWatcher]].
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
  def watch(filename: Buffer | String,
            options: FSWatcherOptions | RawOptions = js.native): FSWatcher = js.native

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
  def watchFile(filename: Buffer | String,
                options: FileWatcherOptions | RawOptions,
                listener: FsCallback2[Stats, Stats]): Unit = js.native

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
  def watchFile(filename: Buffer | String, listener: FsCallback2[Stats, Stats]): Unit = js.native

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
            buffer: Buffer | Uint8Array,
            offset: Int = js.native,
            length: Int = js.native,
            position: Int = js.native,
            callback: FsCallback2[Int, Buffer]): Unit = js.native

  /**
    * Write buffer to the file specified by fd.
    * <p><b>Note</b>: that it is unsafe to use fs.write multiple times on the same file without waiting for the callback.
    * For this scenario, fs.createWriteStream is strongly recommended.</p>
    * <p>On Linux, positional writes don't work when the file is opened in append mode. The kernel ignores the
    * position argument and always appends the data to the end of the file.</p>
    * @param fd       the file descriptor
    * @param buffer   the buffer containing the data to write
    *                 If typeof position !== 'number', the data will be written at the current position. See pwrite(2).
    * @param callback will be given three arguments (err, written, buffer) where written specifies how many
    *                 bytes were written from buffer.
    * @example {{{ fs.write(fd, buffer[, offset[, length[, position]]], callback) }}}
    **/
  def write(fd: FileDescriptor,
            buffer: Buffer | Uint8Array,
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
  def write(fd: FileDescriptor, string: String, position: Int, encoding: String, callback: FsCallback2[Int, String]): Unit = js.native

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
    * @param encoding is the expected string encoding.
    * @param callback will receive the arguments (err, written, string) where written specifies how many bytes
    *                 the passed string required to be written. Note that bytes written is not the same as
    *                 string characters. See Buffer.byteLength.
    * @example {{{ fs.write(fd, string[, position[, encoding]], callback) }}}
    */
  def write(fd: FileDescriptor, string: String, encoding: String, callback: FsCallback2[Int, String]): Unit = js.native

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
    * @param callback will receive the arguments (err, written, string) where written specifies how many bytes
    *                 the passed string required to be written. Note that bytes written is not the same as
    *                 string characters. See Buffer.byteLength.
    * @example {{{ fs.write(fd, string[, position[, encoding]], callback) }}}
    */
  def write(fd: FileDescriptor, string: String, callback: FsCallback2[Int, String]): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String,
                data: Buffer | String,
                options: FileOutputOptions | RawOptions,
                callback: FsCallback0): Unit = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The encoding option is ignored if data is a buffer. It defaults to 'utf8'
    * @example fs.writeFile(file, data[, options], callback)
    */
  def writeFile(file: String, data: Buffer | String, callback: FsCallback0): Unit = js.native

  /**
    * The synchronous version of fs.writeFile().
    * @return undefined.
    * @example fs.writeFileSync(file, data[, options])
    */
  def writeFileSync(file: String, data: Buffer | String, options: FileOutputOptions | RawOptions = js.native): Unit = js.native

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
  def writeSync(fd: FileDescriptor, buffer: Buffer | Uint8Array, offset: Int = js.native, length: Int = js.native, position: Int = js.native): Unit = js.native

  /**
    * Write buffer to the file specified by fd.
    * @param fd     the given file descriptor
    * @param buffer the given [[Buffer buffer]]
    * @example {{{ fs.writeSync(fd, buffer[, offset[, length[, position]]]) }}}
    */
  def writeSync(fd: FileDescriptor, buffer: Buffer | Uint8Array): Unit = js.native

  /**
    * Write string to the file specified by fd.
    * @param fd       the given file descriptor
    * @param data     the given string
    * @param position refers to the offset from the beginning of the file where this data should be written.
    * @param encoding is the expected string encoding.
    * @example {{{ fs.writeSync(fd, string[, position[, encoding]]) }}}
    */
  def writeSync(fd: FileDescriptor, data: String, position: Int, encoding: String): Unit = js.native

  /**
    * Write string to the file specified by fd.
    * @param fd       the given file descriptor
    * @param data     the given string
    * @param position refers to the offset from the beginning of the file where this data should be written.
    * @example {{{ fs.writeSync(fd, string[, position[, encoding]]) }}}
    */
  def writeSync(fd: FileDescriptor, data: String, position: Int): Unit = js.native

  /**
    * Write string to the file specified by fd.
    * @param fd       the given file descriptor
    * @param data     the given string
    * @param encoding is the expected string encoding.
    * @example {{{ fs.writeSync(fd, string[, position[, encoding]]) }}}
    */
  def writeSync(fd: FileDescriptor, data: String, encoding: String): Unit = js.native

  /**
    * Write string to the file specified by fd.
    * @param fd   the given file descriptor
    * @param data the given string
    * @example {{{ fs.writeSync(fd, string[, position[, encoding]]) }}}
    */
  def writeSync(fd: FileDescriptor, data: String): Unit = js.native

}

/**
  * File System Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("fs", JSImport.Namespace)
object Fs extends Fs

/**
  * File Append Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileAppendOptions(val encoding: js.UndefOr[String] = js.undefined,
                        val mode: js.UndefOr[FileMode] = js.undefined,
                        val flag: js.UndefOr[String] = js.undefined)
  extends js.Object

/**
  * File Encoding Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileEncodingOptions(val encoding: js.UndefOr[String] = js.undefined)
  extends js.Object

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileInputOptions(val flags: js.UndefOr[String] = js.undefined,
                       val encoding: js.UndefOr[String] = js.undefined,
                       val fd: js.UndefOr[FileDescriptor] = js.undefined,
                       val mode: js.UndefOr[Int] = js.undefined,
                       val autoClose: js.UndefOr[Boolean] = js.undefined,
                       val start: js.UndefOr[Int] = js.undefined,
                       val end: js.UndefOr[Int] = js.undefined)
  extends js.Object

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileOutputOptions(val flags: js.UndefOr[String] = js.undefined,
                        val defaultEncoding: js.UndefOr[String] = js.undefined,
                        val fd: js.UndefOr[FileDescriptor] = js.undefined,
                        val mode: js.UndefOr[Int] = js.undefined,
                        val autoClose: js.UndefOr[Boolean] = js.undefined,
                        val start: js.UndefOr[Int] = js.undefined)
  extends js.Object

/**
  * File Watcher Options
  * @param persistent <Boolean>
  * @param interval   <Integer>
  */
@ScalaJSDefined
class FileWatcherOptions(val persistent: js.UndefOr[Boolean] = js.undefined,
                         val interval: js.UndefOr[Int] = js.undefined)
  extends js.Object
