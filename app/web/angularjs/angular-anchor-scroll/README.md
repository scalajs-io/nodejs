Angular-anchor-scroll API for Scala.js
================================
[angular-anchor-scroll](https://www.npmjs.com/package/angular-anchor-scroll) - angular-anchor-scroll binding for Scala.js.

### Description

An `angular-anchor-scroll` binding for Scala.js.

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

### Artifacts and Resolvers

To add the `angular-anchor-scroll` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "angular-anchor-scroll" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```