package sview;

import scala.xml._

trait SViewRenderer {
    def setDocType(docType : String)
    def setContentType(contentType : String)
    def setContent(content : Elem)
}

