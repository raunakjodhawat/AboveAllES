import xerial.sbt.Sonatype.sonatypeCentralHost

ThisBuild / sonatypeCredentialHost := sonatypeCentralHost
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.raunakjodhawat"
ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "abovealles",
    idePackagePrefix := Some("com.raunakjodhawat")
  )
libraryDependencies += "io.monix" %% "monix" % "3.4.1"

publishTo := sonatypePublishToBundle.value
