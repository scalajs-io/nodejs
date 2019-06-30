package io.scalajs.nodejs

import scala.reflect.macros.whitebox

object CompilerSwitches {

  private val nodejsVersionPattern = "^nodeJs([0-9]{1,2})\\.([0-9]{1,2})\\.([0-9]{1,2})$".r

  private def compare(predicate: (Int, Int, Int) => Boolean): String => Boolean = { version: String =>
    val nodejsVersionPattern(major, minor, patch) = version
    predicate(major.toInt, minor.toInt, patch.toInt)
  }

  final val isNodeJs8   = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major == 8))
  final val gteNodeJs8  = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major >= 8))

  final val isNodeJs10  = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major == 10))
  final val gteNodeJs10 = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major >= 10))

  final val isNodeJs12  = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major == 12))
  final val gteNodeJs12 = (c: whitebox.Context) => c.settings.exists(compare((major, _, _) => major >= 12))
}
