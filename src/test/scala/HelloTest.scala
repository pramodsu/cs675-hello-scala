package hello
package test

import org.scalatest.FlatSpec
import hello.code._

class ParserSpec extends FlatSpec {
  "main" should "run" in {
    HelloScala.main(Array("HelloScala"))
  }
  "first test case for findFunctions" should "work correctly" in {
    val s1 = IfElseStmt(And(Not(Var("a")), Not(Var("b"))), 
                CallStmt("h"), 
                IfElseStmt(Not(Var("a")), CallStmt("g"), CallStmt("f")))
    var fns = HelloScala.findFunctions(s1)
    assert(fns == Set("h", "g", "f"))
  }
}
