import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.{libraryDependencies, _}
import sbt.Project.projectToRef
import sbt._

import scala.language.postfixOps

val apiVersion = "0.3.0.0-RC1"
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
//      Core sub-project
/////////////////////////////////////////////////////////////////////////////////

lazy val core = (project in file("core")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "core",
    organization := "io.scalajs",
    description := "Scala.js core classes and utilities"
  )

/////////////////////////////////////////////////////////////////////////////////
//      DOM sub-projects
/////////////////////////////////////////////////////////////////////////////////

lazy val dom = (project in file("browser/dom")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "dom",
    organization := "io.scalajs",
    description := "Scala.js DOM/HTML"
  )

lazy val jquery = (project in file("browser/jquery")).
  aggregate(core, dom).
  dependsOn(core, dom).
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
  dependsOn(core, dom).
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
  dependsOn(jquery).
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
//      NodeJS platform
/////////////////////////////////////////////////////////////////////////////////

lazy val nodejs = (project in file("node")).
  dependsOn(core).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "nodejs",
    organization := "io.scalajs",
    description := "NodeJS bindings for Scala.js"
  )

/////////////////////////////////////////////////////////////////////////////////
//      NPM packages
/////////////////////////////////////////////////////////////////////////////////

lazy val npm_async = (project in file("npm/async")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-async",
    organization := "io.scalajs",
    description := "npm/async binding for Scala.js"
  )

lazy val npm_bcrypt = (project in file("npm/bcrypt")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-bcrypt",
    organization := "io.scalajs",
    description := "npm/bcrypt binding for Scala.js"
  )

lazy val npm_bignum = (project in file("npm/bignum")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-bignum",
    organization := "io.scalajs",
    description := "npm/bignum binding for Scala.js"
  )

lazy val npm_body_parser = (project in file("npm/body-parser")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-body-parser",
    organization := "io.scalajs",
    description := "npm/body-parser binding for Scala.js"
  )

lazy val npm_buffermaker = (project in file("npm/buffermaker")).
  dependsOn(nodejs, npm_bignum).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-buffermaker",
    organization := "io.scalajs",
    description := "npm/buffermaker binding for Scala.js"
  )

lazy val npm_cassandra_driver = (project in file("npm/cassandra-driver")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-cassandra-driver",
    organization := "io.scalajs",
    description := "npm/cassandra-driver binding for Scala.js"
  )

lazy val npm_cheerio = (project in file("npm/cheerio")).
  dependsOn(dom, jquery, nodejs, npm_htmlparser2).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-cheerio",
    organization := "io.scalajs",
    description := "npm/cheerio binding for Scala.js"
  )

lazy val npm_colors = (project in file("npm/colors")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-colors",
    organization := "io.scalajs",
    description := "npm/colors binding for Scala.js"
  )

lazy val npm_csv_parse = (project in file("npm/csv-parse")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-csv-parse",
    organization := "io.scalajs",
    description := "npm/csv-parse binding for Scala.js"
  )

lazy val npm_drama = (project in file("npm/drama")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-drama",
    organization := "io.scalajs",
    description := "npm/drama binding for Scala.js"
  )

lazy val npm_escape_html = (project in file("npm/escape-html")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-escape-html",
    organization := "io.scalajs",
    description := "npm/escape-html binding for Scala.js"
  )

lazy val npm_express = (project in file("npm/express/core")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-express",
    organization := "io.scalajs",
    description := "npm/express binding for Scala.js"
  )

lazy val npm_express_csv = (project in file("npm/express/csv")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-express-csv",
    organization := "io.scalajs",
    description := "npm/express-csv binding for Scala.js"
  )

lazy val npm_express_fileupload = (project in file("npm/express/fileupload")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-express-fileupload",
    organization := "io.scalajs",
    description := "npm/express-fileupload binding for Scala.js"
  )

lazy val npm_express_multer = (project in file("npm/express/multer")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-express-multer",
    organization := "io.scalajs",
    description := "npm/express-multer binding for Scala.js"
  )

lazy val npm_express_ws = (project in file("npm/express/ws")).
  dependsOn(npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-express-ws",
    organization := "io.scalajs",
    description := "npm/express-ws binding for Scala.js"
  )

lazy val npm_feedparser = (project in file("npm/feedparser-promised")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-feedparser-promised",
    organization := "io.scalajs",
    description := "npm/feedparser-promised binding for Scala.js"
  )

lazy val npm_filed = (project in file("npm/filed")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-filed",
    organization := "io.scalajs",
    description := "npm/filed binding for Scala.js"
  )

lazy val npm_htmltojson = (project in file("npm/html_to_json")).
  dependsOn(dom, jquery, nodejs, npm_request).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-htmltojson",
    organization := "io.scalajs",
    description := "npm/htmltojson binding for Scala.js"
  )

lazy val npm_htmlparser2 = (project in file("npm/htmlparser2")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-htmlparser2",
    organization := "io.scalajs",
    description := "npm/htmlparser2 binding for Scala.js"
  )

lazy val npm_jsdom = (project in file("npm/jsdom")).
  dependsOn(nodejs, dom, jquery).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-jsdom",
    organization := "io.scalajs",
    description := "npm/jsdom binding for Scala.js"
  )

lazy val npm_jwt_simple = (project in file("npm/jwt-simple")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-jwt-simple",
    organization := "io.scalajs",
    description := "npm/jwt-simple binding for Scala.js"
  )

lazy val npm_kafka_node = (project in file("npm/kafka_node")).
  dependsOn(nodejs, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-kafkanode",
    organization := "io.scalajs",
    description := "npm/kafka-node binding for Scala.js"
  )

lazy val npm_kafka_rest = (project in file("npm/kafka-rest")).
  dependsOn(nodejs, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-kafka-rest",
    organization := "io.scalajs",
    description := "npm/kafka-rest binding for Scala.js"
  )

lazy val npm_md5 = (project in file("npm/md5")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-md5",
    organization := "io.scalajs",
    description := "npm/md5 binding for Scala.js"
  )

lazy val npm_memory_fs = (project in file("npm/memory-fs")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-memory-fs",
    organization := "io.scalajs",
    description := "npm/memory-fs binding for Scala.js"
  )

lazy val npm_moment = (project in file("npm/moment")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-moment",
    organization := "io.scalajs",
    description := "npm/moment binding for Scala.js"
  )

lazy val npm_moment_tz = (project in file("npm/moment_timezone")).
  dependsOn(npm_moment).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-moment-timezone",
    organization := "io.scalajs",
    description := "npm/moment-timezone binding for Scala.js"
  )

lazy val npm_mongodb = (project in file("npm/mongodb")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-mongodb",
    organization := "io.scalajs",
    description := "npm/mongodb binding for Scala.js"
  )

lazy val npm_mysql = (project in file("npm/mysql")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-mysql",
    organization := "io.scalajs",
    description := "npm/mysql binding for Scala.js"
  )

lazy val npm_node_embedded_mongodb = (project in file("npm/node_embedded_mongodb")).
  dependsOn(nodejs, npm_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-node-embedded-mongodb",
    organization := "io.scalajs",
    description := "npm/node-embedded-mongodb binding for Scala.js"
  )

lazy val npm_numeral = (project in file("npm/numeral")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-numeral",
    organization := "io.scalajs",
    description := "npm/numeral binding for Scala.js"
  )

lazy val npm_oppressor = (project in file("npm/oppressor")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-oppressor",
    organization := "io.scalajs",
    description := "npm/oppressor binding for Scala.js"
  )

lazy val npm_request = (project in file("npm/request")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-request",
    organization := "io.scalajs",
    description := "npm/request binding for Scala.js"
  )

lazy val npm_rxjs = (project in file("npm/rxjs")).
  aggregate(npm_transducers).
  dependsOn(nodejs, npm_transducers).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-rxjs",
    organization := "io.scalajs",
    description := "npm/rxjs binding for Scala.js"
  )

lazy val npm_should = (project in file("npm/should")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-should",
    organization := "io.scalajs",
    description := "npm/should binding for Scala.js"
  )

lazy val npm_socketio_client = (project in file("npm/socket.io/client")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-socketio-client",
    organization := "io.scalajs",
    description := "npm/socket.io-client binding for Scala.js"
  )

lazy val npm_socketio_server = (project in file("npm/socket.io/server")).
  dependsOn(nodejs, npm_socketio_client, npm_express).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-socketio",
    organization := "io.scalajs",
    description := "npm/socket.io binding for Scala.js"
  )

lazy val npm_splitargs = (project in file("npm/splitargs")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-splitargs",
    organization := "io.scalajs",
    description := "npm/splitargs binding for Scala.js"
  )

lazy val npm_tingodb = (project in file("npm/tingodb")).
  dependsOn(nodejs, npm_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-tingodb",
    organization := "io.scalajs",
    description := "npm/tingodb binding for Scala.js"
  )

lazy val npm_transducers = (project in file("npm/transducers")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-transducers",
    organization := "io.scalajs",
    description := "npm/transducers-js binding for Scala.js"
  )

lazy val npm_watch = (project in file("npm/watch")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-watch",
    organization := "io.scalajs",
    description := "npm/watch binding for Scala.js"
  )

lazy val npm_xml2js = (project in file("npm/xml2js")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-xml2js",
    organization := "io.scalajs",
    description := "npm/xml2js binding for Scala.js"
  )

lazy val npm_zookeeper = (project in file("npm/zookeeper-client")).
  dependsOn(nodejs).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-zookeeper-client",
    organization := "io.scalajs",
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
  aggregate(core, dom, jquery, nodejs, phaser, pixijs, bundle_social, bundle_angular, bundle_mean_minimal, bundle_npm).
  dependsOn(core, dom, jquery, nodejs, phaser, pixijs, bundle_social, bundle_angular, bundle_mean_minimal, bundle_npm).
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

lazy val bundle_mean_minimal = (project in file("bundles/mean_minimal")).
  aggregate(nodejs, npm_body_parser, npm_express, npm_express_fileupload, npm_express_ws, npm_mongodb).
  dependsOn(nodejs, npm_body_parser, npm_express, npm_express_fileupload, npm_express_ws, npm_mongodb).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-mean-bundle-minimal",
    organization := "io.scalajs",
    description := "MEAN stack bundle (minimal)"
  )

lazy val bundle_npm = (project in file("bundles/npm")).
  aggregate(
    npm_async, npm_bcrypt, npm_bignum, npm_body_parser, npm_buffermaker, npm_cassandra_driver,
    npm_colors, npm_csv_parse, npm_drama, npm_splitargs, npm_escape_html, npm_express, npm_express_csv,
    npm_express_fileupload, npm_express_multer, npm_express_ws, npm_feedparser, npm_filed, npm_htmlparser2, npm_htmltojson,
    npm_jsdom, npm_jwt_simple, npm_kafka_node, npm_kafka_rest,
    npm_memory_fs, npm_moment, npm_moment_tz, npm_mongodb, npm_mysql, npm_node_embedded_mongodb, npm_numeral, npm_oppressor,
    npm_md5, npm_request, npm_rxjs, npm_should, npm_socketio_client, npm_socketio_server,
    npm_tingodb, npm_transducers, npm_watch, npm_xml2js, npm_zookeeper).
  dependsOn(
    npm_async, npm_bcrypt, npm_bignum, npm_body_parser, npm_buffermaker, npm_cassandra_driver,
    npm_colors, npm_csv_parse, npm_drama, npm_splitargs, npm_escape_html, npm_express, npm_express_csv,
    npm_express_fileupload, npm_express_multer, npm_express_ws, npm_feedparser, npm_filed, npm_htmlparser2, npm_htmltojson,
    npm_jsdom, npm_jwt_simple, npm_kafka_node, npm_kafka_rest,
    npm_memory_fs, npm_moment, npm_moment_tz, npm_mongodb, npm_mysql, npm_node_embedded_mongodb, npm_numeral, npm_oppressor,
    npm_md5, npm_request, npm_rxjs, npm_should, npm_socketio_client, npm_socketio_server,
    npm_tingodb, npm_transducers, npm_watch, npm_xml2js, npm_zookeeper).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  settings(
    name := "npm-bundle",
    organization := "io.scalajs",
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
        <connection>scm:git:github.com/ldaniels528/scalajs-nodejs.git</connection>
        <developerConnection>scm:git:git@github.com:ldaniels528/scalajs-nodejs.git</developerConnection>
        <url>github.com/ldaniels528/scalajs-nodejs.git</url>
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

// loads the MEANS.js root project at sbt startup
onLoad in Global := (Command.process("project bundle_complete", _: State)) compose (onLoad in Global).value