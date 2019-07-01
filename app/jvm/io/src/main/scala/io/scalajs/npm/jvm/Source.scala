package io.scalajs.npm.jvm

import io.scalajs.nodejs.fs.Fs
import io.scalajs.npm.syncrequest.SyncRequest

import scala.scalajs.js

/**
  * Inspired by scala.io.Source
  * @author lawrence.daniels@gmail.com
  */
trait Source extends js.Object {

  def getLines: Iterator[String]

  def mkString: String

}

/**
  * Source Companion
  * @author lawrence.daniels@gmail.com
  */
object Source {

  def fromFile(file: File): Source = new FileSource(file.getAbsolutePath())

  def fromFile(path: String): Source = new FileSource(path)

  def fromString(content: String): Source = new StringSource(content)

  def fromURL(url: String): Source = new URLSource(url)

  /**
    * Represents a File-based Source
    * @param path the path of the [[File]]
    */
  class FileSource(path: String) extends Source {

    override def getLines: Iterator[String] = mkString.split('\n').toIterator

    override def mkString: String = Fs.readFileSync(path).toString("utf8")

    override def toString: String = mkString
  }

  /**
    * Represents a String-based Source
    * @param content the string's content
    */
  class StringSource(content: String) extends Source {

    override def getLines: Iterator[String] = mkString.split('\n').toIterator

    override def mkString: String = content

    override def toString: String = mkString
  }

  /**
    * Represents a URL-based Source
    * @param url the given URL
    */
  class URLSource(url: String) extends Source {

    override def getLines: Iterator[String] = mkString.split('\n').toIterator

    override def mkString: String = SyncRequest(method = "GET", url).getBody()

    override def toString: String = mkString
  }

}
