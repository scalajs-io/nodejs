package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.funspec.AnyFunSpec

/**
  * Integer Tests
  * @author lawrence.daniels@gmail.com
  */
class IntegerTest extends AnyFunSpec {

  describe("Integer") {

    it("can be created from a buffer") {
      val number = Integer.fromBuffer(Buffer.alloc(4, "1"))
      info(s"number => $number")
    }

  }

}
