import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.Keys._
import sbt._

val apiVersion = "0.6.0"
val scalaVersion_2_11_x = "2.11.12"
val scalaVersion_2_12_x = "2.12.8"
val scalaVersion_2_13_x = "2.13.0"

val supportedScalaVersions = List(scalaVersion_2_11_x, scalaVersion_2_12_x, scalaVersion_2_13_x)

/////////////////////////////////////////////////////////////////////////////////
//      Common Settings
/////////////////////////////////////////////////////////////////////////////////

ThisBuild / organization := "io.scalajs"
ThisBuild / version := apiVersion
ThisBuild / scalaVersion := scalaVersion_2_12_x

val commonSettings = Seq(
  organization := "io.scalajs",
  version := apiVersion,
  crossScalaVersions := supportedScalaVersions,
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-Xlint"),
  scalacOptions += "-P:scalajs:sjsDefinedByDefault",
  scalacOptions += "-P:scalajs:suppressMissingJSGlobalDeprecations",
  scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
  autoCompilerPlugins := true,
  scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule)),
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "org.scalatest" %%% "scalatest" % "3.1.0-SNAP13" % "test"
  )) ++ publishingSettings

/////////////////////////////////////////////////////////////////////////////////
//      ScalaJs.io Core projects
/////////////////////////////////////////////////////////////////////////////////

lazy val core = (project in file("app/core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "core",
    organization := "io.scalajs",
    description := "ScalaJs.io Core classes and utilities"
  )

lazy val dom_html = (project in file("app/dom-html")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "dom-html",
    organization := "io.scalajs",
    description := "DOM/HTML bindings for Scala.js"
  )

lazy val nodejs = (project in file("app/nodejs")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "nodejs",
    organization := "io.scalajs",
    description := "NodeJS bindings for Scala.js"
  )

lazy val jvm_io = (project in file("app/jvm/io")).
  dependsOn(nodejs, sync_request).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "jvm-io",
    organization := "io.scalajs",
    description := "JVM Inspired I/O"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Browser Platform projects
/////////////////////////////////////////////////////////////////////////////////

lazy val amcharts = (project in file("app/web/amcharts")).
  dependsOn(dom_html).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "amcharts",
    organization := "io.scalajs.web",
    description := "AmCharts bindings for Scala.js"
  )

lazy val facebook = (project in file("app/web/facebook-api")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "facebook-sdk",
    organization := "io.scalajs.web",
    description := "Facebook SDK bindings for Scala.js"
  )

lazy val jquery = (project in file("app/web/jquery")).
  dependsOn(core, dom_html).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "jquery",
    organization := "io.scalajs.web",
    description := "JQuery bindings for Scala.js"
  )

lazy val linkedin = (project in file("app/web/linkedin-api")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "linkedin-sdk",
    organization := "io.scalajs.web",
    description := "LinkedIn SDK bindings for Scala.js"
  )

lazy val phaser = (project in file("app/web/phaser")).
  dependsOn(core, dom_html, pixijs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "phaser",
    organization := "io.scalajs.web",
    description := "Phaser 2.6.x bindings for Scala.js"
  )

lazy val pixijs = (project in file("app/web/pixijs")).
  dependsOn(core, dom_html).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "pixijs",
    organization := "io.scalajs.web",
    description := "PIXI.js bindings for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages (AngularJS)
/////////////////////////////////////////////////////////////////////////////////

lazy val angular = (project in file("app/web/angularjs/angular")).
  dependsOn(core, dom_html, jquery).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular",
    organization := "io.scalajs.web",
    description := "AngularJS binding for Scala.js"
  )

lazy val angular_anchorScroll = (project in file("app/web/angularjs/angular-anchor-scroll")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-anchor-scroll",
    organization := "io.scalajs.web",
    description := "AngularJS/AnchorScroll binding for Scala.js"
  )

lazy val angular_animate = (project in file("app/web/angularjs/angular-animate")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-animate",
    organization := "io.scalajs.web",
    description := "AngularJS/Animate binding for Scala.js"
  )

lazy val angular_cookies = (project in file("app/web/angularjs/angular-cookies")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-cookies",
    organization := "io.scalajs.web",
    description := "AngularJS/Cookies binding for Scala.js"
  )

lazy val angular_facebook = (project in file("app/web/angularjs/angular-facebook")).
  dependsOn(angular, facebook).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-facebook",
    organization := "io.scalajs.web",
    description := "AngularJS/Facebook binding for Scala.js"
  )

lazy val angular_md5 = (project in file("app/web/angularjs/angular-md5")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-md5",
    organization := "io.scalajs.web",
    description := "AngularJS/MD5 binding for Scala.js"
  )

lazy val angular_file_upload = (project in file("app/web/angularjs/angular-file-upload")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-file-upload",
    organization := "io.scalajs.web",
    description := "AngularJS/fileupload binding for Scala.js"
  )

lazy val angular_nvd3 = (project in file("app/web/angularjs/angular-nvd3")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-nvd3",
    organization := "io.scalajs.web",
    description := "AngularJS/NVD3 binding for Scala.js"
  )

lazy val angular_sanitize = (project in file("app/web/angularjs/angular-sanitize")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-sanitize",
    organization := "io.scalajs.web",
    description := "AngularJS/Sanitize binding for Scala.js"
  )

lazy val angular_ui_bootstrap = (project in file("app/web/angularjs/angular-ui-bootstrap")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-ui-bootstrap",
    organization := "io.scalajs.web",
    description := "AngularJS/ui-bootstrap binding for Scala.js"
  )

lazy val angular_ui_router = (project in file("app/web/angularjs/angular-ui-router")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angular-ui-router",
    organization := "io.scalajs.web",
    description := "AngularJS/UI-router binding for Scala.js"
  )

lazy val angularjs_toaster = (project in file("app/web/angularjs/angularjs-toaster")).
  dependsOn(angular).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angularjs-toaster",
    organization := "io.scalajs.web",
    description := "AngularJS/Toaster binding for Scala.js"
  )

lazy val angular_platform = (project in file("app/bundles/angularjs-v1-bundle")).
  aggregate(
    angular, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_file_upload,
    angular_md5, angular_nvd3, angular_sanitize, angularjs_toaster, angular_ui_bootstrap, angular_ui_router).
  dependsOn(
    angular, angular_anchorScroll, angular_animate, angular_cookies, angular_facebook, angular_file_upload,
    angular_md5, angular_nvd3, angular_sanitize, angularjs_toaster, angular_ui_bootstrap, angular_ui_router).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "angularjs-v1-bundle",
    organization := "io.scalajs.web",
    description := "AngularJS v1.7.x platform bundle",
    crossScalaVersions := Nil
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages (Express.js)
/////////////////////////////////////////////////////////////////////////////////

lazy val body_parser = (project in file("app/npmjs/express/body-parser")).
  dependsOn(express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "body-parser",
    organization := "io.scalajs.npm",
    description := "Express.js Body Parser binding for Scala.js"
  )

lazy val express = (project in file("app/npmjs/express/express")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "express",
    organization := "io.scalajs.npm",
    description := "Express.js binding for Scala.js"
  )

lazy val express_csv = (project in file("app/npmjs/express/express-csv")).
  dependsOn(express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "express-csv",
    organization := "io.scalajs.npm",
    description := "Express.js CSV binding for Scala.js"
  )

lazy val express_fileupload = (project in file("app/npmjs/express/express-fileupload")).
  dependsOn(express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "express-fileupload",
    organization := "io.scalajs.npm",
    description := "Express.js File Upload binding for Scala.js"
  )

lazy val express_ws = (project in file("app/npmjs/express/express-ws")).
  dependsOn(express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "express-ws",
    organization := "io.scalajs.npm",
    description := "Express.js Web socket binding for Scala.js"
  )

lazy val multer = (project in file("app/npmjs/express/multer")).
  dependsOn(express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "multer",
    organization := "io.scalajs.npm",
    description := "Express.js Multer binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages (MongoDB)
/////////////////////////////////////////////////////////////////////////////////

lazy val mongodb = (project in file("app/npmjs/mongo/mongodb")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "mongodb",
    organization := "io.scalajs.npm",
    description := "The official MongoDB driver for Node.js."
  )

lazy val mongoose = (project in file("app/npmjs/mongo/mongoose")).
  dependsOn(mongodb, mpromise).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(publishingSettings: _*).
  settings(
    name := "mongoose",
    organization := "io.scalajs.npm",
    description := "Mongoose MongoDB ODM [Scala.js]"
  )

lazy val mpromise = (project in file("app/npmjs/mongo/mpromise")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "mpromise",
    organization := "io.scalajs.npm",
    description := "A promises/A+ conformant implementation, written for mongoose [Scala.js]"
  )

lazy val tingodb = (project in file("app/npmjs/mongo/tingodb")).
  dependsOn(nodejs, mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "tingodb",
    organization := "io.scalajs.npm",
    description := "TingoDB binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages (Moment.js)
/////////////////////////////////////////////////////////////////////////////////

lazy val moment = (project in file("app/npmjs/moment/moment")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "moment",
    organization := "io.scalajs.npm",
    description := "Moment.js binding for Scala.js"
  )

lazy val moment_business = (project in file("app/npmjs/moment/moment-business")).
  dependsOn(moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "moment-business",
    organization := "io.scalajs.npm",
    description := "Utilities for working with week days and weekend days in Moment. It assumes a Western workweek, in which weekends are Saturday and Sunday."
  )

lazy val moment_duration_format = (project in file("app/npmjs/moment/moment-duration-format")).
  dependsOn(moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "moment-duration-format",
    organization := "io.scalajs.npm",
    description := "A Moment.js plugin for formatting durations."
  )

lazy val moment_range = (project in file("app/npmjs/moment/moment-range")).
  dependsOn(moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "moment-range",
    organization := "io.scalajs.npm",
    description := "Fancy date ranges for Moment.js."
  )

lazy val moment_timezone = (project in file("app/npmjs/moment/moment-timezone")).
  dependsOn(moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "moment-timezone",
    organization := "io.scalajs.npm",
    description := "Moment.js Timezone binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages (Winston.js)
/////////////////////////////////////////////////////////////////////////////////

lazy val winston = (project in file("app/npmjs/winston/winston")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "winston",
    organization := "io.scalajs.npm",
    description := "Winston binding for Scala.js"
  )

lazy val winston_daily_rotate_file = (project in file("app/npmjs/winston/winston-daily-rotate-file")).
  dependsOn(nodejs, winston).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "winston-daily-rotate-file",
    organization := "io.scalajs.npm",
    description := "Winston Daily Rotate File binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages
/////////////////////////////////////////////////////////////////////////////////

lazy val async = (project in file("app/npmjs/async")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "async",
    organization := "io.scalajs.npm",
    description := "Async binding for Scala.js"
  )

lazy val aws_sdk = (project in file("app/npmjs/aws-sdk")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "aws-sdk",
    organization := "io.scalajs.npm",
    description := "AWS SDK binding for Scala.js"
  )

lazy val bcrypt = (project in file("app/npmjs/bcrypt")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "bcrypt",
    organization := "io.scalajs.npm",
    description := "Bcrypt binding for Scala.js"
  )

lazy val bignum = (project in file("app/npmjs/bignum")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "bignum",
    organization := "io.scalajs.npm",
    description := "Bignum binding for Scala.js"
  )

lazy val brake = (project in file("app/npmjs/brake")).
  dependsOn(nodejs, readable_stream % "test->test").
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "brake",
    organization := "io.scalajs.npm",
    description := "Brake binding for Scala.js")

lazy val buffermaker = (project in file("app/npmjs/buffermaker")).
  dependsOn(nodejs, bignum).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "buffermaker",
    organization := "io.scalajs.npm",
    description := "Buffermaker binding for Scala.js"
  )

lazy val cassandra_driver = (project in file("app/npmjs/cassandra-driver")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "cassandra-driver",
    organization := "io.scalajs.npm",
    description := "Cassandra-driver binding for Scala.js"
  )

lazy val chalk = (project in file("app/npmjs/chalk")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "chalk",
    organization := "io.scalajs.npm",
    description := "Chalk binding for Scala.js"
  )

lazy val cheerio = (project in file("app/npmjs/cheerio")).
  dependsOn(dom_html, jquery, nodejs, htmlparser2).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "cheerio",
    organization := "io.scalajs.npm",
    description := "Cheerio binding for Scala.js"
  )

lazy val colors = (project in file("app/npmjs/colors")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "colors",
    organization := "io.scalajs.npm",
    description := "Colors binding for Scala.js"
  )

lazy val combined_stream = (project in file("app/npmjs/combined-stream")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "combined-stream",
    organization := "io.scalajs.npm",
    description := "A stream that emits multiple other streams one after another."
  )

lazy val cookie = (project in file("app/npmjs/cookie")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "cookie",
    organization := "io.scalajs.npm",
    description := "Cookie binding for Scala.js"
  )

lazy val cookie_parser = (project in file("app/npmjs/cookie-parser")).
  dependsOn(nodejs, cookie, express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "cookie-parser",
    organization := "io.scalajs.npm",
    description := "Cookie-parser binding for Scala.js"
  )

lazy val csv_parse = (project in file("app/npmjs/csv-parse")).
  dependsOn(nodejs, readable_stream % "test->test").
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "csv-parse",
    organization := "io.scalajs.npm",
    description := "CSV-parse binding for Scala.js")


lazy val csvtojson = (project in file("app/npmjs/csvtojson")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "csvtojson",
    organization := "io.scalajs.npm",
    description := "CSV-to-JSON binding for Scala.js"
  )

lazy val drama = (project in file("app/npmjs/drama")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "drama",
    organization := "io.scalajs.npm",
    description := "Drama binding for Scala.js"
  )

lazy val engine_io = (project in file("app/npmjs/engine-io")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "engine-io",
    organization := "io.scalajs.npm",
    description := "Engine.io binding for Scala.js"
  )

lazy val escape_html = (project in file("app/npmjs/escape-html")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "escape-html",
    organization := "io.scalajs.npm",
    description := "Escape-HTML binding for Scala.js"
  )

lazy val feedparser = (project in file("app/npmjs/feedparser-promised")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "feedparser-promised",
    organization := "io.scalajs.npm",
    description := "Feedparser-promised binding for Scala.js"
  )

lazy val filed = (project in file("app/npmjs/filed")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "filed",
    organization := "io.scalajs.npm",
    description := "Filed binding for Scala.js"
  )

lazy val form_data = (project in file("app/npmjs/form-data")).
  dependsOn(nodejs, request % "test->test").
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "form-data",
    organization := "io.scalajs.npm",
    description := "A library to create readable \"multipart/form-data\" streams.")

lazy val github_api_node = (project in file("app/npmjs/github-api-node")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "github-api-node",
    organization := "io.scalajs.npm",
    description := "A higher-level wrapper around the Github API."
  )

lazy val glob = (project in file("app/npmjs/glob")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "glob",
    organization := "io.scalajs.npm",
    description := "Glob binding for Scala.js"
  )

lazy val gzip_uncompressed_size = (project in file("app/npmjs/gzip-uncompressed-size")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "gzip-uncompressed-size",
    organization := "io.scalajs.npm",
    description := "gzip-uncompressed-size binding for Scala.js"
  )

lazy val html_to_json = (project in file("app/npmjs/html-to-json")).
  dependsOn(dom_html, jquery, nodejs, request).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "html-to-json",
    organization := "io.scalajs.npm",
    description := "html-to-json binding for Scala.js"
  )

lazy val htmlparser2 = (project in file("app/npmjs/htmlparser2")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "htmlparser2",
    organization := "io.scalajs.npm",
    description := "htmlparser2 binding for Scala.js"
  )

lazy val ip = (project in file("app/npmjs/ip")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "ip",
    organization := "io.scalajs.npm",
    description := "IP address utilities for node.js"
  )

lazy val jsdom = (project in file("app/npmjs/jsdom")).
  dependsOn(nodejs, dom_html, jquery).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "jsdom",
    organization := "io.scalajs.npm",
    description := "JsDom binding for Scala.js"
  )

lazy val jwt_simple = (project in file("app/npmjs/jwt-simple")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "jwt-simple",
    organization := "io.scalajs.npm",
    description := "JWT-simple binding for Scala.js"
  )

lazy val kafka_node = (project in file("app/npmjs/kafka-node")).
  dependsOn(nodejs, node_zookeeper_client).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "kafka-node",
    organization := "io.scalajs.npm",
    description := "Kafka-node binding for Scala.js"
  )

lazy val md5 = (project in file("app/npmjs/md5")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "md5",
    organization := "io.scalajs.npm",
    description := "MD5 binding for Scala.js"
  )

lazy val memory_fs = (project in file("app/npmjs/memory-fs")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "memory-fs",
    organization := "io.scalajs.npm",
    description := "Memory-fs binding for Scala.js"
  )

lazy val minimist = (project in file("app/npmjs/minimist")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "minimist",
    organization := "io.scalajs.npm",
    description := "Parse argument options."
  )

lazy val mkdirp = (project in file("app/npmjs/mkdirp")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "mkdirp",
    organization := "io.scalajs.npm",
    description := "Mkdirp binding for Scala.js"
  )

lazy val mysql = (project in file("app/npmjs/mysql")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "mysql",
    organization := "io.scalajs.npm",
    description := "MySQL binding for Scala.js"
  )

lazy val nock = (project in file("app/npmjs/nock")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "nock",
    organization := "io.scalajs.npm",
    description := "Nock is an HTTP mocking and expectations library for Node.js"
  )

lazy val node_fetch = (project in file("app/npmjs/node-fetch")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "node-fetch",
    organization := "io.scalajs.npm",
    description := "A light-weight module that brings window.fetch to Node.js"
  )

lazy val node_zookeeper_client = (project in file("app/npmjs/node-zookeeper-client")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "node-zookeeper-client",
    organization := "io.scalajs.npm",
    description := "Node-Zookeeper client binding for Scala.js"
  )

lazy val numeral = (project in file("app/npmjs/numeral")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "numeral",
    organization := "io.scalajs.npm",
    description := "Numeral binding for Scala.js"
  )

lazy val oppressor = (project in file("app/npmjs/oppressor")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "oppressor",
    organization := "io.scalajs.npm",
    description := "Oppressor binding for Scala.js"
  )

lazy val otaat_repl = (project in file("app/npmjs/otaat-repl")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "otaat-repl",
    organization := "io.scalajs.npm",
    description := "A Node.js REPL that helps you do \"One thing at a time\""
  )

lazy val readable_stream = (project in file("app/npmjs/readable-stream")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "readable-stream",
    organization := "io.scalajs.npm",
    description := "Readable-stream binding for Scala.js"
  )

lazy val redis = (project in file("app/npmjs/redis")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "redis",
    organization := "io.scalajs.npm",
    description := "This is a complete and feature rich Redis client for node.js"
  )

lazy val request = (project in file("app/npmjs/request")).
  dependsOn(tough_cookie).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "request",
    organization := "io.scalajs.npm",
    description := "Request binding for Scala.js"
  )

lazy val rxjs = (project in file("app/npmjs/rx")).
  aggregate(transducers).
  dependsOn(nodejs, transducers).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "rx",
    organization := "io.scalajs.npm",
    description := "rx.js binding for Scala.js"
  )

lazy val splitargs = (project in file("app/npmjs/splitargs")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "splitargs",
    organization := "io.scalajs.npm",
    description := "SplitArgs binding for Scala.js"
  )

lazy val stream_throttle = (project in file("app/npmjs/stream-throttle")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "stream-throttle",
    organization := "io.scalajs.npm",
    description := "Stream-throttle binding for Scala.js"
  )

lazy val sync_request = (project in file("app/npmjs/sync-request")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "sync-request",
    organization := "io.scalajs.npm",
    description := "Sync-request binding for Scala.js"
  )

lazy val throttle = (project in file("app/npmjs/throttle")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "throttle",
    organization := "io.scalajs.npm",
    description := "Node.js Transform stream that passes data through at n bytes per second"
  )

lazy val tough_cookie = (project in file("app/npmjs/tough-cookie")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "tough-cookie",
    organization := "io.scalajs.npm",
    description := "Tough-Cookie binding for Scala.js"
  )

lazy val transducers = (project in file("app/npmjs/transducers-js")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "transducers-js",
    organization := "io.scalajs.npm",
    description := "Transducers.js binding for Scala.js"
  )

lazy val type_is = (project in file("app/npmjs/type-is")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "type-is",
    organization := "io.scalajs.npm",
    description := "Type-is binding for Scala.js"
  )

lazy val watch = (project in file("app/npmjs/watch")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "watch",
    organization := "io.scalajs.npm",
    description := "Watch binding for Scala.js"
  )

lazy val xml2js = (project in file("app/npmjs/xml2js")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "xml2js",
    organization := "io.scalajs.npm",
    description := "XML2js binding for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      Bundles
/////////////////////////////////////////////////////////////////////////////////

lazy val complete_platform = (project in file("app/bundles/complete")).
  aggregate(
    amcharts, core, dom_html, jquery, nodejs, phaser, pixijs, facebook, linkedin, angular_platform,
    // npm packages
    async, aws_sdk, bcrypt, bignum, body_parser, brake, buffermaker, cassandra_driver, chalk, cheerio,
    colors, combined_stream, cookie, cookie_parser, csv_parse, csvtojson, drama, engine_io, escape_html,
    express, express_csv, express_fileupload, express_ws, feedparser, filed, form_data, github_api_node,
    glob, gzip_uncompressed_size, html_to_json, htmlparser2, ip, jsdom, jvm_io, jwt_simple, kafka_node,
    md5, memory_fs, mkdirp, moment, moment_duration_format, moment_range, moment_timezone,
    mongodb, mongoose, mpromise, multer, mysql, nock, node_fetch, node_zookeeper_client,
    numeral, oppressor, otaat_repl, readable_stream, redis, request, rxjs, splitargs,
    stream_throttle, sync_request, throttle, tingodb, tough_cookie, transducers, type_is,
    watch, winston, winston_daily_rotate_file, xml2js).
  dependsOn(
    amcharts, core, dom_html, jquery, nodejs, phaser, pixijs, facebook, linkedin, angular_platform,
    // npm packages
    async, aws_sdk, bcrypt, bignum, body_parser, brake, buffermaker, cassandra_driver, chalk, cheerio,
    colors, combined_stream, cookie, cookie_parser, csv_parse, csvtojson, drama, engine_io, escape_html,
    express, express_csv, express_fileupload, express_ws, feedparser, filed, form_data, github_api_node,
    glob, gzip_uncompressed_size, html_to_json, htmlparser2, ip, jsdom, jvm_io, jwt_simple, kafka_node,
    md5, memory_fs, mkdirp, moment, moment_duration_format, moment_range, moment_timezone,
    mongodb, mongoose, mpromise, multer, mysql, nock, node_fetch, node_zookeeper_client,
    numeral, oppressor, otaat_repl, readable_stream, redis, request, rxjs, splitargs,
    stream_throttle, sync_request, throttle, tingodb, tough_cookie, transducers, type_is,
    watch, winston, winston_daily_rotate_file, xml2js).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings ++ publishingSettings: _*).
  settings(
    name := "complete-platform",
    organization := "io.scalajs",
    description := "Complete platform bundle",
    crossScalaVersions := Nil,
    publish / skip := true
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
    <url>https://github.com/scalajs-io/scalajs-io</url>
      <licenses>
        <license>
          <name>MIT License</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:github.com/scalajs-io/scalajs-io.git</connection>
        <developerConnection>scm:git:git@github.com:scalajs-io/scalajs-io.git</developerConnection>
        <url>github.com/scalajs-io/scalajs-io.git</url>
      </scm>
      <developers>
        <developer>
          <id>ldaniels528</id>
          <name>Lawrence Daniels</name>
          <email>lawrence.daniels@gmail.com</email>
          <organization>io.scalajs</organization>
          <organizationUrl>https://github.com/scalajs-io</organizationUrl>
          <roles>
            <role>Project-Administrator</role>
            <role>Developer</role>
          </roles>
          <timezone>+7</timezone>
        </developer>
      </developers>
)

// loads the Scalajs-io root project at sbt startup
onLoad in Global := (Command.process("project complete_platform", _: State)) compose (onLoad in Global).value
