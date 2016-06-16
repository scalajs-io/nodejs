package examples.nodejs.io

import org.scalajs.nodejs.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.xml2js.XML2JS

import scala.scalajs.js

/**
  * XML Parsing Example
  * @author lawrence.daniels@gmail.com
  */
class XMLParsingExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val xml2js = XML2JS()
  console.log("defaults = %j", xml2js.defaults)

  val xml = "<root>Hello xml2js!</root>"
  xml2js.parseString(xml, (err: js.Any, result: js.Any) => {
    console.dir(result)
  })

}
