package hello
package code

abstract class Expr
case class Var(name: String) extends Expr {
  override def toString() = name
}
case class And(e1: Expr, e2: Expr) extends Expr {
  override def toString() = "(" + e1.toString() + " && " + e2.toString() + ")"
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
      case CallStmt(f) => Set(f)
      case IfElseStmt(e, t, f) =>
        findFunctions(t) ++ findFunctions(f)
    }
  }
  def findVariablesInExpr(e : Expr) : Set[String] = {
    e match {
      case Var(n) => Set(n)
      case And(e1, e2) => findVariablesInExpr(e1) ++ findVariablesInExpr(e2)
      case Not(e) => findVariablesInExpr(e)
    }
  }

  def findVariables(prog: Stmt) : Set[String] = {
    prog match {
      case CallStmt(f) => Set.empty
      case IfElseStmt(e, t, f) =>
        findVariablesInExpr(e) ++ findVariables(t) ++ findVariables(f)
    }
  }

  def main(args: Array[String]) {
    printf("hello, world!\n")
    val s1 = IfElseStmt(And(Not(Var("a")), Not(Var("b"))), 
                CallStmt("h"), 
                IfElseStmt(Not(Var("a")), CallStmt("g"), CallStmt("f")))
    println(s1.toString())
    println("Functions in the above: " + findFunctions(s1))
    println("Variables in the above: " + findVariables(s1))
  }
}
