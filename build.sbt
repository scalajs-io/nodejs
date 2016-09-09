import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt.Project.projectToRef
import sbt._

val apiVersion = "0.2.2.4"

val paradisePluginVersion = "3.0.0-M1"
val _scalaVersion = "2.11.8"
val scalaJsDomVersion = "0.9.0"
val scalaJsJQueryVersion = "0.9.0"
val scalaJsSelenium = "0.1.3"

scalaJSUseRhino in Global := false

val commonSettings = Seq(
  organization := "com.github.ldaniels528",
  version := apiVersion,
  scalaVersion := _scalaVersion,
  scalacOptions ++= Seq("-feature", "-deprecation"),
  scalacOptions in(Compile, doc) ++= Seq(
    "-no-link-warnings" // Suppresses problems with Scaladoc @throws links
  ),
  homepage := Some(url("https://github.com/ldaniels528/scalajs-nodejs")),
  addCompilerPlugin("org.scalamacros" % "paradise" % paradisePluginVersion cross CrossVersion.full),
  testFrameworks += new TestFramework("utest.runner.Framework"),
  libraryDependencies ++= Seq(
    "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    "org.scala-js" %%% "scalajs-dom" % scalaJsDomVersion,
    "org.scala-js" %% "scalajs-env-selenium" % scalaJsSelenium,
    "org.scala-lang" % "scala-reflect" % _scalaVersion,
    //
    // Testing dependencies
    //
    "com.lihaoyi" %%% "utest" % "0.4.3" % "test",
    "org.mockito" % "mockito-all" % "1.9.5" % "test",
    "org.scalatest" %% "scalatest" % "2.2.2" % "test"
  )
)

lazy val bundle_complete = (project in file("bundles/complete")).
  aggregate(core, browser_core, bundle_canvas, bundle_social, bundle_angular, bundle_mean_minimal, bundle_node, bundle_node_oss).
  dependsOn(core, browser_core, bundle_canvas, bundle_social, bundle_angular, bundle_mean_minimal, bundle_node, bundle_node_oss).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(publishingSettings: _*).
  settings(
    name := "scalajs-nodejs-complete-bundle",
    description := "Complete platform bundle"
  )

lazy val bundle_mean_minimal = (project in file("bundles/mean_minimal")).
  aggregate(bundle_node, node_body_parser, node_express, node_express_fileupload, node_express_ws, node_mongodb).
  dependsOn(bundle_node, node_body_parser, node_express, node_express_fileupload, node_express_ws, node_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-mean-bundle-minimal",
    description := "MEAN stack bundle (minimal)"
  )

lazy val examples = (project in file("examples")).
  aggregate(bundle_node, bundle_node_oss).
  dependsOn(bundle_node, bundle_node_oss).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-examples",
    description := "Node.js examples",
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
    name := "scalajs-common",
    description := "Scala.js common/utilities"
  )

lazy val browser_core = (project in file("browser/common")).
  aggregate(core).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-browser-core",
    description := "Scala.js browser/DOM bindings"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Canvas sub-projects
/////////////////////////////////////////////////////////////////////////////////

lazy val bundle_canvas = (project in file("bundles/canvas")).
  aggregate(browser_core, pixijs, phaser).
  dependsOn(browser_core, pixijs, phaser).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-bundle-canvas",
    description := "Scala.js 2D bindings bundle"
  )

lazy val phaser = (project in file("browser/phaser")).
  dependsOn(browser_core, pixijs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-canvas-phaser",
    description := "Scala.js Phaser 3.x bindings"
  )

lazy val pixijs = (project in file("browser/pixijs")).
  dependsOn(browser_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-canvas-pixijs",
    description := "Scala.js PIXI.js bindings"
  )

  /////////////////////////////////////////////////////////////////////////////////
  //      AngularJS sub-projects
  /////////////////////////////////////////////////////////////////////////////////

lazy val bundle_angular = (project in file("bundles/angularjs")).
  aggregate(
    angular_core, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_md5,
    angular_nervgh_fileupload, angular_sanitize, angular_toaster, angular_ui_bootstrap, angular_ui_router).
  dependsOn(
    angular_core, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_md5,
    angular_nervgh_fileupload, angular_sanitize, angular_toaster, angular_ui_bootstrap, angular_ui_router).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-bundle",
    description := "AngularJS Bundle"
  )

lazy val angular_core = (project in file("angularjs/core")).
  dependsOn(browser_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-core",
    description := "AngularJS/core binding for Scala.js"
  )

lazy val angular_anchorScroll = (project in file("angularjs/anchor-scroll")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-anchor-scroll",
    description := "AngularJS/anchorScroll binding for Scala.js"
  )

lazy val angular_animate = (project in file("angularjs/animate")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-animate",
    description := "AngularJS/animate binding for Scala.js"
  )

lazy val angular_cookies = (project in file("angularjs/cookies")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-cookies",
    description := "AngularJS/cookies binding for Scala.js"
  )

lazy val angular_facebook = (project in file("angularjs/facebook")).
  dependsOn(core, angular_core, facebook).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-facebook",
    description := "AngularJS/facebook binding for Scala.js"
  )

lazy val angular_md5 = (project in file("angularjs/md5")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-md5",
    description := "AngularJS/md5 binding for Scala.js"
  )

lazy val angular_nervgh_fileupload = (project in file("angularjs/nervgh-fileupload")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-nervgh-fileupload",
    description := "AngularJS/nervgh-fileupload binding for Scala.js"
  )

lazy val angular_sanitize = (project in file("angularjs/sanitize")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-sanitize",
    description := "AngularJS/sanitize binding for Scala.js"
  )

lazy val angular_toaster = (project in file("angularjs/toaster")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-toaster",
    description := "AngularJS/toaster binding for Scala.js"
  )

lazy val angular_ui_bootstrap = (project in file("angularjs/ui-bootstrap")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-ui-bootstrap",
    description := "AngularJS/ui-bootstrap binding for Scala.js"
  )

lazy val angular_ui_router = (project in file("angularjs/ui-router")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-ui-router",
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
    name := "scalajs-bundle-social",
    description := "Bundles all Social Networking APIs"
  )

lazy val facebook = (project in file("social/facebook")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-social-facebook",
    description := "Social/Facebook binding for Scala.js"
  )

lazy val linkedin = (project in file("social/linkedin")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-social-linkedin",
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
    name := "scalajs-nodejs-bundle",
    description := "Bundles all Node modules"
  )

lazy val node_core = (project in file("node/core")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-core",
    description := "NodeJS/Core binding for Scala.js"
  )

lazy val node_assert = (project in file("node/assert")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-assert",
    description := "NodeJS/assert binding for Scala.js"
  )

lazy val node_cluster = (project in file("node/cluster")).
  dependsOn(node_global).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-cluster",
    description := "NodeJS/cluster binding for Scala.js"
  )

lazy val node_crypto = (project in file("node/crypto")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-crypto",
    description := "NodeJS/crypto binding for Scala.js"
  )

lazy val node_dns = (project in file("node/dns")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-dns",
    description := "NodeJS/DNS binding for Scala.js"
  )

lazy val node_fs = (project in file("node/fs")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-fs",
    description := "NodeJS/fs binding for Scala.js"
  )

lazy val node_global = (project in file("node/global")).
  dependsOn(node_tty).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-global",
    description := "NodeJS/global binding for Scala.js"
  )

lazy val node_http = (project in file("node/http")).
  dependsOn(node_net).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-http",
    description := "NodeJS/http binding for Scala.js"
  )

lazy val node_https = (project in file("node/https")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-https",
    description := "NodeJS/https binding for Scala.js"
  )

lazy val node_net = (project in file("node/net")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-net",
    description := "NodeJS/net binding for Scala.js"
  )

lazy val node_os = (project in file("node/os")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-os",
    description := "NodeJS/OS binding for Scala.js"
  )

lazy val node_path = (project in file("node/path")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-path",
    description := "NodeJS/path binding for Scala.js"
  )

lazy val node_readline = (project in file("node/readline")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-readline",
    description := "NodeJS/readline binding for Scala.js"
  )

lazy val node_repl = (project in file("node/repl")).
  dependsOn(node_net, node_readline).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-repl",
    description := "NodeJS/repl binding for Scala.js"
  )

lazy val node_stream = (project in file("node/stream")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-stream",
    description := "NodeJS/stream binding for Scala.js"
  )

lazy val node_string_decoder = (project in file("node/string_decoder")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-string-decoder",
    description := "NodeJS/string-decoder binding for Scala.js"
  )

lazy val node_tty = (project in file("node/tty")).
  dependsOn(node_net).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-tty",
    description := "NodeJS/TTY binding for Scala.js"
  )

lazy val node_url = (project in file("node/url")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-url",
    description := "NodeJS/url binding for Scala.js"
  )

lazy val node_util = (project in file("node/util")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-util",
    description := "NodeJS/util binding for Scala.js"
  )

lazy val node_vm = (project in file("node/vm")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-vm",
    description := "NodeJS/VM binding for Scala.js"
  )

lazy val node_zlib = (project in file("node/zlib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-zlib",
    description := "NodeJS/zlib binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NodeJS supplemental packages (OSS)
/////////////////////////////////////////////////////////////////////////////////

lazy val bundle_node_oss = (project in file("bundles/node_oss")).
  aggregate(
    node_adal, node_amqplib, node_async, node_azure, node_bcrypt, node_body_parser, node_cassandra,
    node_colors, node_cvs_parse, node_drama, node_elgs_splitargs, node_escape_html, node_express, node_express_csv,
    node_express_fileupload, node_express_ws, node_feedparser, node_filed, node_htmlparser2, node_jwt_simple, node_kafka,
    node_memory_fs, node_moment, node_moment_tz, node_mongodb, node_multer, node_mysql, node_oppressor, node_pvorb_md5, node_request,
    node_rxjs, node_transducers, node_watch, node_xml2js, node_zookeeper).
  dependsOn(
    node_adal, node_amqplib, node_async, node_azure, node_bcrypt, node_body_parser, node_cassandra,
    node_colors, node_cvs_parse, node_drama, node_elgs_splitargs, node_escape_html, node_express, node_express_csv,
    node_express_fileupload, node_express_ws, node_feedparser, node_filed, node_htmlparser2, node_jwt_simple, node_kafka,
    node_memory_fs, node_moment, node_moment_tz, node_mongodb, node_multer, node_mysql, node_oppressor, node_pvorb_md5, node_request,
    node_rxjs, node_transducers, node_watch, node_xml2js, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-oss-bundle",
    description := "Bundles all OSS Node modules"
  )

lazy val node_adal = (project in file("npm/adal")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-adal-node",
    description := "npm/adal-node binding for Scala.js"
  )

lazy val node_amqplib = (project in file("npm/amqplib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-amqplib",
    description := "npm/amqplib binding for Scala.js"
  )

lazy val node_async = (project in file("npm/async")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-async",
    description := "npm/async binding for Scala.js"
  )

lazy val node_azure = (project in file("npm/azure")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-azure",
    description := "npm/azure binding for Scala.js"
  )

lazy val node_bcrypt = (project in file("npm/bcrypt")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-bcrypt",
    description := "npm/bcrypt binding for Scala.js"
  )

lazy val node_body_parser = (project in file("npm/body-parser")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-body-parser",
    description := "npm/body-parser binding for Scala.js"
  )

lazy val node_cassandra = (project in file("npm/cassandra")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-datastax-cassandra",
    description := "npm/cassandra binding for Scala.js"
  )

lazy val node_colors = (project in file("npm/colors")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-colors",
    description := "npm/colors binding for Scala.js"
  )

lazy val node_cvs_parse = (project in file("npm/csv-parse")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-csv-parse",
    description := "npm/csv-parse binding for Scala.js"
  )

lazy val node_drama = (project in file("npm/drama")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-drama",
    description := "npm/drama binding for Scala.js"
  )

lazy val node_elgs_splitargs = (project in file("npm/elgs-splitargs")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-elgs-splitargs",
    description := "npm/elgs-splitargs binding for Scala.js"
  )

lazy val node_escape_html = (project in file("npm/escape-html")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-escape-html",
    description := "npm/escape-html binding for Scala.js"
  )

lazy val node_express = (project in file("npm/express")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-express",
    description := "npm/express binding for Scala.js"
  )

lazy val node_express_csv = (project in file("npm/express-csv")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-express-csv",
    description := "npm/express-csv binding for Scala.js"
  )

lazy val node_express_fileupload = (project in file("npm/express-fileupload")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-express-fileupload",
    description := "npm/express-fileupload binding for Scala.js"
  )

lazy val node_express_ws = (project in file("npm/express-ws")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-express-ws",
    description := "npm/express-ws binding for Scala.js"
  )

lazy val node_feedparser = (project in file("npm/feedparser-promised")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-feedparser-promised",
    description := "npm/feedparser-promised binding for Scala.js"
  )

lazy val node_filed = (project in file("npm/filed")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-filed",
    description := "npm/filed binding for Scala.js"
  )

lazy val node_htmlparser2 = (project in file("npm/htmlparser2")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-htmlparser2",
    description := "npm/htmlparser2 binding for Scala.js"
  )

lazy val node_jwt_simple = (project in file("npm/jwt-simple")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-jwt-simple",
    description := "npm/jwt-simple binding for Scala.js"
  )

lazy val node_kafka = (project in file("npm/kafka_node")).
  dependsOn(node_core, node_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-kafkanode",
    description := "npm/kafka-node binding for Scala.js"
  )

lazy val node_memory_fs = (project in file("npm/memory-fs")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-memory-fs",
    description := "npm/memory-fs binding for Scala.js"
  )

lazy val node_moment = (project in file("npm/moment")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-moment",
    description := "npm/moment binding for Scala.js"
  )

lazy val node_moment_tz = (project in file("npm/moment_timezone")).
  dependsOn(node_moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-moment-timezone",
    description := "npm/moment-timezone binding for Scala.js"
  )

lazy val node_mongodb = (project in file("npm/mongodb")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-mongodb",
    description := "npm/mongodb binding for Scala.js"
  )

lazy val node_multer = (project in file("npm/multer")).
  dependsOn(node_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-multer",
    description := "npm/multer binding for Scala.js"
  )

lazy val node_mysql = (project in file("npm/mysql")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-mysql",
    description := "npm/mysql binding for Scala.js"
  )

lazy val node_oppressor = (project in file("npm/oppressor")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-oppressor",
    description := "npm/oppressor binding for Scala.js"
  )

lazy val node_pvorb_md5 = (project in file("npm/pvorb-md5")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-pvorb-md5",
    description := "npm/pvorb-md5 binding for Scala.js"
  )

lazy val node_request = (project in file("npm/request")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-request",
    description := "npm/request binding for Scala.js"
  )

lazy val node_rxjs = (project in file("npm/rxjs")).
  aggregate(node_transducers).
  dependsOn(core, node_core, node_transducers).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-rxjs",
    description := "npm/rxjs binding for Scala.js"
  )

lazy val node_transducers = (project in file("npm/transducers")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-transducers",
    description := "npm/transducers-js binding for Scala.js"
  )

lazy val node_watch = (project in file("npm/watch")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-watch",
    description := "npm/watch binding for Scala.js"
  )

lazy val node_xml2js = (project in file("npm/xml2js")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-xml2js",
    description := "npm/xml2js binding for Scala.js"
  )

lazy val node_zookeeper = (project in file("npm/zookeeper-client")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-zookeeper-client",
    description := "npm/node-zookeeper-client binding for Scala.js"
  )

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
    <url>https://github.com/ldaniels528/scalajs-nodejs</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:ldaniels528/scalajs-nodejs.git</url>
      <connection>scm:git:git@github.com:ldaniels528/scalajs-nodejs.git</connection>
    </scm>
    <developers>
      <developer>
        <id>ldaniels528</id>
        <name>Lawrence Daniels</name>
        <email>lawrence.daniels@gmail.com</email>
      </developer>
    </developers>
)

// loads the MEANS.js root project at sbt startup
onLoad in Global := (Command.process("project bundle_complete", _: State)) compose (onLoad in Global).value