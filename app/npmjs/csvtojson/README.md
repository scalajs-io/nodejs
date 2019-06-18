csvtojson API for Scala.js
================================
[csvtojson](https://www.npmjs.com/package/csvtojson) - A tool concentrating on converting csv data to JSON with customised parser supporting

#### Description

Nodejs csv to json converter. Fully featured:

* Pipe in / Pipe out
* Use as Command Line tool or a Node.js lib
* Parse CSV to JSON or CSV column arrays
* Support all types of CSV
* Non-blocking parsing / multi core support
* Extremely fast: 4 - 6 times faster than other csv parsers on node.js
* Streaming data / low memory usage on large CSV data source

#### Build Dependencies

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)

#### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

#### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

#### Examples

##### Parse CSV from a string source

```scala
import io.scalajs.npm.csvtojson._
import io.scalajs.util.JSONHelper._
  
val csvStr =
    """1,2,3
      |4,5,6
      |7,8,9""".stripMargin

CsvToJson(new ParsingOptions(noheader = true))
    .fromString(csvStr)
    .onCsv { csvRow =>
        // this func will be called 3 times
        println(csvRow.toJson) // => [1,2,3] , [4,5,6]  , [7,8,9]
    }
    .onDone { () =>
        // parsing finished
    }
```

##### Parse CSV from a file

```scala
import io.scalajs.npm.csvtojson._
import io.scalajs.util.JSONHelper._

CsvToJson()
    .fromFile("./src/test/resources/data.csv")
    .onJson { jsonObj =>
      // combine csv header row and csv line to a json object
      // jsonObj.a ==> 1 or 4
      println(s"json: ${jsonObj.toJson}") // => {"a":"1","b":"2","c":"3"} , {"a":"4","b":"5","c":"6"}
    }
    .onDone { () =>
      // parsing finished
    }
```

The CSV file:

```text
a,b,c
1,2,3
4,5,6
```

#### Artifacts and Resolvers

To add the `CsvToJson` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "csvtojson" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 