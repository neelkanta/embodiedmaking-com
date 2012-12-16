package models

import java.util.Scanner
import java.io.InputStream

import scala.collection.JavaConversions._
import com.google.common.base.Charsets

case class Pattern(id: String = "",
                   title: String = "",
                   summary: String = "",
                   problem: String = "",
                   solution: String = "",
                   patternLanguage: String = "",
                   synonyms: List[String] = Nil)

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

      val title: String = if (scanner.hasNext) scanner.next() else ""
      val summary: String = if (scanner.hasNext) scanner.next() else ""
      val problem: String = if (scanner.hasNext) scanner.next() else ""
      val solution: String = if (scanner.hasNext) scanner.next() else ""
      val patternLanguage: String = if (scanner.hasNext) scanner.next() else ""
      val synonyms: List[String] = if (scanner.hasNext) title :: scanner.next().split(",").toList else List(title)

      new Pattern(id, title, summary, problem, solution, patternLanguage, synonyms)
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
