
import com.mongodb.DBObject
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._


@Salat
trait Menu {
  val title: String
}
case class MenuHeader(title: String = "", children: List[Menu]) extends Menu
case class MenuItem(title: String = "", price: Double = 0.0) extends Menu

object SalatTraitTest {
  implicit val ctx = new Context {
    val name = "When-Necessary-Context"
    override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.Always, typeHint="_typeHint")

  }

  val menu: Menu = MenuHeader("Dinner", List(
    MenuHeader("Appetizer", List(
      MenuItem("Spring Roll", 1.00),
      MenuItem("Chicken Tikka", 2.00),
      MenuHeader("Children Only", List(
        MenuItem("Ice Cream", 3.00)
      ))
    ))
  ))

  def main(args: Array[String]) = {
    val dbo: DBObject = grater[Menu].asDBObject(menu)
    println(dbo)
    //{ "_typeHint" : "MenuHeader" , "title" : "Dinner" , "children" : [ [ "Appetizer" , [ [ "Spring Roll" , 1.0] , [ "Chicken Tikka" , 2.0] , [ "Children Only" , [ [ "Ice Cream" , 3.0]]]]]]}

    val obj: Menu = grater[Menu].asObject(dbo)
    println(obj)
    //MenuHeader(Dinner,List(MenuHeader(Appetizer,List(MenuItem(Spring Roll,1.0), MenuItem(Chicken Tikka,2.0), MenuHeader(Children Only,List(MenuItem(Ice Cream,3.0)))))))

  }
}
