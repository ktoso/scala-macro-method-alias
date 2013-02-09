import sbt._

import Defaults._

libraryDependencies += sbtPluginExtra(
    m = "com.github.mpeltonen" % "sbt-idea" % "1.2.0", // Plugin module name and version
    sbtV = "0.12",    // SBT version
    scalaV = "2.9.2"    // Scala version compiled the plugin
)
