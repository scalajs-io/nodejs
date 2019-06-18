Angular UI Router API for Scala.js
================================
[angular-ui-router](https://www.npmjs.com/package/angular-ui-router) - angular-ui-router binding for Scala.js.

### Description

AngularUI Router is a routing framework for AngularJS, which allows you to organize the parts of your interface 
into a state machine. Unlike the $route service in the Angular ngRoute module, which is organized around URL routes, 
UI-Router is organized around states, which may optionally have routes, as well as other behavior, attached.

States are bound to named, nested and parallel views, allowing you to powerfully manage your application's interface.

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

To add the `angular-ui-router` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "angular-ui-router" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```