package sview.example.index

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope

import sview._

@Component
@Scope("prototype")
class CommonLayout(b:ViewBinding,v:SView) extends SViewComposite(b,v) {

    val foot = <p> FOOT </p>

    def content()  = {
        <html>
        <head>
            { v.content \ "head" \ "_" }
        </head>
        <body>
            { v.content \ "body" \ "_" }
            <p> this is common layout </p>
            { foot }
        </body>
        </html>;
    }
}
