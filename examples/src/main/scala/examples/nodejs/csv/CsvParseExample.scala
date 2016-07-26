package examples.nodejs.csv

import examples.nodejs.libs.btd.Should
import examples.nodejs.libs.btd.Should._
import org.scalajs.nodejs._
import org.scalajs.nodejs.csvparse._

import scala.scalajs.js

/**
  * Csv-Parse Example
  * @author lawrence.daniels@gmail.com
  */
class CsvParseExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  def example1() = {
    val parse = CsvParse() // require("csv-parse")
    Should() // require("should")

    val input = """#Welcome\n"1","2","3","4"\n"a","b","c","d""""
    parse(input, new CsvParseOptions(comment = "#"), (err: errors.Error, output: js.Object) => {
      output.should.eql(js.Array(js.Array("1", "2", "3", "4"), js.Array("a", "b", "c", "d")))
    })
  }

}
