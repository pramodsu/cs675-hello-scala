package hello
package code

abstract class Expr
case class Var(name: String) extends Expr {
  override def toString() = name
}
case class And(e1: Expr, e2: Expr) extends Expr {
  override def toString() = e1.toString() + " && " + e2.toString()
}
case class Not(e: Expr) extends Expr {
  override def toString() = "!" + e.toString()
}

abstract class Stmt
case class IfElseStmt(e: Expr, t: Stmt, f: Stmt) extends Stmt {
  override def toString() =
    "if (" + e.toString() + ")" + " { " + t.toString() + " } else { " + f.toString() + " }"
}
case class CallStmt(f: String) extends Stmt {
  override def toString() =
    f + "()"
}

object HelloScala {
  def findFunctions(prog : Stmt) : Set[String] = {
    prog match {
      case IfElseStmt(e, t, f) => findFunctions(t) ++ findFunctions(f)
      case CallStmt(f) => Set(f)
    }
  }

  def main(args: Array[String]) {
    printf("hello, world!\n")
    val c1 = And(Not(Var("a")), Not(Var("b")))
    val c2 = Not(Var("a"))
    val s1 = IfElseStmt(c1, 
                CallStmt("h"), 
                IfElseStmt(c2, CallStmt("g"), CallStmt("f")))
    println(s1.toString())
    println("Functions in the above: " + findFunctions(s1))
  }
}
