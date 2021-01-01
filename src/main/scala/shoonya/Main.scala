package shoonya

import org.http4s.server.blaze._
import shoonya.http.Routes
import zio.{App, ExitCode, Task, URIO, ZEnv, ZIO}
import zio.interop.catz._
import zio.interop.catz.implicits._

import scala.concurrent.ExecutionContext.global

object Main extends App {
  lazy val main: Task[Unit] = {
    Task.concurrentEffectWith {
      implicit rts =>
        BlazeServerBuilder[Task](global).
          bindHttp(8080, "localhost").
          withHttpApp(Routes.allRoutes).
          resource.
          use(_ => ZIO.never)
    }
  }

  override def run(args: List[String]): URIO[ZEnv, ExitCode] =
    main.exitCode
}
