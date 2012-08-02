import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play2-cloudfront"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.jquery" % "jquery" % "1.7.2-1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      resolvers += "webjars" at "http://webjars.github.com/m2"
    )

}
