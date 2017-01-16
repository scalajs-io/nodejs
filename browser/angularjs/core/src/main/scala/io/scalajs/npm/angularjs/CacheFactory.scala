package io.scalajs.npm.angularjs

import scala.scalajs.js

/**
 * Cache Factory Service - Factory that constructs [[Cache Cache]] objects and gives access to them.
 * @see [[https://docs.angularjs.org/api/ng/service/\$cacheFactory]]
 */
@js.native
trait CacheFactory extends js.Object {

  /**
   * Factory that constructs Cache objects and gives access to them
   * @param cacheId Name or id of the newly created cache.
   * @param options Options object that specifies the cache behavior.
   * @return the newly created [[Cache cache]]
   */
  def apply(cacheId: String, options: js.Dictionary[Any] = js.native): Cache = js.native

  /**
   * Get access to a cache object by the cacheId used when it was created.
   * @param cacheId Name or id of a cache to access.
   * @return Cache object identified by the cacheId or undefined if no such cache.
   */
  def get(cacheId: String): js.Object = js.native

  /**
   * Get information about all the caches that have been created
   * @return key-value map of cacheId to the result of calling cache
   */
  def info(): js.Dictionary[Any] = js.native

}

/**
 * Cache Object
 * @see [[https://docs.angularjs.org/api/ng/type/\$cacheFactory.Cache]]
 */
@js.native
trait Cache extends js.Object {

  /**
   * Destroys the Cache object entirely, removing it from the \$cacheFactory set.
   */
  def destroy(): Unit = js.native

  /**
   * Returns cached value for key or undefined for cache miss.
   * @param key the given key
   * @return cached value for key or undefined for cache miss.
   */
  def get[T](key: String): js.UndefOr[T] = js.native

  /**
   * Returns id, size, and options of cache.
   * @return an object with the following properties:
   *         <ul>
   *         <li>id: the id of the cache instance</li>
   *         <li>size: the number of entries kept in the cache instance</li>
   *         <li>...: any additional properties from the options object when creating the cache.</li>
   *         </ul>
   */
  def info(): js.Dictionary[Any] = js.native

  /**
   * Puts a new key-value pair into the cache and returns it.
   */
  def put(key: String, value: js.Any): Unit = js.native

  /**
   * Removes an entry from the Cache object.
   * @param key the given key
   * @return the value stored.
   */
  def remove(key: String): js.Any = js.native

  /**
   * Clears the cache object of any entries.
   */
  def removeAll(): Unit = js.native

}
