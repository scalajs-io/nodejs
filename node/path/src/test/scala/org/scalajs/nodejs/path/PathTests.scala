package org.scalajs.nodejs.path

import org.scalajs.nodejs.NodeRequire._
import utest._

/**
  * Path Tests
  * @author lawrence.daniels@gmail.com
  */
object PathTests extends TestSuite {

  override val tests = this {
    val path = Path()

    "path.basename" - {
      path.basename("/foo/bar/baz/asdf/quux.html") ==> "quux.html"
      path.basename("/foo/bar/baz/asdf/quux.html", ".html") ==> "quux"
    }

    "path.posix.basename" - {
      path.posix.basename("C:\\temp\\data.txt") ==> "C:\\temp\\data.txt"
      path.posix.basename("/temp/data.txt") ==> "data.txt"
    }

    "path.win32.basename" - {
      path.win32.basename("C:\\temp\\data.txt") ==> "data.txt"
      path.win32.basename("/temp/data.txt") ==> "data.txt"
    }

    "path.format" - {
      path.format(PathObject(root = "/", base = "file.txt")) ==> "/file.txt"
    }

    "path.isAbsolute" - {
      path.isAbsolute("/foo/bar") ==> true
      path.isAbsolute("/baz/..") ==> true
      path.isAbsolute("qux/") ==> false
      path.isAbsolute(".") ==> false
    }

    "path.join" - {
      path.join("/foo", "bar", "baz/asdf", "quux", "..") ==> "/foo/bar/baz/asdf"
    }

  }
}
