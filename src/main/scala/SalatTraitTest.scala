
import com.mongodb.DBObject
import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._

@Salat
trait Menu
case class MenuHeader(title: String = "", children: List[Menu]) extends Menu
case class MenuItem(name: String = "", price: Double = 0.0) extends Menu

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
  }
}
