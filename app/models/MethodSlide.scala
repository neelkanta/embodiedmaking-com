package models

case class MethodSlide(id: String, description: String, note: String)

object MethodSlide {
  def all(sectionId: String): List[MethodSlide] = {
    StaticResources.scan("method/" + sectionId + ".txt", scanner => {
      var list: List[MethodSlide] = Nil

      scanner.useDelimiter("\n\n")
      while (scanner.hasNext) {
        val id: String = if (scanner.hasNext) scanner.next() else ""
        val description: String = if (scanner.hasNext) scanner.next() else ""
        val note: String = if (scanner.hasNext) scanner.next() else ""

        list = new MethodSlide(id, description, note) :: list
      }

      list.reverse
    })
  }
}

