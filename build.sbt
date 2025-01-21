ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.3"

lazy val root = (project in file("."))
  .settings(
    name := "abovealles",
    idePackagePrefix := Some("com.raunakjodhawat")
  )
libraryDependencies += "io.monix" %% "monix" % "3.4.1"
