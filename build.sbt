name := "salat-trait-test"

version := "1.0"

scalaVersion := "2.10.0"

resolvers ++= Seq("Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
 "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
 "Mandubian repository snapshots" at "https://github.com/mandubian/mandubian-mvn/raw/master/snapshots/",
 "Mandubian repository releases" at "https://github.com/mandubian/mandubian-mvn/raw/master/releases/")


libraryDependencies ++= Seq("com.novus" %% "salat" % "1.9.2-SNAPSHOT",
  "play" %% "play-json" % "2.2-SNAPSHOT")


