package sview.example.index

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope

import sview._

@Component
@Scope("prototype")
class CommonLayout(b:ViewBinding,v:SView) extends SViewComposite(b,v) with SHtmlView {

    val foot = <p> FOOT </p>

    def content()  = {
        <html>
        <head>
            { v.content \ "head" }
        </head>
        <body>
            { v.content \ "body" }
            <p> this is common layout </p>
            { foot }
        </body>
        </html>;
    }
}
