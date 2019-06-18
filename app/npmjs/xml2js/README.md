Xml2js API for Scala.js
================================
[xml2js](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter.

### Description

Simple XML to JavaScript object converter. It supports bi-directional conversion. Uses sax-js and xmlbuilder-js.

Note: If you're looking for a full DOM parser, you probably want [JSDom](https://github.com/scalajs-io/jsdom).

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
import io.scalajs.npm.xml2js._
import scalajs.js

val xml = "<root>Hello xml2js!</root>"
Xml2js.parseString[MyObject](xml, (err, result) => {
    println("results: " + JSON.stringify(result)) // results: {"root":"Hello xml2js!"} 
    println(result.root) // Hello xml2js!
})

@js.native
trait MyObject extends js.Object {
  var root: String = js.native
}
```

### Artifacts and Resolvers

To add the `Xml2js` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "xml2js" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```