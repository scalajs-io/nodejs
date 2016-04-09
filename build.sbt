val apiVersion = "0.2.25"
val paradisePluginVersion = "2.1.0"
val _scalaVersion = "2.11.8"
val scalaJsDomVersion = "0.9.0"
val scalaJsJQueryVersion = "0.9.0"

val commonSettings = Seq(
  organization := "com.github.ldaniels528",
  version := apiVersion,
  scalaVersion := _scalaVersion,
  scalacOptions ++= Seq("-feature", "-deprecation"),
  homepage := Some(url("http://github.com.ldaniels528/nodesjs")),
  addCompilerPlugin("org.scalamacros" % "paradise" % paradisePluginVersion cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    "org.scala-js" %%% "scalajs-dom" % scalaJsDomVersion,
    "org.scala-lang" % "scala-reflect" % _scalaVersion
  )
)

lazy val root = (project in file(".")).
  aggregate(core, angularjs, facebook, linkedin, nodejs)

lazy val core = (project in file("core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "nodesjs",
    description := "Core utilities for ScalaScript"
  )

lazy val angularjs = (project in file("angularjs")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core).
  settings(commonSettings: _*).
  settings(
    name := "nodesjs-angularjs",
    description := "AngularJS bindings for Scala.js"
  )

lazy val facebook = (project in file("facebook")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core, angularjs).
  settings(commonSettings: _*).
  settings(
    name := "nodesjs-facebook",
    description := "Facebook buildings for Scala.js"
  )

lazy val linkedin = (project in file("linkedin")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core, angularjs).
  settings(commonSettings: _*).
  settings(
    name := "nodesjs-linkedin",
    description := "LinkedIn buildings for Scala.js"
  )

lazy val nodejs = (project in file("nodejs")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core).
  settings(commonSettings: _*).
  settings(
    name := "nodesjs-nodejs",
    description := "NodeJS bindings for Scala.js"
  )

// loads the ScalaScript "Core" project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value