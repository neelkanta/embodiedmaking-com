package models

import pattern.{Classic_Lines, Change_it_with_Confidence, Aware_and_Integral_Instances}

case class Pattern(title: String = "", summary: String = "", references: List[Pattern] = Nil)

object Pattern {
  def all() = {
    List(
      Aware_and_Integral_Instances,
      Change_it_with_Confidence,
      Classic_Lines
    )
  }
}
