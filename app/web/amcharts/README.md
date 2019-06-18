AmCharts API for Scala.js
================================
[amcharts](https://www.amcharts.com/) - JavaScript Charts & Maps.

### Description

JavaScript Charts & Maps

Programming library for all your data visualization needs.

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
```

### Artifacts and Resolvers

To add the `amcharts` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "amcharts" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```