package sview

import scala.xml.PrettyPrinter 

object SViewRenderer {
    def render(view : SView) : String  = {
//		view.content.toString
        new PrettyPrinter(80 /*width */,3 /*indent */).format(view.content)
    }
}
