package io.scalajs.social

import io.scalajs.util.PromiseHelper._

import scala.concurrent.{ExecutionContext, Future}
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Facebook package object
  * @author lawrence.daniels@gmail.com
  */
package object facebook {

  /**
    * Facebook Singleton
    */
  @js.native
  @JSGlobal("FB")
  object FB extends Facebook

  /**
    * Facebook Enrichment
    * @param fb the given [[Facebook FB instance]]
    */
  final implicit class FacebookEnrichment(val fb: Facebook) extends AnyVal {

    @inline
    def getLoginStatusFuture(implicit ec: ExecutionContext): Future[FacebookLoginStatusResponse] = {
      promiseCallback1[js.UndefOr[FacebookLoginStatusResponse]](fb.getLoginStatus) map (_.toOption) flatMap {
        case Some(response) => Future.successful(response)
        case None => Future.failed(js.JavaScriptException("No response"))
      }
    }

    @inline
    def loginFuture(implicit ec: ExecutionContext): Future[FacebookLoginStatusResponse] = {
      promiseCallback1[js.UndefOr[FacebookLoginStatusResponse]](fb.login) map (_.toOption) flatMap {
        case Some(response) => Future.successful(response)
        case None => Future.failed(js.JavaScriptException("No response"))
      }
    }

    @inline
    def logoutFuture(implicit ec: ExecutionContext): Future[FacebookLoginStatusResponse] = {
      promiseCallback1[js.UndefOr[FacebookLoginStatusResponse]](fb.logout) map (_.toOption) flatMap {
        case Some(response) => Future.successful(response)
        case None => Future.failed(js.JavaScriptException("No response"))
      }
    }

  }

}
