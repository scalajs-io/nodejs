package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.jwtsimple.JwtSimple
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}

import scala.scalajs.js

/**
  * jwt-simple Example
  * @author lawrence.daniels@gmail.com
  */
class JwtSimpleExample(bootstrap: Bootstrap) {
  import bootstrap._

  val jwt = require[JwtSimple]("jwt-simple")
  val payload = js.Dictionary("foo" -> "bar")
  val secret = "scalajs"

  // encode 
  val token = jwt.encode(payload, secret)
  console.log("token = %s", token)

  // decode 
  val decoded = jwt.decode(token, secret)
  console.log("payload = %j", decoded) //=> { foo: "bar" }

}
