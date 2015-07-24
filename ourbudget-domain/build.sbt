name := "ourbudget-domain"

version := "1.0"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  "spray repo"                       at "http://repo.spray.io",
  "Typesafe repository snapshots"    at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe repository releases"     at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype repo"                    at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository"       at "http://download.java.net/maven/2/",
  "Twitter Repository"               at "http://maven.twttr.com"
)

libraryDependencies ++= Seq(
  "org.scalatest"       %%  "scalatest"                 % "2.2.4"   % "test",
  "org.mongodb"         %%  "casbah"                    % "2.8.1",
  "com.typesafe"        %   "config"                    % "1.3.0"
)