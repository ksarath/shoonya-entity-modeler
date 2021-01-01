package shoonya.application.entity

case class Entity(
                   id: Id,
                   name: Option[String],
                   fields: List[Field]
                 )
