package models.pattern

import models.Pattern

object Aware_and_Integral_Instances extends Pattern(
  title = "Aware and Integral Instances",

  summary =
    """
      Components are aware of their role in fulfilling products, and product instances contain their own unique
      semantics. Awareness isn’t elsewhere, but with the component itself.
    """,

  references = List(Change_it_with_Confidence)
)