package shoonya.http

import cats.data.Kleisli
import cats.implicits._
import org.http4s.{HttpRoutes, Request, Response}
import org.http4s.dsl.Http4sDsl
import org.http4s.implicits._
import org.http4s.server.Router
import zio.Task
import zio.interop.catz._

trait Routes extends Http4sDsl[Task] {
  type Route = PartialFunction[Request[Task], Task[Response[Task]]]

  def rootPath: String

  def routes: List[Route]

  lazy val combinedRouter: HttpRoutes[Task] =
    Router((rootPath, HttpRoutes.of(routes.reduceLeft(_ orElse _))))
}

object Routes {
  val allRoutes: Kleisli[Task, Request[Task], Response[Task]] =
    List(
      EntityModeler.combinedRouter
    ).
      reduce(_ <+> _).
      orNotFound
}
