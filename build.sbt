import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt.Project.projectToRef
import sbt._

val apiVersion = "0.1.12"
val paradisePluginVersion = "3.0.0-M1"
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
  testFrameworks += new TestFramework("utest.runner.Framework"),
  libraryDependencies ++= Seq(
    "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    "org.scala-js" %%% "scalajs-dom" % scalaJsDomVersion,
    "org.scala-lang" % "scala-reflect" % _scalaVersion,
    //
    // Testing dependencies
    //
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test",
    "org.mockito" % "mockito-all" % "1.9.5" % "test",
    "org.scalatest" %% "scalatest" % "2.2.2" % "test"
  )
)

lazy val means_js = (project in file(".")).
  aggregate(
    core, core_browser, facebook, linkedin,
    // angular
    angular_core, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_nervgh_fileupload,
    angular_sanitize, angular_toaster, angular_ui_bootstrap, angular_ui_router,
    // node
    node_core, node_adal, node_amqplib, node_assert, node_async, node_azure, node_bcrypt, node_body_parser,
    node_cassandra, node_colors, node_crypto, node_drama, node_escape_html, node_elgs_splitargs, node_express,
    node_express_fileupload, node_express_ws, node_filed, node_fs, node_http, node_https, node_jwt_simple,
    node_kafka, node_mongodb, node_multer, node_mysql, node_net, node_oppressor, node_os, node_path, node_readline,
    node_repl, node_request, node_string_decoder, node_url, node_util, node_watch, node_xml2js, node_zlib,
    node_zookeeper
  )

/////////////////////////////////////////////////////////////////////////////////
//      Core sub-projects
/////////////////////////////////////////////////////////////////////////////////

lazy val core = (project in file("core/util")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-core",
    description := "MEANS.js core/utilities"
  )

lazy val core_browser = (project in file("core/browser")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-core-browser",
    description := "MEANS.js core/browser"
  )

  /////////////////////////////////////////////////////////////////////////////////
  //      AngularJS sub-projects
  /////////////////////////////////////////////////////////////////////////////////

lazy val angular_core = (project in file("angularjs/core")).
  dependsOn(core_browser).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-core",
    description := "AngularJS/core binding for Scala.js"
  )

lazy val angular_anchorScroll = (project in file("angularjs/anchor-scroll")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-anchor-scroll",
    description := "AngularJS/anchorScroll binding for Scala.js"
  )

lazy val angular_animate = (project in file("angularjs/animate")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-animate",
    description := "AngularJS/animate binding for Scala.js"
  )

lazy val angular_cookies = (project in file("angularjs/cookies")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-cookies",
    description := "AngularJS/cookies binding for Scala.js"
  )

lazy val angular_facebook = (project in file("angularjs/facebook")).
  dependsOn(core, angular_core, facebook).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-facebook",
    description := "AngularJS/facebook binding for Scala.js"
  )

lazy val angular_nervgh_fileupload = (project in file("angularjs/nervgh-fileupload")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-nervgh-fileupload",
    description := "AngularJS/nervgh-fileupload binding for Scala.js"
  )

lazy val angular_sanitize = (project in file("angularjs/sanitize")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-sanitize",
    description := "AngularJS/sanitize binding for Scala.js"
  )

lazy val angular_toaster = (project in file("angularjs/toaster")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-toaster",
    description := "AngularJS/toaster binding for Scala.js"
  )

lazy val angular_ui_bootstrap = (project in file("angularjs/ui-bootstrap")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-ui-bootstrap",
    description := "AngularJS/ui-bootstrap binding for Scala.js"
  )

lazy val angular_ui_router = (project in file("angularjs/ui-router")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-angularjs-ui-router",
    description := "AngularJS/ui-router binding for Scala.js"
  )

  /////////////////////////////////////////////////////////////////////////////////
  //      Social sub-projects
  /////////////////////////////////////////////////////////////////////////////////

lazy val facebook = (project in file("social/facebook")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-social-facebook",
    description := "Social/Facebook binding for Scala.js"
  )

lazy val linkedin = (project in file("social/linkedin")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-social-linkedin",
    description := "Social/LinkedIn binding for Scala.js"
  )

  /////////////////////////////////////////////////////////////////////////////////
  //      NodeJS sub-projects
  /////////////////////////////////////////////////////////////////////////////////

lazy val node_core = (project in file("node/core")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-core",
    description := "NodeJS/Core binding for Scala.js"
  )

lazy val node_adal = (project in file("node/adal")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-adal-node",
    description := "NodeJS/adal-node binding for Scala.js"
  )

lazy val node_amqplib = (project in file("node/amqplib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-amqplib",
    description := "NodeJS/amqplib binding for Scala.js"
  )

lazy val node_assert = (project in file("node/assert")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-assert",
    description := "NodeJS/assert binding for Scala.js"
  )

lazy val node_async = (project in file("node/async")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-async",
    description := "NodeJS/async binding for Scala.js"
  )

lazy val node_azure = (project in file("node/azure")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-azure",
    description := "NodeJS/azure binding for Scala.js"
  )

lazy val node_bcrypt = (project in file("node/bcrypt")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-bcrypt",
    description := "NodeJS/bcrypt binding for Scala.js"
  )

lazy val node_body_parser = (project in file("node/body-parser")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-body-parser",
    description := "NodeJS/body-parser binding for Scala.js"
  )

lazy val node_cassandra = (project in file("node/cassandra")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-datastax-cassandra",
    description := "NodeJS/colors binding for Scala.js"
  )

lazy val node_colors = (project in file("node/colors")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-colors",
    description := "NodeJS/colors binding for Scala.js"
  )

lazy val node_crypto = (project in file("node/crypto")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-crypto",
    description := "NodeJS/crypto binding for Scala.js"
  )

lazy val node_drama = (project in file("node/drama")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-drama",
    description := "NodeJS/drama binding for Scala.js"
  )

lazy val node_elgs_splitargs = (project in file("node/elgs-splitargs")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-elgs-splitargs",
    description := "NodeJS/elgs-splitargs binding for Scala.js"
  )

lazy val node_escape_html = (project in file("node/escape-html")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-escape-html",
    description := "NodeJS/escape-html binding for Scala.js"
  )

lazy val node_express = (project in file("node/express")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-express",
    description := "NodeJS/express binding for Scala.js"
  )

lazy val node_express_fileupload = (project in file("node/express-fileupload")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-express-fileupload",
    description := "NodeJS/express-fileupload binding for Scala.js"
  )

lazy val node_express_ws = (project in file("node/express-ws")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-express-ws",
    description := "NodeJS/express-ws binding for Scala.js"
  )

lazy val node_filed = (project in file("node/filed")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-filed",
    description := "NodeJS/filed binding for Scala.js"
  )

lazy val node_fs = (project in file("node/fs")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-fs",
    description := "NodeJS/fs binding for Scala.js"
  )

lazy val node_http = (project in file("node/http")).
  dependsOn(node_net).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-http",
    description := "NodeJS/http binding for Scala.js"
  )

lazy val node_https = (project in file("node/https")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-https",
    description := "NodeJS/https binding for Scala.js"
  )

lazy val node_jwt_simple = (project in file("node/jwt-simple")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-jwt-simple",
    description := "NodeJS/jwt-simple binding for Scala.js"
  )

lazy val node_kafka = (project in file("node/kafka_node")).
  dependsOn(node_core, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-kafkanode",
    description := "NodeJS/kafka-node binding for Scala.js"
  )

lazy val node_mongodb = (project in file("node/mongodb")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-mongodb",
    description := "NodeJS/mongodb binding for Scala.js"
  )

lazy val node_multer = (project in file("node/multer")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-multer",
    description := "NodeJS/multer binding for Scala.js"
  )

lazy val node_mysql = (project in file("node/mysql")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-mysql",
    description := "NodeJS/mysql binding for Scala.js"
  )

lazy val node_net = (project in file("node/net")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-net",
    description := "NodeJS/net binding for Scala.js"
  )

lazy val node_oppressor = (project in file("node/oppressor")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-oppressor",
    description := "NodeJS/oppressor binding for Scala.js"
  )

lazy val node_os = (project in file("node/os")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-os",
    description := "NodeJS/OS binding for Scala.js"
  )

lazy val node_path = (project in file("node/path")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-path",
    description := "NodeJS/path binding for Scala.js"
  )

lazy val node_readline = (project in file("node/readline")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-readline",
    description := "NodeJS/readline binding for Scala.js"
  )

lazy val node_repl = (project in file("node/repl")).
  dependsOn(node_net, node_readline).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-repl",
    description := "NodeJS/repl binding for Scala.js"
  )

lazy val node_request = (project in file("node/request")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-request",
    description := "NodeJS/request binding for Scala.js"
  )

lazy val node_string_decoder = (project in file("node/string_decoder")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-string-decoder",
    description := "NodeJS/string-decoder binding for Scala.js"
  )

lazy val node_url = (project in file("node/url")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-url",
    description := "NodeJS/url binding for Scala.js"
  )

lazy val node_util = (project in file("node/util")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-util",
    description := "NodeJS/util binding for Scala.js"
  )

lazy val node_watch = (project in file("node/watch")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-watch",
    description := "NodeJS/watch binding for Scala.js"
  )

lazy val node_xml2js = (project in file("node/xml2js")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-xml2js",
    description := "NodeJS/xml2js binding for Scala.js"
  )

lazy val node_zlib = (project in file("node/zlib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zlib",
    description := "NodeJS/zlib binding for Scala.js"
  )

lazy val node_zookeeper = (project in file("node/zookeeper-client")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zookeeper-client",
    description := "NodeJS/node-zookeeper-client binding for Scala.js"
  )

lazy val examples = (project in file("examples")).
  aggregate(
    node_core, node_adal, node_amqplib, node_assert, node_async, node_azure, node_bcrypt, node_body_parser, node_cassandra,
    node_colors, node_crypto, node_drama, node_elgs_splitargs, node_escape_html, node_express, node_express_ws, node_filed,
    node_fs, node_http, node_https, node_jwt_simple, node_kafka, node_mongodb, node_multer, node_mysql, node_net, node_oppressor,
    node_os, node_path, node_readline, node_repl, node_request, node_string_decoder, node_url, node_util, node_watch,
    node_xml2js, node_zlib, node_zookeeper).
  dependsOn(
    node_core, node_adal, node_amqplib, node_assert, node_async, node_azure, node_bcrypt, node_body_parser, node_cassandra,
    node_colors, node_crypto, node_drama, node_elgs_splitargs, node_escape_html, node_express, node_express_ws, node_filed,
    node_fs, node_http, node_https, node_jwt_simple, node_kafka, node_mongodb, node_multer, node_mysql, node_net, node_oppressor,
    node_os, node_path, node_readline, node_repl, node_request, node_string_decoder, node_url, node_util, node_watch,
    node_xml2js, node_zlib, node_zookeeper).
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

// loads the MEANS.js root project at sbt startup
onLoad in Global := (Command.process("project means_js", _: State)) compose (onLoad in Global).value