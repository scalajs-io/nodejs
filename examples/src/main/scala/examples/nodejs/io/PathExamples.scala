package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.Process._
import com.github.ldaniels528.meansjs.nodejs.core.Assert
import com.github.ldaniels528.meansjs.nodejs.path.{Path, PathObject}
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console, process}

import scala.scalajs.js.JSConverters._

/**
  * Path Examples
  * @author lawrence.daniels@gmail.com
  */
class PathExamples(bootstrap: Bootstrap) {
  import bootstrap._

  val path = require[Path]("path")
  val assert = require[Assert]("assert")

  console.log("""path.basename("/foo/bar/baz/asdf/quux.html") should be "quux.html"""")
  assert.equal(path.basename("/foo/bar/baz/asdf/quux.html"), "quux.html")

  console.log("""path.basename("/foo/bar/baz/asdf/quux.html", ".html") should be "quux"""")
  assert.equal(path.basename("/foo/bar/baz/asdf/quux.html", ".html"), "quux")

  console.log("process.env.PATH => %s", process.env.PATH.map(_.split(path.delimiter).mkString(", ")).orUndefined)

  console.log("""path.win32.basename("C:\temp\data.txt") => """, path.win32.basename("C:\\temp\\data.txt"))
  console.log("""path.posix.basename("C:\temp\data.txt") => """, path.posix.basename("C:\\temp\\data.txt"))

  console.log("""path.win32.basename("/temp/data.txt") => """, path.win32.basename("/temp/data.txt"))
  console.log("""path.posix.basename("/temp/data.txt") => """, path.posix.basename("/temp/data.txt"))

  console.log("""path.format(PathObject(root = "/", base = "file.txt")) => """, path.format(PathObject(root = "/", base = "file.txt")))

  console.log("""path.isAbsolute("/foo/bar") => """, path.isAbsolute("/foo/bar")) // true
  console.log("""path.isAbsolute("/baz/..") => """, path.isAbsolute("/baz/..")) // true
  console.log("""path.isAbsolute("qux/") => """, path.isAbsolute("qux/"))  // false
  console.log("""path.isAbsolute(".") => """, path.isAbsolute(".") )  // false

  console.log("""path.join("/foo", "bar", "baz/asdf", "quux", "..") => """, path.join("/foo", "bar", "baz/asdf", "quux", ".."))
  assert.equal(path.join("/foo", "bar", "baz/asdf", "quux", ".."), "/foo/bar/baz/asdf")

}
