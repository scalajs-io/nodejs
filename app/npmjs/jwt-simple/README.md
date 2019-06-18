JwtSimple API for Scala.js
================================
[jwt-simple](https://www.npmjs.com/package/jwt-simple) - JWT(JSON Web Token) encode and decode module.

### Description

JWT(JSON Web Token) encode and decode module.

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
import io.scalajs.npm.jwtsimple._
import scala.scalajs.js

val payload = js.Dictionary("foo" -> "bar")
val secret = "scalajs"

// encode
val token = JwtSimple.encode(payload, secret)
println(s"token: $token") //=> eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmb28iOiJiYXIifQ.GmVaWnUkI1glyMfggMz6u4T-8I5KPfk8Kmc4PxKJz50

// decode
val decoded = JwtSimple.decode(token, secret)
println(s"payload: ${JSON.stringify(decoded)}") //=> { foo: "bar" }
```

### Artifacts and Resolvers

To add the `JwtSimple` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "jwt-simple" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```