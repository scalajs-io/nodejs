package io.scalajs.npm.nodefetch

import io.scalajs.FlexibleOptions

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
class NodeFetchRequestOptions(var agent: js.UndefOr[String] = js.undefined,
                              var body: js.Any = js.undefined,
                              var compress: js.UndefOr[Boolean] = js.undefined,
                              var follow: js.UndefOr[Int] = js.undefined,
                              var headers: js.Any = js.undefined,
                              var method: js.UndefOr[String] = js.undefined,
                              var redirect: js.UndefOr[String] = js.undefined,
                              var size: js.UndefOr[Int] = js.undefined,
                              var timeout: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * Request Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NodeFetchRequestOptions extends FlexibleOptions[NodeFetchRequestOptions]