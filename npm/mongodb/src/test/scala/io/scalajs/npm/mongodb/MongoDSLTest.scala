package io.scalajs.npm.mongodb

import io.scalajs.JSON
import org.scalatest.FunSpec

/**
  * MongoDB DSL Tests
  * @author lawrence.daniels@gmail.com
  */
class MongoDSLTest extends FunSpec {

  describe("MongoDB-DSL") {

    it("has the ability to generate queries containing the $elemMatch operator") {
      val query = doc("students" $elemMatch doc("school" -> 102, "age" $gt 10))
      assert(JSON.stringify(query) == """{"students":{"$elemMatch":{"school":102,"age":{"$gt":10}}}}""")
    }

    it("can generate a query containing the $text operator") {
      val query = doc(
        $text(
          new TextSearchOptions(
            $search = "hello",
            $caseSensitive = true,
            $diacriticSensitive = false
          )))
      assert(
        JSON.stringify(query) == """{"$text":{"$search":"hello","$caseSensitive":true,"$diacriticSensitive":false}}""")
    }

  }

}
