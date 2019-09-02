package nodejs
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.child_process.ChildProcess

object TestEnvironment {

  private lazy val nodeMajorVersion: Int =
    ChildProcess.execSync("node -v").asInstanceOf[Buffer].toString().drop(1).takeWhile(_.isDigit).toInt

  def isExecutedInExactNode12: Boolean = nodeMajorVersion == 12
  def isExecutedInExactNode10: Boolean = nodeMajorVersion == 10
  def isExecutedInExactNode8: Boolean  = nodeMajorVersion == 8

  def isExecutedInNode12OrNewer: Boolean = nodeMajorVersion >= 12
  def isExecutedInNode10OrNewer: Boolean = nodeMajorVersion >= 10
}
