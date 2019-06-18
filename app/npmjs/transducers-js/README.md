Transducers-js API for Scala.js
================================
[transducers-js](https://www.npmjs.com/package/transducers-js) - A high performance Transducers implementation for JavaScript.

### Description

Transducers are composable algorithmic transformations. They are independent from the context of 
their input and output sources and specify only the essence of the transformation in terms of an 
individual element. Because transducers are decoupled from input or output sources, they can be 
used in many different processes - collections, streams, channels, observables, etc. Transducers 
compose directly, without awareness of input or creation of intermediate aggregates.

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

### Artifacts and Resolvers

To add the `TransducersJs` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "transducers-js" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```   
resolvers += Resolver.sonatypeRepo("releases") 
```