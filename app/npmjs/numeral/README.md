Numeral API for Scala.js
================================
[numeral](https://www.npmjs.com/package/numeral) - Format and manipulate numbers.

### Description

A javascript library for formatting and manipulating numbers.

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

##### Create

Create an instance of a numeral. Numeral takes numbers or strings that it trys to convert into a number.

```scala
import io.scalajs.npm.numeral.Numeral

val myNumeral = Numeral(1000)

val value = myNumeral.value() // 1000

val myNumeral2 = Numeral("1,000")

val value2 = myNumeral2.value() // 1000
```

| Input                | Value         |
|----------------------|---------------|
| Numeral(974)         | 974           |
| Numeral(0.12345)     | 0.12345       |
| Numeral("10,000.12") | 10000.12      |
| Numeral("23rd")      | 23            |
| Numeral("$10,000.00")| 10000         |
| Numeral("100B")      | 100           |
| Numeral("3.467TB")   | 3467000000000 |
| Numeral("-76%")	   | -0.76         |
| Numeral("2:23:57")   | NaN           |

##### Format

Numbers can be formatted to look like currency, percentages, times, or even plain old numbers with decimal places, thousands, and abbreviations. And you can always create a custom format.

```scala
import io.scalajs.npm.numeral._

val string = Numeral(1000).format("0,0") // "1,000"
```

| Number        | Format        | String            |
|---------------|---------------|-------------------|
| 10000	        | "0,0.0000"    |	10,000.0000     |
| 10000.23	    | "0,0"	        | 10,000            |
| 10000.23	    | "+0,0"	    | +10,000           |
| -10000	    | "0,0.0"	    | -10,000.0         |
| 10000.1234    | "0.000"	    | 10000.123         |
| 10000.1234    | "0[.]00000"	| 10000.12340       |
| -10000	    | "(0,0.0000)"	| (10,000.0000)     |
| -0.23	        | ".00"	        | -.23              |
| -0.23	        | "(.00)"	    | (.23)             |
| 0.23	        | "0.00000"	    | 0.23000           |
| 0.23	        | "0.0[0000]"	| 0.23              |
| 1230974	    | "0.0a"	    | 1.2m              |
| 1460	        | "0 a"	        | 1 k               |
| -104000	    | "0a"	        | -104k             |
| 1		        | "0o"          | 1st               |   
| 100	        | "0o"	        | 100th             |
    
### Artifacts and Resolvers

To add the `Numeral` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "numeral" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```