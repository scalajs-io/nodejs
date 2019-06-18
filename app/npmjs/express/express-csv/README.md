ExpressCSV API for Scala.js
================================
[express-csv](https://www.npmjs.com/package/express-csv) provides response csv easily to express.

### Description

<pre>
 _____                                 ____ ______     __
| ____|_  ___ __  _ __ ___  ___ ___   / ___/ ___\ \   / /
|  _| \ \/ / '_ \| '__/ _ \/ __/ __| | |   \___ \\ \ / / 
| |___ >  <| |_) | | |  __/\__ \__ \ | |___ ___) |\ V /  
|_____/_/\_\ .__/|_|  \___||___/___/  \____|____/  \_/   
           |_|                                                      
</pre>

Express CSV provides response CSV easily to Express.

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

##### A simple Express Server with CSV

```scala
import io.scalajs.npm.express._
import io.scalajs.npm.express.csv._
import scalajs.js

// load the Express modules
val app = Express()
ExpressCSV

app.get("/", { (_: Request, res: Response with CSVResponse) =>
    res.csv(
        js.Array(
          js.Array("a", "b", "c"),
          js.Array("d", "e", "f")
        ))
    })
  .listen(8080)
```

##### A simple client example

```scala
import io.scalajs.nodejs.http._
import io.scalajs.npm.express.csv._

Http.get("http://localhost:8080/", { response: ServerResponse =>
    response.onData { chunk =>
        val data = chunk.toString().split('\n').map(_.trim).mkString("|")
        println(data) // "a","b","c"|"d","e","f"
    }
})
```

### Artifacts and Resolvers

To add the `ExpressCSV` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "express-csv" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```