lazy val todolist = project.in(file("Examples/Todolist"))
  .enablePlugins(ScalaJSPlugin)
  .settings(name := "todolist",
    cfg.base, cfg.rescalatags, cfg.rescala,
    scalaSource in Compile := baseDirectory.value)

// ===================================================================================== Settings

lazy val cfg = new {

  val version_211 = "2.11.12"
  val version_212 = "2.12.6"

  val base = List(
    organization := "de.tuda.stg",
    scalaVersion := version_212,
    crossScalaVersions := Seq(version_211, version_212),
    baseScalac,
    autoAPIMappings := true,
    Compile / doc / scalacOptions += "-groups",
  )

  lazy val baseScalac = scalacOptions ++= List(
    "-deprecation",
    "-encoding", "UTF-8",
    "-unchecked",
    "-feature",
    "-Xlint",
    "-Xfuture",
//    "-Xdisable-assertions"
  )

  lazy val rescala =
    libraryDependencies += "de.tuda.stg" %%% "rescala" % "0.22.0+130-d6cda71b"
  lazy val rescalatags =
    libraryDependencies += "de.tuda.stg" %%% "rescalatags" % "0.22.0+130-d6cda71b"

}
