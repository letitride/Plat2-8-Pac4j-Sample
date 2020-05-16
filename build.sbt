name := """Learn-Playframework2"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.2"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += ehcache
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.12"
libraryDependencies += "com.h2database" % "h2" % "1.4.200" % Test
// https://github.com/playframework/anorm/releases
libraryDependencies += "org.playframework.anorm" %% "anorm" % "2.6.5"


libraryDependencies += "org.pac4j" %% "play-pac4j" % "10.0.0"
libraryDependencies += "org.pac4j" % "pac4j-oauth" % "4.0.0"
libraryDependencies += "org.pac4j" % "pac4j-http" % "4.0.0"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
