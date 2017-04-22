package io.scalajs.nodejs

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

/**
  * fs package object
  * @author lawrence.daniels@gmail.com
  */
package object fs {

  /////////////////////////////////////////////////////////////////////////////////
  //      Type Definitions
  /////////////////////////////////////////////////////////////////////////////////

  type EventType = String

  type FileIOError = SystemError

  type FileMode = Integer

  type FileType = Int

  type Flags = String | Int

  type FsCallback0 = js.Function1[FileIOError, Any]

  type FsCallback1[A] = js.Function2[FileIOError, A, Any]

  type FsCallback2[A, B] = js.Function3[FileIOError, A, B, Any]

  type FsCallback3[A, B, C] = js.Function4[FileIOError, A, B, C, Any]

  type GID = Int

  type UID = Int

  /////////////////////////////////////////////////////////////////////////////////
  //      Implicit conversions and classes
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * File System Extensions
    * @param fs the given [[Fs file system]] instance
    */
  implicit class FsExtensions(val fs: Fs) extends AnyVal {

    @inline
    def accessFuture(path: Buffer | String, mode: FileMode = null): Future[Unit] = {
      promiseWithError0[FileIOError](fs.access(path, mode, _))
    }

    @inline
    def appendFileFuture(file: Buffer | FileDescriptor | String,
                        data: Buffer | String,
                        options: FileAppendOptions = null): Future[Unit] = {
      promiseWithError0[FileIOError](fs.appendFile(file, data, options, _))
    }

    @inline
    def chmodFuture(path: Buffer | String, mode: FileMode, callback: js.Function1[FileIOError, Any]): Future[Unit] = {
      promiseWithError0[FileIOError](fs.chmod(path, mode, _))
    }

    @inline
    def closeFuture(fd: FileDescriptor): Future[Unit] = promiseWithError0[FileIOError](fs.close(fd, _))

    @inline
    def existsFuture(path: String): Future[Boolean] = promiseCallback1[Boolean](fs.exists(path, _))

    @inline
    def fdatasyncFuture(fd: FileDescriptor): Future[Unit] = promiseWithError0[FileIOError](fs.fdatasync(fd, _))

    @inline
    def futimesFuture(fd: FileDescriptor, atime: Integer, mtime: Integer): Future[Unit] = {
      promiseWithError0[FileIOError](fs.futimes(fd, atime, mtime, _))
    }

    @inline
    def lchmodFuture(path: Buffer | String, mode: FileMode): Future[Unit] = {
      promiseWithError0[FileIOError](fs.lchmod(path, mode, _))
    }

    @inline
    def lchownFuture(path: Buffer | String, uid: UID, gid: GID): Future[Unit] = {
      promiseWithError0[FileIOError](fs.lchown(path, uid, gid, _))
    }

    @inline
    def linkFuture(srcpath: Buffer | String, dstpath: Buffer | String): Future[Unit] = {
      promiseWithError0[FileIOError](fs.link(srcpath, dstpath, _))
    }

    @inline
    def mkdirFuture(path: Buffer | String, mode: FileMode = null): Future[Unit] = {
      promiseWithError0[FileIOError](fs.mkdir(path, mode, _))
    }

    @inline
    def openFuture(path: Buffer | String, flags: Flags, mode: FileMode = null): Future[FileDescriptor] = {
      promiseWithError1[FileIOError, FileDescriptor](fs.open(path, flags, mode, _))
    }

    @inline
    def readFuture(fd: FileDescriptor, buffer: Buffer, offset: Int, length: Int, position: Int): Future[(Int, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](Fs.read(fd, buffer, offset, length, position, _))
    }

    @inline
    def readdirFuture(path: Buffer | String,
                     options: String | FileEncodingOptions | RawOptions = null): Future[js.Array[String]] = {
      promiseWithError1[FileIOError, js.Array[String]](fs.readdir(path, options, _))
    }

    @inline
    def readFileFuture(file: String, options: FileInputOptions = null): Future[js.Any] = {
      promiseWithError1[FileIOError, js.Any](fs.readFile(file, options, _))
    }

    @inline
    def renameFuture(oldPath: String, newPath: String): Future[Unit] = {
      promiseWithError0[FileIOError](fs.rename(oldPath, newPath, _))
    }

    @inline
    def realpathFuture(path: String, options: FileEncodingOptions = null): Future[String] = {
      promiseWithError1[FileIOError, String](fs.realpath(path, options, _))
    }

    @inline
    def rmdirFuture(path: Buffer | String): Future[Unit] = promiseWithError0[FileIOError](fs.rmdir(path, _))

    @inline
    def statFuture(path: String): Future[Stats] = promiseWithError1[FileIOError, Stats](fs.stat(path, _))

    @inline
    def symlinkFuture(target: Buffer | String, path: Buffer | String, `type`: String = null): Future[Unit] = {
      promiseWithError0[FileIOError](fs.symlink(target, path, `type`, _))
    }

    @inline
    def unlinkFuture(path: Buffer | String): Future[Unit] = promiseWithError0[FileIOError](fs.unlink(path, _))

    @inline
    def unwatchFileFuture(filename: Buffer | String): Future[Unit] =
      promiseWithError0[FileIOError](fs.unwatchFile(filename, _))

    @inline
    def utimesFuture(path: Buffer | String, atime: Int, mtime: Int): Future[Unit] =
      promiseWithError0[FileIOError](fs.utimes(path, atime, mtime, _))

    @inline
    def watchFuture(filename: String, options: FSWatcherOptions = null): Future[(String, String)] = {
      promiseCallback2[String, String](fs.watch(filename, options, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor,
                   buffer: Buffer | Uint8Array,
                   offset: Integer = null,
                   length: Integer = null,
                   position: Integer = null): Future[(FileType, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](fs.write(fd, buffer, offset, length, position, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor, string: String, position: Int, encoding: String): Future[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](fs.write(fd, string, position, encoding, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor, string: String, position: Int): Future[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](fs.write(fd, string, position, null, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor, string: String): Future[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](fs.write(fd, string, _))
    }

    @inline
    def writeFileFuture(file: String, data: Buffer | String, options: FileOutputOptions = null): Future[Unit] = {
      promiseWithError0[FileIOError](fs.writeFile(file, data, options, _))
    }

  }

}
