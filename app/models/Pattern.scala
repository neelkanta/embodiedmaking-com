package models

import java.util.Scanner
import java.io.InputStream

import scala.collection.JavaConversions._

case class Pattern(title: String = "",
                   summary: String = "",
                   problem: String = "",
                   solution: String = "",
                   patternLanguage: String = "",
                   references: List[Pattern] = Nil)

object Pattern {
  def all(): List[Pattern] = {

    getFiles().map(filename => {
      println(filename)
      val stream: InputStream = getInputStream(filename)
      try {
        val scanner: Scanner = new Scanner(stream).useDelimiter("\n\n")

        val title: String = if (scanner.hasNext) scanner.next() else ""
        val summary: String = if (scanner.hasNext) scanner.next() else ""
        val problem: String = if (scanner.hasNext) scanner.next() else ""
        val solution: String = if (scanner.hasNext) scanner.next() else ""
        val patternLanguage: String = if (scanner.hasNext) scanner.next() else ""

        new Pattern(title, summary, problem, solution, patternLanguage)
      } finally {
        stream.close()
      }
    })
  }

  def getFiles(): List[String] = {
    val stream: InputStream = getInputStream("patterns/plm/__Patterns.txt")
    try {
      new Scanner(stream).toList.map(filename => "patterns/plm/" + filename + ".txt")
    } finally {
      stream.close()
    }
  }

  def getInputStream(name: String): InputStream = {
    Thread.currentThread().getContextClassLoader.getResourceAsStream(name)
  }
}
