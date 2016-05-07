package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.xml2js.XML2JS
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}

import scala.scalajs.js

/**
  * XML Parsing Example
  * @author lawrence.daniels@gmail.com
  */
class XMLParsingExample(bootstrap: Bootstrap) {
  import bootstrap._

  val xml2js = require[XML2JS]("xml2js")
  console.log("defaults = %j", xml2js.defaults)

  val xml = "<root>Hello xml2js!</root>"
  xml2js.parseString(xml, (err: js.Any, result: js.Any) => {
    console.dir(result)
  })

}
