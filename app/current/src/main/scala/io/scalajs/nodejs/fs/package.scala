package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.{typedarray, |}

/**
  * fs package object
  */
package object fs {
  type Path             = typedarray.Uint8Array | String | URL
  type Time             = Int | String | js.Date
  type BufferLike       = typedarray.TypedArray[_, _] | typedarray.DataView
  type Output           = String | Buffer
  type FileWriteOptions = FileAppendOptions

  type ReaddirArrays  = js.Array[String] | js.Array[Buffer]
  type ReaddirArrays2 = ReaddirArrays | js.Array[fs.Dirent]

  type Dirent = Fs.Dirent

  type StatsVariant = Stats | BigIntStats

  /////////////////////////////////////////////////////////////////////////////////
  //      Implicit conversions and classes
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * File System Extensions
    *
    * @param instance the given [[Fs file system]] instance
    */
  implicit final class FsExtensions(private val instance: Fs) extends AnyVal {
    @inline
    def accessFuture(path: Buffer | String): Future[Unit] = {
      promiseWithError0[FileIOError](instance.access(path, _))
    }

    @inline
    def accessFuture(path: Buffer | String, mode: FileMode): Future[Unit] = {
      promiseWithError0[FileIOError](instance.access(path, mode, _))
    }

    @inline
    def appendFileFuture(file: Buffer | FileDescriptor | String,
                         data: Buffer | String,
                         options: FileAppendOptions = null
    ): Future[Unit] = {
      promiseWithError0[FileIOError](instance.appendFile(file, data, options, _))
    }

    @inline
    def chmodFuture(path: Buffer | String, mode: FileMode): Future[Unit] = {
      promiseWithError0[FileIOError](instance.chmod(path, mode, _))
    }

    @inline
    def chownFuture(path: Path, uid: UID, gid: GID): Future[Unit] = {
      promiseWithError0[FileIOError](instance.chown(path, uid, gid, _))
    }

    @inline
    def copyFileFuture(src: Path, dest: Path, flags: Flags): Future[Unit] = {
      promiseWithError0[FileIOError](instance.copyFile(src, dest, flags, _))
    }

    @inline
    def copyFileFuture(src: Path, dest: Path): Future[Unit] = {
      promiseWithError0[FileIOError](instance.copyFile(src, dest, _))
    }

    @inline
    def existsFuture(path: Path): Future[Boolean] = promiseWithErrorAsBoolean[FileIOError](instance.access(path, _))

    @inline
    def fchmodFuture(fd: FileDescriptor, mode: FileMode): Future[Unit] = {
      promiseWithError0[FileIOError](instance.fchmod(fd, mode, _))
    }

    @inline
    def fchownFuture(fd: FileDescriptor, uid: UID, gid: GID): Future[Unit] = {
      promiseWithError0[FileIOError](instance.fchown(fd, uid, gid, _))
    }

    @inline
    def fdatasyncFuture(fd: FileDescriptor): Future[Unit] = promiseWithError0[FileIOError](instance.fdatasync(fd, _))

    @inline
    def fstatFuture(fd: FileDescriptor, options: StatOptions): Future[StatsVariant] = {
      promiseWithError1[FileIOError, StatsVariant](instance.fstat(fd, options, _))
    }

    @inline
    def fstatFuture(fd: FileDescriptor): Future[Stats] = {
      promiseWithError1[FileIOError, Stats](instance.fstat(fd, _))
    }

    @inline
    def fsyncFuture(fd: FileDescriptor): Future[Unit] = {
      promiseWithError0[FileIOError](instance.fsync(fd, _))
    }

    @inline
    def ftruncateFuture(fd: FileDescriptor): Future[Unit] = {
      promiseWithError0[FileIOError](instance.ftruncate(fd, _))
    }

    @inline
    def futimesFuture(fd: FileDescriptor, atime: Time, mtime: Time): Future[Unit] = {
      promiseWithError0[FileIOError](instance.futimes(fd, atime, mtime, _))
    }

    @inline
    def lchmodFuture(path: Path, mode: FileMode): Future[Unit] = {
      promiseWithError0[FileIOError](instance.lchmod(path, mode, _))
    }

    @inline
    def lchownFuture(path: Path, uid: UID, gid: GID): Future[Unit] = {
      promiseWithError0[FileIOError](instance.lchown(path, uid, gid, _))
    }

    @inline
    def linkFuture(srcpath: Path, dstpath: Path): Future[Unit] = {
      promiseWithError0[FileIOError](instance.link(srcpath, dstpath, _))
    }

    @inline
    def lstatFuture(path: Path, options: StatOptions): Future[StatsVariant] = {
      promiseWithError1[FileIOError, StatsVariant](instance.lstat(path, options, _))
    }

    @inline
    def lstatFuture(path: Path): Future[Stats] = {
      promiseWithError1[FileIOError, Stats](instance.lstat(path, _))
    }

    @inline
    def mkdirFuture(path: Path, mode: FileMode): Future[Unit] = {
      promiseWithError0[FileIOError](instance.mkdir(path, mode, _))
    }

    @inline
    def mkdirFuture(path: Path): Future[Unit] = {
      promiseWithError0[FileIOError](instance.mkdir(path, _))
    }

    @inline
    def mkdirFuture(path: Path, options: MkdirOptions): Future[Unit] = {
      promiseWithError0[FileIOError](instance.mkdir(path, options, _))
    }

    @inline
    def mkdirRecursiveFuture(path: Path): Future[Unit] = {
      val recursiveEnabled = new MkdirOptions(recursive = true)
      promiseWithError0[FileIOError](instance.mkdir(path, recursiveEnabled, _))
    }

    @inline
    def mkdirRecursiveFuture(path: Path, options: MkdirOptions): Future[Unit] = {
      val recursiveEnabled = new MkdirOptions(
        recursive = true,
        mode = options.mode
      )
      promiseWithError0[FileIOError](instance.mkdir(path, recursiveEnabled, _))
    }

    @inline
    def mkdtempFuture(prefix: String, options: FileEncodingOptions): Future[String] = {
      promiseWithError1[FileIOError, String](instance.mkdtemp(prefix, options, _))
    }

    @inline
    def mkdtempFuture(prefix: String): Future[String] = {
      promiseWithError1[FileIOError, String](instance.mkdtemp(prefix, _))
    }

    @inline
    def openFuture(path: Path, flags: Flags, mode: FileMode): Future[FileDescriptor] = {
      promiseWithError1[FileIOError, FileDescriptor](instance.open(path, flags, mode, _))
    }

    @inline
    def openFuture(path: Path, flags: Flags): Future[FileDescriptor] = {
      promiseWithError1[FileIOError, FileDescriptor](instance.open(path, flags, _))
    }

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def openFuture(path: Path): Future[FileDescriptor] = {
      promiseWithError1[FileIOError, FileDescriptor](instance.open(path, _))
    }

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def opendirFuture(path: Path, options: OpendirOptions): Future[Fs.Dir] = {
      promiseWithError1[FileIOError, Fs.Dir](instance.opendir(path, options, _))
    }

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def opendirFuture(path: Path): Future[Fs.Dir] = {
      promiseWithError1[FileIOError, Fs.Dir](instance.opendir(path, _))
    }

    @inline
    def readFuture(fd: FileDescriptor,
                   buffer: Buffer,
                   offset: Int | Null,
                   length: Int | Null,
                   position: Int | Null
    ): Future[(Int, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](Fs.read(fd, buffer, offset, length, position, _))
    }

    @inline
    def readdirFuture(path: Path, encoding: String = "utf8"): Future[js.Array[String]] = {
      val callback: FsCallback1[js.Array[String]] => Unit = { callback =>
        instance.readdir(path, encoding, callback.asInstanceOf[FsCallback1[ReaddirArrays]])
      }
      promiseWithError1[FileIOError, js.Array[String]](callback)
    }

    @inline
    def readdirFuture(path: Path, options: FileEncodingOptions): Future[js.Array[String]] = {
      val callback: FsCallback1[js.Array[String]] => Unit = { callback =>
        instance.readdir(path, options, callback.asInstanceOf[FsCallback1[ReaddirArrays]])
      }
      promiseWithError1[FileIOError, js.Array[String]](callback)
    }

    @inline
    def readdirBufferFuture(path: Path): Future[js.Array[Buffer]] = {
      val callback: FsCallback1[js.Array[Buffer]] => Unit = { callback =>
        instance.readdir(
          path,
          new FileEncodingOptions(encoding = "buffer"),
          callback.asInstanceOf[FsCallback1[ReaddirArrays]]
        )
      }
      promiseWithError1[FileIOError, js.Array[Buffer]](callback)
    }

    @inline
    def readdirDirentFuture(path: Buffer | String): Future[js.Array[Dirent]] = {
      val callback: FsCallback1[js.Array[Dirent]] => Unit = { callback =>
        instance.readdir(
          path,
          new ReaddirOptions(withFileTypes = true),
          callback.asInstanceOf[FsCallback1[ReaddirArrays2]]
        )
      }
      promiseWithError1[FileIOError, js.Array[Dirent]](callback)
    }

    @inline
    def readFileFuture(file: Path | FileDescriptor, options: ReadFileOptions): Future[Output] = {
      promiseWithError1[FileIOError, Output](instance.readFile(file, options, _))
    }

    @inline
    def readFileFuture(file: Path | FileDescriptor, encoding: String): Future[String] = {
      promiseWithError1[FileIOError, String](instance.readFile(file, encoding, _))
    }

    @inline
    def readFileFuture(file: Path | FileDescriptor): Future[Buffer] = {
      promiseWithError1[FileIOError, Buffer](instance.readFile(file, _))
    }

    @inline
    def readlinkFuture(file: Path, options: String | FileEncodingOptions): Future[Output] = {
      promiseWithError1[FileIOError, Output](instance.readlink(file, options, _))
    }

    @inline
    def renameFuture(oldPath: Path, newPath: Path): Future[Unit] = {
      promiseWithError0[FileIOError](instance.rename(oldPath, newPath, _))
    }

    @inline
    def readlinkFuture(file: Path): Future[String] = {
      promiseWithError1[FileIOError, String](instance.readlink(file, _))
    }

    @inline
    def realpathFuture(file: Path, options: String | FileEncodingOptions): Future[Output] = {
      promiseWithError1[FileIOError, Output](instance.realpath(file, options, _))
    }

    @inline
    def realpathNativeFuture(file: Path, options: FileEncodingOptions): Future[Output] = {
      promiseWithError1[FileIOError, Output](instance.realpath.native(file, options, _))
    }

    @inline
    def realpathNativeFuture(file: Path, encoding: String): Future[Output] = {
      promiseWithError1[FileIOError, Output](instance.realpath.native(file, encoding, _))
    }

    @inline
    def realpathNativeFuture(file: Path): Future[String] = {
      promiseWithError1[FileIOError, String](instance.realpath.native(file, _))
    }

    @inline
    def realpathFuture(file: Path): Future[String] = {
      promiseWithError1[FileIOError, String](instance.realpath(file, _))
    }

    @inline
    def rmdirFuture(path: Path): Future[Unit] = promiseWithError0[FileIOError](instance.rmdir(path, _))

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def rmdirFuture(path: Path, options: RmdirOptions): Future[Unit] =
      promiseWithError0[FileIOError](instance.rmdir(path, options, _))

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def rmdirRecursiveFuture(path: Path, options: RmdirOptions): Future[Unit] = {
      val recursiveEnabled =
        new RmdirOptions(recursive = true, maxBusyTries = options.maxBusyTries, emfileWait = options.emfileWait)
      promiseWithError0[FileIOError](instance.rmdir(path, recursiveEnabled, _))
    }

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def rmdirRecursiveFuture(path: Path): Future[Unit] = {
      promiseWithError0[FileIOError](instance.rmdir(path, new RmdirOptions(recursive = true), _))
    }

    @inline
    def statFuture(path: Path): Future[Stats] = promiseWithError1[FileIOError, Stats](instance.stat(path, _))

    @inline
    def statFuture(path: Path, options: StatOptions): Future[StatsVariant] = {
      promiseWithError1[FileIOError, StatsVariant](instance.stat(path, options, _))
    }

    @inline
    def symlinkFuture(target: Path, path: Path, `type`: String): Future[Unit] = {
      promiseWithError0[FileIOError](instance.symlink(target, path, `type`, _))
    }

    @inline
    def symlinkFuture(target: Path, path: Path): Future[Unit] = {
      promiseWithError0[FileIOError](instance.symlink(target, path, _))
    }

    @inline
    def truncateFuture(target: Path): Future[Unit] = {
      promiseWithError0[FileIOError](instance.truncate(target, _))
    }

    @inline
    def truncateFuture(target: Path, length: Int): Future[Unit] = {
      promiseWithError0[FileIOError](instance.truncate(target, length, _))
    }

    @inline
    def unlinkFuture(path: Path): Future[Unit] = promiseWithError0[FileIOError](instance.unlink(path, _))

    @inline
    def unwatchFileFuture(filename: Path): Future[Unit] =
      promiseWithError0[FileIOError](instance.unwatchFile(filename, _))

    @inline
    def utimesFuture(path: Path, atime: Time, mtime: Time): Future[Unit] =
      promiseWithError0[FileIOError](instance.utimes(path, atime, mtime, _))

    @inline
    def watchFuture(filename: Path): Future[(EventType, String)] = {
      promiseCallback2[EventType, String](instance.watch(filename, _))
    }

    @inline
    def watchFuture(filename: Path, options: FSWatcherOptions): Future[(EventType, String)] = {
      promiseCallback2[EventType, String](instance.watch(filename, options, _))
    }

    @inline
    def watchFileFuture(filename: Path): Future[(Stats, Stats)] = {
      promiseCallback2[Stats, Stats](instance.watchFile(filename, _))
    }

    @inline
    def watchFileFuture(filename: Path, options: FileWatcherOptions): Future[(Stats, Stats)] = {
      promiseCallback2[Stats, Stats](instance.watchFile(filename, options, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor,
                    buffer: typedarray.Uint8Array,
                    offset: Int | Null = null,
                    length: Int | Null = null,
                    position: Int | Null = null
    ): Future[(FileType, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](instance.write(fd, buffer, offset, length, position, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor,
                    buffer: BufferLike,
                    offset: Int | Null,
                    length: Int | Null,
                    position: Int | Null
    ): Future[(FileType, Buffer)] = {
      promiseWithError2[FileIOError, Int, Buffer](instance.write(fd, buffer, offset, length, position, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor, string: String, position: Int, encoding: String): Future[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](instance.write(fd, string, position, encoding, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor, string: String, position: Int): Future[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](instance.write(fd, string, position, _))
    }

    @inline
    def writeFuture(fd: FileDescriptor, string: String): Future[(FileType, String)] = {
      promiseWithError2[FileIOError, Int, String](instance.write(fd, string, _))
    }

    @inline
    def writeFileFuture(file: String, data: typedarray.Uint8Array, options: FileWriteOptions = null): Future[Unit] = {
      promiseWithError0[FileIOError](instance.writeFile(file, data, options, _))
    }

    @inline
    def writeFileFuture(file: String, data: BufferLike): Future[Unit] = {
      promiseWithError0[FileIOError](instance.writeFile(file, data, _))
    }

    @inline
    def writeFileFuture(file: String, data: BufferLike, options: FileWriteOptions): Future[Unit] = {
      promiseWithError0[FileIOError](instance.writeFile(file, data, options, _))
    }

    @inline
    def writeFileFuture(file: String, data: String, options: FileWriteOptions): Future[Unit] = {
      promiseWithError0[FileIOError](instance.writeFile(file, data, options, _))
    }

    @inline
    def writeFileFuture(file: String, data: String): Future[Unit] = {
      promiseWithError0[FileIOError](instance.writeFile(file, data, _))
    }

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def writevFuture(fd: FileDescriptor,
                     buffers: js.Array[typedarray.ArrayBufferView],
                     position: Int
    ): Future[(Int, js.Array[typedarray.ArrayBufferView])] = {
      promiseWithError2[FileIOError, Int, js.Array[typedarray.ArrayBufferView]](
        instance.writev(fd, buffers, position, _)
      )
    }
  }

  /**
    * Dir Extensions
    *
    * @param instance the given [[Fs.Dir]] instance
    */
  implicit final class FsDirExtensions(private val instance: Fs.Dir) extends AnyVal {
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def readFuture(): Future[Option[Fs.Dirent]] = {
      promiseWithError1[js.Error, Option[Fs.Dirent]](f => {
        instance.read((err, dir) => {
          f(err, Option(dir))
        })
      })
    }

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline
    def closeFuture(): Future[Unit] = {
      promiseWithError0[js.Error](instance.close _)
    }
  }

  /**
    * File System Watcher Extensions
    */
  implicit final class FSWatcherExtensions[T <: FSWatcher](private val watcher: T) extends AnyVal {

    /**
      * Emitted when something changes in a watched directory or file. See more details in fs.watch().
      *
      * The filename argument may not be provided depending on operating system support. If filename is provided,
      * it will be provided as a Buffer if fs.watch() is called with it's encoding option set to 'buffer', otherwise
      * filename will be a string.
      * @param listener the event handler
      *                 <ul>
      *                 <li>event: String - The type of fs change</li>
      *                 <li>filename: String> | Buffer - The filename that changed (if relevant/available)</li>
      *                 </ul>
      * @since 0.5.8
      */
    @inline
    def onChange(listener: (String, js.Any) => Any): T = watcher.on("change", listener)

    /**
      * Added in Node.js v10.0.0
      * @see https://nodejs.org/api/fs.html#fs_event_close
      */
    @inline
    def onClose(listener: () => Any): T = watcher.on("close", listener)

    /**
      * Emitted when an error occurs.
      * @param listener the event handler
      * @since 0.5.8
      */
    @inline
    def onError(listener: Error => Any): T = watcher.on("error", listener)
  }

  implicit final class ReadStreamExtensions[R <: ReadStream](private val stream: R) extends AnyVal {

    /**
      * Emitted when the ReadStream's underlying file descriptor has been closed using the fs.close() method.
      * @param listener the event handler
      * @since 0.1.93
      */
    @inline
    def onClose(listener: () => Any): R = stream.on("close", listener)

    /**
      * Emitted when the ReadStream's file is opened.
      * @param listener the event handler
      *                 <ul>
      *                 <li>fd: Integer - file descriptor used by the ReadStream.</li>
      *                 </ul>
      * @since 0.1.93
      */
    @inline
    def onOpen(listener: FileDescriptor => Any): R = stream.on("open", listener)

    /**
      * Added in Node.js v9.11.0
      * @see https://nodejs.org/api/fs.html#fs_event_ready
      */
    @inline
    def onReady(listener: () => Any): R = stream.on("ready", listener)

    @inline
    def closeFuture: Future[Unit] = promiseCallback1[Unit](stream.close)
  }

  /**
    * Write Stream Events
    */
  implicit final class WriteStreamExtensions[T <: WriteStream](private val stream: T) extends AnyVal {

    /**
      * Emitted when the WriteStream's underlying file descriptor has been closed using the fs.close() method.
      * @param listener the event handler
      * @since 0.1.93
      */
    @inline
    def onClose(listener: () => Any): T = stream.on("close", listener)

    /**
      * Emitted when the WriteStream's file is opened.
      * @param listener the event handler
      *                 <ul>
      *                 <li>fd: Integer - file descriptor used by the ReadStream.</li>
      *                 </ul>
      * @since 0.1.93
      */
    @inline
    def onOpen(listener: FileDescriptor => Any): T = stream.on("open", listener)

    /**
      * Added in Node.js v9.11.0
      * @see https://nodejs.org/api/fs.html#fs_event_ready_1
      */
    @inline
    def onReady(listener: () => Any): T = stream.on("ready", listener)

    @inline
    def closeFuture: Future[Unit] = promiseCallback1[Unit](stream.close)
  }
}
