package models.pattern

import models.Pattern

object Aware_and_Integral_Instances extends Pattern(
  title = "Aware and Integral Instances",

  summary =
    """
      Components are aware of their role in fulfilling products, and product instances contain their own unique
      semantics. Awareness isn’t elsewhere, but with the component itself.
    """,

    problem =
    """
    A product instance, or a product as a customer experiences it, is realized through several systems, ranging from configuring access in a network switch to a customer record in a customer-relationship management system. Each of these systems have a part in constructing the customer's experience of the product. Given the diversity and volume of products, there are several configurations possible in each of these systems, leading to high-levels of complexity in managing all of these combinations. Processes for provisioning products need to anticipate several eventualities, to the extent that process definitions need to be conscious of the state of several network elements and systems simultaneously. When provisioning processes are treated as end-to-end transactions, errors in the process necessitate restorations of original system configurations before the product was provisioned through an expensive rollback. Rule-bases for individual situations such
    product pricing (promotions, discounts, commissions) or permitted products given an individual's installed product base further increase complexity. Given that stable systems require that the number of states in the control mechanism must be greater than or equal to the number of states in the system being controlled, creating centralized controllers and single points of truth only increase the complexity, not reduce it.
    """,

    solution =
    """
    Therefore make product instances exist integrally where they have knowledge of the components that realize them, and conversely, the components that realize them have knowledge of the product instances that reside within them. Instances are aware when they are unfulfilled, and are capable of being fixed individually. Make it possible for instances to have individual and unique behaviour, and for customers to have their unique situations reflected in the system. When systems aren't capable of enabling unique behaviour for instances, utilize proxies for in systems with that capability.
    """

    patternlanguage =
    """
    Use the Language for Product Instances to reflect product instances and the customer's situation and use the same Language for Product Instances to interpret the customer's unique situation and install base. If the customer is experiencing problems with their product, permit customer agents to Change it with Confidence. Enable Product Markers that describe the product instance's performance, costs, and efficiency.
    """

)