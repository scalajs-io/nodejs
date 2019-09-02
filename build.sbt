organization in ThisBuild := "net.exoego"

lazy val root = (project in file("."))
  .aggregate(core, current, nodejs_v8)
  .settings(MySettings.commonSettings)
  .settings(MySettings.publishingSettings)
  .settings(MySettings.nonPublishingSetting)
  .settings(
    name := "scala-js-nodejs"
  )

lazy val core = (project in file("./core"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.publishingSettings)
  .settings(
    name := "scala-js-nodejs-core",
    libraryDependencies ++= Dependencies.core.value
  )

lazy val compilerSwitches = (project in file("./compiler-switches"))
  .settings(MySettings.commonSettings)
  .settings(MySettings.nonPublishingSetting)
  .settings(
    libraryDependencies += Dependencies.scalaReflect.value
  )

lazy val current = (project in file("./app/current"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.commonMacroParadiseSetting)
  .settings(MySettings.publishingSettings)
  .settings(
    scalacOptions ++= Seq(
      "-Xmacro-settings:nodeJs12.5.0"
    ),
    name := "scala-js-nodejs-v12",
    libraryDependencies ++= Dependencies.app.value
  )
  .dependsOn(core, compilerSwitches)

lazy val nodejs_v10 = (project in file("./app/nodejs-v10"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.commonMacroParadiseSetting)
  .settings(MySettings.publishingSettings)
  .settings(
    unmanagedSourceDirectories in Compile += (baseDirectory in current).value / "src" / "main" / "scala",
    scalacOptions ++= Seq(
      "-Xmacro-settings:nodeJs10.16.0"
    ),
    name := "scala-js-nodejs-v10",
    description := "NodeJS v10.16.0 API for Scala.js",
    homepage := Some(url("https://github.com/exoego/scala-js-nodejs")),
    libraryDependencies ++= Dependencies.app.value
  )
  .dependsOn(core, compilerSwitches)

lazy val nodejs_v8 = (project in file("./app/nodejs-v8"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.commonMacroParadiseSetting)
  .settings(MySettings.publishingSettings)
  .settings(
    unmanagedSourceDirectories in Compile += (baseDirectory in current).value / "src" / "main" / "scala",
    scalacOptions ++= Seq(
      "-Xmacro-settings:nodeJs8.16.0"
    ),
    name := "scala-js-nodejs-v8",
    description := "NodeJS v8.16.0 API for Scala.js",
    homepage := Some(url("https://github.com/exoego/scala-js-nodejs")),
    libraryDependencies ++= Dependencies.app.value
  )
  .dependsOn(core, compilerSwitches)
