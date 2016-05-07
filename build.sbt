import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt.Project.projectToRef
import sbt._

val apiVersion = "0.1.5"
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
    core, facebook, linkedin,
    angular_core, angular_animate, angular_facebook, angular_nervgh_fileupload, angular_toaster,
    angular_ui_bootstrap, angular_ui_router,
    node_core, node_async, node_bcrypt, node_crypto, node_elgs_splitargs, node_express, node_filed, node_jwt_simple,
    node_kafka, node_mongodb, node_oppressor, node_os, node_repl, node_request, node_string_decoder,
    node_xml2js, node_zlib, node_zookeeper
  )

lazy val core = (project in file("core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-core",
    description := "MEANS.js core utilities"
  )

lazy val angular_core = (project in file("angularjs/core")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-core",
    description := "AngularJS facade for Scala.js"
  )

lazy val angular_animate = (project in file("angularjs/animate")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-animate",
    description := "AngularJS facade for Scala.js"
  )

lazy val angular_facebook = (project in file("angularjs/facebook")).
  dependsOn(core, angular_core, facebook).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-facebook",
    description := "AngularJS facebook facade for Scala.js"
  )

lazy val angular_nervgh_fileupload = (project in file("angularjs/nervgh-fileupload")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-nervgh-fileupload",
    description := "AngularJS/nervgh-fileupload facade for Scala.js"
  )

lazy val angular_toaster = (project in file("angularjs/toaster")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-toaster",
    description := "AngularJS/toaster facade for Scala.js"
  )

lazy val angular_ui_bootstrap = (project in file("angularjs/ui-bootstrap")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-ui-bootstrap",
    description := "AngularJS/ui-bootstrap facade for Scala.js"
  )

lazy val angular_ui_router = (project in file("angularjs/ui-router")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-ui-router",
    description := "AngularJS/ui-router facade for Scala.js"
  )

lazy val facebook = (project in file("social/facebook")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-social-facebook",
    description := "Social/Facebook facade for Scala.js"
  )

lazy val linkedin = (project in file("social/linkedin")).
  dependsOn(core).
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

lazy val node_async = (project in file("node/async")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-async",
    description := "NodeJS/async facade for Scala.js"
  )

lazy val node_bcrypt = (project in file("node/bcrypt")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-bcrypt",
    description := "NodeJS/bcrypt facade for Scala.js"
  )

lazy val node_crypto = (project in file("node/crypto")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-crypto",
    description := "NodeJS/crypto facade for Scala.js"
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
    description := "NodeJS/express facade for Scala.js"
  )

lazy val node_filed = (project in file("node/filed")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-filed",
    description := "NodeJS/filed facade for Scala.js"
  )

lazy val node_jwt_simple = (project in file("node/jwt-simple")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-jwt-simple",
    description := "NodeJS/jwt-simple facade for Scala.js"
  )

lazy val node_kafka = (project in file("node/kafka_node")).
  dependsOn(core, node_core, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-kafkanode",
    description := "NodeJS/kafka-node facade for Scala.js"
  )

lazy val node_mongodb = (project in file("node/mongodb")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-mongodb",
    description := "NodeJS/mongodb facade for Scala.js"
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
    description := "NodeJS/os facade for Scala.js"
  )

lazy val node_repl = (project in file("node/repl")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-repl",
    description := "NodeJS/repl facade for Scala.js"
  )

lazy val node_request = (project in file("node/request")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-request",
    description := "NodeJS/request facade for Scala.js"
  )

lazy val node_string_decoder = (project in file("node/string_decoder")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-string-decoder",
    description := "NodeJS/string-decoder facade for Scala.js"
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
    description := "NodeJS/zlib facade for Scala.js"
  )

lazy val node_zookeeper = (project in file("node/zookeeper-client")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zookeeper-client",
    description := "NodeJS/node-zookeeper-client facade for Scala.js"
  )

lazy val examples = (project in file("examples")).
  aggregate(
    core, node_core, node_async, node_bcrypt, node_crypto, node_elgs_splitargs, node_express, node_filed, node_jwt_simple, node_kafka,
    node_mongodb, node_oppressor, node_os, node_repl, node_request, node_string_decoder, node_xml2js, node_zlib, node_zookeeper).
  dependsOn(
    core, node_core, node_async, node_bcrypt, node_crypto, node_elgs_splitargs, node_express, node_filed, node_jwt_simple, node_kafka,
    node_mongodb, node_oppressor, node_os, node_repl, node_request, node_string_decoder, node_xml2js, node_zlib, node_zookeeper).
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