ThisBuild / version := "0.1"
ThisBuild / scalaVersion :="2.13.10"
ThisBuild / organization := "risoco"

lazy val risoco = (project in file("."))
  .settings(
    addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % "3.6.0" cross CrossVersion.full),
    libraryDependencies += "edu.berkeley.cs" %% "chisel3" % "3.6.0",
    libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "0.6.0" % "test"
  )