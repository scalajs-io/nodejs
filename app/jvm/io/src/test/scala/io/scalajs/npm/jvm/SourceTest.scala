package io.scalajs.npm.jvm

import org.scalatest.FunSpec

class SourceTest extends FunSpec {

  describe(classOf[Source].getSimpleName) {

    it("should read a file from disk") {
      Source.fromFile(new File("package.json")).getLines foreach { line =>
        info(line)
      }
    }

  }

}
