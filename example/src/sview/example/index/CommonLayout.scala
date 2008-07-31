package sview.example.index

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope

import sview._

@Component
@Scope("prototype")
class CommonLayout(b:ViewBinding,v:SHtmlView) extends SHtmlLayoutView(b,v) {

	val foot = <p> FOOT </p>

    def content()  = {
        <html>
        <head>
            { v.head }
        </head>
        <body>
            { v.body }
            <p> this is common layout </p>
			{ foot }
        </body>
        </html>;
    }
}
