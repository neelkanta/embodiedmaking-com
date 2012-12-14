package models

import java.util.Scanner
import java.io.InputStream

case class Pattern(title: String = "",
                   summary: String = "",
                   problem: String = "",
                   solution: String = "",
                   patternLanguage: String = "",
                   references: List[Pattern] = Nil)

object Pattern {
  def all(): List[Pattern] = {
    val inputStream: InputStream = getClass.getResourceAsStream("/patterns/plm/Aware_and_Integral_Instances.txt")
    val scanner: Scanner = new Scanner(inputStream)
    scanner.useDelimiter("\n\n")

    val contents: String = scanner.next

    List(new Pattern(title = contents))
  }
}
