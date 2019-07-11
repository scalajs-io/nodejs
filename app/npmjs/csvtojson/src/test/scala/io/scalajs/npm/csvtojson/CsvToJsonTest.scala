package io.scalajs.npm.csvtojson

import io.scalajs.util.JSONHelper._
import org.scalatest.funspec.AnyFunSpec

/**
  * CsvToJson Test Suite
  * @author lawrence.daniels@gmail.com
  */
class CsvToJsonTest extends AnyFunSpec {

  describe("CsvToJson") {

    it("supports parsing CSV from a string source") {
      val csvStr =
        """1,2,3
          |4,5,6
          |7,8,9""".stripMargin

      CsvToJson(new ParsingOptions(noheader = true))
        .fromString(csvStr)
        .onCsv { csvRow =>
          // this func will be called 3 times
          info(csvRow.toJson) // => [1,2,3] , [4,5,6]  , [7,8,9]
        }
        .onDone { () =>
          // parsing finished
        }
    }

    it("supports parsing CSV from a file") {
      CsvToJson()
        .fromFile("./src/test/resources/data.csv")
        .onJson { jsonObj =>
          // combine csv header row and csv line to a json object
          // jsonObj.a ==> 1 or 4
          info(jsonObj.toJson) // => {"a":"1","b":"2","c":"3"} , {"a":"4","b":"5","c":"6"}
        }
        .onDone { () =>
          // parsing finished
        }
    }

  }

}
