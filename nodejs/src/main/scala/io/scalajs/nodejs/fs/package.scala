package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.ScalaJsHelper.{futureCallbackA2, futureCallbackE0, futureCallbackE1}

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * fs package object
  * @author lawrence.daniels@gmail.com
  */
package object fs {

  type FileMode = Integer

  type FileType = Int

  /**
    * File System Extensions
    * @param fs the given [[Fs file system]] instance
    */
  implicit class FsExtensions(val fs: Fs) extends AnyVal {

    @inline
    def accessFuture(path: String | Buffer, mode: FileMode = null): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.access(path, mode, _))

    @inline
    def appendFileFuture(file: String | Buffer, data: String | Buffer, options: AppendOptions): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.appendFile(file, data, options, _))

    @inline
    def closeFuture(fd: FileDescriptor): Promise[Unit] = futureCallbackE0[FileIOError](fs.close(fd, _))

    @inline
    def fdatasyncFuture(fd: FileDescriptor): Promise[Unit] = futureCallbackE0[FileIOError](fs.fdatasync(fd, _))

    @inline
    def futimesFuture(fd: FileDescriptor, atime: Integer, mtime: Integer): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.futimes(fd, atime, mtime, _))

    @inline
    def lchmodFuture(path: String | Buffer, mode: FileMode): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.lchmod(path, mode, _))

    @inline
    def lchownFuture(path: String | Buffer, uid: Integer, gid: Integer): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.lchown(path, uid, gid, _))

    @inline
    def linkFuture(srcpath: String | Buffer, dstpath: String | Buffer): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.link(srcpath, dstpath, _))

    @inline
    def mkdirFuture(path: String | Buffer, mode: FileMode | js.Any = null): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.mkdir(path, mode, _))

    @inline
    def readFileFuture(file: String, options: FileInputOptions = null): Promise[js.Any] =
      futureCallbackE1[FileIOError, js.Any](fs.readFile(file, options, _))

    @inline
    def renameFuture(oldPath: String, newPath: String): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.rename(oldPath, newPath, _))

    @inline
    def realpathFuture(path: String, options: FileEncodingOptions = null): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.realpath(path, options, _))

    @inline
    def rmdirFuture(path: Buffer | String): Promise[Unit] = futureCallbackE0[FileIOError](fs.rmdir(path, _))

    @inline
    def statFuture(path: String): Promise[Stats] = futureCallbackE1[FileIOError, Stats](fs.stat(path, _))

    @inline
    def symlinkFuture(target: String | Buffer, path: String | Buffer, `type`: String = null): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.symlink(target, path, `type`, _))

    @inline
    def unlinkFuture(path: String | Buffer): Promise[Unit] = futureCallbackE0[FileIOError](fs.unlink(path, _))

    @inline
    def unwatchFile(filename: String | Buffer): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.unwatchFile(filename, _))

    @inline
    def utimes(path: String | Buffer, atime: Int, mtime: Int): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.utimes(path, atime, mtime, _))

    @inline
    def watchFuture(filename: String, options: FSWatcherOptions = null): Promise[(String, String)] =
      futureCallbackA2[String, String](fs.watch(filename, options, _))

    @inline
    def writeFileFuture(file: String, data: String | Buffer, options: FileOutputOptions = null): Promise[Unit] =
      futureCallbackE0[FileIOError](fs.writeFile(file, data, options, _))

  }

}
