package org.scalajs.nodejs.xml2js

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.console
import org.scalajs.sjs.JSONHelper._
import utest._

import scala.scalajs.js

/**
  * xml2js Tests
  * @author lawrence.daniels@gmail.com
  */
object XML2JSTests extends TestSuite {

  override val tests = this {

    "xml2js.parseString" - {
      val xml2js = XML2JS()
      console.log("defaults:", xml2js.defaults.toJson)

      val xml = "<root>Hello xml2js!</root>"
      xml2js.parseString(xml, (err: js.Any, result: js.Any) => {
        console.dir(result)
      })
    }

  }

}
