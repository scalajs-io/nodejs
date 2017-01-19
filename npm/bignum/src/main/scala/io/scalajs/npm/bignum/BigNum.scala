package io.scalajs.npm.bignum

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Arbitrary-precision integer arithmetic using OpenSSL
  * @version 0.12.5
  * @see https://www.npmjs.com/package/bignum
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("bignum", JSImport.Namespace)
class BigNum(initial: BigNumCompatible, base: Int = js.native) extends js.Object {

  /**
    * Return a new bignum with the absolute value of the instance.
    */
  def abs(): this.type = js.native

  /**
    * Return a new bignum containing the instance value plus n.
    */
  def add(n: BigNumCompatible): this.type = js.native

  /**
    * Return a new bignum with the instance value bitwise AND (&)-ed with n.
    */
  def and(n: BigNumCompatible): this.type = js.native

  /**
    * Return the number of bits used to represent the current bignum.
    */
  def bitLength(): Int = js.native

  /**
    * Compare the instance value to n.
    * @return a positive integer if > n, a negative integer if < n, and 0 if == n.
    */
  def cmp(n: BigNumCompatible): Int = js.native

  /**
    * Return a new bignum containing the instance value integrally divided by n.
    */
  def div(n: BigNumCompatible): this.type = js.native

  /**
    * Return a boolean: whether the instance value is equal to n (== n).
    */
  def eq(n: BigNumCompatible): Boolean = js.native

  /**
    * Return the greatest common divisor of the current bignum with n as a new bignum.
    */
  def gcd(n: BigNumCompatible): this.type = js.native

  /**
    * Return a boolean: whether the instance value is greater than n (> n).
    */
  def gt(n: BigNumCompatible): Boolean = js.native

  /**
    * Return a boolean: whether the instance value is greater than or equal to n (>= n).
    */
  def ge(n: BigNumCompatible): Boolean = js.native

  /**
    * Return the Jacobi symbol (or Legendre symbol if n is prime) of the current bignum (= a) over n.
    * Note that n must be odd and >= 3. 0 <= a < n.
    * Returns -1 or 1 as an int (NOT a bignum). Throws an error on failure.
    */
  def jacobi(n: BigNumCompatible): Double = js.native

  /**
    * Compute the multiplicative inverse modulo m.
    */
  def invertm(m: BigNumCompatible): this.type = js.native

  /**
    * Return a boolean: whether the instance value is less than n (< n).
    */
  def lt(n: BigNumCompatible): Boolean = js.native

  /**
    * Return a boolean: whether the instance value is less than or equal to n (<= n).
    */
  def le(n: BigNumCompatible): Boolean = js.native

  /**
    * Return a new bignum with the instance value modulo n.
    */
  def mod(n: BigNumCompatible): this.type = js.native

  /**
    * Return a new bignum containing the instance value multiplied by n.
    */
  def mul(n: BigNumCompatible): this.type = js.native

  /**
    * Return a new bignum with the negative of the instance value.
    */
  def neg(): this.type = js.native

  /**
    * Return a new bignum with the instance value bitwise inclusive-OR (|)-ed with n.
    */
  def or(n: BigNumCompatible): this.type = js.native

  /**
    * Return a new bignum with the instance value raised to the nth power.
    */
  def pow(n: BigNumCompatible): this.type = js.native

  /**
    * Return a new bignum with the instance value raised to the nth power modulo m.
    */
  def powm(n: BigNumCompatible, mn: BigNumCompatible): this.type = js.native

  /**
    * Return whether the bignum is:
    * * certainly prime (true)
    * * probably prime ('maybe')
    * * certainly composite (false)
    */
  def probPrime(n: BigNumCompatible): Boolean = js.native

  /**
    * If upperBound is supplied, return a random bignum between the instance value and upperBound - 1, inclusive.
    *
    * Otherwise, return a random bignum between 0 and the instance value - 1, inclusive.
    * @param upperBound the upper-bound
    */
  def rand(upperBound: BigNumCompatible = js.native): this.type = js.native

  /**
    * Return a new bignum that is the nth root. This truncates.
    */
  def root(n: BigNumCompatible): Boolean = js.native

  /**
    * Return a new bignum that is the {{{2^n}}} multiple. Equivalent of the << operator.
    */
  def shiftLeft(n: BigNumCompatible): this.type = js.native

  /**
    * Return a new bignum of the value integer divided by {{{2^n}}}. Equivalent of the >> operator.
    */
  def shiftRight(n: BigNumCompatible): this.type = js.native

  /**
    * Return a new bignum that is the square root. This truncates.
    */
  def sqrt(): this.type = js.native

  /**
    * Return a new bignum containing the instance value minus n.
    */
  def sub(n: BigNumCompatible): this.type = js.native

  /**
    * Turn a bignum into a Number. If the bignum is too big you'll lose precision or you'll get ±Infinity.
    */
  def toNumber(): Double = js.native

  /**
    * Print out the bignum instance in the requested base as a string.
    * @param base the given base
    * @return the requested base as a string
    */
  def toString(base: Int): String = js.native

  /**
    * Return a new bignum with the instance value bitwise exclusive-OR {{{(^)}}}-ed with n.
    */
  def xor(n: BigNumCompatible): this.type = js.native

}

/**
  * BigNum Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("bignum", JSImport.Namespace)
object BigNum extends js.Object {

  /**
    * Create a new bignum from a Buffer.
    * @param buf     the [[Buffer]]
    * @param options the [[BigNumOptions options]]
    * @return a new [[BigNum]] instance
    */
  def fromBuffer(buf: Buffer, options: BigNumOptions | RawOptions = js.native): BigNum = js.native

  /**
    * Return true if num is identified as a bignum instance. Otherwise, return false.
    * @param num the value to check
    * @return true if num is identified as a bignum instance. Otherwise, return false.
    */
  def isBigNum(num: js.Any): Boolean = js.native

  def pow(base: BigNumCompatible, exponent: BigNumCompatible): BigNum = js.native

  /**
    * Generate a probable prime of length bits. If safe is true, it will be a "safe" prime of the
    * form p=2p'+1 where p' is also prime.
    */
  def prime(bits: BigNumCompatible, safe: Boolean = js.native): BigNum = js.native

  /**
    * Return a new Buffer with the data from the bignum.
    * @param options the [[BigNumOptions options]]
    * @return a new [[Buffer]] instance
    */
  def toBuffer(options: BigNumOptions | RawOptions = js.native): Buffer = js.native

}