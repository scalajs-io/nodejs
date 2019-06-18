package io.scalajs.npm.redis

import io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * RedisError: All errors returned by the client
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("redis", "RedisError")
class RedisError extends nodejs.Error

/**
  * AbortError subclass of RedisError: All commands that could not finish due to what ever reason
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("redis", "AbortError")
class AbortError extends RedisError

/**
  * AggregateError subclass of AbortError: Emitted in case multiple unresolved commands without callback got rejected
  * in debug_mode instead of lots of AbortErrors.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("redis", "AggregateError")
class AggregateError extends AbortError

/**
  * ParserError subclass of RedisError: Returned in case of a parser error (this should not happen)
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("redis", "ParserError")
class ParserError extends RedisError

/**
  * ReplyError subclass of RedisError: All errors returned by Redis itself
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("redis", "ReplyError")
class ReplyError extends RedisError
