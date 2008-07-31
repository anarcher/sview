package sview.example.index

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope

import sview._

@Component
@Scope("prototype")
class IndexList(b:ViewBinding) extends SViewContent(b){

    def head()  = {
        <title> this is index </title>
    }

    def content() = {
       val m : Model = b.getModels.get("model").asInstanceOf[Model]
    <html>
    <head>
        { head }
    </head>
    <body>
    <div>
        <div> aaa </div>
        <div> { m.getName } </div>
    </div>
    </body>
    </html>
    }
}
