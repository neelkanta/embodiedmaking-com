package models

import java.util.Scanner
import java.io.InputStream

import scala.collection.JavaConversions._

case class Pattern(id: String,
                   maturity: Int,
                   title: String,
                   summary: String,
                   problem: String,
                   solution: String,
                   patternLanguage: String,
                   synonyms: List[String])

object Pattern {
  def all(): List[Pattern] = {
    getIds().map(id => {
      get(id)
    })
  }

  def get(id: String): Pattern = {
    val stream: InputStream = getInputStream("patterns/plm/" + id + ".txt")
    try {
      val scanner: Scanner = new Scanner(stream, "UTF-8").useDelimiter("\n\n")

      val caption = if (scanner.hasNext) scanner.next() else ""
      val split: Array[String] = caption.split('|')

      val title: String = if (split.length > 0) split(0) else ""
      val maturity: Int = if (split.length > 1) split(1).toInt else 2
      val summary: String = if (scanner.hasNext) scanner.next() else ""
      val problem: String = if (scanner.hasNext) scanner.next() else "to be continued..."
      val solution: String = if (scanner.hasNext) scanner.next() else "to be continued..."
      val patternLanguage: String = if (scanner.hasNext) scanner.next() else "to be continued..."
      val synonyms: List[String] = if (scanner.hasNext) title :: scanner.next().split(",").toList else List(title)

      new Pattern(id, maturity, title, summary, problem, solution, patternLanguage, synonyms)
    } finally {
      stream.close()
    }
  }

  def getIds(): List[String] = {
    val stream: InputStream = getInputStream("patterns/plm/__Patterns.txt")
    try {
      new Scanner(stream, "UTF-8").toList
    } finally {
      stream.close()
    }
  }

  def getInputStream(name: String): InputStream = {
    Thread.currentThread().getContextClassLoader.getResourceAsStream(name)
  }
}
