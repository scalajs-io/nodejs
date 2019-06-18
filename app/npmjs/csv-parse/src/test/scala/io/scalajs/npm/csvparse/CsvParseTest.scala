package io.scalajs.npm.csvparse

import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import io.scalajs.npm.readablestream.Readable
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * CsvParse Test
  * @author lawrence.daniels@gmail.com
  */
class CsvParseTest extends FunSpec {

  describe("CsvParse") {

    it("should parse text via streaming") {
      val text =
        """|# A List of Super Heroes
           |"first", "last", "alter-ego", "votes"
           |"Bruce", "Wayne", "Batman", 1000
           |"Charles", "Xavier", "Professor X", 890
           |"Clark", "Kent", "Superman", 2000
           |"David", "Banner", "The Incredible Hulk", 1985
           |"Peter", "Parker", "The Amazing Spider-Man", 1999""".stripMargin

      val results = js.Array[js.Any]()

      val parser = CsvParse(new ParserOptions(
        comment = "#",
        auto_parse = true,
        columns = true,
        delimiter = ",",
        quote = "\"",
        relax = true,
        rowDelimiter = "\n",
        skip_empty_lines = true,
        trim = true
      ))
      parser.onData[js.Any] { data =>
        info(s"data: ${JSON.stringify(data)}")
        results.push(data)
      }

      val readable = new Readable()
      readable._read = () => {}
      readable.push(text)
      readable.push(null)
      readable.pipe(parser)

      readable.onEnd(() => {
        info(s"results = ${JSON.stringify(results, null, " ")}")

        Assert.deepEqual(results, js.Array(
          js.Dictionary("first" -> "Bruce", "last" -> "Wayne", "alter-ego" -> "Batman", "votes" -> 1000),
          js.Dictionary("first" -> "Charles", "last" -> "Xavier", "alter-ego" -> "Professor X", "votes" -> 890),
          js.Dictionary("first" -> "Clark", "last" -> "Kent", "alter-ego" -> "Superman", "votes" -> 2000),
          js.Dictionary("first" -> "David", "last" -> "Banner", "alter-ego" -> "The Incredible Hulk", "votes" -> 1985),
          js.Dictionary("first" -> "Peter", "last" -> "Parker", "alter-ego" -> "The Amazing Spider-Man", "votes" -> 1999)
        ))
      })
    }

    // TODO fix test issues

    /*
    it("should parse text asynchronously") {
      val text =
        """|"1","2","3","4"
           |"a","b","c","d"""".stripMargin

      CsvParse(text, new ParserOptions(comment = "#"), (err, output) => {
        Assert.equal(err, null, err.toJson)
        Assert.deepEqual(output, js.Array(js.Array("1", "2", "3", "4"), js.Array("a", "b", "c", "d")))
      })
    }*/

    /*
    it("should parse text asynchronously with comments") {
      val text =
        """|"a","b","c","d"
           |"1","2","3","4"
           |#This is a comment!""".stripMargin

      CsvParse(text, new ParserOptions(comment = "#"), (err, output) => {
        Assert.equal(err, null, err.toJson)
        Assert.deepEqual(output, js.Array(js.Array("a", "b", "c", "d"), js.Array("1", "2", "3", "4")))
      })
    }*/

  }

}
