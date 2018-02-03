scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")


addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "4.0.1")
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.5.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.2")