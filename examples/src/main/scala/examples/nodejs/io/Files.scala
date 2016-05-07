package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import org.scalajs.dom.console

/**
  * Files
  * @author lawrence.daniels@gmail.com
  */
class Files(bootstrap: Bootstrap) {
  import bootstrap._

  val fs = require[Fs]("fs")

  console.log("fs = %j", fs.F_OK)
}
