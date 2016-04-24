package examples.nodejs.basics

import com.github.ldaniels528.meansjs.nodejs.Require
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import org.scalajs.dom.console

/**
  * Files
  * @author lawrence.daniels@gmail.com
  */
class Files(require: Require) {

  val fs = require[Fs]("fs")

  console.log("fs = %j", fs.F_OK)
}
