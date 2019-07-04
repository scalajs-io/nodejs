package io.scalajs.npm.jvm

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.path.Path
import io.scalajs.npm.jvm.File._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * Inspired by java.io.File
  * @see [[https://docs.oracle.com/javase/10/docs/api/java/io/File.html]]
  * @author lawrence.daniels@gmail.com
  */
class File(path: String) extends js.Object {
  private val (parent, name) = (Path.dirname(path), Path.basename(path))
  private val fullPath = (parent + separator + name).replaceAllLiterally(separator * 2, separator)

  /**
    * Alternate Constructor
    * @param parent the parent directory of the [[String file]]
    * @param name   the name of the [[String file]]
    */
  def this(parent: String, name: String) = this(parent + separator + name)

  /**
    * Alternate Constructor
    * @param parent the parent directory of the [[File file]]
    * @param name   the name of the [[File file]]
    */
  def this(parent: File, name: String) = this(parent.getAbsolutePath() + separator + name)

  def accessedTime(): js.Date = Fs.statSync(fullPath).atime

  /**
    * Tests whether the application can execute the file denoted by this abstract pathname.
    */
  def canExecute(): Boolean = (Fs.statSync(path).mode & 0x01) > 0 // mask rwx => 001b = 1h

  /**
    * Tests whether the application can read the file denoted by this abstract pathname.
    */
  def canRead(): Boolean = (Fs.statSync(path).mode & 0x04) > 0 // mask rwx => 100b = 04h

  /**
    * Tests whether the application can modify the file denoted by this abstract pathname.
    */
  def canWrite(): Boolean = (Fs.statSync(path).mode & 0x02) > 0 // mask rwx => 010b = 02h

  /**
    * Compares two abstract pathnames lexicographically. The ordering defined by this method depends upon the
    * underlying system. On UNIX systems, alphabetic case is significant in comparing pathnames;
    * on Microsoft Windows systems it is not.
    * @param pathname The abstract pathname to be compared to this abstract pathname
    * @return Zero if the argument is equal to this abstract pathname, a value less than zero if this abstract pathname
    *         is lexicographically less than the argument, or a value greater than zero if this abstract pathname is
    *         lexicographically greater than the argument
    */
  def compareTo​(pathname: File): Int = pathname.fullPath.compareTo(fullPath)

  /**
    * Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.
    */
  def createNewFile(): Boolean = {
    val alreadyExists = exists()
    if (!alreadyExists) Fs.writeFileSync(fullPath, "")
    !alreadyExists
  }

  def createdTime(): js.Date = Fs.statSync(fullPath).birthtime

  /**
    * Deletes the file or directory denoted by this abstract pathname. If this pathname denotes a directory,
    * then the directory must be empty in order to be deleted.
    * Note that the Files class defines the delete method to throw an IOException when a file cannot be deleted.
    * This is useful for error reporting and to diagnose why a file cannot be deleted.
    * @return true if and only if the file or directory is successfully deleted; false otherwise
    */
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

  /**
    * Tests whether this abstract pathname is absolute.
    */
  def isAbsolute(): Boolean = fullPath.startsWith(separator)

  def isBlockDevice(): Boolean = Fs.statSync(fullPath).isBlockDevice()

  def isCharacterDevice(): Boolean = Fs.statSync(fullPath).isCharacterDevice()

  def isDirectory(): Boolean = Fs.statSync(fullPath).isDirectory()

  def isFile(): Boolean = Fs.statSync(fullPath).isFile()

  def isHidden(): Boolean = name.startsWith(".")

  def isSocket(): Boolean = Fs.statSync(fullPath).isSocket()

  def isSymbolicLink(): Boolean = Fs.statSync(fullPath).isSymbolicLink()

  def lastModified(): js.Date = Fs.statSync(fullPath).ctime

  def length(): Long = Fs.statSync(fullPath).size.toLong

  def list(): js.Array[String] = Fs.readdirSync[String](fullPath)

  /**
    * Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname
    * that satisfy the specified filter. The behavior of this method is the same as that of the list() method, except
    * that the strings in the returned array must satisfy the filter. If the given filter is null then all names are
    * accepted. Otherwise, a name satisfies the filter if and only if the value true results when the
    * FilenameFilter.accept(File, String) method of the filter is invoked on this abstract pathname and
    * the name of a file or directory in the directory that it denotes.
    * @param filter A [[FilenameFilter filename filter]]
    * @return An array of strings naming the files and directories in the directory denoted by this abstract pathname
    *         that were accepted by the given filter. The array will be empty if the directory is empty or if no names
    *         were accepted by the filter. Returns null if this abstract pathname does not denote a directory, or if
    *         an I/O error occurs.
    */
  def list​(filter: FilenameFilter): js.Array[String] =
    listFiles().filter(f => filter.accept​(dir = f.getParentFile(), name = f.getName())).map(_.getName())

  def listFiles(): js.Array[File] = list().map(new File(_))

  /**
    * Returns an array of abstract pathnames denoting the files and directories in the directory denoted by this
    * abstract pathname that satisfy the specified filter.
    * @param filter A [[FileFilter file filter]]
    * @return An array of abstract pathnames denoting the files and directories in the directory denoted by this
    *         abstract pathname. The array will be empty if the directory is empty. Returns null if this abstract
    *         pathname does not denote a directory, or if an I/O error occurs.
    */
  def listFiles​(filter: FileFilter): js.Array[File] = listFiles().filter(filter.accept​)

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
  val separator: String = Path.sep
  val separatorChar: Char = separator.head

  /**
    * List the available filesystem roots.
    */
  def listRoots(): js.Array[File] = Fs.readdirSync[String](path = separator).map(path => new File(path))

  private def getFiles(path: String): List[String] = Fs.statSync(path) match {
    case stat if stat.isDirectory() => Fs.readdirSync[String](path).toList.flatMap(subPath => getFiles(s"$path/$subPath"))
    case stat if stat.isFile() => path :: Nil
    case _ => Nil
  }

}