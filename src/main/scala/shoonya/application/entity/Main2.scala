package shoonya.application.entity

import io.circe.generic.extras.Configuration

object Main2 extends App {
  import io.circe.generic.extras.auto._
  import io.circe.parser._
  import io.circe.syntax._

  implicit val configuration: Configuration =
    Configuration.
      default.
      //withSnakeCaseMemberNames. //(underscore)
      //withKebabCaseMemberNames. //(hyphen)
      withDiscriminator("type")

  println(
    Entity("id1", None, List(Text("id2", Option("name2")))).asJson.spaces2
  )

  val operationsJson =
    parse("""
      {
        "id": "id1",
        "fields" : [
          {
            "type": "Text",
            "id" : "id2",
            "name" : "name2",
            "required" : false,
            "default" : null,
            "maxLength" : 255,
            "minLength" : 0
          }
        ]
      }
       """)

  println(
    operationsJson match {
      case Right(json) => json.as[Entity]
      case Left(e)     => s"Invalid json: $e"
    }
  )

}
