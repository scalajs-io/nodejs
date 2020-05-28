package io.scalajs.nodejs

package object timers {
  implicit final class TimeoutEnrichment(private val handle: Timeout) extends AnyVal {
    @inline
    def clear(): Unit = clearTimeout(handle)
  }

  implicit final class IntervalEnrichment(private val handle: Interval) extends AnyVal {
    @inline
    def clear(): Unit = clearInterval(handle)
  }

  implicit final class ImmediateEnrichment(private val immediate: Immediate) extends AnyVal {
    @inline
    def clear(): Unit = clearImmediate(immediate)
  }
}
