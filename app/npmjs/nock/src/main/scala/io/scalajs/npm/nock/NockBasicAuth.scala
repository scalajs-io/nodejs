package io.scalajs.npm.nock

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Nock Basic Authentication
  * @param user the given user
  * @param pass the given password
  */
class NockBasicAuth(var user: js.UndefOr[String] = js.undefined,
                    var pass: js.UndefOr[String] = js.undefined) extends js.Object

/**
  * Nock Basic Authentication Companion
  * @author lawrence.daniels@gmail.com
  */
object NockBasicAuth extends FlexibleOptions[NockBasicAuth]