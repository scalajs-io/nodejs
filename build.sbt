import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt.Project.projectToRef
import sbt._

val apiVersion = "0.1.15"
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

lazy val bundle_complete = (project in file("bundles/complete")).
  aggregate(core, core_browser, bundle_social, bundle_angular, bundle_mean_minimal, bundle_node, bundle_node_oss).
  dependsOn(core, core_browser, bundle_social, bundle_angular, bundle_mean_minimal, bundle_node, bundle_node_oss).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-bundle-complete",
    description := "MEANS.js complete platform bundle"
  )

lazy val bundle_mean_minimal = (project in file("bundles/mean_minimal")).
  aggregate(bundle_node, node_body_parser, node_express, node_express_fileupload, node_express_ws, node_mongodb).
  dependsOn(bundle_node, node_body_parser, node_express, node_express_fileupload, node_express_ws, node_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-bundle-mean-minimal",
    description := "MEANS.js MEAN stack bundle (minimal)"
  )

lazy val examples = (project in file("examples")).
  aggregate(bundle_node, bundle_node_oss).
  dependsOn(bundle_node, bundle_node_oss).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-examples",
    description := "MEANS.js Node examples",
    pipelineStages := Seq(gzip),
    compile in Compile <<=
      (compile in Compile) dependsOn (fastOptJS in(node_core, Compile)),
    ivyScala := ivyScala.value map (_.copy(overrideScalaVersion = true))
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
  aggregate(core).
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

lazy val bundle_angular = (project in file("bundles/angularjs")).
  aggregate(
    angular_core, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_nervgh_fileupload,
    angular_sanitize, angular_toaster, angular_ui_bootstrap, angular_ui_router).
  dependsOn(
    angular_core, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_nervgh_fileupload,
    angular_sanitize, angular_toaster, angular_ui_bootstrap, angular_ui_router).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-bundle-angularjs",
    description := "AngularJS Bundle for MEANS.js"
  )

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

lazy val bundle_social = (project in file("bundles/social")).
  aggregate(facebook, linkedin).
  dependsOn(facebook, linkedin).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-bundle-social",
    description := "Bundles all Social Networking APIs for MEANS.js"
  )

lazy val facebook = (project in file("social/facebook")).
  dependsOn(core).
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
  //      NodeJS platform
  /////////////////////////////////////////////////////////////////////////////////

lazy val bundle_node = (project in file("bundles/node")).
  aggregate(
    core, node_core, node_assert, node_cluster, node_crypto, node_dns, node_fs, node_global, node_http, node_https,
    node_net, node_os, node_path, node_readline, node_repl, node_stream, node_string_decoder,
    node_tty, node_url, node_util, node_vm, node_zlib).
  dependsOn(
    core, node_core, node_assert, node_cluster, node_crypto, node_dns, node_fs, node_global, node_http, node_https,
    node_net, node_os, node_path, node_readline, node_repl, node_stream, node_string_decoder,
    node_tty, node_url, node_util, node_vm, node_zlib).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-bundle-nodejs",
    description := "Bundles all Node modules for MEANS.js"
  )

lazy val node_core = (project in file("node/core")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-core",
    description := "NodeJS/Core binding for Scala.js"
  )

lazy val node_assert = (project in file("node/assert")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-assert",
    description := "NodeJS/assert binding for Scala.js"
  )

lazy val node_cluster = (project in file("node/cluster")).
  dependsOn(node_global).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-cluster",
    description := "NodeJS/cluster binding for Scala.js"
  )

lazy val node_crypto = (project in file("node/crypto")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-crypto",
    description := "NodeJS/crypto binding for Scala.js"
  )

lazy val node_dns = (project in file("node/dns")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-dns",
    description := "NodeJS/DNS binding for Scala.js"
  )

lazy val node_fs = (project in file("node/fs")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-fs",
    description := "NodeJS/fs binding for Scala.js"
  )

lazy val node_global = (project in file("node/global")).
  dependsOn(node_tty).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-global",
    description := "NodeJS/global binding for Scala.js"
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

lazy val node_net = (project in file("node/net")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-net",
    description := "NodeJS/net binding for Scala.js"
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
  dependsOn(node_stream).
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

lazy val node_stream = (project in file("node/stream")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-stream",
    description := "NodeJS/stream binding for Scala.js"
  )

lazy val node_string_decoder = (project in file("node/string_decoder")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-string-decoder",
    description := "NodeJS/string-decoder binding for Scala.js"
  )

lazy val node_tty = (project in file("node/tty")).
  dependsOn(node_net).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-tty",
    description := "NodeJS/TTY binding for Scala.js"
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

lazy val node_vm = (project in file("node/vm")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-vm",
    description := "NodeJS/VM binding for Scala.js"
  )

lazy val node_zlib = (project in file("node/zlib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zlib",
    description := "NodeJS/zlib binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NodeJS supplements (OSS packages)
/////////////////////////////////////////////////////////////////////////////////

lazy val bundle_node_oss = (project in file("bundles/node_oss")).
  aggregate(
    node_adal, node_amqplib, node_async, node_azure, node_bcrypt, node_body_parser, node_cassandra,
    node_colors, node_drama, node_elgs_splitargs, node_escape_html, node_express, node_express_fileupload,
    node_express_ws, node_filed, node_jwt_simple, node_kafka, node_mongodb, node_multer, node_mysql,
    node_oppressor, node_request, node_watch, node_xml2js, node_zookeeper).
  dependsOn(
    node_adal, node_amqplib, node_async, node_azure, node_bcrypt, node_body_parser, node_cassandra,
    node_colors, node_drama, node_elgs_splitargs, node_escape_html, node_express, node_express_fileupload,
    node_express_ws, node_filed, node_jwt_simple, node_kafka, node_mongodb, node_multer, node_mysql,
    node_oppressor, node_request, node_watch, node_xml2js, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-bundle-node-oss",
    description := "Bundles all Node modules for MEANS.js"
  )

lazy val node_adal = (project in file("node_libs/adal")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-adal-node",
    description := "NodeJS/adal-node binding for Scala.js"
  )

lazy val node_amqplib = (project in file("node_libs/amqplib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-amqplib",
    description := "NodeJS/amqplib binding for Scala.js"
  )

lazy val node_async = (project in file("node_libs/async")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-async",
    description := "NodeJS/async binding for Scala.js"
  )

lazy val node_azure = (project in file("node_libs/azure")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-azure",
    description := "NodeJS/azure binding for Scala.js"
  )

lazy val node_bcrypt = (project in file("node_libs/bcrypt")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-bcrypt",
    description := "NodeJS/bcrypt binding for Scala.js"
  )

lazy val node_body_parser = (project in file("node_libs/body-parser")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-body-parser",
    description := "NodeJS/body-parser binding for Scala.js"
  )

lazy val node_cassandra = (project in file("node_libs/cassandra")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-datastax-cassandra",
    description := "NodeJS/cassandra binding for Scala.js"
  )

lazy val node_colors = (project in file("node_libs/colors")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-colors",
    description := "NodeJS/colors binding for Scala.js"
  )

lazy val node_drama = (project in file("node_libs/drama")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-drama",
    description := "NodeJS/drama binding for Scala.js"
  )

lazy val node_elgs_splitargs = (project in file("node_libs/elgs-splitargs")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-elgs-splitargs",
    description := "NodeJS/elgs-splitargs binding for Scala.js"
  )

lazy val node_escape_html = (project in file("node_libs/escape-html")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-escape-html",
    description := "NodeJS/escape-html binding for Scala.js"
  )

lazy val node_express = (project in file("node_libs/express")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-express",
    description := "NodeJS/express binding for Scala.js"
  )

lazy val node_express_fileupload = (project in file("node_libs/express-fileupload")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-express-fileupload",
    description := "NodeJS/express-fileupload binding for Scala.js"
  )

lazy val node_express_ws = (project in file("node_libs/express-ws")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-express-ws",
    description := "NodeJS/express-ws binding for Scala.js"
  )

lazy val node_filed = (project in file("node_libs/filed")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-filed",
    description := "NodeJS/filed binding for Scala.js"
  )

lazy val node_jwt_simple = (project in file("node_libs/jwt-simple")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-jwt-simple",
    description := "NodeJS/jwt-simple binding for Scala.js"
  )

lazy val node_kafka = (project in file("node_libs/kafka_node")).
  dependsOn(node_core, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-kafkanode",
    description := "NodeJS/kafka-node binding for Scala.js"
  )

lazy val node_mongodb = (project in file("node_libs/mongodb")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-mongodb",
    description := "NodeJS/mongodb binding for Scala.js"
  )

lazy val node_multer = (project in file("node_libs/multer")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-multer",
    description := "NodeJS/multer binding for Scala.js"
  )

lazy val node_mysql = (project in file("node_libs/mysql")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-mysql",
    description := "NodeJS/mysql binding for Scala.js"
  )

lazy val node_oppressor = (project in file("node_libs/oppressor")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-oppressor",
    description := "NodeJS/oppressor binding for Scala.js"
  )

lazy val node_request = (project in file("node_libs/request")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-request",
    description := "NodeJS/request binding for Scala.js"
  )

lazy val node_watch = (project in file("node_libs/watch")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-watch",
    description := "NodeJS/watch binding for Scala.js"
  )

lazy val node_xml2js = (project in file("node_libs/xml2js")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-xml2js",
    description := "NodeJS/xml2js binding for Scala.js"
  )

lazy val node_zookeeper = (project in file("node_libs/zookeeper-client")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "means-node-zookeeper-client",
    description := "NodeJS/node-zookeeper-client binding for Scala.js"
  )

// loads the MEANS.js root project at sbt startup
onLoad in Global := (Command.process("project bundle_complete", _: State)) compose (onLoad in Global).value