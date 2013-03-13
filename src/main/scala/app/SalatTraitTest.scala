package app

import com.mongodb.DBObject
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.novus.salat.annotations._
import model._


object SalatTraitTest {
  implicit val ctx = new Context {
    val name = "Always-Typehint-Context"
    override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.Always, typeHint="_typeHint")

  }

  val menu: Menu = MenuHeader("Dinner", List[Menu](
    MenuHeader("", Nil),
    MenuHeader("Appetizer", List[Menu](
      MenuItem("Spring Roll", 1.00),
      MenuItem("Chicken Tikka", 2.00),
      MenuHeader("Children Only", List[Menu](
        MenuItem("Ice Cream", 3.00)
      ))
    ))
  ))

  def main(args: Array[String]) = {
    /*
    {
      "title": "Dinner",
      "children": [{
        "title": "",
        "children": []
       }]
     }
     */
    val dbo: DBObject = MongoDBObject("title" -> "Dinner", "children" -> MongoDBList(
      MongoDBObject("title" -> "", "children" -> MongoDBList())

    ))
    println(dbo)

    val obj: Menu = grater[Menu].asObject(dbo)
    println(obj)

  }
}
