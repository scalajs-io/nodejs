import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.{libraryDependencies, _}
import sbt.Project.projectToRef
import sbt._

import scala.language.postfixOps

val apiVersion = "0.3.0.4-SNAPSHOT"
val scalaJsVersion = "2.12.1"

organization := "io.scalajs"

homepage := Some(url("https://github.com/ldaniels528/scalajs.io"))

val commonSettings = Seq(
  scalaVersion := scalaJsVersion,
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-Xlint"),
  scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
  autoCompilerPlugins := true,
  scalaJSModuleKind := ModuleKind.CommonJSModule,
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaJsVersion,
    "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
  ))

/////////////////////////////////////////////////////////////////////////////////
//      Core Modules
/////////////////////////////////////////////////////////////////////////////////

lazy val core = (project in file("core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "core",
    version := apiVersion,
    organization := "io.scalajs",
    description := "ScalaJs.io core classes and utilities"
  )

lazy val dom_html = (project in file("dom_html")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "dom-html",
    version := apiVersion,
    organization := "io.scalajs",
    description := "Scala.js DOM/HTML"
  )

lazy val nodejs = (project in file("nodejs")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "nodejs",
    version := apiVersion,
    organization := "io.scalajs",
    description := "NodeJS bindings for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Bundles
/////////////////////////////////////////////////////////////////////////////////

lazy val bundle_complete = (project in file("bundles/complete")).
  dependsOn(core, dom_html, nodejs).
  aggregate(core, dom_html, nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(publishingSettings: _*).
  settings(
    name := "complete-platform",
    organization := "io.scalajs",
    description := "Complete platform bundle"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Publishing
/////////////////////////////////////////////////////////////////////////////////

lazy val publishingSettings = Seq(
  sonatypeProfileName := "org.xerial",
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
    <url>https://github.com/ldaniels528/scalajs-node-npm</url>
      <licenses>
        <license>
          <name>MIT License</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:github.com/ldaniels528/scalajs-node-npm.git</connection>
        <developerConnection>scm:git:git@github.com:ldaniels528/scalajs-node-npm.git</developerConnection>
        <url>github.com/ldaniels528/scalajs-node-npm.git</url>
      </scm>
      <developers>
        <developer>
          <id>ldaniels528</id>
          <name>Lawrence Daniels</name>
          <email>lawrence.daniels@gmail.com</email>
          <organization>io.scalajs</organization>
          <organizationUrl>https://github.com/ldaniels528</organizationUrl>
          <roles>
            <role>Project-Administrator</role>
            <role>Developer</role>
          </roles>
          <timezone>+7</timezone>
        </developer>
      </developers>
)

// loads the Scalajs-io root project at sbt startup
onLoad in Global := (Command.process("project bundle_complete", _: State)) compose (onLoad in Global).value