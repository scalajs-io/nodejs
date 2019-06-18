Cheerio API for Scala.js
================================
[cheerio](https://www.npmjs.com/package/cheerio) - A tiny, fast, and elegant implementation of core jQuery designed specifically for the server.

### Description

Fast, flexible & lean implementation of core jQuery designed specifically for the server.

### Build Requirements

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

```scala
import io.scalajs.npm.cheerio._

val input = """<h2 class="title">Hello world</h2>"""
val $ = Cheerio.load(input)

$("h2.title").text("Hello there!")
$("h2").addClass("welcome")

val output = $.html()
println(s"after:  $output") // => <h2 class="title welcome">Hello there!</h2>
```

### Artifacts and Resolvers

To add the `Cheerio` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "cheerio" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```