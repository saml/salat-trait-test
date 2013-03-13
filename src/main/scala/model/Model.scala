package model

import com.novus.salat.annotations._


@Salat
trait Menu[T] {
  val title: T
}
case class MenuHeader[T](title: T, children: List[Menu[T]]) extends Menu[T]
case class MenuItem[T](title: T, price: Double = 0.0) extends Menu[T]