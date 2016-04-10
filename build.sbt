val apiVersion = "0.1"
val paradisePluginVersion = "2.1.0"
val _scalaVersion = "2.11.8"
val scalaJsDomVersion = "0.9.0"
val scalaJsJQueryVersion = "0.9.0"

val commonSettings = Seq(
  organization := "com.github.ldaniels528",
  version := apiVersion,
  scalaVersion := _scalaVersion,
  scalacOptions ++= Seq("-feature", "-deprecation"),
  homepage := Some(url("http://github.com.ldaniels528/meansjs")),
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
    name := "meansjs",
    description := "Core utilities for MEAN.sjs"
  )

lazy val angularjs = (project in file("angularjs")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core).
  settings(commonSettings: _*).
  settings(
    name := "meansjs-angularjs",
    description := "AngularJS bindings for Scala.js"
  )

lazy val facebook = (project in file("facebook")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core, angularjs).
  settings(commonSettings: _*).
  settings(
    name := "meansjs-facebook",
    description := "Facebook buildings for Scala.js"
  )

lazy val linkedin = (project in file("linkedin")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core, angularjs).
  settings(commonSettings: _*).
  settings(
    name := "meansjs-linkedin",
    description := "LinkedIn buildings for Scala.js"
  )

lazy val nodejs = (project in file("nodejs")).
  enablePlugins(ScalaJSPlugin).
  dependsOn(core).
  settings(commonSettings: _*).
  settings(
    name := "meansjs-nodejs",
    description := "NodeJS bindings for Scala.js"
  )

// loads the MEAN.sjs "Core" project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value