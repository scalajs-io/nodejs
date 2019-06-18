HtmlToJson API for Scala.js
================================
[html-to-json](https://www.npmjs.com/package/html-to-json) - Parses HTML strings into objects using flexible, composable filters.

### Description

Parses HTML strings into objects using flexible, composable filters.

### Build Dependencies

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
import io.scalajs.JSON
import io.scalajs.jquery.JQueryElement
import io.scalajs.npm.htmltojson._
import scalajs.js

val content =
    """<div>
      |<img src="http://some/server/image.jpg">
      |<a href="/a/link/to/something">This is a link</a>
      |This is a test
      |</div>""".stripMargin
      
      
val linkParser = HtmlToJson.createParser(
    js.Array("a[href]",
      js.Dictionary(
        "text" -> (($a: JQueryElement) => $a.text()),
        "href" -> (($a: JQueryElement) => $a.attr("href"))
      )))

println(s"linkParser = ${JSON.stringify(linkParser)}")
```

### Artifacts and Resolvers

To add the `HtmlToJson` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "html-to-json" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```