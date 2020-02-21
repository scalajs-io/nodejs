import sbt._
import sbt.Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {
  val scalaReflect = Def.setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)

  val core = Def.setting(
    Seq(
      scalaReflect.value,
      "org.scalatest" %%% "scalatest" % "3.1.1" % "test"
    )
  )

  val app = Def.setting(
    Seq(
      scalaReflect.value,
      "org.scalatest"             %%% "scalatest" % "3.1.1" % "test",
      "com.thoughtworks.enableIf" %% "enableif"   % "1.1.7"
    )
  )
}
