package examples.nodejs.basics

import com.github.ldaniels528.meansjs.nodejs.Require
import com.github.ldaniels528.meansjs.nodejs.zlib.Zlib
import org.scalajs.dom._

/**
  * Compression Examples
  * @author lawrence.daniels@gmail.com
  */
class Compression(require: Require) {

  val zlib = require[Zlib]("zlib")

  console.log("zlib = %j", zlib.Z_VERSION_ERROR)

  //zlib.flushAsync(1)

}
