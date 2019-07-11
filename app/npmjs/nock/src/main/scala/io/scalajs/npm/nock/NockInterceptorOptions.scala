package io.scalajs.npm.nock

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Nock Interceptor Options
  * @param hostname the host name
  * @param path     the path
  * @param method   the method
  * @param proto    the proto
  */
class NockInterceptorOptions(var hostname: js.UndefOr[String] = js.undefined,
                             var path: js.UndefOr[String] = js.undefined,
                             var method: js.UndefOr[String] = js.undefined,
                             var proto: js.UndefOr[String] = js.undefined) extends js.Object

/**
  * Nock Interceptor Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NockInterceptorOptions extends FlexibleOptions[NockInterceptorOptions]
