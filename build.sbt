import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val catsEffect = (project in file("."))
  .settings(name := "cats-effect")
  .aggregate(catsEffectCore.projectRefs *)

lazy val catsEffectCore = (projectMatrix in file("cats-effect-core"))
  .settings(name := "cats-effect-core")
  .settings(libraryDependencies ++= dependencies(typelevel.catsEffect))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
