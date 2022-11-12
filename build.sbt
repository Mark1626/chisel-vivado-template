// See README.md for license details.
import scala.sys.process._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.mark"

val chiselVersion = "3.5.1"

lazy val root = (project in file("."))
  .settings(
    name := "Fact",
    libraryDependencies ++= Seq(
      "edu.berkeley.cs" %% "chisel3" % chiselVersion,
      "edu.berkeley.cs" %% "chiseltest" % "0.5.1" % "test"
    ),
    scalacOptions ++= Seq(
      "-language:reflectiveCalls",
      "-deprecation",
      "-feature",
      "-Xcheckinit",
      "-P:chiselplugin:genBundleElements",
    ),
    addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % chiselVersion cross CrossVersion.full),
  )

lazy val importVivado = taskKey[Unit]("Import project into Vivado")

importVivado := {
  "python vivado-project-template/git_vivado.py checkout" !
}
