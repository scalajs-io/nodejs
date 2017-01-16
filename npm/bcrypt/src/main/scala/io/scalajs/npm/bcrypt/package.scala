package io.scalajs.npm

import io.scalajs.nodejs.Error
import io.scalajs.util.ScalaJsHelper._

import scala.concurrent.Promise
import scala.scalajs.js

/**
  * bcrypt package object
  * @author lawrence.daniels@gmail.com
  */
package object bcrypt {

  type BCryptError = Error

  type Hash = js.Any

  type Salt = js.Any

  /**
    * BCrypt Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class BCryptExtensions(val bcrypt: Bcrypt) extends AnyVal {

    /**
      * Asynchronously compares the hash to the given data
      * @param data      the given data to be compared
      * @param encrypted the encrypted data to be compared to.
      */
    @inline
    def compareFuture(data: js.Any, encrypted: Hash): Promise[Boolean] = {
      futureCallbackE1[BCryptError, Boolean](bcrypt.compare(data, encrypted, _))
    }

    /**
      * Asynchronously generates the salt
      * @param rounds the number of rounds to process the data for. (default - 10)
      */
    @inline
    def genSaltFuture(rounds: Int = 10): Promise[Salt] = {
      futureCallbackE1[BCryptError, Salt](bcrypt.genSalt(rounds, _))
    }

    /**
      * Asynchronously creates a hash using the given data
      * @param data the given data to be hashed
      * @param salt the salt to be used to hash the password.
      * @example bcrypt.hash(data, salt, progress, cb)
      */
    @inline
    def hashFuture(data: js.Any, salt: Salt): Promise[Hash] = {
      futureCallbackE1[BCryptError, Hash](bcrypt.hash(data, salt, _))
    }

  }

}
