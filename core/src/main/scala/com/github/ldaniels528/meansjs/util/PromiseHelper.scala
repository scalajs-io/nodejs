package com.github.ldaniels528.meansjs.util

import org.scalajs.dom._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

/**
  * Promise Helper
  * @author lawrence.daniels@gmail.com
  */
object PromiseHelper {

  ////////////////////////////////////////////////////////////////////////
  //    Monitoring Functions
  ////////////////////////////////////////////////////////////////////////

  def time[T](action: String, task: => Future[T], showHeader: Boolean = true)(implicit ec: ExecutionContext): Future[T] = {
    if (showHeader) console.info(s"$action...")
    val startTime = System.currentTimeMillis()
    task onComplete {
      case Success(_) =>
        console.info(s"$action took ${System.currentTimeMillis() - startTime} msecs")
      case Failure(e) =>
        console.warn(s"$action failed after ${System.currentTimeMillis() - startTime} msecs")
    }
    task
  }

  /**
    * Time Measurement Extensions
    * @param task the given [[Future task]]
    * @tparam T the return type of the task
    */
  implicit class TimeExtensions[T](val task: Future[T]) extends AnyVal {

    def withTimer(action: String, showHeader: Boolean = false)(implicit ec: ExecutionContext) = time(action, task, showHeader)

  }

}
