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

lazy val nodejs_v14 = createNodeVersionSpecificProject("14.3.0")
lazy val nodejs_v12 = createNodeVersionSpecificProject("12.16.3")
lazy val nodejs_v10 = createNodeVersionSpecificProject("10.20.1")

def createNodeVersionSpecificProject(nodeFullVersion: String) = {
  val majorVersion = nodeFullVersion.split("\\.")(0)
  sbt
    .Project(id = s"nodejs_v${majorVersion}", base = file(s"./app/nodejs-v${majorVersion}"))
    .enablePlugins(ScalaJSPlugin)
    .settings(MySettings.commonSettings)
    .settings(MySettings.commonScalaJsSettings)
    .settings(MySettings.commonMacroParadiseSetting)
    .settings(MySettings.publishingSettings)
    .settings(
      unmanagedSourceDirectories in Compile ++= {
        val symlinkDir = baseDirectory.value / "src" / "main"
        val hasSymlink = symlinkDir.exists && symlinkDir.isDirectory
        Seq(file("app") / "nodejs-v14" / "src" / "main" / "scala").filter(_ => majorVersion != "14" && !hasSymlink)
      },
      scalacOptions ++= Seq(
        s"-Xmacro-settings:nodeJs${nodeFullVersion}"
      ),
      name := s"scala-js-nodejs-v${majorVersion}",
      description := s"NodeJS v${majorVersion} API for Scala.js",
      libraryDependencies ++= Dependencies.app.value
    )
    .dependsOn(core)
}
