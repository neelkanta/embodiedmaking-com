import sbt._
import Keys._
import PlayProject._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "venturesite"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "securesocial" % "securesocial_2.10" % "2.1.1"
    )

	val main = play.Project(appName, appVersion, appDependencies).settings(
      resolvers += Resolver.url("sbt-plugin-snapshots", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
    )

}
