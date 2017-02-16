// Scala.js

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.14")

// Code Formatting

addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.5.5")

// Testing

//addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.0")

// Publishing

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "1.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-pgp" % "0.8.3")

// Resolvers

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

resolvers += "TypeSafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.url("scala-js-snapshots", url("http://repo.scala-js.org/repo/snapshots/"))(Resolver.ivyStylePatterns)
