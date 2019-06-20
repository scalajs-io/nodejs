import sbt.url
import sbtrelease.ReleaseStateTransformations._

val scala212Version       = "2.12.8"
val scala213Version       = "2.13.0"
val supportedScalaVersion = Seq(scala212Version, scala213Version)

val scalatestVersion = "3.0.8"
val scalacticVersion = "3.0.8"

organization in ThisBuild := "net.exoego"

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
val nonPublishingSetting = Seq(
  publishArtifact := false,
  publish := {},
  publishLocal := {}
)

lazy val root = (project in file("."))
  .aggregate(core, common, nodejs_v8)
  .settings(commonSettings)
  .settings(publishingSettings)
  .settings(nonPublishingSetting)
  .settings(
    name := "scala-js-nodejs-all"
  )

lazy val core = (project in file("./core"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(commonScalaJsSettings)
  .settings(publishingSettings)
  .settings(
    name := "scala-js-nodejs-core",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalatest"  %%% "scalatest"   % scalatestVersion % "test"
    )
  )

lazy val common = (project in file("./app/common"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(commonScalaJsSettings)
  .settings(commonMacroParadiseSetting)
  .settings(publishingSettings)
  .settings(
    name := "scala-js-nodejs-common",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalactic"  %% "scalactic"    % scalacticVersion,
      "org.scalatest"  %%% "scalatest"   % scalatestVersion % "test"
    )
  )
  .dependsOn(core)

lazy val nodejs_v8 = (project in file("./app/nodejs_v8"))
  .dependsOn(common)
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(commonScalaJsSettings)
  .settings(commonMacroParadiseSetting)
  .settings(publishingSettings)
  .settings(
    name := "scala-js-nodejs-v8",
    description := "NodeJS v8.7.0 API for Scala.js",
    homepage := Some(url("https://github.com/exoego/scala-js-nodejs")),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalactic"  %% "scalactic"    % scalacticVersion,
      "org.scalatest"  %%% "scalatest"   % scalatestVersion % "test"
    )
  )
  .dependsOn(core)

lazy val publishingSettings = Seq(
  licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/exoego/scala-js-nodejs"),
      "scm:git:git@github.com:exoego/scala-js-nodejs.git"
    )
  ),
  homepage := scmInfo.value.map(_.browseUrl),
  developers := List(
    Developer(
      id = "exoego",
      name = "TATSUNO Yasuhiro",
      email = "ytatsuno.jp@gmail.com",
      url = url("https://www.exoego.net")
    )
  ),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishArtifact in (Compile, packageDoc) := true,
  publishArtifact in (Compile, packageSrc) := true,
  publishArtifact in packageDoc := false,
  pomIncludeRepository := { _ =>
    false
  },
  publishTo := Some(
    if (isSnapshot.value)
      Opts.resolver.sonatypeSnapshots
    else
      Opts.resolver.sonatypeStaging
  ),
  publishConfiguration := publishConfiguration.value.withOverwrite(false),
  publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true),
  sources in (Compile, doc) := Seq.empty,
  releaseIgnoreUntrackedFiles := true,
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    releaseStepCommandAndRemaining("+publishSigned"),
    setNextVersion,
    commitNextVersion,
    releaseStepCommand("sonatypeReleaseAll")
  )
)

// loads the Scalajs-io root project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value
