package pl.project13.scala.macros

import pl.project13.scala.macros.Alias._

class AliasExample {

  var tellCalled = 0
  var askCalled = 0

  // delegation code will be generated automatically

  def tell(name: String) {
    tellCalled += 1
  }

  def !(name: String) = aliasFor { tell _ }


  // delegating with many parameters - you don't have to delegate manualy :-)

  def manyParams(a: String, b: Int): String = {
    a + b
  }

  def !!(a: String, b: Int) = aliasFor { manyParams _ }


  // delegating using the aliasFor annotation

  def ask(name: String): Int = {
    askCalled += 1
    askCalled
  }

  @aliasFor(ask _)
  def ?(name: String) = delegated[Int]


  // delegate to a many-parameters method using the aliasFor annotation

  def askMany(a: String, b: Int): String = {
    a + b
  }

  @aliasFor(askMany _)
  def ??(a: String, b: Int) = delegated[String]
}
