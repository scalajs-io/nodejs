package io.scalajs.npm.angularjs

import scala.language.experimental.macros
import scala.language.implicitConversions
import scala.reflect.macros.blackbox
import scala.scalajs.js

/**
  * Dependency Set: an array of dependencies and an injection function
  * @example ["\$http", "\$log", "toaster", function(\$http, \$log, toaster) { ... }]
  * @author lawrence.daniels@gmail.com
  */
@inline
case class DependencySet(dependencies: js.Array[Any]) extends AnyVal

/**
  * Dependency Set Singleton
  * @author lawrence.daniels@gmail.com
  */
object DependencySet {

  @inline
  implicit def fn[Z](f: => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, Z](f: A => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, Z](f: (A, B) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, Z](f: (A, B, C) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, Z](f: (A, B, C, D) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, Z](f: (A, B, C, D, E) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, Z](f: (A, B, C, D, E, F) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, Z](f: (A, B, C, D, E, F, G) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, Z](f: (A, B, C, D, E, F, G, H) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, Z](f: (A, B, C, D, E, F, G, H, I) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, Z](f: (A, B, C, D, E, F, G, H, I, J) => Z): DependencySet =
    macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, Z](f: (A, B, C, D, E, F, G, H, I, J, K) => Z): DependencySet =
    macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, Z](f: (A, B, C, D, E, F, G, H, I, J, K, L) => Z): DependencySet =
    macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R, S, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R, S) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R, S, T, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R, S, T) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R, S, T, U, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, S, T, U) => Z): DependencySet = macro generate

  @inline
  implicit def fn[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R, S, T, U, V, Z](
      f: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, S, T, U, V) => Z): DependencySet = macro generate

  def generate(c: blackbox.Context)(f: c.Tree): c.universe.Tree = {
    import c.universe._

    val dpSetType = typeOf[DependencySet]
    val diArray   = createFunctionDIArray(c)(f)
    q"""{
       import scala.scalajs.js
       new $dpSetType($diArray)
    }"""
  }

  private def createFunctionDIArray(c: blackbox.Context)(tree: c.Tree) = {
    import c.universe._

    val (f, params) = decodeFunction(c)(tree)
    val diNames     = params.map(_._2.toString)
    q"js.Array(..$diNames, $f:js.Function)"
  }

  private def decodeFunction(c: blackbox.Context)(tree: c.Tree) = {
    import c.universe._

    val (m: Tree, params: List[ValDef]) = tree match {
      case q"(..$params) => $body"   => (tree, params)
      case q"{(..$params) => $body}" => (tree.children.head, params)
    }
    val args = params.map { p =>
      val q"$mods val $name: $tpe = $rhs" = p
      (mods, name, tpe, rhs)
    }
    (m, args)
  }

}
