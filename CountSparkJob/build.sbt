name := "CountSparkJob"

version := "0.1"

scalaVersion := "2.12.8"

idePackagePrefix := Some("global.coda")

libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.4.3")
