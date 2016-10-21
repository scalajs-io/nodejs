addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.0")

// Scala.js

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.13" )

// Publishing

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "1.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-pgp" % "0.8.3")

// Resolvers

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.url("scala-js-snapshots", url("http://repo.scala-js.org/repo/snapshots/"))(Resolver.ivyStylePatterns)