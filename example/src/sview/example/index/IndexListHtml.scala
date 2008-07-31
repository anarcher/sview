package sview.example.index

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope

import sview._

@Component
@Scope("prototype")
class IndexListHtml(b:ViewBinding) extends SHtmlView(b) with SHtmlViewContent {

    def head()  = {
        <title> this is index </title>
    }

    def body() = {
       val m : Model = b.getModels.get("model").asInstanceOf[Model]
    <div>
        <div> aaa </div>
        <div> { m.getName } </div>
    </div>
    }
}
