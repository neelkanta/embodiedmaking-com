package models

case class PatternLanguage(id: String, description: String, patterns: List[Pattern]) {
  def getPattern(id: String): Pattern = {
    patterns.find(_.id == id).get
  }
}

object PatternLanguage {
  private val all = LazyCache {
    List(
      ("plm", "a plm pattern language for telecommunication operators")
    ).map(p => {
      (p._1, new PatternLanguage(p._1, p._2, Pattern.all(p._1)))
    }).toMap
  }

  def get(id: String): PatternLanguage = {
    all(id)
  }
}
