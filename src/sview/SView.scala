package sview

import scala.xml._

trait SView
{
    def content() : Elem
}

abstract case class SContentView(binding : ViewBinding) extends SView {}

abstract case class SHtmlView(binding : ViewBinding) extends SView {
    def head() : Elem
    def body() : Elem
}

abstract case class SHtmlLayoutView(binding : ViewBinding , view : SHtmlView) extends SView {
}

trait SHtmlViewContent extends SHtmlView {
    def content() : Elem = {
        <html>
        <head>
        { head }
        </head>
        <body>
        { body } 
        </body>
        </html>
    }
}

