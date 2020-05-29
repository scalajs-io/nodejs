organization in ThisBuild := "net.exoego"

lazy val root = (project in file("."))
  .aggregate(core, nodejs_v14, nodejs_v12, nodejs_v10)
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

lazy val nodejs_v14 = (project in file("./app/nodejs-v14"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.commonMacroParadiseSetting)
  .settings(MySettings.publishingSettings)
  .settings(
    scalacOptions ++= Seq(
      "-Xmacro-settings:nodeJs14.3.0"
    ),
    name := "scala-js-nodejs-v14",
    description := "NodeJS v14 API for Scala.js",
    libraryDependencies ++= Dependencies.app.value
  )
  .dependsOn(core)

lazy val nodejs_v12 = (project in file("./app/nodejs-v12"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.commonMacroParadiseSetting)
  .settings(MySettings.publishingSettings)
  .settings(
    unmanagedSourceDirectories in Compile ++= {
      val symlinkDir = baseDirectory.value / "src" / "main"
      val hasSymlink = symlinkDir.exists && symlinkDir.isDirectory
      Seq((baseDirectory in nodejs_v14).value / "src" / "main" / "scala").filter(_ => !hasSymlink)
    },
    scalacOptions ++= Seq(
      "-Xmacro-settings:nodeJs12.16.3"
    ),
    name := "scala-js-nodejs-v12",
    description := "NodeJS v12 API for Scala.js",
    libraryDependencies ++= Dependencies.app.value
  )
  .dependsOn(core)

lazy val nodejs_v10 = (project in file("./app/nodejs-v10"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.commonMacroParadiseSetting)
  .settings(MySettings.publishingSettings)
  .settings(
    unmanagedSourceDirectories in Compile ++= {
      val symlinkDir = baseDirectory.value / "src" / "main"
      val hasSymlink = symlinkDir.exists && symlinkDir.isDirectory
      Seq((baseDirectory in nodejs_v14).value / "src" / "main" / "scala").filter(_ => !hasSymlink)
    },
    scalacOptions ++= Seq(
      "-Xmacro-settings:nodeJs10.20.1"
    ),
    name := "scala-js-nodejs-v10",
    description := "NodeJS v10 API for Scala.js",
    libraryDependencies ++= Dependencies.app.value
  )
  .dependsOn(core)
