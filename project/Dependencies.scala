import sbt._
import sbt.Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {
  val scalaReflect     = Def.setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)
  val scalatestVersion = "3.1.2"

  val core = Def.setting(
    Seq(
      scalaReflect.value,
      "org.scalatest" %%% "scalatest" % scalatestVersion % "test"
    )
  )

  val app = Def.setting(
    Seq(
      scalaReflect.value,
      "net.exoego"               %%% "scalajs-types-util" % "0.1.0",
      "org.scalatest"            %%% "scalatest"          % scalatestVersion % "test",
      "com.thoughtworks.enableIf" %% "enableif"           % "1.1.7"
    )
  )

}
