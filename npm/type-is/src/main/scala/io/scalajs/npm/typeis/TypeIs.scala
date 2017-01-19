package io.scalajs.npm.typeis

import io.scalajs.nodejs.http.ClientRequest

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * type-is - Infer the content-type of a request.
  * @version 1.6.14
  * @see https://www.npmjs.com/package/type-is
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TypeIs extends js.Object {

  /**
    * Returns a Boolean if the given request has a body, regardless of the Content-Type header.
    *
    * Having a body has no relation to how large the body is (it may be 0 bytes). This is similar
    * to how file existence works. If a body does exist, then this indicates that there is data to
    * read from the Node.js request stream.
    * @param request the given [[ClientRequest request]]
    * @return a Boolean if the given request has a body, regardless of the Content-Type header.
    */
  def hasBody(request: ClientRequest): Boolean = js.native

  /**
    * Returns a match of the given request's media type and the given array of potential type matches.
    * @param request is the node HTTP request.
    * @param types   is an array of types.
    * @return the matched type or false if no match was found
    */
  def is(request: ClientRequest, types: js.Array[String]): js.Any = js.native

  /**
    * Returns a match of the given media type and the given array of potential type matches.
    * @param mediaType is the media type string.
    * @param types     is an array of types.
    * @return the matched type or false if no match was found
    */
  def is(mediaType: String, types: js.Array[String]): js.Any = js.native

}

/**
  * Type-Is Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("type-is", JSImport.Namespace)
object TypeIs extends TypeIs