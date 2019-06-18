package io.scalajs.npm.aws

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * AWS.Service
  * @see http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Service.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "Service")
class Service(val config: ServiceConfigurationOptions | RawOptions = js.native) extends js.Object {

  //////////////////////////////////////////////////////////////
  //    Properties
  //////////////////////////////////////////////////////////////

  /**
    * The list of API versions supported by this service.
    */
  def apiVersions: js.Array[String] = js.native

  /**
    * An Endpoint object representing the endpoint URL for service requests.
    */
  var endpoint: Endpoint = js.native

  //////////////////////////////////////////////////////////////
  //    Methods
  //////////////////////////////////////////////////////////////

  /**
    * Defines a new Service class using a service identifier and list of versions including an
    * optional set of features (functions) to apply to the class prototype.
    * @param serviceIdentifier the identifier for the service
    * @param versions          a list of versions that work with this service
    * @param features          an object to attach to the prototype
    * @return the service class defined by this function.
    */
  def defineService(serviceIdentifier: String,
                    versions: js.Array[String],
                    features: RawOptions): Class[Service] = js.native

  /**
    * Calls an operation on a service with the given input parameters.
    * @param operation the name of the operation to call on the service.
    * @param params    a map of input options for the operation
    * @param callback  If a callback is supplied, it is called when a response is returned from the service.
    *                  Parameters:
    *                  <ul>
    *                  <li>err (Error) — the error object returned from the request. Set to null if the request
    *                  is successful.</li>
    *                  <li>data (Object) — the de-serialized data returned from the request. Set to null if a request
    *                  error occurs.</li>
    *                  </ul>
    */
  def makeRequest[T](operation: String,
                     params: js.Dictionary[js.Any],
                     callback: js.Function2[AWSError, T, Any]): Unit = js.native

  /**
    * Calls an operation on a service with the given input parameters, without any authentication data.
    * This method is useful for "public" API operations.
    * @param operation the name of the operation to call on the service.
    * @param params    a map of input options for the operation
    * @param callback  If a callback is supplied, it is called when a response is returned from the service.
    *                  Parameters:
    *                  <ul>
    *                  <li>err (Error) — the error object returned from the request. Set to null if the request
    *                  is successful.</li>
    *                  <li>data (Object) — the de-serialized data returned from the request. Set to null if a request
    *                  error occurs.</li>
    *                  </ul>
    */
  def makeUnauthenticatedRequest[T](operation: String,
                                    params: js.Dictionary[js.Any],
                                    callback: js.Function2[AWSError, T, Any]): Unit = js.native

  /**
    * Override this method to setup any custom request listeners for each new request to the service.
    */
  def setupRequestListeners(): Unit = js.native

  /**
    * Waits for a given state
    * @param state    the state on the service to wait for
    * @param params   a map of parameters to pass with each request
    * @param callback If a callback is supplied, it is called when a response is returned from the service.
    */
  def waitFor[T](state: String,
                 params: js.Dictionary[js.Any],
                 callback: js.Function2[AWSError, T, Any]): Unit = js.native

}


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