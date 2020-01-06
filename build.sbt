name := "hello-scal"
version := "0.1.0"
maintainer := "spramod@cse.iitk.ac.in"
scalaVersion := "2.12.7"
 
scalacOptions += "-feature"
scalacOptions += "-unchecked"
scalacOptions += "-deprecation"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

