val scalaJSVersion =
  Option(System.getenv("SCALAJS_VERSION")).getOrElse("1.0.0")

addSbtPlugin("org.scala-js"      % "sbt-scalajs"   % scalaJSVersion)
addSbtPlugin("org.scalameta"     % "sbt-scalafmt"  % "2.3.1")
addSbtPlugin("org.xerial.sbt"    % "sbt-sonatype"  % "3.8.1")
addSbtPlugin("com.github.gseitz" % "sbt-release"   % "1.0.13")
addSbtPlugin("com.jsuereth"      % "sbt-pgp"       % "2.0.1")
addSbtPlugin("org.scoverage"     % "sbt-scoverage" % "1.6.1")
addSbtPlugin("com.dwijnand"      % "sbt-travisci"  % "1.2.0")
