ToughCookie API for Scala.js
================================
[tough-cookie](https://www.npmjs.com/package/tough-cookie) - RFC6265 Cookies and Cookie Jar for node.js

#### Description

RFC6265 Cookies and Cookie Jar for node.js

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
import io.scalajs.npm.toughcookie._

val cookie = Cookie.parse("key1=value1")
println(s"cookie: ${JSON.stringify(cookie)}")
//=> cookie: {"key":"key1","value":"value1","creation":"2017-02-08T06:25:57.717Z"} 
```

### Artifacts and Resolvers

To add the `ToughCookie` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "tough-cookie" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```