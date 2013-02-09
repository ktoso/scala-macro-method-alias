import sbt._
import Defaults._

resolvers += Resolver.url("sbt-plugin-releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.jsuereth" % "xsbt-gpg-plugin" % "0.6")

libraryDependencies += sbtPluginExtra(
    m = "com.github.mpeltonen" % "sbt-idea" % "1.2.0",
    sbtV = "0.12",
    scalaV = "2.9.2"
)
