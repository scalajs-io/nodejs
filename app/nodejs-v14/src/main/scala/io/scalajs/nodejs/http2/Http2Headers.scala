package io.scalajs.nodejs.http2

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSBracketAccess, JSName}
import scala.scalajs.js.|

@js.native
trait Http2Headers extends js.Object {
  @JSName(":status") var status: js.UndefOr[String]                                                 = js.undefined
  @JSName(":method") var method: js.UndefOr[String]                                                 = js.undefined
  @JSName(":authority") var authority: js.UndefOr[String]                                           = js.undefined
  @JSName(":scheme") var scheme: js.UndefOr[String]                                                 = js.undefined
  @JSName(":path") var path: js.UndefOr[String]                                                     = js.undefined
  @JSName(":protocol") var protocol: js.UndefOr[String]                                             = js.undefined
  @JSName("age") var age: js.UndefOr[String]                                                        = js.undefined
  @JSName("authorization") var authorization: js.UndefOr[String]                                    = js.undefined
  @JSName("access-control-allow-credentials") var accessControlAllowCredentials: js.UndefOr[String] = js.undefined
  @JSName("access-control-max-age") var accessControlMaxAge: js.UndefOr[String]                     = js.undefined
  @JSName("access-control-request-method") var accessControlRequestMethod: js.UndefOr[String]       = js.undefined
  @JSName("content-encoding") var contentEncoding: js.UndefOr[String]                               = js.undefined
  @JSName("content-language") var contentLanguage: js.UndefOr[String]                               = js.undefined
  @JSName("content-length") var contentLength: js.UndefOr[String]                                   = js.undefined
  @JSName("content-location") var contentLocation: js.UndefOr[String]                               = js.undefined
  @JSName("content-md5") var contentMd5: js.UndefOr[String]                                         = js.undefined
  @JSName("content-range") var contentRange: js.UndefOr[String]                                     = js.undefined
  @JSName("content-type") var contentType: js.UndefOr[String]                                       = js.undefined
  @JSName("date") var date: js.UndefOr[String]                                                      = js.undefined
  @JSName("dnt") var dnt: js.UndefOr[String]                                                        = js.undefined
  @JSName("etag") var etag: js.UndefOr[String]                                                      = js.undefined
  @JSName("expires") var expires: js.UndefOr[String]                                                = js.undefined
  @JSName("from") var from: js.UndefOr[String]                                                      = js.undefined
  @JSName("if-match") var ifMatch: js.UndefOr[String]                                               = js.undefined
  @JSName("if-modified-since") var ifModifiedSince: js.UndefOr[String]                              = js.undefined
  @JSName("if-none-match") var ifNoneMatch: js.UndefOr[String]                                      = js.undefined
  @JSName("if-range") var ifRange: js.UndefOr[String]                                               = js.undefined
  @JSName("if-unmodified-since") var ifUnmodifiedSince: js.UndefOr[String]                          = js.undefined
  @JSName("last-modified") var lastModified: js.UndefOr[String]                                     = js.undefined
  @JSName("location") var location: js.UndefOr[String]                                              = js.undefined
  @JSName("max-forwards") var maxForwards: js.UndefOr[String]                                       = js.undefined
  @JSName("proxy-authorization") var proxyAuthorization: js.UndefOr[String]                         = js.undefined
  @JSName("range") var range: js.UndefOr[String]                                                    = js.undefined
  @JSName("referer") var referer: js.UndefOr[String]                                                = js.undefined
  @JSName("retry-after") var retryAfter: js.UndefOr[String]                                         = js.undefined
  @JSName("tk") var tk: js.UndefOr[String]                                                          = js.undefined
  @JSName("upgrade-insecure-requests") var upgradeInsecureRequests: js.UndefOr[String]              = js.undefined
  @JSName("user-agent") var userAgent: js.UndefOr[String]                                           = js.undefined
  @JSName("x-content-type-options") var xContentTypeOptions: js.UndefOr[String]                     = js.undefined
  @JSName("cookie") var cookie: js.UndefOr[js.Array[String]]                                        = js.undefined
  @JSName("set-cookie") var setCookie: js.UndefOr[js.Array[String]]                                 = js.undefined

  @JSBracketAccess
  def apply(key: String): js.UndefOr[String | js.Array[String]] = js.native

  @JSBracketAccess
  def update(key: String, value: String | js.Array[String]): Unit = js.native
}

object Http2Headers {
  def forIncoming(
      status: String,
      method: js.UndefOr[String] = js.undefined,
      authority: js.UndefOr[String] = js.undefined,
      scheme: js.UndefOr[String] = js.undefined,
      path: js.UndefOr[String] = js.undefined,
      protocol: js.UndefOr[String] = js.undefined,
      age: js.UndefOr[String] = js.undefined,
      authorization: js.UndefOr[String] = js.undefined,
      accessControlAllowCredentials: js.UndefOr[String] = js.undefined,
      accessControlMaxAge: js.UndefOr[String] = js.undefined,
      accessControlRequestMethod: js.UndefOr[String] = js.undefined,
      contentEncoding: js.UndefOr[String] = js.undefined,
      contentLanguage: js.UndefOr[String] = js.undefined,
      contentLength: js.UndefOr[String] = js.undefined,
      contentLocation: js.UndefOr[String] = js.undefined,
      contentMd5: js.UndefOr[String] = js.undefined,
      contentRange: js.UndefOr[String] = js.undefined,
      contentType: js.UndefOr[String] = js.undefined,
      date: js.UndefOr[String] = js.undefined,
      dnt: js.UndefOr[String] = js.undefined,
      etag: js.UndefOr[String] = js.undefined,
      expires: js.UndefOr[String] = js.undefined,
      from: js.UndefOr[String] = js.undefined,
      ifMatch: js.UndefOr[String] = js.undefined,
      ifModifiedSince: js.UndefOr[String] = js.undefined,
      ifNoneMatch: js.UndefOr[String] = js.undefined,
      ifRange: js.UndefOr[String] = js.undefined,
      ifUnmodifiedSince: js.UndefOr[String] = js.undefined,
      lastModified: js.UndefOr[String] = js.undefined,
      location: js.UndefOr[String] = js.undefined,
      maxForwards: js.UndefOr[String] = js.undefined,
      proxyAuthorization: js.UndefOr[String] = js.undefined,
      range: js.UndefOr[String] = js.undefined,
      referer: js.UndefOr[String] = js.undefined,
      retryAfter: js.UndefOr[String] = js.undefined,
      tk: js.UndefOr[String] = js.undefined,
      upgradeInsecureRequests: js.UndefOr[String] = js.undefined,
      userAgent: js.UndefOr[String] = js.undefined,
      xContentTypeOptions: js.UndefOr[String] = js.undefined,
      cookie: js.UndefOr[js.Array[String]] = js.undefined,
      setCookie: js.UndefOr[js.Array[String]] = js.undefined
  ): Http2Headers = {
    val o = js.Dynamic.literal().asInstanceOf[Http2Headers]
    o.status = status
    o.method = method
    o.authority = authority
    o.scheme = scheme
    o.path = path
    o.protocol = protocol
    o.age = age
    o.authorization = authorization
    o.accessControlAllowCredentials = accessControlAllowCredentials
    o.accessControlMaxAge = accessControlMaxAge
    o.accessControlRequestMethod = accessControlRequestMethod
    o.contentEncoding = contentEncoding
    o.contentLanguage = contentLanguage
    o.contentLength = contentLength
    o.contentLocation = contentLocation
    o.contentMd5 = contentMd5
    o.contentRange = contentRange
    o.contentType = contentType
    o.date = date
    o.dnt = dnt
    o.etag = etag
    o.expires = expires
    o.from = from
    o.ifMatch = ifMatch
    o.ifModifiedSince = ifModifiedSince
    o.ifNoneMatch = ifNoneMatch
    o.ifRange = ifRange
    o.ifUnmodifiedSince = ifUnmodifiedSince
    o.lastModified = lastModified
    o.location = location
    o.maxForwards = maxForwards
    o.proxyAuthorization = proxyAuthorization
    o.range = range
    o.referer = referer
    o.retryAfter = retryAfter
    o.tk = tk
    o.upgradeInsecureRequests = upgradeInsecureRequests
    o.userAgent = userAgent
    o.xContentTypeOptions = xContentTypeOptions
    o.cookie = cookie
    o.setCookie = setCookie
    o
  }
}
