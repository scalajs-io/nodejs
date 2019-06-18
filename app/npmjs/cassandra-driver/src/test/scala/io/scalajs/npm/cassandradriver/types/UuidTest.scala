package io.scalajs.npm.cassandradriver.types

import org.scalatest.FunSpec

/**
  * Uuid Tests
  * @author lawrence.daniels@gmail.com
  */
class UuidTest extends FunSpec {

  describe("Uuid") {

    it("supports fromString(...)") {
      val uuid = Uuid.fromString("980eb56a-5cf3-4136-b449-702ed72c4041")
      info(s"uuid => $uuid")
    }

    it("supports random()") {
      val uuid = Uuid.random()
      info(s"uuid => $uuid")
    }

  }

}
