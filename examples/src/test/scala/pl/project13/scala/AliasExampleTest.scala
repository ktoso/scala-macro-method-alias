package com.softwaremill.debug

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import pl.project13.scala.macros.AliasExample

class AliasExampleTest extends FlatSpec with ShouldMatchers {

  it should "call tell via delegate" in {
    // given
    val example = new AliasExample

    // when
    example ! "Konrad"

    // then
    example.tellCalled should equal (1)
  }

  it should "delegate to ask using the annotation delegate" in {
    // given
    val example = new AliasExample

    // when
    val got = example ? "Konrad"

    // then
    got should equal (1)
    example.askCalled should equal (1)
  }

  it should "delegate using the alias syntax, even with many parameters" in {
    // given
    val example = new AliasExample

    // when
    val got = example.!!("number", 10)

    // then
    got should equal ("number10")
  }

  it should "delegate using the annotation syntax, even with many parameters" in {
      // given
      val example = new AliasExample

      // when
      val got = example.??("number", 10)

      // then
      got should equal ("number10")
    }
}
