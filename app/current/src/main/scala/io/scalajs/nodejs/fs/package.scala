package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray, Uint8Array}
import scala.scalajs.js.|

/**
  * fs package object
  */
package object fs {

  type Path             = Uint8Array | String | URL
  type Time             = Int | String | js.Date
  type BufferLike       = TypedArray[_, _] | DataView
  type Output           = String | Buffer
  type FileWriteOptions = FileAppendOptions

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  type Dirent = Fs.Dirent

  /////////////////////////////////////////////////////////////////////////////////
  //      Implicit conversions and classes
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * File System Extensions
    * @param fs the given [[Fs file system]] instance
    */
  final implicit class FsExtensions(private val fs: Fs) extends AnyVal {
    @inline
    def accessFuture(path: Buffer | String): Future[Unit] = {
      promiseWithError0[FileIOError](fs.access(path, _))
    }

    @inline
    def accessFuture(path: Buffer | String, mode: FileMode): Future[Unit] = {
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
    def existsFuture(path: String): Future[Boolean] = promiseWithErrorAsBoolean[FileIOError](fs.access(path, _))

    @inline
    def fdatasyncFuture(fd: FileDescriptor): Future[Unit] = promiseWithError0[FileIOError](fs.fdatasync(fd, _))

    @inline
    def futimesFuture(fd: FileDescriptor, atime: Time, mtime: Time): Future[Unit] = {
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
    def mkdirFuture(path: Buffer | String, mode: FileMode): Future[Unit] = {
      promiseWithError0[FileIOError](fs.mkdir(path, mode, _))
    }

    @inline
    def mkdirFuture(path: Buffer | String): Future[Unit] = {
      promiseWithError0[FileIOError](fs.mkdir(path, _))
    }

    @inline
    def openFuture(path: Buffer | String, flags: Flags, mode: FileMode): Future[FileDescriptor] = {
      promiseWithError1[FileIOError, FileDescriptor](fs.open(path, flags, mode, _))
    }
    @inline
    def openFuture(path: Buffer | String, flags: Flags): Future[FileDescriptor] = {
      promiseWithError1[FileIOError, FileDescriptor](fs.open(path, flags, _))
    }

    @inline
    def readFuture(fd: FileDescriptor,
                   buffer: Buffer,
                   offset: Int,
                   length: Int,
                   position: Int): Future[(Int, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](Fs.read(fd, buffer, offset, length, position, _))
    }

    @inline
    def readdirFuture(path: Buffer | String, options: String = "utf8"): Future[js.Array[String]] = {
      val callback: FsCallback1[js.Array[String]] => Unit = { callback =>
        fs.readdir(path, options, callback.asInstanceOf[FsCallback1[ReaddirArrays]])
      }
      promiseWithError1[FileIOError, js.Array[String]](callback)
    }

    @inline
    def readdirBufferFuture(path: Buffer | String): Future[js.Array[Buffer]] = {
      val callback: FsCallback1[js.Array[Buffer]] => Unit = { callback =>
        fs.readdir(
          path,
          new FileEncodingOptions(encoding = "buffer"),
          callback.asInstanceOf[FsCallback1[ReaddirArrays]]
        )
      }
      promiseWithError1[FileIOError, js.Array[Buffer]](callback)
    }

    @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
    @inline
    def readdirDirentFuture(path: Buffer | String): Future[js.Array[Dirent]] = {
      val callback: FsCallback1[js.Array[Dirent]] => Unit = { callback =>
        fs.readdir(path, new ReaddirOptions(withFileTypes = true), callback.asInstanceOf[FsCallback1[ReaddirArrays2]])
      }
      promiseWithError1[FileIOError, js.Array[Dirent]](callback)
    }

    @inline
    def readFileFuture(file: String, options: ReadFileOptions = null): Future[Output] = {
      promiseWithError1[FileIOError, Output](fs.readFile(file, options, _))
    }

    @inline
    def renameFuture(oldPath: String, newPath: String): Future[Unit] = {
      promiseWithError0[FileIOError](fs.rename(oldPath, newPath, _))
    }

    @inline
    def realpathFuture(path: String): Future[String] = {
      promiseWithError1[FileIOError, String](fs.realpath(path, _))
    }

    @inline
    def realpathFuture(path: String, options: FileEncodingOptions): Future[Output] = {
      promiseWithError1[FileIOError, Output](fs.realpath(path, options, _))
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
                    buffer: Uint8Array,
                    offset: Int | Null = null,
                    length: Int | Null = null,
                    position: Int | Null = null): Future[(FileType, Buffer)] = {
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
    def writeFileFuture(file: String, data: Buffer, options: FileWriteOptions = null): Future[Unit] = {
      promiseWithError0[FileIOError](fs.writeFile(file, data, options, _))
    }

    @inline
    def writeFileFuture(file: String, data: String, options: FileWriteOptions): Future[Unit] = {
      promiseWithError0[FileIOError](fs.writeFile(file, data, options, _))
    }

    @inline
    def writeFileFuture(file: String, data: String): Future[Unit] = {
      promiseWithError0[FileIOError](fs.writeFile(file, data, _))
    }
  }

}
