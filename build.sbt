
scalaVersion := "2.13.4"

val zioV = "1.0.3"
val zioCatsInterOpV = "2.2.0.1"
val circeV = "0.13.0"
val http4sV = "0.21.14"
val slf4jV = "1.7.30"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-Ymacro-annotations",
  "-language:higherKinds",
  "-Ydelambdafy:inline"
)

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioV,
  "dev.zio" %% "zio-streams" % zioV,
  "dev.zio" %% "zio-interop-cats" % zioCatsInterOpV,

  "org.http4s" %% "http4s-core" % http4sV,
  "org.http4s" %% "http4s-dsl" % http4sV,

  "org.http4s" %% "http4s-blaze-server" % http4sV,
  "org.http4s" %% "http4s-blaze-client" % http4sV,

  "org.http4s" %% "http4s-server" % http4sV,
  "org.http4s" %% "http4s-client" % http4sV,

  "org.http4s" %% "http4s-async-http-client" % http4sV,

  "org.http4s" %% "http4s-circe" % http4sV,
  "io.circe" %% "circe-core" % circeV,
  "io.circe" %% "circe-parser" % circeV,
  // "io.circe" %% "circe-shapes" % circeV,
  // "io.circe" %% "circe-literal" % circeV,
  "io.circe" %% "circe-generic" % circeV,
  "io.circe" %% "circe-generic-extras" % circeV,
  // "org.http4s" %% "http4s-json4s-jackson" % http4sV,

  "org.slf4j" % "slf4j-jdk14" % slf4jV,

  "org.http4s" %% "http4s-testing" % http4sV,
)
