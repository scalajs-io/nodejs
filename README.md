Node.sjs
=============
Type-safe Scala.js Bindings for the MEAN Stack (MongoDB ExpressJS AngularJS NodeJS)

## Introduction

The goal of Node.sjs is to be complete set of type-safe Scala.js bindings for the entire MEAN Stack. Node.sjs goes to 
great lengths to make all the things you love about writing Scala on the back-end, to the front-end. To that end, various
refinements have been added to make the transition more seamless.

## Defining a Module

```scala
val module = angular.createModule("shocktrade",
  js.Array("ngAnimate", "ngCookies", "ngRoute", "ngSanitize", "nvd3ChartDirectives", "toaster", "ui.bootstrap"))

// add the custom directives
module.directiveOf[AvatarDirective]("avatar")
module.directiveOf[ChangeArrowDirective]("changearrow")

// add the custom filters
module.filter("duration", Filters.duration)
module.filter("yesno", Filters.yesNo)

// add the controllers and services
module.controllerOf[DiscoverController]("DiscoverController")
module.serviceOf[FacebookService]("Facebook")
module.serviceOf[MySession]
module.serviceOf[QuoteService]

// define the routes
module.config({ ($routeProvider: RouteProvider) =>
  $routeProvider
    .when("/about/us", RouteTo(templateUrl = "/assets/views/about/us.htm"))
    .when("/discover", RouteTo(templateUrl = "/assets/views/discover/discover.htm", controller = "DiscoverController"))
    .when("/discover/:symbol", RouteTo(templateUrl = "/assets/views/discover/discover.htm", controller = "DiscoverController"))
    .otherwise(RouteTo(redirectTo = "/about/us"))
})

// initialize the application
module.run({ (WebSocketService: WebSocketService) =>
  // inject Facebook's JavaScript SDK
  FacebookInjector.init()

  // initialize the web socket service
  WebSocketService.init()
})
```

## ScalaScript Examples

### Filter Example

```scala
val yesNo: js.Function = () => ((state: Boolean) => if (state) "Yes" else "No"): js.Function

module.filter("yesno", yesNo)
```

### Controller Example 1: Js.Dynamic Impelementation

```scala
module.controllerOf[AwardsController]("AwardsCtrl")

class AwardsController($scope: js.Dynamic, $http: Http, @injected("MySession") mySession: MySession) 
    extends Controller {

  $scope.getAwards = () => AvailableAwards

  $scope.getMyAwards = () => getMyAwards

  $scope.getAwardImage = (code: String) => AwardIconsByCode.get(code).orNull

  $scope.setupAwards = () => setupAwards()
    
  private def getMyAwards: js.Array[js.Dynamic] = {
    mySession.getMyAwards() map (code => AwardsByCode.get(code).orNull)
  }

  private def setupAwards() {
    console.log("Setting up awards....")
    AvailableAwards foreach { award =>
      award.owned = mySession.getMyAwards().contains(award.code.as[String])
    }
  }
}
```

In the example above, we're using a Scala.js JSON literal as our scope. While this is very flexible, it's not at all 
type-safe. In addition, most IDE's will be unable to provide any useful type inference information. 

### Controller Example 2: Type-Safe Implementation

```scala
class AwardsController($scope: Scope, $http: Http, @injected("MySession") mySession: MySession)
  extends Controller {

  ///////////////////////////////////////////////////////////////////////////
  //          Public Functions
  ///////////////////////////////////////////////////////////////////////////

  @scoped def getAwards = Award.AvailableAwards map { award =>
    val myAward = award.asInstanceOf[MyAward]
    myAward.owned = mySession.getMyAwards.contains(award.code)
    myAward
  } sortBy (_.owned) reverse

  @scoped def getAwardImage(code: String) = AwardIconsByCode.get(code).orNull

  @scoped def getMyAwards = mySession.getMyAwards map (code => AwardsByCode.get(code).orNull)

}

trait Award extends js.Object {
  var name: String = js.native
  var code: String = js.native
  var icon: String = js.native
  var description: String = js.native
}

trait MyAward extends Award {
  var owned: Boolean = js.native
}
```

In the example above, we using a generic scope object because we don't need to specify any custom scope variables, and 
we're using the `@scope` macro annotation to attach our methods to the `$scope` variable. 

### Modal Dialog &#8212; Controller and Service

```scala
class InvitePlayerDialog($http: Http, $modal: Modal) extends Service {
  def popup(participant: Participant): Future[InvitePlayerDialogResult] = {
    val modalInstance = $modal.open[InvitePlayerDialogResult](ModalOptions(
      templateUrl = "invite_player_dialog.htm",
      controllerClass = classOf[InvitePlayerDialogController]
    ))
    modalInstance.result
  }
}

class InvitePlayerDialogController($scope: InvitePlayerScope, $modalInstance: ModalInstance[InvitePlayerDialogResult],
                                   @injected("MySession") mySession: MySession)
  extends Controller {

  private val myFriends = mySession.fbFriends
  $scope.invites = emptyArray[TaggableFriend]

  @scoped def getFriends = myFriends

  @scoped def getInvitedCount = $scope.invites.count(invitee => isDefined(invitee))

  @scoped def getInvites = $scope.invites

  @scoped def ok() = $modalInstance.close(getSelectedFriends)

  @scoped def cancel() = $modalInstance.dismiss("cancel")

  private def getSelectedFriends = {
    val selectedFriends = emptyArray[TaggableFriend]
    for (n <- 0 to $scope.invites.length) {
      if (isDefined($scope.invites(n))) selectedFriends.push(myFriends(n))
    }
    selectedFriends
  }
}

trait InvitePlayerScope extends Scope {
  var invites: js.Array[TaggableFriend] = js.native
}

object InvitePlayerDialogController {
  type InvitePlayerDialogResult = js.Array[TaggableFriend]
}
```

### Service Example

```scala
module.serviceOf[MarketStatusService]("MarketStatusSvc")

class MarketStatusService($http: Http) extends Service {

  def getMarketStatus(implicit ec: ExecutionContext): Future[MarketStatus] = {
    $http.get[MarketStatus]("/api/tradingClock/status")
  }
  
}

trait MarketStatus extends js.Object {
  var stateChanged: Boolean = js.native
  var active: Boolean = js.native
  var sysTime: Double = js.native
  var delay: Double = js.native
  var start: Double = js.native
  var end: Double = js.native
}
```

### Directive Example

```scala
module.directiveOf[ChangeArrowDirective]("changearrow")

class ChangeArrowDirective extends Directive[ChangeArrowDirectiveScope] {
  override val restrict = "E"
  override val scope = JS(value = "@value")
  override val transclude = true
  override val replace = false
  override val template = """<i ng-class="icon"></i>"""

  override def link(scope: ChangeArrowDirectiveScope, element: JQLite, attrs: Attributes) = {
    scope.$watch("value", { (newValue: js.UndefOr[Any], oldValue: js.UndefOr[Any]) =>
      scope.icon = newValue.toOption flatMap getNumericValue map {
        case v if v > 0 => "fa fa-arrow-up positive"
        case v if v < 0 => "fa fa-arrow-down negative"
        case _ => "fa fa-minus null"
      } orNull
    })
  }

  private def getNumericValue(newValue: Any): Option[Double] = newValue match {
    case n: Number => Some(n.doubleValue)
    case s: String if s.nonEmpty => Try(s.toDouble).toOption
    case _ => None
  }
}

trait ChangeArrowDirectiveScope extends Scope {
  var value: js.UndefOr[Any] = js.native
  var icon: String = js.native
}

object ChangeArrowDirectiveScope {
  def apply(): ChangeArrowDirectiveScope = {
    val scope = new js.Object().asInstanceOf[ChangeArrowDirectiveScope]
    scope.icon = null
    scope
  }
}
```

## The Refinements

### Durations

ScalaScript provides implicit conversions so that you may use `scala.concurrent.duration.FiniteDuration`s with `$timeout`,
`$interval`, and any other services that use time in milliseconds.

```scala
import com.github.ldaniels528.nodesjs.core.TimerConversions._

$timeout(() => doSomething(), 5.minutes)
```

### JSON data as Scala objects

ScalaScript allows you to utilize dynamic JavaScript objects or type-safe Scala objects using traits. 
Consider the following example:

```scala
$http.get[js.Dynamic]("/api/tradingClock/status") onComplete {
    case Success(obj) => console.log(angular.toJson(obj))
    case Failure(e) => ...
}
```

Above we retrieve a JSON object (see below) in much the same fashion as you would using native JavaScript. Sometimes
one may want to retrieve the data as a `js.Dynamic` because of the flexibility it offers.

```json
{"stateChanged":false,"active":false,"sysTime":1392092448795,"delay":-49848795,"start":1392042600000,"end":1392066000000}
```

However, sometimes we instead want to retrieve the data as a type-safe Scala object. ScalaScript makes this as simple as:

```scala
$http.get[MarketStatus]("/api/tradingClock/status") onComplete {
    case Success(status) => ...
    case Failure(e) => ...
}

trait MarketStatus extends js.Object {
    var stateChanged: Boolean = js.native
    var active: Boolean = js.native
    var sysTime: Double = js.native
    var delay: Double = js.native
    var start: Double = js.native
    var end: Double = js.native
}
```

Above, we retrieve a JSON object via the given API and return a Market Status object. *NOTE:* The fact 
that `MarketStatus` extends `js.Object` is significant.

### For Comprehensions

ScalaScript provides implicit conversions that convert a `HttpResponse[T]` into a `Future[T]`, we can also use `for`
comprehensions when we need to combine data from multiple API calls.

```scala
val outcome = for {
   symbols <- contestService.getHeldSecurities(playerId)
   quotes <- quoteService.getStockQuoteList(symbols)
 } yield quotes
```

The above code uses Scala's for comprehension to first retrieve a collection of symbols (via REST) and then use the 
symbols to then retrieve a collection of quotes (also via REST). 

To do the same in JavaScript would've required creating 
multiple promises (via $q) or ugly callbacks, and then there's the results gathering/error handling... which would also 
be more painful in JavaScript. 

Here's how it's handled via Scala.js:

```scala
outcome onComplete {
  case Success(updatedQuotes) =>
    obj.quotes = updatedQuotes
  case Failure(e) =>
    toaster.error(s"Failed to load Held Securities")
    console.error(s"Failed to load Held Securities: ${e.getMessage}")
}
```

### Social Components (Facebook and LinkedIn)

#### Sample Code for Facebook

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
import com.github.ldaniels528.nodesjs.social.facebook.Facebook.FB

val config = FacebookAppConfig(appId = "[YOUR_APP_KEY_GOES_HERE]", status = true, xfbml = true, version = "v2.5")
FB.init(config)
```

Assuming you're using AngularJS, within your Scala.js application, you define the AngularJS Facebook service:

```scala
module.serviceOf[FacebookService]("Facebook")
```
      
Finally, within your AngularJS controller or service you invoke the Facebook login:   
  
```scala    
import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

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
import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

val outcome = for {
  // load the user"s Facebook profile
  fbProfile <- facebook.getUserProfile
  fbFriends <- facebook.getTaggableFriends
} yield (fbProfile, friends)

outcome onComplete {
  case Success((fbProfile, friends)) =>
    console.log("fbProfile = ${angular.toJson(fbProfile, pretty = true)}")
    console.log(s"fbFriends = ${angular.toJson(fbFriends, pretty = true)}")
  case Failure(e) =>
    toaster.error(s"Failed to retrieve Facebook profile and friends - ${e.displayMessage}")
}
()
```

If you're not using AngularJS, you can use the Facebook SDK directly:

```scala
FB.login((response: js.UndefOr[FacebookLoginStatusResponse]) =>
  response.toOption match {
    case Some(resp) if resp.error.isEmpty =>
        console.log(s"auth = ${angular.toJson(auth)}")
    case Some(resp) => console.error(s"Error logging in to Facebook: ${resp.error}")
    case None => console.error("No response from Facebook servers")
  })     
```

#### Sample Code for LinkedIn

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
import com.github.ldaniels528.nodesjs.social.linkedin.LinkedIn.IN

var linkedInID: js.UndefOr[String] = js.undefined

// read the authenticated user's profile
IN.API.Profile(js.Array("me")) onComplete {
  case Success(response) =>
    linkedInID = response.values.headOption.flatMap(_.id.toOption).orUndefined
  case Failure(e) =>
    console.error(s"Failed to retrieve LinkedIn profile - ${e.getMessage}")
}
```