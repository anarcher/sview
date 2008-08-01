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
       val df : java.text.DateFormat = java.text.DateFormat.getDateInstance() 
    <html>
    <head>
        { head }
    </head>
    <body>
    <div>
        <div> this is index List ! </div>
        <div> { m.getName } </div>
        <div> today is { df.format(new java.util.Date()) } </div>
    </div>
    </body>
    </html>
    }
}
