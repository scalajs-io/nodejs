package io.scalajs.npm.nodefetch

import scala.scalajs.js


/**
  * Request Options
  * @param agent    http.Agent instance, allows custom proxy, certificate etc.
  * @param body     request body. can be a string, buffer, readable stream
  * @param compress support gzip/deflate content encoding. false to disable
  * @param follow   maximum redirect count. 0 to not follow redirect
  * @param headers  request header. format {a:'1'} or {b:['1','2','3']}
  * @param method   the HTTP method (e.g. "GET")
  * @param redirect set to `manual` to extract redirect headers, `error` to reject redirect (e.g. "follow")
  * @param size     maximum response body size in bytes. 0 to disable
  * @param timeout  maximum redirect count. 0 to not follow redirect
  */

class RequestOptions(val agent: js.UndefOr[String] = js.undefined,
                     val body: js.Any = js.undefined,
                     val compress: js.UndefOr[Boolean] = js.undefined,
                     val follow: js.UndefOr[Int] = js.undefined,
                     val headers: js.Any = js.undefined,
                     val method: js.UndefOr[String] = js.undefined,
                     val redirect: js.UndefOr[String] = js.undefined,
                     val size: js.UndefOr[Int] = js.undefined,
                     val timeout: js.UndefOr[Int] = js.undefined) extends js.Object