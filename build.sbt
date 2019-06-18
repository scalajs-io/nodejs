val scalaJsIOVersion      = "0.4.3"
val apiVersion            = scalaJsIOVersion
val scala212Version       = "2.12.8"
val scala213Version       = "2.13.0"
val supportedScalaVersion = Seq(scala212Version, scala213Version)

val scalatestVersion = "3.0.8"
val scalacticVersion = "3.0.8"

lazy val commonSettings = Seq(
  autoCompilerPlugins := true,
  crossScalaVersions := supportedScalaVersion,
  scalacOptions ++= Seq(
    "-deprecation",
    "-unchecked",
    "-feature",
    "-language:implicitConversions",
    "-Xlint",
    "-Xfatal-warnings"
  ),
  scalacOptions in (Compile, doc) ++= Seq("-no-link-warnings")
)
lazy val commonScalaJsSettings = Seq(
  scalacOptions += "-P:scalajs:sjsDefinedByDefault",
  scalaJSModuleKind := ModuleKind.CommonJSModule,
  logBuffered in Test := true
)
lazy val commonMacroParadiseSetting = Seq(
  Compile / scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, n)) if n >= 13 => "-Ymacro-annotations" :: Nil
      case _                       => Nil
    }
  },
  libraryDependencies ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, n)) if n >= 13 => Nil
      case _                       => compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full) :: Nil
    }
  }
)

lazy val root = (project in file("."))
  .aggregate(core, common, nodejs_v8)

lazy val core = (project in file("./core"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(commonScalaJsSettings)
  .settings(
    name := "core",
    organization := "io.scalajs",
    description := "Core utilities for the ScalaJs.io platform",
    version := apiVersion,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalatest"  %%% "scalatest"   % scalatestVersion % "test"
    )
  )

lazy val common = (project in file("./app/common"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(commonScalaJsSettings)
  .settings(
    name := "nodejs-common",
    version := apiVersion,
    organization := "io.scalajs",
    description := "NodeJS common API",
    homepage := Some(url("https://github.com/scalajs-io/nodejs")),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalactic"  %% "scalactic"    % scalacticVersion,
      "org.scalatest"  %%% "scalatest"   % scalatestVersion % "test"
    )
  )
  .settings(commonMacroParadiseSetting)
  .dependsOn(core)

lazy val nodejs_v8 = (project in file("./app/nodejs_v8"))
  .dependsOn(common)
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(commonScalaJsSettings)
  .settings(
    name := "nodejs",
    version := apiVersion,
    organization := "io.scalajs",
    description := "NodeJS v8.7.0 API for Scala.js",
    homepage := Some(url("https://github.com/scalajs-io/nodejs")),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalactic"  %% "scalactic"    % scalacticVersion,
      "org.scalatest"  %%% "scalatest"   % scalatestVersion % "test"
    )
  )
  .settings(commonMacroParadiseSetting)
  .dependsOn(core)

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
    <url>https://github.com/scalajs-io/nodejs</url>
      <licenses>
        <license>
          <name>MIT License</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:github.com/scalajs-io/nodejs.git</connection>
        <developerConnection>scm:git:git@github.com:scalajs-io/nodejs.git</developerConnection>
        <url>github.com/scalajs-io/nodejs.git</url>
      </scm>
      <developers>
        <developer>
          <id>scalajs-io</id>
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
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value
