scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")


addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "1.1.0")
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.4.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.4")