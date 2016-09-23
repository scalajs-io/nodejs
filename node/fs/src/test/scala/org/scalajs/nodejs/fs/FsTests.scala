package org.scalajs.nodejs.fs

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import utest._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * File System (Fs) Tests
  * @author lawrence.daniels@gmail.com
  */
object FsTests extends TestSuite {
  private val fileName1 = "testfs1.data"
  private val fileName2 = "testfs2.data"
  val fs = Fs()

  override val tests = this {

    "fs should write, read, rename and delete files from disk" - {
      for {
        _ <- {
          console.log(s"Writing file $fileName1...")
          fs.writeFileFuture(fileName1, "Hello World")
        }
        data <- {
          console.log(s"Reading file $fileName1...")
          fs.readFileFuture(fileName1)
        }
        _ <- {
          console.log(s"Renaming $fileName1 to $fileName2...")
          fs.renameFuture(fileName1, fileName2)
        }
        - <- {
          console.log(s"Deleting $fileName2...")
          fs.unlinkFuture(fileName2)
        }
      } {
        console.log("Read data:", data)
        assert(data.toString == "Hello World")
      }
    }

  }

}
