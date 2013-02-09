import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization  := "pl.project13.scala",
    name          := "macro-delegate",
    version       := "0.0.1-SNAPSHOT",
    scalaVersion  := "2.10.0",
    scalacOptions += "",
    licenses      := ("Apache2", new java.net.URL("http://www.apache.org/licenses/LICENSE-2.0.txt")) :: Nil,
    publishMavenStyle := true,
    // For some reason generating the docs generates a publish error
    publishArtifact in (Compile, packageDoc) := false
  )
}

object ScalaMacroDebugBuild extends Build {
  import BuildSettings._

  val scalaTest = "org.scalatest" %% "scalatest" % "2.0.M5b" % "test"

  lazy val root: Project = Project(
    "root",
    file("."),
    settings = buildSettings
  ) aggregate(macros, examples)

  lazy val macros: Project = Project(
    "macros",
    file("macros"),
    settings = buildSettings ++ Seq(
      libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _),
      libraryDependencies += scalaTest
    )
  )

  lazy val examples: Project = Project(
    "examples",
    file("examples"),
    settings = buildSettings ++ Seq(
      libraryDependencies += scalaTest
    )
  ) dependsOn(macros)
}
