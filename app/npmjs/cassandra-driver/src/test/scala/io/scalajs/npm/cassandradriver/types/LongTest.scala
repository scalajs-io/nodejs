package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.FunSpec

/**
  * Long Tests
  * @author lawrence.daniels@gmail.com
  */
class LongTest extends FunSpec {

  describe("Long") {

    it("can be created from a buffer") {
      val number = Long.fromBuffer(Buffer.alloc(8, "1"))
      info(s"number => $number")
    }

    it("has a MAX_VALUE") {
      info(s"MAX_VALUE => ${Long.MAX_VALUE}")
    }

    it("has a MIN_VALUE") {
      info(s"MIN_VALUE => ${Long.MIN_VALUE}")
    }

    it("has a MAX_UNSIGNED_VALUE") {
      info(s"MAX_UNSIGNED_VALUE => ${Long.MAX_UNSIGNED_VALUE}")
    }

  }

}
