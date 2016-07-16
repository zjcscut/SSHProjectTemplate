package cn.zjc.scala

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody}

/**
  * @author zjc
  * @version 2016/7/16 23:52
  */
@Controller
class HelloWorldController {

  @RequestMapping(value = Array("scala/hello.html"), method = Array(RequestMethod.GET))
  @ResponseBody
  def Hello(): String ={
     "Hello World! SpringMVC with Scala"
  }

}
