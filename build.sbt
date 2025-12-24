import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val catsEffect = (project in file("."))
  .settings(name := "cats-effect")
  .aggregate(
    catsEffectCore.jvm,
    catsEffectCore.js,
  )

lazy val catsEffectCore = (crossProject(JVMPlatform, JSPlatform) in file("cats-effect-core"))
  .settings(name := "cats-effect-core")
  .settings(crossDependencies(typelevel.catsEffect))

