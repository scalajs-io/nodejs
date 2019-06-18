package io.scalajs.npm.jvm

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.process
import io.scalajs.npm.jvm.File._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * Inspired by java.io.File
  * @author lawrence.daniels@gmail.com
  */
class File(path: String) extends js.Object {
  private val (parent, name) = splitPath(path)
  private val fullPath = (parent + separator + name).replaceAllLiterally(separator * 2, separator)

  /**
    * Alternate Constructor
    * @param parent the parent directory of the [[File file]]
    * @param name   the name of the [[File file]]
    */
  def this(parent: String, name: String) = this(parent + separator + name)

  def accessedTime(): js.Date = Fs.statSync(fullPath).atime

  def createdTime(): js.Date = Fs.statSync(fullPath).birthtime

  def delete(): Boolean = {
    Fs.unlinkSync(fullPath)
    exists()
  }

  override def equals(o: Any): Boolean = o.isInstanceOf[File] && o.asInstanceOf[File].fullPath == fullPath

  /**
    * Tests whether the file or directory denoted by this abstract pathname exists.
    * @return true, if the file or directory denoted by this abstract pathname exists.
    */
  def exists(): Boolean = Fs.existsSync(fullPath)

  /**
    * Returns the absolute form of this abstract pathname.
    * @return the absolute form of this abstract pathname.
    */
  def getAbsoluteFile(): File = new File(fullPath)

  /**
    * Returns the absolute form of this abstract pathname.
    * @return the absolute form of this abstract pathname.
    */
  def getAbsolutePath(): String = fullPath

  def getCanonicalFile(): File = new File(fullPath)

  def getCanonicalPath(): String = fullPath

  def getName(): String = name

  def getParent(): String = parent

  def getParentFile(): File = new File(parent)

  override def hashCode(): Int = fullPath.hashCode

  def isBlockDevice(): Boolean = Fs.statSync(fullPath).isBlockDevice()

  def isCharacterDevice(): Boolean = Fs.statSync(fullPath).isCharacterDevice()

  def isDirectory(): Boolean = Fs.statSync(fullPath).isDirectory()

  def isFile(): Boolean = Fs.statSync(fullPath).isFile()

  def isHidden(): Boolean = name.startsWith(".")

  def isSocket(): Boolean = Fs.statSync(fullPath).isSocket()

  def isSymbolicLink(): Boolean = Fs.statSync(fullPath).isSymbolicLink()

  def lastModified(): js.Date = Fs.statSync(fullPath).ctime

  def length(): Long = Fs.statSync(fullPath).size.toLong

  def list(): js.Array[String] = Fs.readdirSync(fullPath)

  def listFiles(): js.Array[File] = list().map(new File(_))

  def listFilesRecursively(): js.Array[File] = getFiles(fullPath).map(new File(_)).toJSArray

  def mkdir(): Boolean = {
    Fs.mkdirSync(fullPath)
    exists()
  }

  def mkdirs(): Boolean = {
    fullPath.split(s"[$separator]").foldLeft[String]("") { case (aggPath, child) =>
      val newPath = aggPath + separator + child
      Fs.mkdirSync(newPath)
      newPath
    }
    exists()
  }

  /**
    * Renames the file denoted by this abstract pathname.
    * @param dest the new abstract pathname for the named file
    * @return true if and only if the renaming succeeded; false otherwise
    */
  def renameTo(dest: File): Boolean = {
    Fs.renameSync(fullPath, dest.getAbsolutePath())
    dest.exists()
  }

}

/**
  * File Companion
  * @author lawrence.daniels@gmail.com
  */
object File {
  val separator: String = "/"
  val separatorChar: Char = separator.head

  private def getFiles(path: String): List[String] = Fs.statSync(path) match {
    case stat if stat.isDirectory() => Fs.readdirSync(path).toList.flatMap(subPath => getFiles(s"$path/$subPath"))
    case stat if stat.isFile() => path :: Nil
    case _ => Nil
  }

  private def splitPath(path: String): (String, String) = path.trim match {
    case s if s.endsWith(separator) => splitPath(s.dropRight(1))
    case s if s.contains(separator) =>
      val index = s.lastIndexOf(separator)
      (s.take(index), s.substring(index + 1))
    case s => (process.cwd(), s)
  }

}