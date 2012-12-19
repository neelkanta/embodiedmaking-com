package models


import scala.collection.JavaConversions._
import StaticResources._

case class Pattern(id: String,
                   maturity: Int,
                   title: String,
                   summary: String,
                   problem: String,
                   solution: String,
                   patternLanguage: String,
                   synonyms: List[String])

object Pattern {
  private val ids = LazyCache {
    scan("patterns/plm/__Patterns.txt", _.toList)
  }

  private val patterns = LazyCache {
    ids.map(id => {
      scan("patterns/plm/" + id + ".txt", {
        scanner =>
          scanner.useDelimiter("\n\n")

          val caption = if (scanner.hasNext) scanner.next() else ""
          val split: Array[String] = caption.split('|')

          val title: String = if (split.length > 0) split(0) else ""
          val maturity: Int = if (split.length > 1) split(1).toInt else 2
          val summary: String = if (scanner.hasNext) scanner.next() else ""
          val problem: String = if (scanner.hasNext) scanner.next() else "to be continued..."
          val solution: String = if (scanner.hasNext) scanner.next() else "to be continued..."
          val patternLanguage: String = if (scanner.hasNext) scanner.next() else "to be continued..."
          val synonyms: List[String] = if (scanner.hasNext) title :: scanner.next().split(",").toList else List(title)

          (id, new Pattern(id, maturity, title, summary, problem, solution, patternLanguage, synonyms))
      })
    }).toMap
  }

  def all(): List[Pattern] = ids.map(get(_))

  def get(id: String): Pattern = patterns(id)
}
