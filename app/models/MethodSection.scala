package models


import scala.collection.JavaConversions._

case class MethodSection(id: String, title: String, summary: String)

object MethodSection {
  def all(): List[MethodSection] = {
    StaticResources.scan("method/__Sections.txt", scanner => {
      scanner.useDelimiter("\n\n").toList.map(line => {
        val split: Array[String] = line.split('\n')
        new MethodSection(split(0), split(1), split(2))
      })
    })
  }

  def getSection(id: String): MethodSection = {
    all().filter(_.id == id).head
  }
}
