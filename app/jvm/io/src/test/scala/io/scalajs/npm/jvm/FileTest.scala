package io.scalajs.npm.jvm

import org.scalatest.FunSpec

/**
  * File Test Suite
  * @author lawrence.daniels@gmail.com
  */
class FileTest extends FunSpec {

  describe(classOf[File].getSimpleName) {

    it("should list files within the current directory") {
      val directory = new File(".")
      directory.listFiles().take(5) foreach { file =>
        info("*" * 40)
        show(file)
      }
    }

  }

  def show(file: File): Unit = {
    info(s"getCanonicalPath : ${file.getCanonicalPath()}")
    info(s"getParent : ${file.getParent()}")
    info(s"canExecute : ${file.canExecute()}")
    info(s"canRead : ${file.canRead()}")
    info(s"canWrite : ${file.canWrite()}")
    info(s"isDirectory : ${file.isDirectory()}")
    info(s"isFile : ${file.isFile()}")
    info(s"isHidden : ${file.isHidden()}")
    info(s"isSymbolicLink : ${file.isSymbolicLink()}")
    info(s"createdTime : ${file.createdTime()}")
    info(s"lastModified : ${file.lastModified()}")
    info(s"accessedTime : ${file.accessedTime()}")
    info(s"length : ${file.length()} bytes")
  }

}
