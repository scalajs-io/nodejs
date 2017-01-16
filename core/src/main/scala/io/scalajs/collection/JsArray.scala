package io.scalajs.collection

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSBracketAccess, JSName}
import scala.scalajs.js.{Array, Function2, |}

/**
  * An array is an ordered collection of data (either primitive or object depending upon the language).
  * Arrays are used to store multiple values in a single variable. This is compared to a variable that
  * can only store one value.
  *
  * Each item in an array has a number attached to it, called a numeric index, that allows you to access it.
  * In JavaScript, array's start at index zero and can be manipulated with various methods.
  * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array
  * @author lawrence.daniels@gmail.com
  */
@js.native
class JsArray[A]() extends JsCollection[A] {

  /**
    * Creates a new array with the given length.
    * @param length the initial length of the array.
    */
  def this(length: Int) = this()

  /**
    * Length of the array.
    */
  override def length: Int = js.native

  /**
    * Sets the length of the array.
    * If the new length is bigger than the old length, created slots are
    * filled with `undefined` (irrespective of the type argument `A`!).
    * If the new length is smaller than the old length, the array is shrunk.
    */
  def length_=(newLength: Int): Unit = js.native

  /**
    * Returns the element at the specified index
    * @param index the specified index
    * @return the element at the specified index
    */
  @JSBracketAccess
  override def apply(index: Int): A = js.native

  /**
    * Set the element at the given index.
    * @param index the position of the Node to be set.
    * @param value the value to set.
    */
  @JSBracketAccess
  def update(index: Int, value: A): Unit = js.native

  /**
    * concat creates a new array consisting of the elements in the this object
    * on which it is called, followed in order by, for each argument, the
    * elements of that argument (if the argument is an array) or the argument
    * itself (if the argument is not an array).
    *
    * MDN
    */
  def concat[B >: A](items: Array[_ <: B]*): Array[B] = js.native

  /**
    * The join() method joins all elements of an array into a string.
    *
    * separator Specifies a string to separate each element of the array.
    * The separator is converted to a string if necessary. If omitted, the
    * array elements are separated with a comma.
    */
  def join(separator: String = ","): String = js.native

  /**
    * The pop() method removes the last element from an array and returns that
    * element.
    *
    * MDN
    */
  def pop(): A = js.native

  /**
    * The push() method mutates an array by appending the given elements and
    * returning the new length of the array.
    *
    * MDN
    */
  def push(items: A*): Int = js.native

  /**
    * The reverse() method reverses an array in place. The first array element
    * becomes the last and the last becomes the first.
    *
    * MDN
    */
  @JSName("reverse")
  def reverseInPlace(): Array[A] = js.native

  /**
    * The shift() method removes the first element from an array and returns that
    * element. This method changes the length of the array.
    *
    * MDN
    */
  def shift(): A = js.native

  /**
    * The slice() method returns a shallow copy of a portion of an array.
    *
    * MDN
    */
  @JSName("slice")
  def jsSlice(start: Int = 0, end: Int = Int.MaxValue): Array[A] = js.native

  /**
    * The sort() method sorts the elements of an array in place and returns the
    * array. The sort is not necessarily stable. The default sort order is
    * lexicographic (not numeric).
    *
    * If compareFunction is not supplied, elements are sorted by converting them
    * to strings and comparing strings in lexicographic ("dictionary" or "telephone
    * book," not numerical) order. For example, "80" comes before "9" in
    * lexicographic order, but in a numeric sort 9 comes before 80.
    *
    * MDN
    */
  def sort(compareFn: Function2[A, A, Int] = js.native): Array[A] = js.native

  /** Removes and adds new elements at a given index in the array.
    *
    * This method first removes `deleteCount` elements starting from the index
    * `index`, then inserts the new elements `items` at that index.
    *
    * If `index` is negative, it is treated as that number of elements starting
    * from the end of the array.
    * @param index       Index where to start changes
    * @param deleteCount Number of elements to delete from index
    * @param items       Elements to insert at index
    * @return An array of the elements that were deleted
    */
  def splice(index: Int, deleteCount: Int, items: A*): Array[A] = js.native

  /**
    * The unshift() method adds one or more elements to the beginning of an array
    * and returns the new length of the array.
    *
    * MDN
    */
  def unshift(items: A*): Int = js.native

}

@js.native
@JSName("Array")
object JsArray extends js.Object {

  /**
    * The Array.from() method creates a new Array instance from an array-like or iterable object.
    * @param array   An array-like or iterable object to convert to an array.
    * @param mapFn   Optional. Map function to call on every element of the array.
    * @param thisArg Optional. Value to use as this when executing mapFn.
    * @return A new Array instance.
    */
  def from[T <: String | Iterator[T]](array: T, mapFn: js.Function = js.native, thisArg: js.Any = js.native): JsArray[T] = js.native

  /**
    * The Array.isArray() determines whether the passed value is an Array.
    * @param obj The object to be checked.
    * @return true if the object is an Array; otherwise, false.
    */
  def isArray(obj: js.Any): Boolean = js.native

  /**
    * The Array.of() method creates a new Array instance with a variable number of arguments, regardless
    * of number or type of the arguments.
    *
    * The difference between Array.of() and the Array constructor is in the handling of integer arguments:
    * Array.of(7) creates an array with a single element, 7, whereas Array(7) creates an array with 7 elements,
    * each of which is undefined.
    * @param elements Elements of which to create the array.
    * @return A new Array instance.
    */
  def of[T <: js.Any](elements: T*): JsArray[T] = js.native

}