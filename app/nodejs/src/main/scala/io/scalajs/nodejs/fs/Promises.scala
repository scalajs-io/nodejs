package io.scalajs.nodejs.fs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL
import io.scalajs.nodejs.{GID, UID}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * fs.Promises API
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Promises extends js.Object {

  /**
    * Tests a user's permissions for the file or directory specified by path. The mode argument is an optional integer
    * that specifies the accessibility checks to be performed. Check File Access Constants for possible values of mode.
    * It is possible to create a mask consisting of the bitwise OR of two or more values
    * (e.g. [[FSConstants.W_OK]] or [[FSConstants.R_OK]]).
    *
    * If the accessibility check is successful, the Promise is resolved with no value. If any of the accessibility
    * checks fail, the Promise is rejected with an Error object. The following example checks if the file /etc/passwd
    * can be read and written by the current process.
    * @example access(path[, mode])
    * @param path filename or [[URL]]
    * @param mode Default: [[FSConstants.F_OK]]
    * @return a [[js.Promise promise]]
    */
  def access(path: String | Buffer | URL, mode: Int = js.native): js.Promise[Unit] = js.native

  /**
    * Asynchronously append data to a file, creating the file if it does not yet exist. data can be a string or a Buffer.
    * The Promise will be resolved with no arguments upon success.
    *
    * If options is a string, then it specifies the encoding.
    *
    * The path may be specified as a FileHandle that has been opened for appending (using open()).
    * @example appendFile(path, data[, options])
    * @param path    filename, [[URL]] or [[FileHandle]]
    * @param data    the data to append
    * @param options the [[FileAppendOptions options]]
    * @return a [[js.Promise promise]]
    */
  def appendFile(path: String | Buffer | URL | FileHandle,
                 data: String | Buffer,
                 options: FileAppendOptions = js.native): js.Promise[Unit] = js.native

  /**
    * Changes the permissions of a file then resolves the Promise with no arguments upon succces.
    * @example chmod(path, mode)
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @param mode the file mode (e.g. 0666)
    * @return a [[js.Promise promise]]
    */
  def chmod(path: String | Buffer | URL, mode: Int): js.Promise[Unit] = js.native

  /**
    * Changes the ownership of a file then resolves the Promise with no arguments upon success.
    * @example chown(path, uid, gid)
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @param uid  the user ID
    * @param gid  the group ID
    * @return a [[js.Promise promise]]
    */
  def chown(path: String | Buffer | URL, uid: UID, gid: GID): js.Promise[Unit] = js.native

  /**
    * Asynchronously copies src to dest. By default, dest is overwritten if it already exists. The Promise will be
    * resolved with no arguments upon success.
    *
    * Node.js makes no guarantees about the atomicity of the copy operation. If an error occurs after the destination
    * file has been opened for writing, Node.js will attempt to remove the destination.
    *
    * flags is an optional integer that specifies the behavior of the copy operation. It is possible to create a mask
    * consisting of the bitwise OR of two or more values (e.g. [[FSConstants.COPYFILE_EXCL]] | [[FSConstants.COPYFILE_FICLONE]]).
    * <ul>
    * <li>[[FSConstants.COPYFILE_EXCL]] - The copy operation will fail if dest already exists.</li>
    * <li>[[FSConstants.COPYFILE_FICLONE]] - The copy operation will attempt to create a copy-on-write reflink.
    * If the platform does not support copy-on-write, then a fallback copy mechanism is used.</li>
    * <li>[[FSConstants.COPYFILE_FICLONE_FORCE]] - The copy operation will attempt to create a copy-on-write reflink.
    * If the platform does not support copy-on-write, then the operation will fail.</li>
    * </ul>
    * @example copyFile(src, dest[, flags])
    * @param src   the source path
    * @param dest  the destination path
    * @param flags the flags
    * @return a [[js.Promise promise]]
    */
  def copyFile(src: String | Buffer | URL,
               dest: String | Buffer | URL,
               flags: Int = js.native): js.Promise[Unit] = js.native

  /**
    * Changes the permissions on a symbolic link then resolves the Promise with no arguments upon success.
    * This method is only implemented on macOS.
    * @example lchmod(path, mode)
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @param mode the file mode (e.g. 0666)
    * @return a [[js.Promise promise]]
    */
  def lchmod(path: String | Buffer | URL, mode: Int): js.Promise[Unit] = js.native

  /**
    * Changes the ownership on a symbolic link then resolves the Promise with no arguments upon success.
    * @example lchown(path, uid, gid)
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @param uid  the user ID
    * @param gid  the group ID
    * @return a [[js.Promise promise]]
    */
  def lchown(path: String | Buffer | URL, uid: UID, gid: GID): js.Promise[Unit] = js.native

  /**
    * Asynchronous link(2). The Promise is resolved with no arguments upon success.
    * @example link(existingPath, newPath)
    * @param existingPath [[String]] or [[Buffer]] or [[URL]]
    * @param newPath      [[String]] or [[Buffer]] or [[URL]]
    * @return a [[js.Promise promise]]
    */
  def link(existingPath: String | Buffer | URL, newPath: String | Buffer | URL): js.Promise[Unit] = js.native

  /**
    * Asynchronous lstat(2). The Promise is resolved with the fs.[[Stats]] object for the given symbolic link path.
    * @example lstat(path[, options])
    * @param path    [[String]] or [[Buffer]] or [[URL]]
    * @param options the [[FileEncodingOptions options]]
    * @return the [[js.Promise promise]] of a [[Stats]]
    */
  def lstat(path: String | Buffer | URL, options: FileEncodingOptions = js.native): js.Promise[Stats] = js.native

  /**
    * @example mkdir(path[, options])#
    * @param path    [[String]] or [[Buffer]] or [[URL]]
    * @param options the [[FileEncodingOptions options]]
    * @return a [[js.Promise promise]]
    */
  def mkdir(path: String | Buffer | URL, options: FileEncodingOptions = js.native): js.Promise[Unit] = js.native

  /**
    * Creates a unique temporary directory and resolves the Promise with the created folder path. A unique directory
    * name is generated by appending six random characters to the end of the provided prefix. Due to platform
    * inconsistencies, avoid trailing X characters in prefix. Some platforms, notably the BSDs, can return more than
    * six random characters, and replace trailing X characters in prefix with random characters.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use.
    * @example mkdtemp(prefix[, options])
    * @param prefix  the prefix string
    * @param options the [[FileEncodingOptions options]]
    * @return a [[js.Promise promise]]
    */
  def mkdtemp(prefix: String, options: FileEncodingOptions | String = js.native): js.Promise[String] = js.native

  /**
    * Asynchronous file open that returns a Promise that, when resolved, yields a [[FileHandle]] object. See open(2).
    *
    * mode sets the file mode (permission and sticky bits), but only if the file was created.
    *
    * Some characters (< > : " / \ | ? *) are reserved under Windows as documented by Naming Files, Paths, and Namespaces.
    * Under NTFS, if the filename contains a colon, Node.js will open a file system stream, as described by this MSDN page.
    * @example open(path, flags[, mode])
    * @param path  [[String]] or [[Buffer]] or [[URL]]
    * @param flags See support of file system flags. Default: 'r'.
    * @param mode  Default: 0o666 (readable and writable)
    * @return the [[js.Promise promise]] of a [[FileHandle]]
    */
  def open(path: String | Buffer | URL, flags: String, mode: Int = js.native): js.Promise[FileHandle] = js.native

  /**
    * Reads the contents of a directory then resolves the Promise with an array of the names of the files in the
    * directory excluding '.' and '..'.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the filenames. If the encoding is set to 'buffer', the filenames
    * returned will be passed as Buffer objects.
    *
    * If options.withFileTypes is set to true, the resolved array will contain fs.[[Dirent]] objects.
    * @example readdir(path[, options])
    * @param path    [[String]] or [[Buffer]] or [[URL]]
    * @param options the [[FileEncodingOptions options]]
    * @return a [[js.Promise promise]]
    */
  def readdir(path: String | Buffer | URL, options: FileEncodingOptions | String): js.Promise[js.Array[Dirent]] = js.native

  /**
    * Asynchronously reads the entire contents of a file.
    *
    * The Promise is resolved with the contents of the file. If no encoding is specified (using options.encoding),
    * the data is returned as a Buffer object. Otherwise, the data will be a string.
    *
    * If options is a string, then it specifies the encoding.
    *
    * When the path is a directory, the behavior of readFile() is platform-specific. On macOS, Linux,
    * and Windows, the promise will be rejected with an error. On FreeBSD, a representation of the directory's
    * contents will be returned.
    *
    * Any specified FileHandle has to support reading.
    * @example readFile(path[, options])
    * @param path    [[String]] or [[Buffer]] or [[URL]]
    * @param options the [[FileEncodingOptions options]]
    * @return a [[js.Promise promise]]
    */
  def readFile(path: String | Buffer | URL, options: FileEncodingOptions = js.native): js.Promise[String] = js.native

  /**
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the link path returned. If the encoding is set to 'buffer', the
    * link path returned will be passed as a Buffer object.
    * @example readlink(path[, options])
    * @param path    [[String]] or [[Buffer]] or [[URL]]
    * @param options the [[FileEncodingOptions options]]
    * @return a [[js.Promise promise]]
    */
  def readlink(path: String | Buffer | URL, options: FileEncodingOptions = js.native): js.Promise[String] = js.native

  /**
    * Determines the actual location of path using the same semantics as the fs.realpath.native() function then
    * resolves the Promise with the resolved path.
    *
    * Only paths that can be converted to UTF8 strings are supported.
    *
    * The optional options argument can be a string specifying an encoding, or an object with an encoding property
    * specifying the character encoding to use for the path. If the encoding is set to 'buffer', the path returned
    * will be passed as a Buffer object.
    *
    * On Linux, when Node.js is linked against musl libc, the procfs file system must be mounted on /proc in order
    * for this function to work. Glibc does not have this restriction.
    * @example realpath(path[, options])
    * @param path    [[String]] or [[Buffer]] or [[URL]]
    * @param options the [[FileEncodingOptions options]]
    * @return the [[js.Promise promised]] path
    */
  def realpath(path: String | Buffer | URL, options: FileEncodingOptions | String = js.native): js.Promise[String] = js.native

  /**
    * Renames oldPath to newPath and resolves the Promise with no arguments upon success.
    * @example rename(oldPath, newPath)
    * @param oldPath [[String]] or [[Buffer]] or [[URL]]
    * @param newPath [[String]] or [[Buffer]] or [[URL]]
    * @return a [[js.Promise promise]]
    */
  def rename(oldPath: String | Buffer | URL, newPath: String | Buffer | URL): js.Promise[Unit] = js.native

  /**
    * Removes the directory identified by path then resolves the Promise with no arguments upon success.
    *
    * Using rmdir() on a file (not a directory) results in the Promise being rejected with an ENOENT error
    * on Windows and an ENOTDIR error on POSIX.
    * @example rmdir(path)
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @return a [[js.Promise promise]]
    */
  def rmdir(path: String | Buffer | URL): js.Promise[Unit] = js.native

  /**
    * The Promise is resolved with the fs.[[Stats]] object for the given path.
    * @example stat(path[, options])
    * @param path    [[String]] or [[Buffer]] or [[URL]]
    * @param options the [[FileStatOptions options]]
    * @return a [[js.Promise promise]]
    */
  def stat(path: String | Buffer | URL, options: FileStatOptions = js.native): js.Promise[Stats] = js.native

  /**
    * Creates a symbolic link then resolves the Promise with no arguments upon success.
    * @example symlink(target, path[, type])
    * @param target [[String]] or [[Buffer]] or [[URL]]
    * @param path   [[String]] or [[Buffer]] or [[URL]]
    * @param `type` Default: 'file'
    * @return a [[js.Promise promise]]
    */
  def symlink(target: String | Buffer | URL,
              path: String | Buffer | URL,
              `type`: String = js.native): js.Promise[Unit] = js.native

  /**
    * Truncates the path then resolves the Promise with no arguments upon success. The path must be a string or [[Buffer]].
    * @example truncate(path[, len])
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @param len  Default: 0
    * @return a [[js.Promise promise]]
    */
  def truncate(path: String | Buffer | URL, len: Int = js.native): js.Promise[Unit] = js.native

  /**
    * Asynchronous unlink(2). The Promise is resolved with no arguments upon success.
    * @example unlink(path)
    * @param path [[String]] or [[Buffer]] or [[URL]]
    * @return a [[js.Promise promise]]
    */
  def unlink(path: String | Buffer | URL): js.Promise[Unit] = js.native

  /**
    * Change the file system timestamps of the object referenced by path then resolves the Promise with no arguments upon success.
    *
    * The atime and mtime arguments follow these rules:
    *
    * Values can be either numbers representing Unix epoch time, Dates, or a numeric string like '123456789.0'.
    * If the value can not be converted to a number, or is NaN, Infinity or -Infinity, an Error will be thrown.
    * @example utimes(path, atime, mtime)
    * @param path  [[String]] or [[Buffer]] or [[URL]]
    * @param atime [[Number]] or [[String]] or [[js.Date]]
    * @param mtime [[Number]] or [[String]] or [[js.Date]]
    * @return a [[js.Promise promise]]
    */
  def utimes(path: String | Buffer | URL,
             atime: Int | Double | String | js.Date,
             mtime: Int | Double | String | js.Date): js.Promise[Unit] = js.native

  /**
    * Asynchronously writes data to a file, replacing the file if it already exists. data can be a string or a buffer.
    * The Promise will be resolved with no arguments upon success.
    *
    * The encoding option is ignored if data is a buffer.
    *
    * If options is a string, then it specifies the encoding.
    *
    * Any specified FileHandle has to support writing.
    *
    * It is unsafe to use writeFile() multiple times on the same file without waiting for the Promise to
    * be resolved (or rejected).
    * @example writeFile(file, data[, options])
    * @param file    filename or [[FileHandle]]
    * @param data    the data to write
    * @param options the [[FileOutputOptions]]
    * @return a [[js.Promise promise]]
    */
  def writeFile(file: String | Buffer | URL | FileHandle,
                data: String | Buffer,
                options: FileOutputOptions = js.native): js.Promise[Unit] = js.native

}
