import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt.Project.projectToRef
import sbt._

val apiVersion = "0.0.7"
val paradisePluginVersion = "2.1.0"
val _scalaVersion = "2.11.8"
val scalaJsDomVersion = "0.9.0"
val scalaJsJQueryVersion = "0.9.0"

val commonSettings = Seq(
  organization := "com.github.ldaniels528",
  version := apiVersion,
  scalaVersion := _scalaVersion,
  scalacOptions ++= Seq("-feature", "-deprecation"),
  homepage := Some(url("http://github.com.ldaniels528/MEANS.js")),
  addCompilerPlugin("org.scalamacros" % "paradise" % paradisePluginVersion cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    "org.scala-js" %%% "scalajs-dom" % scalaJsDomVersion,
    "org.scala-lang" % "scala-reflect" % _scalaVersion
  )
)

lazy val root = (project in file(".")).
  aggregate(core, angularjs, express, facebook, kafka_node, linkedin, mongodb, nodejs)

lazy val core = (project in file("core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means",
    description := "Core bindings for MEANS.js"
  )

lazy val angularjs = (project in file("angularjs")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs",
    description := "AngularJS bindings for Scala.js"
  )

lazy val facebook = (project in file("facebook")).
  dependsOn(core, angularjs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-facebook",
    description := "Facebook buildings for Scala.js"
  )

lazy val express = (project in file("express")).
  dependsOn(core, nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-express",
    description := "Express.js bindings for Scala.js"
  )

lazy val linkedin = (project in file("linkedin")).
  dependsOn(core, angularjs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-linkedin",
    description := "LinkedIn buildings for Scala.js"
  )

lazy val kafka_node = (project in file("kafka_node")).
  dependsOn(core, nodejs, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-kafka-node",
    description := "Kafka bindings for Scala.js"
  )

lazy val mongodb = (project in file("mongodb")).
  dependsOn(core, nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-mongodb",
    description := "MongoDB bindings for Scala.js"
  )

lazy val nodejs = (project in file("nodejs")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-nodejs",
    description := "Node.js bindings for Scala.js"
  )

lazy val node_zookeeper = (project in file("node_zookeeper")).
  dependsOn(core, nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zookeeper-client",
    description := "Zookeeper client bindings for Scala.js"
  )

lazy val examples = (project in file("examples")).
  aggregate(core, express, kafka_node, mongodb, nodejs, node_zookeeper).
  dependsOn(core, express, kafka_node, mongodb, nodejs, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-examples",
    description := "MEANS.js examples",
    pipelineStages := Seq(gzip),
    compile in Compile <<=
      (compile in Compile) dependsOn (fastOptJS in(nodejs, Compile)),
    ivyScala := ivyScala.value map (_.copy(overrideScalaVersion = true))
  )

// loads the MEANS.js "Core" project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value