package models

import StaticResources._

case class MethodSlide(id: String, description: String, note: String)

object MethodSlide {
  private val methodSlides = LazyCache {
    MethodSection.all().map(section => {
      scan("method/" + section.id + ".txt", scanner => {
        var list: List[MethodSlide] = Nil

        scanner.useDelimiter("\n\n")
        while (scanner.hasNext) {
          val id: String = if (scanner.hasNext) scanner.next() else ""
          val description: String = if (scanner.hasNext) scanner.next() else ""
          val note: String = if (scanner.hasNext) scanner.next() else ""

          list = new MethodSlide(id, description, note) :: list
        }

        (section.id, list.reverse)
      })
    }).toMap
  }

  def all(sectionId: String): List[MethodSlide] = methodSlides(sectionId)
}

