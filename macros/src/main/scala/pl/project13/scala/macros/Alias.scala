package pl.project13.scala.macros

import language.experimental.macros

import reflect.macros._
import annotation.StaticAnnotation

object Alias {

  /**
   * Annotation used in the annotation style method delegation. See example bellow:
   * {{{
   *  def ask(name: String): Int = ???
   *
   *  @aliasFor(ask _) // [1] delegate where?
   *  def ?(name: String) = delegated[Int] // [2] keep return type
   * }}}
   *
   * In this style of delegation we can see the "aliasFor" [1] before the method, which makes it more "stand out",
   * and it'll be kept in the docs - whereas just the in-body delegation hides this information.
   *
   * Also notice that while the '''delegated[Int]''' is a bit verbose, you cannot get it wrong.
   * If you would type '''delegated[String]''' where the ask method clearly returnes a String here you would get a type error like this one:
   * {{{
   *   [error]  found   : Int
   *   [error]  required: String
   *   [error]   def ?(name: String) = delegated[String]
   * }}}
   */
  final class aliasFor[T](delegate: => T) extends StaticAnnotation

  def delegated[T]: T = macro delegated_impl[T]
  def aliasFor[P1, T](delegate: (P1) => T) = macro alias_impl[T]
  def aliasFor[P1, P2, T](delegate: (P1, P2) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, T](delegate: (P1, P2, P3) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, T](delegate: (P1, P2, P3, P4) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, T](delegate: (P1, P2, P3, P4, P5) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, T](delegate: (P1, P2, P3, P4, P5, P6) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, T](delegate: (P1, P2, P3, P4, P5, P6, P7) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21) => T): T = macro alias_impl[T]
  def aliasFor[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, T](delegate: (P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22) => T): T = macro alias_impl[T]

  def delegated_impl[T](c: Context): c.Expr[T] = {
    import c._

    val annotation = extractAliasForAnnotation(classOf[aliasFor[_]], c)

    val inParams = extractDelegatorParams(c)

    val delegatorMethodName = extractDelegatorMethodName(c)
    val methodName = extractDelegateMethodName1(c)(annotation.scalaArgs.head.children) // we take out the code from inside the annotation, find the method name

    require(delegatorMethodName != methodName.symbol.name, s"You should not delegate to the same method (name)! Tried to delegate [$methodName]")

    val params = inParams.mkString(", ")

    val tree = parse(s"$methodName($params)")

    c.Expr(tree)
  }

  def alias_impl[T](c: Context)(delegate: c.Expr[Any]): c.Expr[T] = {
    import c._

    p("delegate: " + delegate.tree.children)

    val tree = delegate.tree.children match {
      case expr :: Nil =>
        p("expr = " + expr)

        val filledInParam = expr.children.head
        p("filledInParam = " + filledInParam)

        val inParams = extractDelegatorParams(c)
        p("inParams = " + inParams)

        val delegatorMethodName = extractDelegatorMethodName(c)
        val methodName = extractDelegateMethodName(c)
        require(delegatorMethodName != methodName, s"You should not delegate to the same method (name)! Tried to delegate [$methodName]")

        val params = inParams.mkString(", ")

        parse(s"""$methodName($params)""")

      case _ =>
        c.abort(c.enclosingPosition, "alias macro should only be used on single method delegation")
        null
    }

    p("")
    c.Expr(tree)
  }


  def extractDelegatorParams(c: Context) =
    c.enclosingMethod.children
      .filterNot(p => p.isTerm && p.symbol.isParameter)
      .map(a => Option(a.symbol))
      .filterNot(_.isEmpty)
      .flatMap(a => a.map(_.name.toString))
      .filterNot(_ == "<none>")

  def extractDelegatorMethodName(c: Context) =
    c.enclosingMethod.symbol.name

  def extractDelegateMethodName(c: Context) =
    extractDelegateMethodName1(c)(c.enclosingMethod.children)

  def extractDelegateMethodName1(c: Context)(children: List[c.universe.Tree]) =
    children
      .map(a => a.children)
      .flatten
      .filter(_.isTerm)
      .filterNot(_.isEmpty)
      .filterNot(_.toString == "aliasFor") // exclude the macro name
      .head // first tree inside our macro
      .children.head // the thing inside is partially applied - it should

  /**
   * Aborts execution if unable to find ''aliasFor'' annotation, returns it otherwise.
   */
  def extractAliasForAnnotation[A <: StaticAnnotation](annotation: Class[A], c: Context): c.universe.Annotation = {
    val rawAnnotations = c.enclosingMethod.symbol.annotations
    val annotationTypes = rawAnnotations.map(_.tpe.toString)
    p(s"The method [${c.enclosingMethod.symbol}] has these annotations: $annotationTypes")

    val aliasForClassname = classOf[aliasFor[A]].getName.replace("$", ".") + "[T]"

    annotationTypes.find(_ == aliasForClassname) match {
      case Some(found) => rawAnnotations.find(_.tpe.toString == aliasForClassname).get
      case _           => c.abort(c.enclosingPosition, s"When using aliasFor/delegate style delegation you must annotate the method with [$aliasForClassname].")
    }
  }

  /** Flag to enable debug printing, see ''p'' for usage. */
  val DebugPrinting = false

  /** Debug printing, using err as println is swallowed by sbt when used in compile phase */
  private def p(s: String) = {
    if(DebugPrinting) System.err.println(s)
  }
}
