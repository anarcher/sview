package sview

import scala.xml._

trait SView
{
    def content() : Elem
}

abstract case class SViewContent(binding : ViewBinding) extends SView {}
abstract case class SViewComposite(binding : ViewBinding , view : SView) extends SView {}

