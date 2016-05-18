package examples.nodejs.general

import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}

import scala.scalajs.js

/**
  * Scoping Experiment
  * @author lawrence.daniels@gmail.com
  */
class ScopingTest(bootstrap: Bootstrap) {
  import bootstrap._

  console.log(js.Array(require.cache.keys.toSeq: _*))

}
