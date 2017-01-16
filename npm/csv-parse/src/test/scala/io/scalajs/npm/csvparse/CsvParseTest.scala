package io.scalajs.npm.csvparse

import io.scalajs.JSON
import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.{Assert, console}
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * CsvParse Test
  * @author lawrence.daniels@gmail.com
  */
class CsvParseTest extends FunSpec {

  describe("CsvParse") {

    it("should parse text via streaming") {
      val parser = CsvParse(new ParserOptions(comment = "#"))
      parser.onData((data: js.Any) => console.log(s"data => ${JSON.stringify(data)}"))
      val readable = Fs.createReadStream("./npm/csv-parse/src/test/resources/heroes.txt")
      readable.pipe(parser)
    }

    it("should parse text asynchronously") {
      val text =
        """"1","2","3","4"
          |"a","b","c","d"""".stripMargin
      CsvParse(text, new ParserOptions(comment = "#"), (err, output) => {
        Assert(err == null, err)
        Assert.deepEqual(output, js.Array(js.Array("1", "2", "3", "4"), js.Array("a", "b", "c", "d")))
      })
    }

    it("should parse text asynchronously with comments") {
      val text =
        """"a","b","c","d"
          |"1","2","3","4"
          |#This is a comment!""".stripMargin
      CsvParse(text, new ParserOptions(comment = "#"), (err, output) => {
        Assert(err == null, err)
        Assert.deepEqual(output, js.Array(js.Array("a", "b", "c", "d"), js.Array("1", "2", "3", "4")))
      })
    }

  }

}
