package models

case class Venture(id: String, name: String, description: String, stories: List[String])

object Venture {
  def get(id: String) : Venture = {
    return new Venture("fruent", "Fruent", "Your working day is starting and ending fruently...",
      List(
        "I have a small business, and I would like my customers to know my opening and closing times easily. I often have to go out for a little while, and when I do, I shut the store for a few moments. I would like my customers to know that I am out for a short while, and that I will be back soon! I would like to maintain this in 1 simple place, and I would like my other solutions on the web, like my webshop, to get this information.",
        "All these different branches of the supermarket have different opening times. I would like to know the opening times of their different branches without spending too much time trying to scour and search the content on some corporate website.",
        "I arrived at a shop to pick up my package, only to find that it was closed. The sign on the shop says \"back in 1 hour\", but I wish I didn't have to travel all this way to find this out. I have another appointment, so I can't wait. I'll try again tomorrow.",
        "I need to get some medicine urgently. I need to know if there is a Pharmacy near me that is open this late at night.",
        "I am about to make some deliveries to a facility so that customers can pick-up the packages later. I want to be sure that there is someone at the facility who will be there when I get there. There are 20 packages in total, and I don't want the guy to be surprised when I show up. Worse, I don't want to wait around on the street trying to park my big truck while he makes some space in his small shop for the 20 packages. I want him to be prepared when I get there, and it would be nice if he even had a trolley or something to help me offload the packages.",
        "I run up a small shop, and I offer it as a pickup facility. I need to know a safe time to pop out for lunch. If someone is planning on coming to the store in the next 30 minutes or so, it would be nice if they would let me know slightly in advance."
      ))
  }
}