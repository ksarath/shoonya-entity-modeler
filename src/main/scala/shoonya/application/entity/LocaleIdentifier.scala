package shoonya.application.entity

sealed trait LocaleIdentifier

case class LocaleByLanguage(
                             language: String,
                             country: Option[String] = None,
                             variant: Option[String] = None
                           ) extends LocaleIdentifier

case class LocaleByLanguageTag(languageTag: String) extends LocaleIdentifier // IETF BCP 47 language tag
