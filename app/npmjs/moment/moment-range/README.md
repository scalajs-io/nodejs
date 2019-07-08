MomentRange API for Scala.js
=======================
[moment-range](https://www.npmjs.com/package/moment-range) - Parse and display moments in any range.

### Description

Parse and display [moment](https://github.com/scalajs-io/moment)s in any range.

### Build Dependencies

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)x

### Build/publish the SDK locally

```bash
$ sbt clean publish-local
```

#### Run the tests

```bash
$ sbt test
```

### Examples

Create a date range:

```
val start = new js.Date(2012, 0, 15);
val end   = new js.Date(2012, 4, 23);
val range = moment.range(start, end);
```
You can also create a date range with moment objects:
```
val start = moment("2011-04-15", "YYYY-MM-DD");
val end   = moment("2011-11-27", "YYYY-MM-DD");
val range = moment.range(start, end);
```
Arrays work too:
```
val dates = [moment("2011-04-15", "YYYY-MM-DD"), moment("2011-11-27", "YYYY-MM-DD")];
val range = moment.range(dates);
```
You can also create a range from an ISO 8601 time interval string:
```
val timeInterval = "2015-01-17T09:50:04+00:00/2015-04-17T08:29:55+00:00";
val range = moment.range(timeInterval);
```

### Artifacts and Resolvers

To add the `MomentRange` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "moment-range" % "0.6.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
