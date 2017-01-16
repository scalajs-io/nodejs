package io.scalajs.npm.cassandradriver.types

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * TimeUuid Tests
  * @author lawrence.daniels@gmail.com
  */
class TimeUuidTest extends FunSpec {

  describe("TimeUuid") {

    it("supports fromDate(...)") {
      val timeUuid = TimeUuid.fromDate(new js.Date())
      info(s"timeUuid => $timeUuid")
    }

    it("supports fromString(...)") {
      val timeUuid = TimeUuid.fromString("980eb56a-5cf3-4136-b449-702ed72c4041")
      info(s"timeUuid => $timeUuid")
    }

    it("supports now()") {
      val timeUuid = TimeUuid.now()
      info(s"timeUuid => $timeUuid")
    }

  }

}