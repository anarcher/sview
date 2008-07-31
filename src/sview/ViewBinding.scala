package sview

import java.util.Map

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import scala.xml.Elem

class ViewBinding(models : Map[String,Object] , 
                  request : HttpServletRequest , 
                  response : HttpServletResponse) 
{
    def getModels : Map[String,Object] = {
        models
    }
}

