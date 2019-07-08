Facebook API for Scala.js
================================
A Scala.js type-safe binding for the Facebook SDK.

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

```javascript
<script>
    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>
```

Within your Scala.js application, you can initialize the Facebook SDK:

```scala
import io.scalajs.social.facebook._

val config = FacebookAppConfig(appId = "[YOUR_APP_KEY_GOES_HERE]", status = true, xfbml = true, version = "v2.5")
FB.init(config)
```

Assuming you're using AngularJS, within your Scala.js application, you define the AngularJS Facebook service:

```scala
module.serviceOf[FacebookService]("Facebook")
```
      
Finally, within your AngularJS controller or service you invoke the Facebook login:   
  
```scala    
import io.scalajs.util.ScalaJsHelper._

class SocialController($scope: SocialControllerScope, @injected("Facebook") facebook: FacebookService) extends Controller {
    private var facebookID: js.UndefOr[String] = js.undefined

    $scope.loginToFacebook = () => {
        facebook.login() onComplete {
          case Success(response) =>
            facebookID = response.authResponse.userID
          case Failure(e) =>
            toaster.error("Facebook Login Error", e.displayMessage)
        }
    }   
}

@js.native
trait SocialControllerScope extends Scope {
    var loginToFacebook: js.Function0[Unit] = js.native
}
```

Afterwards, you may call any Facebook API that you have the permissions to execute:

```scala
import io.scalajs.social.facebook._
import io.scalajs.util.ScalaJsHelper._

val outcome = for {
    fbProfile <- facebook.getUserProfile
    fbFriends <- facebook.getTaggableFriends
} yield (fbProfile, friends)

outcome onComplete {
    case Success((fbProfile, friends)) =>
        console.log(s"fbProfile = ${angular.toJson(fbProfile, pretty = true)}")
        console.log(s"fbFriends = ${angular.toJson(fbFriends, pretty = true)}")
    case Failure(e) =>
        toaster.error(s"Failed to retrieve Facebook profile and friends - ${e.displayMessage}")
}
```

If you're not using AngularJS, you can use the Facebook SDK directly:

```scala
import io.scalajs.social.facebook._
import scalajs.js

FB.login((response: js.UndefOr[FacebookLoginStatusResponse]) =>
    response.toOption match {
        case Some(resp) if resp.error.isEmpty => console.log(s"auth = ${angular.toJson(auth)}")
        case Some(resp) => console.error(s"Error logging in to Facebook: ${resp.error}")
        case None => console.error("No response from Facebook servers")
    }
)     
```

### Artifacts and Resolvers

To add the `Facebook` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs" %%% "facebook-api" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```