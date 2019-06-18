Phaser.js API for Scala.js
================================
[phaser](http://phaser.io/docs/2.6.2/) - A fast, free and fun HTML5 Game Framework for Desktop and Mobile web browsers.

### Description

Phaser is a fast, free, and fun open source HTML5 game framework. It uses a custom build of Pixi.js for 
WebGL and Canvas rendering, and supports desktop and mobile web browsers. Games can be compiled to iOS, 
Android and native desktop apps via 3rd party tools. You can use JavaScript or TypeScript for development.

Along with the fantastic open source community, Phaser is actively developed and maintained by Photon Storm. 
As a result of rapid support, and a developer friendly API, Phaser is currently one of the most starred game 
frameworks on GitHub.

Thousands of developers worldwide use Phaser. From indies and multi-national digital agencies, to schools 
and Universities. Each creating their own incredible games.

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

To add the `Phaser` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "phaser" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
