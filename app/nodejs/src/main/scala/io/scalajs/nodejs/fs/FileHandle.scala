package io.scalajs.nodejs.fs

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL
import io.scalajs.nodejs.{FileDescriptor, GID, UID}

import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

/**
  * A FileHandle object is a wrapper for a numeric file descriptor. Instances of FileHandle are distinct from numeric
  * file descriptors in that they provide an object oriented API for working with files.
  *
  * If a FileHandle is not closed using the filehandle.close() method, it might automatically close the file descriptor
  * and will emit a process warning, thereby helping to prevent memory leaks. Please do not rely on this behavior in
  * your code because it is unreliable and your file may not be closed. Instead, always explicitly close FileHandles.
  * Node.js may change this behavior in the future.
  *
  * Instances of the FileHandle object are created internally by the fsPromises.open() method.
  *
  * Unlike the callback-based API (fs.fstat(), fs.fchown(), fs.fchmod(), and so on), a numeric file descriptor is not
  * used by the promise-based API. Instead, the promise-based API uses the FileHandle class in order to help avoid
  * accidental leaking of unclosed file descriptors after a Promise is resolved or rejected.
  * @see [[https://nodejs.org/api/fs.html#fs_class_filehandle]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileHandle extends js.Object {

  /**
    * The numeric file descriptor managed by the FileHandle object.
    */
  def fd: FileDescriptor = js.native

  /**
    * Asynchronously append data to this file, creating the file if it does not yet exist. data can be a string
    * or a Buffer. The Promise will be resolved with no arguments upon success.
    * @param data    a [[String]] or [[Buffer]]
    * @param options the encoding or [[FileAppendOptions options]] object
    * @return a [[js.Promise promise]]
    */
  def appendFile(data: String | Buffer, options: String | FileAppendOptions | RawOptions): js.Promise[Unit] = js.native

  /**
    * Modifies the permissions on the file. The Promise is resolved with no arguments upon success.
    * @example filehandle.chmod(mode)
    * @param mode the mode
    * @return a [[js.Promise promise]]
    */
  def chmod(mode: Int): js.Promise[Unit] = js.native

  /**
    * Changes the ownership of the file then resolves the Promise with no arguments upon success.
    * @example chown(path, uid, gid)
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @param uid  the user ID
    * @param gid  the group ID
    * @return a [[js.Promise promise]]
    */
  def chown(path: String | Buffer | URL, uid: UID, gid: GID): js.Promise[Unit] = js.native

  /**
    * Closes the file descriptor.
    * @return A Promise that will be resolved once the underlying file descriptor is closed,
    *         or will be rejected if an error occurs while closing.
    */
  def close(): js.Promise[Unit] = js.native

  /**
    * Asynchronous fdatasync(2). The Promise is resolved with no arguments upon success.
    * @return a [[js.Promise promise]]
    */
  def datasync(): js.Promise[Unit] = js.native

  /**
    * Read data from the file.
    *
    * buffer is the buffer that the data will be written to.
    *
    * offset is the offset in the buffer to start writing at.
    *
    * length is an integer specifying the number of bytes to read.
    *
    * position is an argument specifying where to begin reading from in the file. If position is null, data will be
    * read from the current file position, and the file position will be updated. If position is an integer, the file
    * position will remain unchanged.
    *
    * Following successful read, the Promise is resolved with an object with a bytesRead property specifying the
    * number of bytes read, and a buffer property that is a reference to the passed in buffer argument.
    * @example read(buffer, offset, length, position)#
    * @param buffer   the buffer
    * @param offset   the offset
    * @param length   the length
    * @param position the position
    * @return a [[js.Promise promise]]
    */
  def read(buffer: Buffer | Uint8Array, offset: Int, length: Int, position: Int): js.Promise[Int] = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    *
    * The Promise is resolved with the contents of the file. If no encoding is specified (using options.encoding),
    * the data is returned as a Buffer object. Otherwise, the data will be a string.
    *
    * If options is a string, then it specifies the encoding.
    *
    * When the path is a directory, the behavior of fsPromises.readFile() is platform-specific. On macOS, Linux,
    * and Windows, the promise will be rejected with an error. On FreeBSD, a representation of the directory's contents
    * will be returned.
    *
    * The FileHandle has to support reading.
    *
    * If one or more filehandle.read() calls are made on a file handle and then a filehandle.readFile() call is made,
    * the data will be read from the current position till the end of the file. It doesn't always read from the
    * beginning of the file.
    * @example readFile(options)
    * @param options the [[FileEncodingOptions options]]
    * @return a [[js.Promise promise]]
    */
  def readFile(options: FileEncodingOptions | RawOptions): js.Promise[String] = js.native

  /**
    * Retrieves the fs.Stats for the file.
    * @example stat(path[, options])
    * @param options the [[FileStatOptions options]]
    * @return a [[js.Promise promise]]
    */
  def stat(options: FileStatOptions | RawOptions = js.native): js.Promise[Stats] = js.native

  /**
    * Asynchronous fsync(2). The Promise is resolved with no arguments upon success.
    * @return a [[js.Promise promise]]
    */
  def sync(): js.Promise[Unit] = js.native

  /**
    * Truncates the file then resolves the Promise with no arguments upon success.
    *
    * If the file was larger than len bytes, only the first len bytes will be retained in the file.
    * @example truncate(len)
    * @param len the length. Default: 0
    * @return a [[js.Promise promise]]
    */
  def truncate(len: Int = js.native): js.Promise[Unit] = js.native

  /**
    * Change the file system timestamps of the object referenced by the FileHandle then resolves the Promise with
    * no arguments upon success.
    *
    * This function does not work on AIX versions before 7.1, it will resolve the Promise with an error using code UV_ENOSYS.
    * @example utimes(atime, mtime)
    * @param atime the accessed time
    * @param mtime the modified time
    * @return a [[js.Promise promise]]
    */
  def utimes(atime: Double | String | js.Date, mtime: Double | String | js.Date): js.Promise[Unit] = js.native

  /**
    * Write buffer to the file.
    *
    * The Promise is resolved with an object containing a bytesWritten property identifying the number of bytes written,
    * and a buffer property containing a reference to the buffer written.
    *
    * offset determines the part of the buffer to be written, and length is an integer specifying the number of bytes to write.
    *
    * position refers to the offset from the beginning of the file where this data should be written.
    * If typeof position !== 'number', the data will be written at the current position. See pwrite(2).
    *
    * It is unsafe to use [[FileHandle.write()]] multiple times on the same file without waiting for the Promise
    * to be resolved (or rejected). For this scenario, use [[Fs.createWriteStream()]].
    *
    * On Linux, positional writes do not work when the file is opened in append mode. The kernel ignores the position
    * argument and always appends the data to the end of the file.
    * @example write(buffer, offset, length, position)
    * @param buffer   the buffer to write
    * @param offset   the offset
    * @param length   the length
    * @param position the position
    * @return a [[js.Promise promise]]
    */
  def write(buffer: Buffer | Uint8Array, offset: Int, length: Int, position: Int): js.Promise[Int] = js.native

  /**
    * Write string to the file. If string is not a string, then the value will be coerced to one.
    *
    * The Promise is resolved with an object containing a bytesWritten property identifying the number of bytes written,
    * and a buffer property containing a reference to the string written.
    *
    * position refers to the offset from the beginning of the file where this data should be written. If the type of
    * position is not a number the data will be written at the current position. See pwrite(2).
    *
    * encoding is the expected string encoding.
    *
    * It is unsafe to use filehandle.write() multiple times on the same file without waiting for the Promise to be
    * resolved (or rejected). For this scenario, use fs.createWriteStream().
    *
    * On Linux, positional writes do not work when the file is opened in append mode. The kernel ignores the position
    * argument and always appends the data to the end of the file.
    * @example {{{ filehandle.write(string[, position[, encoding]]) }}}
    * @param data     the data
    * @param position the position
    * @param encoding Default: 'utf8'
    * @return a [[js.Promise promise]]
    */
  def write(data: String, position: Int = js.native, encoding: String = js.native): js.Promise[Unit] = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The Promise will be resolved with no arguments upon success.
    *
    * The encoding option is ignored if data is a buffer.
    *
    * If options is a string, then it specifies the encoding.
    *
    * The FileHandle has to support writing.
    *
    * It is unsafe to use filehandle.writeFile() multiple times on the same file without waiting for the Promise to be
    * resolved (or rejected).
    *
    * If one or more filehandle.write() calls are made on a file handle and then a filehandle.writeFile() call is made,
    * the data will be written from the current position till the end of the file. It doesn't always write from the
    * beginning of the file.
    * @example filehandle.writeFile(data, options)
    * @param data    <string> | <Buffer> | <Uint8Array>
    * @param options the [[FileOutputOptions options]]
    * @return a [[js.Promise promise]]
    */
  def writeFile(data: String | Buffer | Uint8Array, options: FileOutputOptions | RawOptions): js.Promise[Unit] = js.native

}
