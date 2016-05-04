import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt.Project.projectToRef
import sbt._

val apiVersion = "0.1.4"
val paradisePluginVersion = "2.1.0"
val _scalaVersion = "2.11.8"
val scalaJsDomVersion = "0.9.0"
val scalaJsJQueryVersion = "0.9.0"

val commonSettings = Seq(
  organization := "com.github.ldaniels528",
  version := apiVersion,
  scalaVersion := _scalaVersion,
  scalacOptions ++= Seq("-feature", "-deprecation"),
  scalacOptions in(Compile, doc) ++= Seq(
    "-no-link-warnings" // Suppresses problems with Scaladoc @throws links
  ),
  homepage := Some(url("http://github.com.ldaniels528/MEANS.js")),
  addCompilerPlugin("org.scalamacros" % "paradise" % paradisePluginVersion cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    "org.scala-js" %%% "scalajs-dom" % scalaJsDomVersion,
    "org.scala-lang" % "scala-reflect" % _scalaVersion,
    //
    // Testing dependencies
    //
    "org.mockito" % "mockito-all" % "1.9.5" % "test",
    "org.scalatest" %% "scalatest" % "2.2.2" % "test"
  )
)

lazy val root = (project in file(".")).
  aggregate(
    core, angularjs, facebook, linkedin,
    node_core, node_elgs_splitargs, node_express, node_filed, node_kafka, node_mongodb, node_oppressor,
    node_os, node_repl, node_request, node_string_decoder, node_xml2js, node_zlib, node_zookeeper
  )

lazy val core = (project in file("core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-core",
    description := "MEANS.js core utilities"
  )

lazy val angularjs = (project in file("angularjs")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs",
    description := "AngularJS facade for Scala.js"
  )

lazy val facebook = (project in file("social/facebook")).
  dependsOn(core, angularjs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-social-facebook",
    description := "Social/Facebook facade for Scala.js"
  )

lazy val linkedin = (project in file("social/linkedin")).
  dependsOn(core, angularjs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-social-linkedin",
    description := "Social/LinkedIn facade for Scala.js"
  )

lazy val node_core = (project in file("node/core")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-core",
    description := "NodeJS/Core facade for Scala.js"
  )

lazy val node_elgs_splitargs = (project in file("node/elgs-splitargs")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-elgs-splitargs",
    description := "NodeJS/elgs-splitargs facade for Scala.js"
  )

lazy val node_express = (project in file("node/express")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-express",
    description := "NodeJS/Express facade for Scala.js"
  )

lazy val node_filed = (project in file("node/filed")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-filed",
    description := "NodeJS/filed facade for Scala.js"
  )

lazy val node_kafka = (project in file("node/kafka_node")).
  dependsOn(core, node_core, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-kafkanode",
    description := "NodeJS/Kafka facade for Scala.js"
  )

lazy val node_mongodb = (project in file("node/mongodb")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-mongodb",
    description := "NodeJS/MongoDB facade for Scala.js"
  )

lazy val node_oppressor = (project in file("node/oppressor")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-oppressor",
    description := "NodeJS/oppressor facade for Scala.js"
  )

lazy val node_os = (project in file("node/os")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-os",
    description := "NodeJS/OS facade for Scala.js"
  )

lazy val node_repl = (project in file("node/repl")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-repl",
    description := "NodeJS/REPL facade for Scala.js"
  )

lazy val node_request = (project in file("node/request")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-request",
    description := "NodeJS/Request facade for Scala.js"
  )

lazy val node_string_decoder = (project in file("node/string_decoder")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-string-decoder",
    description := "NodeJS/REPL facade for Scala.js"
  )

lazy val node_xml2js = (project in file("node/xml2js")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-xml2js",
    description := "NodeJS/xml2js facade for Scala.js"
  )

lazy val node_zlib = (project in file("node/zlib")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zlib",
    description := "NodeJS/Zlib facade for Scala.js"
  )

lazy val node_zookeeper = (project in file("node/node_zookeeper")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zookeeper-client",
    description := "NodeJS/Zookeeper-client facade for Scala.js"
  )

lazy val examples = (project in file("examples")).
  aggregate(
    core, node_core, node_elgs_splitargs, node_express, node_filed, node_kafka, node_mongodb, node_oppressor,
    node_os, node_repl, node_request, node_string_decoder, node_xml2js, node_zlib, node_zookeeper).
  dependsOn(
    core, node_core, node_elgs_splitargs, node_express, node_filed, node_kafka, node_mongodb, node_oppressor,
    node_os, node_repl, node_request, node_string_decoder, node_xml2js, node_zlib, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-examples",
    description := "MEANS.js examples",
    pipelineStages := Seq(gzip),
    compile in Compile <<=
      (compile in Compile) dependsOn (fastOptJS in(node_core, Compile)),
    ivyScala := ivyScala.value map (_.copy(overrideScalaVersion = true))
  )

// loads the MEANS.js "Core" project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value