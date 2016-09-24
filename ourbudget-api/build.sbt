lazy val scalatraVersion = "2.4.0"

lazy val root = (project in file(".")).settings(
  organization := "br.com.ourbudget",
  name := "ourbudget-api",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
  libraryDependencies ++= Seq(
    "org.scalatra"             %% "scalatra"            % scalatraVersion,
    "org.scalatra"             %% "scalatra-scalate"    % scalatraVersion,
    "org.scalatra"             %% "scalatra-json"       % scalatraVersion,
	"org.scalaj"               %% "scalaj-http"         % "2.3.0",
  	"org.json4s"               %% "json4s-jackson"      % "3.3.0",
    "org.eclipse.jetty"        %  "jetty-webapp"        % "9.3.9.v20160517",
    "org.scalactic"            %% "scalactic"           % "3.0.0",
    "org.springframework.data" %  "spring-data-mongodb" % "1.9.2.RELEASE",

    "org.scalatest"     %% "scalatest"          %  "3.0.0"  % "test",
    "org.scalatra"      %% "scalatra-scalatest" %  "2.4.1"  % "test",


    "ch.qos.logback"    %  "logback-classic"   % "1.1.3"    % "runtime",
    "javax.servlet"     %  "javax.servlet-api" % "3.1.0"    % "provided"
  )

).settings(jetty(): _*)
