package sview

import scala.xml._

trait SView
{
    def doctype() : String
    def contenttype() : String
    def content() : Elem
    def render(render : SViewRenderer) : Unit
}

abstract class AbstractSView extends SView {
    def contenttype() : String = {"text/html"}
    def doctype() : String = {""}
    def render(render : SViewRenderer) : Unit = {
        render.setContentType(contenttype())
        render.setDocType(doctype())
        render.setContent(content())
    }
}

abstract case class SViewContent(binding : ViewBinding) extends AbstractSView {}
abstract case class SViewComposite(binding : ViewBinding , view : SView) extends AbstractSView {}
