// set the name of the project
name := "Learning Scala"

version := "1.0"

organization := "com.learningscala"

// set the Scala version used for the project
scalaVersion := "2.11.2"

// set the main Scala source directory to be <base>/src
scalaSource in Compile := baseDirectory.value / "src"

libraryDependencies += "io.spray" %% "spray-json" % "1.2.6"