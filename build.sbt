lazy val root = (project in file(".")).
  settings(
    name := "takehome",
    version := "0.1",
    scalaVersion := "2.11.4",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.1.6" % "test",
      "org.typelevel" %% "scalaz-scalatest" % "0.2.2" % "test",
      "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test"
    )
  )
