package io.scalajs.nodejs

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Promise
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
    def accessAsync(path: Buffer | String, mode: FileMode = null): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.access(path, mode, _))
    }

    @inline
    def appendFileAsync(file: Buffer | FileDescriptor | String,
                        data: Buffer | String,
                        options: FileAppendOptions = null): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.appendFile(file, data, options, _))
    }

    @inline
    def chmodAsync(path: Buffer | String, mode: FileMode, callback: js.Function1[FileIOError, Any]): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.chmod(path, mode, _))
    }

    @inline
    def closeAsync(fd: FileDescriptor): Promise[Unit] = promiseWithError0[FileIOError](fs.close(fd, _))

    @inline
    def existsAsync(path: String): Promise[Boolean] = promiseCallback1[Boolean](fs.exists(path, _))

    @inline
    def fdatasyncAsync(fd: FileDescriptor): Promise[Unit] = promiseWithError0[FileIOError](fs.fdatasync(fd, _))

    @inline
    def futimesAsync(fd: FileDescriptor, atime: Integer, mtime: Integer): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.futimes(fd, atime, mtime, _))
    }

    @inline
    def lchmodAsync(path: Buffer | String, mode: FileMode): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.lchmod(path, mode, _))
    }

    @inline
    def lchownAsync(path: Buffer | String, uid: UID, gid: GID): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.lchown(path, uid, gid, _))
    }

    @inline
    def linkAsync(srcpath: Buffer | String, dstpath: Buffer | String): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.link(srcpath, dstpath, _))
    }

    @inline
    def mkdirAsync(path: Buffer | String, mode: FileMode = null): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.mkdir(path, mode, _))
    }

    @inline
    def openAsync(path: Buffer | String, flags: Flags, mode: FileMode = null): Promise[FileDescriptor] = {
      promiseWithError1[FileIOError, FileDescriptor](fs.open(path, flags, mode, _))
    }

    @inline
    def readAsync(fd: FileDescriptor, buffer: Buffer, offset: Int, length: Int, position: Int): Promise[(Int, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](Fs.read(fd, buffer, offset, length, position, _))
    }

    @inline
    def readdirAsync(path: Buffer | String,
                     options: String | FileEncodingOptions | RawOptions = null): Promise[js.Array[String]] = {
      promiseWithError1[FileIOError, js.Array[String]](fs.readdir(path, options, _))
    }

    @inline
    def readFileAsync(file: String, options: FileInputOptions = null): Promise[js.Any] = {
      promiseWithError1[FileIOError, js.Any](fs.readFile(file, options, _))
    }

    @inline
    def renameAsync(oldPath: String, newPath: String): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.rename(oldPath, newPath, _))
    }

    @inline
    def realpathAsync(path: String, options: FileEncodingOptions = null): Promise[String] = {
      promiseWithError1[FileIOError, String](fs.realpath(path, options, _))
    }

    @inline
    def rmdirAsync(path: Buffer | String): Promise[Unit] = promiseWithError0[FileIOError](fs.rmdir(path, _))

    @inline
    def statAsync(path: String): Promise[Stats] = promiseWithError1[FileIOError, Stats](fs.stat(path, _))

    @inline
    def symlinkAsync(target: Buffer | String, path: Buffer | String, `type`: String = null): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.symlink(target, path, `type`, _))
    }

    @inline
    def unlinkAsync(path: Buffer | String): Promise[Unit] = promiseWithError0[FileIOError](fs.unlink(path, _))

    @inline
    def unwatchFileAsync(filename: Buffer | String): Promise[Unit] =
      promiseWithError0[FileIOError](fs.unwatchFile(filename, _))

    @inline
    def utimesAsync(path: Buffer | String, atime: Int, mtime: Int): Promise[Unit] =
      promiseWithError0[FileIOError](fs.utimes(path, atime, mtime, _))

    @inline
    def watchAsync(filename: String, options: FSWatcherOptions = null): Promise[(String, String)] = {
      promiseCallback2[String, String](fs.watch(filename, options, _))
    }

    @inline
    def writeAsync(fd: FileDescriptor,
                   buffer: Buffer | Uint8Array,
                   offset: Integer = null,
                   length: Integer = null,
                   position: Integer = null): Promise[(FileType, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](fs.write(fd, buffer, offset, length, position, _))
    }

    @inline
    def writeAsync(fd: FileDescriptor, string: String, position: Int, encoding: String): Promise[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](fs.write(fd, string, position, encoding, _))
    }

    @inline
    def writeAsync(fd: FileDescriptor, string: String, position: Int): Promise[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](fs.write(fd, string, position, null, _))
    }

    @inline
    def writeAsync(fd: FileDescriptor, string: String): Promise[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](fs.write(fd, string, _))
    }

    @inline
    def writeFileAsync(file: String, data: Buffer | String, options: FileOutputOptions = null): Promise[Unit] = {
      promiseWithError0[FileIOError](fs.writeFile(file, data, options, _))
    }

  }

}
