package model

import com.novus.salat.annotations._


@Salat
trait Menu {
  val title: String
}
case class MenuHeader(title: String = "", children: List[Menu]) extends Menu
case class MenuItem(title: String = "", price: Double = 0.0) extends Menu