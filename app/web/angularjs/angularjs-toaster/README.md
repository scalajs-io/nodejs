AngularJS Toaster API for Scala.js
================================
[angularjs-toaster](https://www.npmjs.com/package/angularjs-toaster) - angularjs-toaster binding for Scala.js.

### Description

AngularJS Toaster is an AngularJS port of the `toastr` non-blocking notification jQuery library. 
It requires AngularJS v1.2.6 or higher and angular-animate for the CSS3 transformations.

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

To add the `angularjs-toaster` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "angularjs-toaster" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```