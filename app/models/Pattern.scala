package models

import java.util.Scanner
import java.io.File

case class Pattern(title: String = "",
                   summary: String = "",
                   problem: String = "",
                   solution: String = "",
                   patternLanguage: String = "",
                   references: List[Pattern] = Nil)

object Pattern {
  def all(): List[Pattern] = {
    val folder: File = new File(getClass.getResource("/patterns/plm/").toURI)
    folder.listFiles.map(file => {
      val scanner: Scanner = new Scanner(file).useDelimiter("\n\n")

      try {
        val title: String = if (scanner.hasNext) scanner.next() else ""
        val summary: String = if (scanner.hasNext) scanner.next() else ""
        val problem: String = if (scanner.hasNext) scanner.next() else ""
        val solution: String = if (scanner.hasNext) scanner.next() else ""
        val patternLanguage: String = if (scanner.hasNext) scanner.next() else ""

        new Pattern(title, summary, problem, solution, patternLanguage)
      } finally {
        scanner.close()
      }
    }).toList
  }
}
