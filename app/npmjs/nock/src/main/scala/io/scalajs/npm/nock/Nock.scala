package io.scalajs.npm.nock

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Nock is an HTTP mocking and expectations library for Node.js
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Nock extends js.Object {

  /**
    * You can see every mock that is currently active (i.e. might potentially reply to requests) in a scope using
    * scope.activeMocks(). A mock is active if it is pending, optional but not yet completed, or persisted. Mocks
    * that have intercepted their requests and are no longer doing anything are the only mocks which won't appear here.
    * You probably don't need to use this - it mainly exists as a mechanism to recreate the previous (now-changed)
    * behavior of pendingMocks().
    * @return the array of active mocks
    */
  def activeMocks(): js.Array[String] = js.native

  /**
    * Basic authentication can be specified
    * @param options the basic authentication options
    */
  def basicAuth(options: NockBasicAuth | js.Any): this.type = js.native

  /**
    * You can cleanup all the prepared mocks (could be useful to cleanup some state after a failed test)
    */
  def cleanAll(): this.type = js.native

  /**
    * You are able to specify the number of milliseconds that the response body should be delayed.
    * Response header will be replied immediately. delayBody(1000) is equivalent to delay({body: 1000}).
    * @param options an object containing the delay in milliseconds
    */
  def delay(options: NockDelayBody | js.Any): this.type = js.native

  /**
    * You are able to specify the number of milliseconds that the response body should be delayed.
    * Response header will be replied immediately. delayBody(1000) is equivalent to delay({body: 1000}).
    * @param millis the given delay in milliseconds
    */
  def delayBody(millis: Int): this.type = js.native

  /**
    * HTTP DELETE
    * @param uri the given url
    */
  def delete(uri: js.Any): this.type = js.native

  /**
    * By default, any requests made to a host that is not mocked will be executed normally.
    * If you want to block these requests, nock allows you to do so.
    *
    * For disabling real http requests.
    */
  def disableNetConnect(host: js.Any = js.native): this.type = js.native

  /**
    * For enabling real HTTP requests (the default behaviour).
    */
  def enableNetConnect(host: js.Any = js.native): this.type = js.native

  /**
    * HTTP GET
    * @param uri the given url
    */
  def get(uri: js.Any): this.type = js.native

  /**
    * HTTP HEAD
    * @param uri the given url
    */
  def head(uri: js.Any): this.type = js.native

  /**
    * You can call isDone() on a single expectation to determine if the expectation was met
    * @return true, if the expectation was met
    */
  def isDone(): Boolean = js.native

  /**
    * If you save this as a JSON file, you can load them directly through nock.load(path). Then you can post-process
    * them before using them in the tests for example to add them request body filtering (shown here fixing timestamps
    * to match the ones captured during recording)
    * @param pathToJson the path to the JSON file
    * @return the loaded object
    */
  def load(pathToJson: String): js.Object = js.native

  /**
    * Nock can log matches if you pass in a log function
    * @example {{{ Nock.log(console.log) }}}
    * @param logger the given logger function
    */
  def log(logger: js.Any): this.type = js.native

  def matchHeader(key: String, value: js.Any): this.type = js.native

  def optionally(): this.type = js.native

  /**
    * HTTP PATCH
    * @param uri the given url
    */
  def patch(uri: String, body: js.Any = js.native): this.type = js.native

  /**
    * You can inspect the scope to infer which ones are still pending
    * @return the array of pending mocks
    */
  def pendingMocks(): js.Array[String] = js.native

  /**
    * You can make all the interceptors for a scope persist by calling .persist() on it
    * @return self
    */
  def persist(): this.type = js.native

  /**
    * HTTP POST
    * @param uri the given url
    */
  def post(uri: String, body: js.Any = js.native): this.type = js.native

  def query(params: js.Any): this.type = js.native

  /**
    * This is a cool feature:
    * Guessing what the HTTP calls are is a mess, specially if you are introducing nock on your already-coded tests.
    * For these cases where you want to mock an existing live system you can record and playback the HTTP calls like this:
    * @return the [[NockRecorder recorder]] instance
    */
  def recorder: NockRecorder = js.native

  def removeInterceptor(options: NockInterceptorOptions | js.Any = js.native): this.type = js.native

  def reply(statusCode: Int, response: js.Any = js.native): this.type = js.native

  def replyWithError(error: js.Any): this.type = js.native

  /**
    * You can restore the HTTP interceptor to the normal unmocked behaviour
    */
  def restore(): this.type = js.native

  def times(count: Int): this.type = js.native

  def once(): this.type = js.native

  def twice(): this.type = js.native

  def thrice(): this.type = js.native

}

/**
  * Nock Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("nock", JSImport.Namespace)
object Nock extends Nock {

  def apply(url: js.Any, options: NockOptions | js.Any = js.native): Nock = js.native

}
