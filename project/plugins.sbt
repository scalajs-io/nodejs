// Scala.js

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.14")

// Publishing

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "1.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-pgp" % "0.8.3")

// Resolvers

addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.5.5")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.url("scala-js-snapshots", url("http://repo.scala-js.org/repo/snapshots/"))(Resolver.ivyStylePatterns)
