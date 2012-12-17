package models

import java.io.InputStream
import java.util.Scanner

case class MethodSlide(id: String, description: String, note: String)

object MethodSlide {
  def all(sectionId: String): List[MethodSlide] = {
    val stream: InputStream = getInputStream("method/" + sectionId + ".txt")
    try {
      var list: List[MethodSlide] = Nil

      val scanner: Scanner = new Scanner(stream, "UTF-8").useDelimiter("\n\n")
      while (scanner.hasNext) {
        val id: String = if (scanner.hasNext) scanner.next() else ""
        val description: String = if (scanner.hasNext) scanner.next() else ""
        val note: String = if (scanner.hasNext) scanner.next() else ""

        list = new MethodSlide(id, description, note) :: list
      }

      list.reverse
    } finally {
      stream.close()
    }
  }

  def getInputStream(name: String): InputStream = {
    Thread.currentThread().getContextClassLoader.getResourceAsStream(name)
  }
}

