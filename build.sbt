import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.{libraryDependencies, _}
import sbt.Project.projectToRef
import sbt._

import scala.language.postfixOps

val apiVersion = "0.3.0.1"
val _scalaVersion = "2.12.1"

organization := "io.scalajs"

homepage := Some(url("https://github.com/ldaniels528/scalajs.io"))

val commonSettings = Seq(
  version := apiVersion,
  scalaVersion := _scalaVersion,
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-Xlint"),
  scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
  autoCompilerPlugins := true,
  scalaJSModuleKind := ModuleKind.CommonJSModule,
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % _scalaVersion,
    "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
  ))

/////////////////////////////////////////////////////////////////////////////////
//      Core sub-projects
/////////////////////////////////////////////////////////////////////////////////

lazy val core = (project in file("core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "core",
    organization := "io.scalajs",
    description := "Scala.js core classes and utilities"
  )

lazy val nodejs = (project in file("nodejs")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "nodejs",
    organization := "io.scalajs",
    description := "NodeJS bindings for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      DOM/HTML sub-projects
/////////////////////////////////////////////////////////////////////////////////

lazy val dom_html = (project in file("browser/dom")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "dom",
    organization := "io.scalajs",
    description := "Scala.js DOM/HTML"
  )

lazy val jquery = (project in file("browser/jquery")).
  aggregate(core, dom_html).
  dependsOn(core, dom_html).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "jquery",
    organization := "io.scalajs",
    description := "JQuery API bindings"
  )

lazy val phaser = (project in file("browser/phaser")).
  dependsOn(pixijs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "phaser",
    organization := "io.scalajs",
    description := "Scalajs.io Phaser 3.x bindings"
  )

lazy val pixijs = (project in file("browser/pixijs")).
  dependsOn(core, dom_html).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "pixijs",
    organization := "io.scalajs",
    description := "Scalajs.io PIXI.js bindings"
  )

/////////////////////////////////////////////////////////////////////////////////
//      AngularJS sub-projects
/////////////////////////////////////////////////////////////////////////////////

lazy val angular_core = (project in file("browser/angularjs/core")).
  dependsOn(core, dom_html, jquery).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-core",
    organization := "io.scalajs",
    description := "AngularJS/core binding for Scala.js"
  )

lazy val angular_anchorScroll = (project in file("browser/angularjs/anchor-scroll")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-anchor-scroll",
    organization := "io.scalajs",
    description := "AngularJS/anchorScroll binding for Scala.js"
  )

lazy val angular_animate = (project in file("browser/angularjs/animate")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-animate",
    organization := "io.scalajs",
    description := "AngularJS/animate binding for Scala.js"
  )

lazy val angular_cookies = (project in file("browser/angularjs/cookies")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-cookies",
    organization := "io.scalajs",
    description := "AngularJS/cookies binding for Scala.js"
  )

lazy val angular_facebook = (project in file("browser/angularjs/facebook")).
  dependsOn(core, angular_core, facebook).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-facebook",
    organization := "io.scalajs",
    description := "AngularJS/facebook binding for Scala.js"
  )

lazy val angular_md5 = (project in file("browser/angularjs/md5")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-md5",
    organization := "io.scalajs",
    description := "AngularJS/md5 binding for Scala.js"
  )

lazy val angular_nervgh_fileupload = (project in file("browser/angularjs/nervgh-fileupload")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-nervgh-fileupload",
    organization := "io.scalajs",
    description := "AngularJS/nervgh-fileupload binding for Scala.js"
  )

lazy val angular_nvd3 = (project in file("browser/angularjs/nvd3")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-nvd3",
    organization := "io.scalajs",
    description := "AngularJS/nvd3 binding for Scala.js"
  )

lazy val angular_sanitize = (project in file("browser/angularjs/sanitize")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-sanitize",
    organization := "io.scalajs",
    description := "AngularJS/sanitize binding for Scala.js"
  )

lazy val angular_toaster = (project in file("browser/angularjs/toaster")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-toaster",
    organization := "io.scalajs",
    description := "AngularJS/toaster binding for Scala.js"
  )

lazy val angular_ui_bootstrap = (project in file("browser/angularjs/ui-bootstrap")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-ui-bootstrap",
    organization := "io.scalajs",
    description := "AngularJS/ui-bootstrap binding for Scala.js"
  )

lazy val angular_ui_router = (project in file("browser/angularjs/ui-router")).
  dependsOn(core, angular_core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "angularjs-ui-router",
    organization := "io.scalajs",
    description := "AngularJS/ui-router binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Express.js packages
/////////////////////////////////////////////////////////////////////////////////

lazy val npm_body_parser = (project in file("npm/expressjs/body-parser")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "body-parser",
    organization := "io.scalajs.npm",
    description := "npm/body-parser binding for Scala.js"
  )

lazy val npm_cookie_parser = (project in file("npm/expressjs/cookie-parser")).
  dependsOn(nodejs, npm_cookie, npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "cookie-parser",
    organization := "io.scalajs.npm",
    description := "npm/cookie-parser binding for Scala.js"
  )

lazy val npm_express = (project in file("npm/expressjs/core")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "express",
    organization := "io.scalajs.npm",
    description := "npm/express binding for Scala.js"
  )

lazy val npm_express_csv = (project in file("npm/expressjs/csv")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "express-csv",
    organization := "io.scalajs.npm",
    description := "npm/expressjs-csv binding for Scala.js"
  )

lazy val npm_express_fileupload = (project in file("npm/expressjs/fileupload")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "express-fileupload",
    organization := "io.scalajs.npm",
    description := "npm/expressjs-fileupload binding for Scala.js"
  )

lazy val npm_express_multer = (project in file("npm/expressjs/multer")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "express-multer",
    organization := "io.scalajs.npm",
    description := "npm/expressjs-multer binding for Scala.js"
  )

lazy val npm_express_ws = (project in file("npm/expressjs/ws")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "express-ws",
    organization := "io.scalajs.npm",
    description := "npm/expressjs-ws binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages
/////////////////////////////////////////////////////////////////////////////////

lazy val npm_async = (project in file("npm/async")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "async",
    organization := "io.scalajs.npm",
    description := "npm/async binding for Scala.js"
  )

lazy val npm_bcrypt = (project in file("npm/bcrypt")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "bcrypt",
    organization := "io.scalajs.npm",
    description := "npm/bcrypt binding for Scala.js"
  )

lazy val npm_bignum = (project in file("npm/bignum")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "bignum",
    organization := "io.scalajs.npm",
    description := "npm/bignum binding for Scala.js"
  )

lazy val npm_buffermaker = (project in file("npm/buffermaker")).
  dependsOn(nodejs, npm_bignum).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "buffermaker",
    organization := "io.scalajs.npm",
    description := "npm/buffermaker binding for Scala.js"
  )

lazy val npm_cassandra_driver = (project in file("npm/cassandra-driver")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "cassandra-driver",
    organization := "io.scalajs.npm",
    description := "npm/cassandra-driver binding for Scala.js"
  )

lazy val npm_cheerio = (project in file("npm/cheerio")).
  dependsOn(dom_html, jquery, nodejs, npm_htmlparser2).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "cheerio",
    organization := "io.scalajs.npm",
    description := "npm/cheerio binding for Scala.js"
  )

lazy val npm_colors = (project in file("npm/colors")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "colors",
    organization := "io.scalajs.npm",
    description := "npm/colors binding for Scala.js"
  )

lazy val npm_cookie = (project in file("npm/cookie")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "cookie",
    organization := "io.scalajs.npm",
    description := "npm/cookie binding for Scala.js"
  )

lazy val npm_csv_parse = (project in file("npm/csv-parse")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "csv-parse",
    organization := "io.scalajs.npm",
    description := "npm/csv-parse binding for Scala.js"
  )

lazy val npm_drama = (project in file("npm/drama")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "drama",
    organization := "io.scalajs.npm",
    description := "npm/drama binding for Scala.js"
  )

lazy val npm_escape_html = (project in file("npm/escape-html")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "escape-html",
    organization := "io.scalajs.npm",
    description := "npm/escape-html binding for Scala.js"
  )

lazy val npm_feedparser = (project in file("npm/feedparser-promised")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "feedparser-promised",
    organization := "io.scalajs.npm",
    description := "npm/feedparser-promised binding for Scala.js"
  )

lazy val npm_filed = (project in file("npm/filed")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "filed",
    organization := "io.scalajs.npm",
    description := "npm/filed binding for Scala.js"
  )

lazy val npm_htmltojson = (project in file("npm/html_to_json")).
  dependsOn(dom_html, jquery, nodejs, npm_request).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "html-to-json",
    organization := "io.scalajs.npm",
    description := "npm/htmltojson binding for Scala.js"
  )

lazy val npm_htmlparser2 = (project in file("npm/htmlparser2")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "htmlparser2",
    organization := "io.scalajs.npm",
    description := "npm/htmlparser2 binding for Scala.js"
  )

lazy val npm_jsdom = (project in file("npm/jsdom")).
  dependsOn(nodejs, dom_html, jquery).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "jsdom",
    organization := "io.scalajs.npm",
    description := "npm/jsdom binding for Scala.js"
  )

lazy val npm_jwt_simple = (project in file("npm/jwt-simple")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "jwt-simple",
    organization := "io.scalajs.npm",
    description := "npm/jwt-simple binding for Scala.js"
  )

lazy val npm_kafka_node = (project in file("npm/kafka_node")).
  dependsOn(nodejs, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "kafka-node",
    organization := "io.scalajs.npm",
    description := "npm/kafka-node binding for Scala.js"
  )

lazy val npm_kafka_rest = (project in file("npm/kafka-rest")).
  dependsOn(nodejs, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "kafka-rest",
    organization := "io.scalajs.npm",
    description := "npm/kafka-rest binding for Scala.js"
  )

lazy val npm_md5 = (project in file("npm/md5")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "md5",
    organization := "io.scalajs.npm",
    description := "npm/md5 binding for Scala.js"
  )

lazy val npm_memory_fs = (project in file("npm/memory-fs")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "memory-fs",
    organization := "io.scalajs.npm",
    description := "npm/memory-fs binding for Scala.js"
  )

lazy val npm_moment = (project in file("npm/moment")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "moment",
    organization := "io.scalajs.npm",
    description := "npm/moment binding for Scala.js"
  )

lazy val npm_moment_tz = (project in file("npm/moment_timezone")).
  dependsOn(npm_moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "moment-timezone",
    organization := "io.scalajs.npm",
    description := "npm/moment-timezone binding for Scala.js"
  )

lazy val npm_mongodb = (project in file("npm/mongodb")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "mongodb",
    organization := "io.scalajs.npm",
    description := "npm/mongodb binding for Scala.js"
  )

lazy val npm_mysql = (project in file("npm/mysql")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "mysql",
    organization := "io.scalajs.npm",
    description := "npm/mysql binding for Scala.js"
  )

lazy val npm_node_embedded_mongodb = (project in file("npm/node_embedded_mongodb")).
  dependsOn(nodejs, npm_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "node-embedded-mongodb",
    organization := "io.scalajs.npm",
    description := "npm/node-embedded-mongodb binding for Scala.js"
  )

lazy val npm_numeral = (project in file("npm/numeral")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "numeral",
    organization := "io.scalajs.npm",
    description := "npm/numeral binding for Scala.js"
  )

lazy val npm_oppressor = (project in file("npm/oppressor")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "oppressor",
    organization := "io.scalajs.npm",
    description := "npm/oppressor binding for Scala.js"
  )

lazy val npm_request = (project in file("npm/request")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "request",
    organization := "io.scalajs.npm",
    description := "npm/request binding for Scala.js"
  )

lazy val npm_rxjs = (project in file("npm/rxjs")).
  aggregate(npm_transducers).
  dependsOn(nodejs, npm_transducers).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "rx",
    organization := "io.scalajs.npm",
    description := "npm/rx binding for Scala.js"
  )

lazy val npm_should = (project in file("npm/should")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "should",
    organization := "io.scalajs.npm",
    description := "npm/should binding for Scala.js"
  )

lazy val npm_socketio_client = (project in file("npm/socket.io/client")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "socket.io-client",
    organization := "io.scalajs.npm",
    description := "npm/socket.io-client binding for Scala.js"
  )

lazy val npm_socketio_server = (project in file("npm/socket.io/server")).
  dependsOn(nodejs, npm_socketio_client, npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "socket.io-server",
    organization := "io.scalajs.npm",
    description := "npm/socket.io binding for Scala.js"
  )

lazy val npm_splitargs = (project in file("npm/splitargs")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "splitargs",
    organization := "io.scalajs.npm",
    description := "npm/splitargs binding for Scala.js"
  )

lazy val npm_tingodb = (project in file("npm/tingodb")).
  dependsOn(nodejs, npm_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "tingodb",
    organization := "io.scalajs.npm",
    description := "npm/tingodb binding for Scala.js"
  )

lazy val npm_transducers = (project in file("npm/transducers")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "transducers",
    organization := "io.scalajs.npm",
    description := "npm/transducers-js binding for Scala.js"
  )

lazy val npm_type_is = (project in file("npm/type-is")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "type-is",
    organization := "io.scalajs.npm",
    description := "npm/type-is binding for Scala.js"
  )

lazy val npm_watch = (project in file("npm/watch")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "watch",
    organization := "io.scalajs.npm",
    description := "npm/watch binding for Scala.js"
  )

lazy val npm_xml2js = (project in file("npm/xml2js")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "xml2js",
    organization := "io.scalajs.npm",
    description := "npm/xml2js binding for Scala.js"
  )

lazy val npm_zookeeper = (project in file("npm/zookeeper-client")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "zookeeper-client",
    organization := "io.scalajs.npm",
    description := "npm/node-zookeeper-client binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Social sub-projects
/////////////////////////////////////////////////////////////////////////////////

lazy val facebook = (project in file("social/facebook")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "social-facebook",
    organization := "io.scalajs",
    description := "Social/Facebook bindings for Scala.js"
  )

lazy val linkedin = (project in file("social/linkedin")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "social-linkedin",
    organization := "io.scalajs",
    description := "Social/LinkedIn bindings for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Bundles
/////////////////////////////////////////////////////////////////////////////////

lazy val bundle_complete = (project in file("bundles/complete")).
  aggregate(core, dom_html, jquery, nodejs, phaser, pixijs, bundle_social, bundle_angular, bundle_expressjs, bundle_mean_stack, bundle_npm).
  dependsOn(core, dom_html, jquery, nodejs, phaser, pixijs, bundle_social, bundle_angular, bundle_expressjs, bundle_mean_stack, bundle_npm).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(publishingSettings: _*).
  settings(
    name := "complete-platform-bundle",
    organization := "io.scalajs",
    description := "Complete platform bundle"
  )

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
    name := "angularjs-bundle",
    organization := "io.scalajs",
    description := "AngularJS Bundle"
  )

lazy val bundle_expressjs = (project in file("bundles/expressjs")).
  aggregate(npm_body_parser, npm_cookie_parser, npm_express, npm_express_csv, npm_express_fileupload, npm_express_multer, npm_express_ws).
  aggregate(npm_body_parser, npm_cookie_parser, npm_express, npm_express_csv, npm_express_fileupload, npm_express_multer, npm_express_ws).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(publishingSettings: _*).
  settings(
    name := "expressjs-bundle",
    organization := "io.scalajs.npm",
    description := "Express.js bundle"
  )

lazy val bundle_mean_stack = (project in file("bundles/mean_stack")).
  aggregate(nodejs, npm_body_parser, bundle_expressjs, npm_mongodb).
  dependsOn(nodejs, npm_body_parser, bundle_expressjs, npm_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "mean-stack-bundle",
    organization := "io.scalajs.npm",
    description := "MEAN Stack bundle"
  )

lazy val bundle_npm = (project in file("bundles/npm")).
  aggregate(
    bundle_expressjs,
    npm_async, npm_bcrypt, npm_bignum, npm_buffermaker, npm_cassandra_driver,
    npm_colors, npm_cookie, npm_csv_parse, npm_drama, npm_splitargs, npm_escape_html, npm_feedparser, npm_filed, npm_htmlparser2, npm_htmltojson,
    npm_jsdom, npm_jwt_simple, npm_kafka_node, npm_kafka_rest,
    npm_memory_fs, npm_moment, npm_moment_tz, npm_mongodb, npm_mysql, npm_node_embedded_mongodb, npm_numeral, npm_oppressor,
    npm_md5, npm_request, npm_rxjs, npm_should, npm_socketio_client, npm_socketio_server,
    npm_tingodb, npm_transducers, npm_type_is, npm_watch, npm_xml2js, npm_zookeeper).
  dependsOn(
    bundle_expressjs,
    npm_async, npm_bcrypt, npm_bignum, npm_buffermaker, npm_cassandra_driver,
    npm_colors, npm_cookie, npm_csv_parse, npm_drama, npm_splitargs, npm_escape_html, npm_feedparser, npm_filed, npm_htmlparser2, npm_htmltojson,
    npm_jsdom, npm_jwt_simple, npm_kafka_node, npm_kafka_rest,
    npm_memory_fs, npm_moment, npm_moment_tz, npm_mongodb, npm_mysql, npm_node_embedded_mongodb, npm_numeral, npm_oppressor,
    npm_md5, npm_request, npm_rxjs, npm_should, npm_socketio_client, npm_socketio_server,
    npm_tingodb, npm_transducers, npm_type_is, npm_watch, npm_xml2js, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-bundle",
    organization := "io.scalajs.npm",
    description := "Bundles all npm modules"
  )

lazy val bundle_social = (project in file("bundles/social")).
  aggregate(facebook, linkedin).
  dependsOn(facebook, linkedin).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "social-bundle",
    organization := "io.scalajs",
    description := "Bundles all Social Networking APIs"
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