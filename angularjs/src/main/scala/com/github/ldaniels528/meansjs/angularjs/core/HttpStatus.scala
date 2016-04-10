package com.github.ldaniels528.meansjs.angularjs.core

import scala.language.implicitConversions

/**
 * HTTP Status
 * @param code the given status code
 * @author lawrence.daniels@gmail.com
 */
case class HttpStatus(code: Int) extends AnyVal

/**
 * HTTP Status Singleton
 * @author lawrence.daniels@gmail.com
 * @see https://github.com/spray/spray/blob/master/spray-http/src/main/scala/spray/http/StatusCode.scala
 */
object HttpStatus {
  val Continue = HttpStatus(100)
  val SwitchingProtocols = HttpStatus(101)
  val Processing = HttpStatus(102)

  val Ok = HttpStatus(200)
  val Created = HttpStatus(201)
  val Accepted = HttpStatus(202)
  val NonAuthoritativeInformation = HttpStatus(203)
  val NoContent = HttpStatus(204)
  val ResetContent = HttpStatus(205)
  val PartialContent = HttpStatus(206)
  val MultiStatus = HttpStatus(207)
  val AlreadyReported = HttpStatus(208)
  val IMUsed = HttpStatus(226)

  val MultipleChoices = HttpStatus(300)
  val MovedPermanently = HttpStatus(301)
  val Found = HttpStatus(302)
  val SeeOther = HttpStatus(303)
  val NotModified = HttpStatus(304)
  val UseProxy = HttpStatus(305)
  val TemporaryRedirect = HttpStatus(307)
  val PermanentRedirect = HttpStatus(308)

  val BadRequest = HttpStatus(400)
  val Unauthorized = HttpStatus(401)
  val PaymentRequired = HttpStatus(402)
  val Forbidden = HttpStatus(403)
  val NotFound = HttpStatus(404)
  val MethodNotAllowed = HttpStatus(405)
  val NotAcceptable = HttpStatus(406)
  val ProxyAuthenticationRequired = HttpStatus(407)
  val RequestTimeout = HttpStatus(408)
  val Conflict = HttpStatus(409)
  val Gone = HttpStatus(410)
  val LengthRequired = HttpStatus(411)
  val PreconditionFailed = HttpStatus(412)
  val EntityTooLarge = HttpStatus(413)
  val RequestUriTooLong = HttpStatus(414)
  val UnsupportedMediaType = HttpStatus(415)
  val RequestedRangeNotSatisfiable = HttpStatus(416)
  val ExpectationFailed = HttpStatus(417)
  val EnhanceYourCalm = HttpStatus(420)
  val UnprocessableEntity = HttpStatus(422)
  val Locked = HttpStatus(423)
  val FailedDependency = HttpStatus(424)
  val UnorderedCollection = HttpStatus(425)
  val UpgradeRequired = HttpStatus(426)
  val PreconditionRequired = HttpStatus(428)
  val TooManyRequests = HttpStatus(429)
  val RequestHeaderFieldsTooLarge = HttpStatus(431)
  val RetryWith = HttpStatus(449)
  val BlockedByParentalControls = HttpStatus(450)
  val UnavailableForLegalReasons = HttpStatus(451)

  val InternalServerError = HttpStatus(500)
  val NotImplemented = HttpStatus(501)
  val BadGateway = HttpStatus(502)
  val ServiceUnavailable = HttpStatus(503)
  val GatewayTimeout = HttpStatus(504)
  val HTTPVersionNotSupported = HttpStatus(505)
  val VariantAlsoNegotiates = HttpStatus(506)
  val InsufficientStorage = HttpStatus(507)
  val LoopDetected = HttpStatus(508)
  val BandwidthLimitExceeded = HttpStatus(509)
  val NotExtended = HttpStatus(510)
  val NetworkAuthenticationRequired = HttpStatus(511)
  val NetworkReadTimeout = HttpStatus(598)
  val NetworkConnectTimeout = HttpStatus(599)

  implicit def int2HttpStatus(code: Int): HttpStatus = HttpStatus(code)

}
