package io.scalajs.nodejs.internal

import scala.reflect.macros.whitebox

object CompilerSwitches {
  private val nodejsVersionPattern = "^nodeJs([0-9]{1,2})\\.([0-9]{1,2})\\.([0-9]{1,2})$".r

  private def compare(predicate: (Int, Int, Int) => Boolean): String => Boolean = { version: String =>
    val nodejsVersionPattern(major, minor, patch) = version
    predicate(major.toInt, minor.toInt, patch.toInt)
  }

  final val isNodeJs12  = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major == 12))
  final val gteNodeJs12 = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major >= 12))

  final val isNodeJs14  = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major == 14))
  final val gteNodeJs14 = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major >= 14))
  final val ltNodeJs14  = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major < 14))
}
