JQuery API for Scala.js
================================
[jquery](http://api.jquery.com/) - JavaScript library for DOM operations

### Description

jQuery is a fast, small, and feature-rich JavaScript library.

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
import io.scalajs.jquery._
import io.scalajs.jquery.JQuery.$
import scala.scalajs.js
 
$("#greatphoto").attr(new js.Object {
    val alt: String = "Beijing Brush Seller"
    val title: String = "photo by Kelly Clark"
})
```

### Artifacts and Resolvers

To add the `JQuery` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "jquery" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```