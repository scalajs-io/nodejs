package io.scalajs.npm.filed

import org.scalatest.funspec.AnyFunSpec

/**
  * Filed Tests
  * @author lawrence.daniels@gmail.com
  */
class FiledTest extends AnyFunSpec {
  val fileA = "./src/test/resources/fileA.txt"
  val fileB = "./src/test/resources/fileB.txt"
  val message = "Hello World"

  describe("Filed") {

    // TODO fix test issues

    /*
      it("can faciliate writing directly to files") {
        val f = Filed("./temp/newfile")
        f.write("test")
        f.end()
      }

      it("can pipe data from one stream to another") {
        info(s"Writing '$message' to Filed('$fileA')...")
        Fs.writeFileSync(fileA, message)

        info(s"Piping Filed('$fileA') to Filed('$fileB')...")
        Filed(fileA).pipe(Filed(fileB)).onEnd { () =>
          info(s"Verifying that Filed('$fileA') is identical to Filed('$fileB')")
          Assert.equal(Fs.readFileSync(fileB).toString(), message)
        }
      }*/

  }

}
