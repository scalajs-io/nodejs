package io.scalajs.npm.aws

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Service Configuration Options
  * @param endpoint The endpoint URI to send requests to. The default endpoint is built from the configured region.
  *                 The endpoint should be a string like 'https://{service}.{region}.amazonaws.com'.
  * @param params   An optional map of parameters to bind to every request sent by this service object.
  *                 For more information on bound parameters, see "Working with Services" in the Getting Started Guide.
  */
class ServiceConfigurationOptions(val endpoint: js.UndefOr[String] = js.undefined,
                                  val params: js.UndefOr[js.Dictionary[js.Any]] = js.undefined)
  extends js.Object

/**
  * Service Configuration Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ServiceConfigurationOptions extends FlexibleOptions[ServiceConfigurationOptions]

