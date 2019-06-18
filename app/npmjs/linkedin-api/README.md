Linkedin API for Scala.js
================================
[linkedin](https://developer.linkedin.com/docs) - Linkedin SDK for Scala.js

### Description

Linkedin SDK for Scala.js

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

Inside of your HTML index page:

```html
<script type="text/javascript" src="//platform.linkedin.com/in.js">
    api_key: [YOUR_API_KEY_GOES_HERE]
    authorize: true
    onLoad: linkedInInit
    scope: r_basicprofile r_emailaddress rw_company_admin w_share
</script>
```

Within your Scala.js application:

```scala
import io.scalajs.social.linkedin._
import scalajs.js

js.Dynamic.global.linkedInInit = () => {
    val injector = angular.element(jQuery("#Main")).injector()
    injector.get[MySessionService]("MySession").toOption match {
        case Some(mySession) =>
            console.info("Initializing LinkedIn API...")
            mySession.initLinkedIn(LinkedIn.IN)
        case None =>
            console.error("MySession could not be retrieved.")
    }
}
```

Afterwards, you may call any LinkedIn API that you have the permissions to execute: 

```scala
import io.scalajs.social.linkedin._
import scalajs.js

var linkedInID: js.UndefOr[String] = js.undefined

// read the authenticated user's profile
IN.API.Profile(js.Array("me")) onComplete {
    case Success(response) =>
        linkedInID = response.values.headOption.flatMap(_.id.toOption).orUndefined
    case Failure(e) =>
        console.error(s"Failed to retrieve LinkedIn profile - ${e.getMessage}")
}
```

### Artifacts and Resolvers

To add the `Linkedin` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs" %%% "linkedin-api" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```