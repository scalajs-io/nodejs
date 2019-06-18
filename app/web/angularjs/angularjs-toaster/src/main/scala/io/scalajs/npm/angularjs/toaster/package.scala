package io.scalajs.npm.angularjs

/**
  * toaster package object
  * @author lawrence.daniels@gmail.com
  */
package object toaster {

  val INFO = "info"
  val DANGER = "danger"
  val ERROR = "error"
  val SUCCESS = "success"
  val WARNING = "warning"

  /**
    * Toaster Enhancements
    * @param toaster the given Toaster service instance
    */
  final implicit class ToasterEnhancements(val toaster: Toaster) extends AnyVal {

    @inline
    def danger(title: String): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = DANGER, title = title))
    }

    @inline
    def danger(title: String, body: String): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = DANGER, title = title, body = body))
    }

    @inline
    def danger(title: String, body: String, timeout: Long): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = DANGER, title = title, body = body, timeout = timeout))
    }

    @inline
    def error(title: String): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = DANGER, title = title))
    }

    @inline
    def error(title: String, body: String): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = DANGER, title = title, body = body))
    }

    @inline
    def error(title: String, body: String, timeout: Long): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = DANGER, title = title, body = body, timeout = timeout))
    }

    @inline
    def info(title: String): ToasterInstance = toaster.pop(new ToasterOptions(`type` = INFO, title = title))

    @inline
    def info(title: String, body: String): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = INFO, title = title, body = body))
    }

    @inline
    def info(title: String, body: String, timeout: Long): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = INFO, title = title, body = body, timeout = timeout))
    }

    @inline
    def success(title: String): ToasterInstance = toaster.pop(new ToasterOptions(`type` = SUCCESS, title = title))

    @inline
    def success(title: String, body: String): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = SUCCESS, title = title, body = body))
    }

    @inline
    def success(title: String, body: String, timeout: Long): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = SUCCESS, title = title, body = body, timeout = timeout))
    }

    @inline
    def warning(title: String): ToasterInstance = toaster.pop(new ToasterOptions(`type` = SUCCESS, title = title))

    @inline
    def warning(title: String, body: String): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = SUCCESS, title = title, body = body))
    }

    @inline
    def warning(title: String, body: String, timeout: Long): ToasterInstance = {
      toaster.pop(new ToasterOptions(`type` = SUCCESS, title = title, body = body, timeout = timeout))
    }

  }

}
