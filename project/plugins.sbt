// Scala.js

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.0.0-M3")

// Publishing

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0")

// Resolvers

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "scala-js-snapshots" at "http://repo.scala-js.org/repo/snapshots/"