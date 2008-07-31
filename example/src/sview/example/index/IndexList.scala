package sview.example.index

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope

import sview._

import scala.xml.PrettyPrinter 
import scala.xml._ 

@Component
@Scope("prototype")
class IndexList(req:ViewBinding) extends SContentView(req) {

    val head = <head>
        <title> index list </title>
    </head>;

    def content()  = {
        val m : Model = req.getModels.get("model").asInstanceOf[Model]

        val content = <html>
            { head } 
        <p> this is INDEX LIST! </p>
        </html>;

        Console.println(content)
		content
    }
}
