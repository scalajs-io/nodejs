import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt.Project.projectToRef
import sbt._

val apiVersion = "0.2.3.2"

val paradisePluginVersion = "3.0.0-M1"
val _scalaVersion = "2.11.8"
val scalaJsDomVersion = "0.9.0"
val scalaJsJQueryVersion = "0.9.0"
val scalaJsSelenium = "0.1.3"

scalaJSUseRhino in Global := false

organization := "com.github.ldaniels528"

homepage := Some(url("https://github.com/ldaniels528/scalajs-nodejs"))

val commonSettings = Seq(
  version := apiVersion,
  scalaVersion := _scalaVersion,
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-language:implicitConversions","-Xlint"),
  scalacOptions in(Compile, doc) ++= Seq(
     "-no-link-warnings" // Suppresses problems with Scaladoc @throws links
  ),
  autoCompilerPlugins := true,
  addCompilerPlugin("com.lihaoyi" %% "acyclic" % "0.1.2"),
  libraryDependencies += "com.lihaoyi" %% "acyclic" % "0.1.2" % "provided",
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
    "com.lihaoyi" %%% "utest" % "0.4.3" % "test"
  )
)

lazy val bundle_complete = (project in file("bundles/complete")).
  aggregate(core, browser_core, bundle_canvas, bundle_social, bundle_angular, bundle_mean_minimal, bundle_node, bundle_npm).
  dependsOn(core, browser_core, bundle_canvas, bundle_social, bundle_angular, bundle_mean_minimal, bundle_node, bundle_npm).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(publishingSettings: _*).
  settings(
    name := "scalajs-nodejs-complete-bundle",
    organization := "com.github.ldaniels528",
    description := "Complete platform bundle"
  )

lazy val bundle_mean_minimal = (project in file("bundles/mean_minimal")).
  aggregate(bundle_node, npm_body_parser, npm_express, npm_express_fileupload, npm_express_ws, npm_mongodb).
  dependsOn(bundle_node, npm_body_parser, npm_express, npm_express_fileupload, npm_express_ws, npm_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-mean-bundle-minimal",
    organization := "com.github.ldaniels528",
    description := "MEAN stack bundle (minimal)"
  )

lazy val examples = (project in file("examples")).
  aggregate(bundle_node, bundle_npm).
  dependsOn(bundle_node, bundle_npm).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-examples",
    organization := "com.github.ldaniels528",
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
    organization := "com.github.ldaniels528",
    description := "Scala.js common/utilities"
  )

lazy val browser_core = (project in file("browser/common")).
  aggregate(core).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-browser-core",
    organization := "com.github.ldaniels528",
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
    organization := "com.github.ldaniels528",
    description := "Scala.js 2D bindings bundle"
  )

lazy val phaser = (project in file("browser/phaser")).
  dependsOn(browser_core, pixijs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-canvas-phaser",
    organization := "com.github.ldaniels528",
    description := "Scala.js Phaser 3.x bindings"
  )

lazy val pixijs = (project in file("browser/pixijs")).
  dependsOn(browser_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-canvas-pixijs",
    organization := "com.github.ldaniels528",
    description := "Scala.js PIXI.js bindings"
  )

  /////////////////////////////////////////////////////////////////////////////////
  //      AngularJS sub-projects
  /////////////////////////////////////////////////////////////////////////////////

lazy val bundle_angular = (project in file("bundles/angularjs")).
  aggregate(
    angular_core, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_md5,
    angular_nervgh_fileupload, angular_nvd3, angular_sanitize, angular_toaster, angular_ui_bootstrap, angular_ui_router).
  dependsOn(
    angular_core, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_md5,
    angular_nervgh_fileupload, angular_nvd3, angular_sanitize, angular_toaster, angular_ui_bootstrap, angular_ui_router).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-bundle",
    organization := "com.github.ldaniels528",
    description := "AngularJS Bundle"
  )

lazy val angular_core = (project in file("angularjs/core")).
  dependsOn(browser_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-core",
    organization := "com.github.ldaniels528",
    description := "AngularJS/core binding for Scala.js"
  )

lazy val angular_anchorScroll = (project in file("angularjs/anchor-scroll")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-anchor-scroll",
    organization := "com.github.ldaniels528",
    description := "AngularJS/anchorScroll binding for Scala.js"
  )

lazy val angular_animate = (project in file("angularjs/animate")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-animate",
    organization := "com.github.ldaniels528",
    description := "AngularJS/animate binding for Scala.js"
  )

lazy val angular_cookies = (project in file("angularjs/cookies")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-cookies",
    organization := "com.github.ldaniels528",
    description := "AngularJS/cookies binding for Scala.js"
  )

lazy val angular_facebook = (project in file("angularjs/facebook")).
  dependsOn(core, angular_core, facebook).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-facebook",
    organization := "com.github.ldaniels528",
    description := "AngularJS/facebook binding for Scala.js"
  )

lazy val angular_md5 = (project in file("angularjs/md5")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-md5",
    organization := "com.github.ldaniels528",
    description := "AngularJS/md5 binding for Scala.js"
  )

lazy val angular_nervgh_fileupload = (project in file("angularjs/nervgh-fileupload")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-nervgh-fileupload",
    organization := "com.github.ldaniels528",
    description := "AngularJS/nervgh-fileupload binding for Scala.js"
  )

lazy val angular_nvd3 = (project in file("angularjs/nvd3")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-nvd3",
    organization := "com.github.ldaniels528",
    description := "AngularJS/nvd3 binding for Scala.js"
  )

lazy val angular_sanitize = (project in file("angularjs/sanitize")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-sanitize",
    organization := "com.github.ldaniels528",
    description := "AngularJS/sanitize binding for Scala.js"
  )

lazy val angular_toaster = (project in file("angularjs/toaster")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-toaster",
    organization := "com.github.ldaniels528",
    description := "AngularJS/toaster binding for Scala.js"
  )

lazy val angular_ui_bootstrap = (project in file("angularjs/ui-bootstrap")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-ui-bootstrap",
    organization := "com.github.ldaniels528",
    description := "AngularJS/ui-bootstrap binding for Scala.js"
  )

lazy val angular_ui_router = (project in file("angularjs/ui-router")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-angularjs-ui-router",
    organization := "com.github.ldaniels528",
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
    organization := "com.github.ldaniels528",
    description := "Bundles all Social Networking APIs"
  )

lazy val facebook = (project in file("social/facebook")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-social-facebook",
    organization := "com.github.ldaniels528",
    description := "Social/Facebook binding for Scala.js"
  )

lazy val linkedin = (project in file("social/linkedin")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-social-linkedin",
    organization := "com.github.ldaniels528",
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
    organization := "com.github.ldaniels528",
    description := "Bundles all Node modules"
  )

lazy val node_core = (project in file("node/core")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-core",
    organization := "com.github.ldaniels528",
    description := "NodeJS/Core binding for Scala.js"
  )

lazy val node_assert = (project in file("node/assert")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-assert",
    organization := "com.github.ldaniels528",
    description := "NodeJS/assert binding for Scala.js"
  )

lazy val node_cluster = (project in file("node/cluster")).
  dependsOn(node_global).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-cluster",
    organization := "com.github.ldaniels528",
    description := "NodeJS/cluster binding for Scala.js"
  )

lazy val node_crypto = (project in file("node/crypto")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-crypto",
    organization := "com.github.ldaniels528",
    description := "NodeJS/crypto binding for Scala.js"
  )

lazy val node_dns = (project in file("node/dns")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-dns",
    organization := "com.github.ldaniels528",
    description := "NodeJS/DNS binding for Scala.js"
  )

lazy val node_fs = (project in file("node/fs")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-fs",
    organization := "com.github.ldaniels528",
    description := "NodeJS/fs binding for Scala.js"
  )

lazy val node_global = (project in file("node/global")).
  dependsOn(node_tty).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-global",
    organization := "com.github.ldaniels528",
    description := "NodeJS/global binding for Scala.js"
  )

lazy val node_http = (project in file("node/http")).
  dependsOn(node_net).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-http",
    organization := "com.github.ldaniels528",
    description := "NodeJS/http binding for Scala.js"
  )

lazy val node_https = (project in file("node/https")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-https",
    organization := "com.github.ldaniels528",
    description := "NodeJS/https binding for Scala.js"
  )

lazy val node_net = (project in file("node/net")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-net",
    organization := "com.github.ldaniels528",
    description := "NodeJS/net binding for Scala.js"
  )

lazy val node_os = (project in file("node/os")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-os",
    organization := "com.github.ldaniels528",
    description := "NodeJS/OS binding for Scala.js"
  )

lazy val node_path = (project in file("node/path")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-path",
    organization := "com.github.ldaniels528",
    description := "NodeJS/path binding for Scala.js"
  )

lazy val node_readline = (project in file("node/readline")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-readline",
    organization := "com.github.ldaniels528",
    description := "NodeJS/readline binding for Scala.js"
  )

lazy val node_repl = (project in file("node/repl")).
  dependsOn(node_net, node_readline).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-repl",
    organization := "com.github.ldaniels528",
    description := "NodeJS/repl binding for Scala.js"
  )

lazy val node_stream = (project in file("node/stream")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-stream",
    organization := "com.github.ldaniels528",
    description := "NodeJS/stream binding for Scala.js"
  )

lazy val node_string_decoder = (project in file("node/string_decoder")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-string-decoder",
    organization := "com.github.ldaniels528",
    description := "NodeJS/string-decoder binding for Scala.js"
  )

lazy val node_tty = (project in file("node/tty")).
  dependsOn(node_net).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-tty",
    organization := "com.github.ldaniels528",
    description := "NodeJS/TTY binding for Scala.js"
  )

lazy val node_url = (project in file("node/url")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-url",
    organization := "com.github.ldaniels528",
    description := "NodeJS/url binding for Scala.js"
  )

lazy val node_util = (project in file("node/util")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-util",
    organization := "com.github.ldaniels528",
    description := "NodeJS/util binding for Scala.js"
  )

lazy val node_vm = (project in file("node/vm")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-vm",
    organization := "com.github.ldaniels528",
    description := "NodeJS/VM binding for Scala.js"
  )

lazy val node_zlib = (project in file("node/zlib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-nodejs-zlib",
    organization := "com.github.ldaniels528",
    description := "NodeJS/zlib binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NodeJS supplemental packages (OSS)
/////////////////////////////////////////////////////////////////////////////////

lazy val bundle_npm = (project in file("bundles/npm")).
  aggregate(
    npm_adal, npm_amqplib, npm_async, npm_azure, npm_bcrypt, npm_body_parser, npm_cassandra,
    npm_colors, npm_csv_parse, npm_drama, npm_splitargs, npm_escape_html, npm_express, npm_express_csv,
    npm_express_fileupload, npm_express_ws, npm_feedparser, npm_filed, npm_htmlparser2, npm_htmltojson, npm_jwt_simple, npm_kafka,
    npm_memory_fs, npm_moment, npm_moment_tz, npm_mongodb, npm_multer, npm_mysql, npm_numeral, npm_oppressor,
    npm_md5, npm_request, npm_rxjs, npm_transducers, npm_watch, npm_xml2js, npm_zookeeper).
  dependsOn(
    npm_adal, npm_amqplib, npm_async, npm_azure, npm_bcrypt, npm_body_parser, npm_cassandra,
    npm_colors, npm_csv_parse, npm_drama, npm_splitargs, npm_escape_html, npm_express, npm_express_csv,
    npm_express_fileupload, npm_express_ws, npm_feedparser, npm_filed, npm_htmlparser2, npm_htmltojson, npm_jwt_simple, npm_kafka,
    npm_memory_fs, npm_moment, npm_moment_tz, npm_mongodb, npm_multer, npm_mysql, npm_numeral, npm_oppressor,
    npm_md5, npm_request, npm_rxjs, npm_transducers, npm_watch, npm_xml2js, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-bundle",
    organization := "com.github.ldaniels528",
    description := "Bundles all OSS Node modules"
  )

lazy val npm_adal = (project in file("npm/adal")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-adal-node",
    organization := "com.github.ldaniels528",
    description := "npm/adal-node binding for Scala.js"
  )

lazy val npm_amqplib = (project in file("npm/amqplib")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-amqplib",
    organization := "com.github.ldaniels528",
    description := "npm/amqplib binding for Scala.js"
  )

lazy val npm_async = (project in file("npm/async")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-async",
    organization := "com.github.ldaniels528",
    description := "npm/async binding for Scala.js"
  )

lazy val npm_azure = (project in file("npm/azure")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-azure",
    organization := "com.github.ldaniels528",
    description := "npm/azure binding for Scala.js"
  )

lazy val npm_bcrypt = (project in file("npm/bcrypt")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-bcrypt",
    organization := "com.github.ldaniels528",
    description := "npm/bcrypt binding for Scala.js"
  )

lazy val npm_body_parser = (project in file("npm/body-parser")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-body-parser",
    organization := "com.github.ldaniels528",
    description := "npm/body-parser binding for Scala.js"
  )

lazy val npm_cassandra = (project in file("npm/cassandra-driver")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-cassandra-driver",
    organization := "com.github.ldaniels528",
    description := "npm/cassandra-driver binding for Scala.js"
  )

lazy val npm_colors = (project in file("npm/colors")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-colors",
    organization := "com.github.ldaniels528",
    description := "npm/colors binding for Scala.js"
  )

lazy val npm_csv_parse = (project in file("npm/csv-parse")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-csv-parse",
    organization := "com.github.ldaniels528",
    description := "npm/csv-parse binding for Scala.js"
  )

lazy val npm_drama = (project in file("npm/drama")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-drama",
    organization := "com.github.ldaniels528",
    description := "npm/drama binding for Scala.js"
  )

lazy val npm_escape_html = (project in file("npm/escape-html")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-escape-html",
    organization := "com.github.ldaniels528",
    description := "npm/escape-html binding for Scala.js"
  )

lazy val npm_express = (project in file("npm/express")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-express",
    organization := "com.github.ldaniels528",
    description := "npm/express binding for Scala.js"
  )

lazy val npm_express_csv = (project in file("npm/express-csv")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-express-csv",
    organization := "com.github.ldaniels528",
    description := "npm/express-csv binding for Scala.js"
  )

lazy val npm_express_fileupload = (project in file("npm/express-fileupload")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-express-fileupload",
    organization := "com.github.ldaniels528",
    description := "npm/express-fileupload binding for Scala.js"
  )

lazy val npm_express_ws = (project in file("npm/express-ws")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-express-ws",
    organization := "com.github.ldaniels528",
    description := "npm/express-ws binding for Scala.js"
  )

lazy val npm_feedparser = (project in file("npm/feedparser-promised")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-feedparser-promised",
    organization := "com.github.ldaniels528",
    description := "npm/feedparser-promised binding for Scala.js"
  )

lazy val npm_filed = (project in file("npm/filed")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-filed",
    organization := "com.github.ldaniels528",
    description := "npm/filed binding for Scala.js"
  )

lazy val npm_htmltojson = (project in file("npm/html_to_json")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-htmltojson",
    organization := "com.github.ldaniels528",
    description := "npm/htmltojson binding for Scala.js"
  )

lazy val npm_htmlparser2 = (project in file("npm/htmlparser2")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-htmlparser2",
    organization := "com.github.ldaniels528",
    description := "npm/htmlparser2 binding for Scala.js"
  )

lazy val npm_jwt_simple = (project in file("npm/jwt-simple")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-jwt-simple",
    organization := "com.github.ldaniels528",
    description := "npm/jwt-simple binding for Scala.js"
  )

lazy val npm_kafka = (project in file("npm/kafka_node")).
  dependsOn(node_core, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-kafkanode",
    organization := "com.github.ldaniels528",
    description := "npm/kafka-node binding for Scala.js"
  )

lazy val npm_md5 = (project in file("npm/md5")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-md5",
    organization := "com.github.ldaniels528",
    description := "npm/md5 binding for Scala.js"
  )

lazy val npm_memory_fs = (project in file("npm/memory-fs")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-memory-fs",
    organization := "com.github.ldaniels528",
    description := "npm/memory-fs binding for Scala.js"
  )

lazy val npm_moment = (project in file("npm/moment")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-moment",
    organization := "com.github.ldaniels528",
    description := "npm/moment binding for Scala.js"
  )

lazy val npm_moment_tz = (project in file("npm/moment_timezone")).
  dependsOn(npm_moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-moment-timezone",
    organization := "com.github.ldaniels528",
    description := "npm/moment-timezone binding for Scala.js"
  )

lazy val npm_mongodb = (project in file("npm/mongodb")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-mongodb",
    organization := "com.github.ldaniels528",
    description := "npm/mongodb binding for Scala.js"
  )

lazy val npm_multer = (project in file("npm/multer")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-multer",
    organization := "com.github.ldaniels528",
    description := "npm/multer binding for Scala.js"
  )

lazy val npm_mysql = (project in file("npm/mysql")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-mysql",
    organization := "com.github.ldaniels528",
    description := "npm/mysql binding for Scala.js"
  )

lazy val npm_numeral = (project in file("npm/numeral")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-numeral",
    organization := "com.github.ldaniels528",
    description := "npm/numeral binding for Scala.js"
  )

lazy val npm_oppressor = (project in file("npm/oppressor")).
  dependsOn(node_stream).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-oppressor",
    organization := "com.github.ldaniels528",
    description := "npm/oppressor binding for Scala.js"
  )

lazy val npm_request = (project in file("npm/request")).
  dependsOn(node_http).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-request",
    organization := "com.github.ldaniels528",
    description := "npm/request binding for Scala.js"
  )

lazy val npm_rxjs = (project in file("npm/rxjs")).
  aggregate(npm_transducers).
  dependsOn(core, node_core, npm_transducers).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-rxjs",
    organization := "com.github.ldaniels528",
    description := "npm/rxjs binding for Scala.js"
  )

lazy val npm_splitargs = (project in file("npm/splitargs")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-splitargs",
    organization := "com.github.ldaniels528",
    description := "npm/splitargs binding for Scala.js"
  )

lazy val npm_transducers = (project in file("npm/transducers")).
  dependsOn(core, node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-transducers",
    organization := "com.github.ldaniels528",
    description := "npm/transducers-js binding for Scala.js"
  )

lazy val npm_watch = (project in file("npm/watch")).
  dependsOn(node_fs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-watch",
    organization := "com.github.ldaniels528",
    description := "npm/watch binding for Scala.js"
  )

lazy val npm_xml2js = (project in file("npm/xml2js")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-xml2js",
    organization := "com.github.ldaniels528",
    description := "npm/xml2js binding for Scala.js"
  )

lazy val npm_zookeeper = (project in file("npm/zookeeper-client")).
  dependsOn(node_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "scalajs-npm-zookeeper-client",
    organization := "com.github.ldaniels528",
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
        <connection>scm:git:github.com/ldaniels528/scalajs-nodejs.git</connection>
        <developerConnection>scm:git:git@github.com:ldaniels528/scalajs-nodejs.git</developerConnection>
        <url>github.com/ldaniels528/scalajs-nodejs.git</url>
      </scm>
    <developers>
      <developer>
        <id>ldaniels528</id>
        <name>Lawrence Daniels</name>
        <email>lawrence.daniels@gmail.com</email>
        <organization>com.github.ldaniels528</organization>
        <organizationUrl>https://github.com/ldaniels528</organizationUrl>
        <roles>
          <role>Project-Administrator</role>
          <role>Developer</role>
        </roles>
        <timezone>+7</timezone>
      </developer>
    </developers>
)

// loads the MEANS.js root project at sbt startup
onLoad in Global := (Command.process("project bundle_complete", _: State)) compose (onLoad in Global).value