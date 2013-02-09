import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization  := "pl.project13.scala",
    name          := "macro-method-alias",
    version       := "1.0",
    scalaVersion  := "2.10.0"
  )
}

trait SonatypeSettings {
  val sonatypeSettings = Seq(
      publishMavenStyle := true,
      publishArtifact in Test := false,
      pomIncludeRepository := { _ => false },
      publishTo <<= version { (v: String) =>
        val nexus = "https://oss.sonatype.org/"
        if (v.trim.endsWith("SNAPSHOT"))
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases" at nexus + "service/local/staging/deploy/maven2")
      },
      credentials += Credentials(Path.userHome / ".sbt" / "sonatype.properties"),
      pomExtra := (
      <url>http://ktoso.github.com/scala-macro-delegate</url>
      <licenses>
        <license>
          <name>Apache 2 License</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:ktoso/scala-macro-delegate.git</url>
        <connection>scm:git:git@github.com:ktoso/scala-macro-delegate.git</connection>
      </scm>
      <developers>
        <developer>
          <id>ktoso</id>
          <name>Konrad 'ktoso' Malawski</name>
          <url>http://blog.project13.pl</url>
        </developer>
      </developers>
      <parent>
        <groupId>org.sonatype.oss</groupId>
        <artifactId>oss-parent</artifactId>
        <version>7</version>
      </parent>)
      )
}

object ScalaMacroDebugBuild extends Build with SonatypeSettings {
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
    settings = buildSettings ++ sonatypeSettings ++ Seq(
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
