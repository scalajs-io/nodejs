package io.scalajs.npm

import scala.scalajs.js.|

/**
  * bignum package object
  * @author lawrence.daniels@gmail.com
  */
package object bignum {

  type BigNumCompatible = Int | Long | Double | java.lang.Number | String | BigNum

  /**
    * BigNum Enrichment
    * @param bigNum the given [[BigNum]]
    */
  implicit class BigNumEnrichment(val bigNum: BigNum) extends AnyVal {

    /////////////////////////////////////////////////////////////////////////////////
    //      Mathematics
    /////////////////////////////////////////////////////////////////////////////////

    @inline
    def +(value: BigNumCompatible): bigNum.type = bigNum.add(value)

    @inline
    def -(value: BigNumCompatible): bigNum.type = bigNum.sub(value)

    @inline
    def *(value: BigNumCompatible): bigNum.type = bigNum.mul(value)

    @inline
    def /(value: BigNumCompatible): bigNum.type = bigNum.div(value)

    @inline
    def %(value: BigNumCompatible): bigNum.type = bigNum.mod(value)

    /////////////////////////////////////////////////////////////////////////////////
    //      Bitwise
    /////////////////////////////////////////////////////////////////////////////////

    @inline
    def &(value: BigNumCompatible): bigNum.type = bigNum.add(value)

    @inline
    def |(value: BigNumCompatible): bigNum.type = bigNum.or(value)

    @inline
    def <<(value: BigNumCompatible): bigNum.type = bigNum.shiftLeft(value)

    @inline
    def >>(value: BigNumCompatible): bigNum.type = bigNum.shiftRight(value)

    /////////////////////////////////////////////////////////////////////////////////
    //      Comparison
    /////////////////////////////////////////////////////////////////////////////////

    @inline
    def >=(value: BigNumCompatible): Boolean = bigNum.ge(value)

    @inline
    def >(value: BigNumCompatible): Boolean = bigNum.gt(value)

    @inline
    def <=(value: BigNumCompatible): Boolean = bigNum.le(value)

    @inline
    def <(value: BigNumCompatible): Boolean = bigNum.lt(value)

  }

}
