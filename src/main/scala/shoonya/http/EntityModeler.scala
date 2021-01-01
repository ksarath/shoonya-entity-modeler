package shoonya.http

import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.circe._
import org.http4s.circe.CirceEntityCodec._
import shoonya.application.entity.{Entity, Text}
import zio.interop.catz._

object EntityModeler extends Routes {

  override val rootPath: String = "/entity"

  override def routes: List[Route] = List(
    {
      case GET -> Root =>
        Ok(Entity("id1", Option("name1"), List(Text("id2"))).asJson)
    },
    {
      case request @ POST -> Root =>
        for {
          entity <- request.as[Entity]
          response <- Ok(entity)
        } yield response
    }
  )
}
