package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.console
import utest._

/**
  * MongoDB DSL Specification
  * @author lawrence.daniels@gmail.com
  */
object MongoDBTests extends TestSuite {

  override val tests = this {

    console.log("As a Mongo DSL instance")
    console.log("I want to be able to represent MongoDB-style queries")

    "Ability to generate queries containing the $elemMatch operator" - {
      val query = doc("students" $elemMatch doc("school" -> 102, "age" $gt 10))

      console.log("When: the query is generated")
      console.log(s"query = $query")

      console.log("Then: The query should match the expected value")
      assert(query.toString == """{ "students" : { $elemMatch { "school" : 102, "age" : { $gt : 10 } } } }""")
    }

    "Generate a query containing the $text operator" - {
      val query = doc($text(new TextSearchOptions(
        $search = "hello",
        $caseSensitive = true,
        $diacriticSensitive = false
      )))

      console.log(s"query = $query")

      assert(query.toString == """{ $text: { $search: "hello", $caseSensitive: true, $diacriticSensitive: false } }""")
    }

    1
  }

}
