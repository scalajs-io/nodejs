package com.github.ldaniels528.meansjs.nodejs.mongodb

import org.scalatest.Matchers._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * MongoDB DSL Specification
  * @author lawrence.daniels@gmail.com
  */
class DSLSpec() extends FeatureSpec with GivenWhenThen with MockitoSugar {

  info("As a Mongo DSL instance")
  info("I want to be able to represent MongoDB-style queries")

  feature("Ability to generate queries containing the $elemMatch operator") {
    scenario("Generate a query containing the $elemMatch operator") {
      Given("A query containing an $elemMatch operator")
      val query = doc("students" $elemMatch doc("school" -> 102, "age" $gt 10))

      When("the query is generated")
      info(s"query = $query")

      Then("The query should match the expected value")
      query shouldBe """{ "students" : { $elemMatch { "school" : 102, "age" : { $gt : 10 } } } }"""
    }
  }

  feature("Ability to generate queries containing the $text operator") {
    scenario("Generate a query containing the $text operator") {
      Given("A query containing an $text operator")
      val query = doc($text(new TextSearchOptions(
        $search = "hello",
        $caseSensitive = true,
        $diacriticSensitive = false
      )))

      When("the query is generated")
      info(s"query = $query")

      Then("The query should match the expected value")
      query shouldBe """{ $text: { $search: "hello", $caseSensitive: true, $diacriticSensitive: false } }"""
    }
  }

}
