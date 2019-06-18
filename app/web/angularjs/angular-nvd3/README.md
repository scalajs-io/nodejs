Angular nvd3 API for Scala.js
================================
[angular-nvd3](https://www.npmjs.com/package/angular-nvd3) - An angular-nvd3 binging for Scala.js.

### Description

This thing is designed to make it easier to work with nvd3.js re-usable charting library. This directive allows you 
to easily customize your charts via JSON API.

The key feature is that the original hierarchical structure of nvd3 models is completely preserved in directive JSON 
structure. This means that while you creating a complex chart that containing multiple elementary chart models 
(such as line, bar, axis, ...), you can in turn customize the properties of each internal elementary models as well 
as the global charting properties the way you want. This can be done as usual, but it becomes quite easily to customize 
while applying JSON approach to.

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

To add the `angular-nvd3` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "angular-nvd3" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```