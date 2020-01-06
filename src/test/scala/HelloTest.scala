package hello
package test

import org.scalatest.FlatSpec
import hello.code.HelloScala

class ParserSpec extends FlatSpec {
  "main" should "run" in {
    HelloScala.main(Array("HelloScala"))
  }
}
