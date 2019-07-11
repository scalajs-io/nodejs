package io.scalajs.npm.jvm

import org.scalatest.funspec.AnyFunSpec

class SourceTest extends AnyFunSpec {

  describe(classOf[Source].getSimpleName) {

    it("should read a file from disk") {
      Source.fromFile(new File("package.json")).getLines foreach { line =>
        info(line)
      }
    }

  }

}
