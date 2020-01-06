# Example Scala Code

How to use this repository?

First, run sbt:

    $ sbt

Then run compile from within sbt.

    sbt:hello-scala> compile

You should see the following output.

    [info] Updating ...
    [info] Done updating.
    [info] Compiling 1 Scala source to /home/pramod/teaching/cs675a-2020/demo/hello-scala/target/scala-2.12/classes ...
    [info] Done compiling.
    [success] Total time: 3 s, completed Jan 6, 2020 11:30:53 PM

The run the program using sbt's run command.

    sbt:hello-scala> run

You should see the following output.

    [info] Packaging /home/pramod/teaching/cs675a-2020/demo/hello-scala/target/scala-2.12/hello-scala_2.12-0.1.0.jar ...
    [info] Done packaging.
    [info] Running hello.code.HelloScala 
    hello, world!
    if (!a && !b) { h() } else { if (!a) { g() } else { f() } }
    Functions in the above: Set(h, g, f)
    [success] Total time: 0 s, completed Jan 6, 2020 11:31:23 PM

The code is in the directory src/main/scala while the tests are in src/test/scala.
