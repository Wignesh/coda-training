name := "DataJobs"

version := "0.1"

scalaVersion := "2.12.8"

idePackagePrefix := Some("ga.veee")


libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.4.3",
  "org.apache.spark" %% "spark-streaming" % "2.4.3",
  "org.apache.kafka" %% "kafka" % "2.1.0",
  "org.apache.kafka" % "kafka-clients" % "2.1.0",
  "org.apache.spark" %% "spark-sql" % "2.4.3",
  "org.slf4j" % "slf4j-simple" % "1.8.0-alpha2"
)
dependencyOverrides ++= {
  Seq(
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.6.7.1",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7",
    "com.fasterxml.jackson.core" % "jackson-core" % "2.6.7"
  )
}