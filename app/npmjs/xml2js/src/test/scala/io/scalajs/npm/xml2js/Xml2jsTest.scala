package io.scalajs.npm.xml2js

import io.scalajs.JSON
import io.scalajs.npm.xml2js.Xml2jsTest.MyObject
import io.scalajs.util.JSONHelper._
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Xml2js Tests
  * @author lawrence.daniels@gmail.com
  */
class Xml2jsTest extends FunSpec {

  describe("Xml2js") {

    it("should contain defaults") {
      info(s"defaults: ${Xml2js.defaults.toJson}")
      assert(Xml2js.defaults.nonEmpty)
    }

    it("should parse XML strings") {
      val xml = "<root>Hello xml2js!</root>"
      Xml2js.parseString[MyObject](xml, (err, result) => {
        info("results: " + JSON.stringify(result))
        assert(result.root == "Hello xml2js!")
      })
    }

  }

}

/**
  * Xml2js Test Companion
  * @author lawrence.daniels@gmail.com
  */
object Xml2jsTest {

  @js.native
  trait MyObject extends js.Object {
    var root: String = js.native
  }

}