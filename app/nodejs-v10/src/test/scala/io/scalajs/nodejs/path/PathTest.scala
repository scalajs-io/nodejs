package io.scalajs.nodejs
package path

import org.scalatest.funspec.AnyFunSpec

class PathTest extends AnyFunSpec {
  describe("Path") {
    it("supports basename()") {
      assert(Path.basename("/foo/bar/baz/asdf/quux.html") === "quux.html")
      assert(Path.basename("/foo/bar/baz/asdf/quux.html", ".html") === "quux")
    }

    it("supports posix.basename()") {
      assert(Path.posix.basename("C:\\temp\\data.txt") === "C:\\temp\\data.txt")
      assert(Path.posix.basename("/temp/data.txt") === "data.txt")
    }

    it("supports win32.basename()") {
      assert(Path.win32.basename("C:\\temp\\data.txt") === "data.txt")
      assert(Path.win32.basename("/temp/data.txt") === "data.txt")
    }

    it("supports format()") {
      assert(Path.format(PathObject(root = "/", base = "file.txt")) === "/file.txt")
    }

    it("supports isAbsolute()") {
      assert(Path.isAbsolute("/foo/bar"))
      assert(Path.isAbsolute("/baz/.."))
      assert(!Path.isAbsolute("qux/"))
      assert(!Path.isAbsolute("."))
    }

    it("supports join()") {
      assert(Path.join("/foo", "bar", "baz/asdf", "quux", "..") === "/foo/bar/baz/asdf")
    }

    it("supports os specific from Node.js v10") {
      assert(Path.win32.toNamespacedPath("c:\\foo\\bar") === "\\\\?\\c:\\foo\\bar")
      assert(Path.posix.toNamespacedPath("c:\\foo\\bar") === "c:\\foo\\bar")
    }
  }
}
