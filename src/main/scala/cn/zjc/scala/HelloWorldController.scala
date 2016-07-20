package cn.zjc.scala

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam, ResponseBody}
import org.springframework.web.servlet.ModelAndView

/**
  * @author zjc
  * @version 2016/7/16 23:52
  */
@Controller
class HelloWorldController {

  @RequestMapping(value = Array("scala/hello.html"), method = Array(RequestMethod.GET))
  @ResponseBody
  def Hello(): String = {
    "Hello World! SpringMVC with Scala"
  }

  @RequestMapping(value = Array("scala/index.html"), method = Array(RequestMethod.GET))
  def Index(mav: ModelAndView, @RequestParam("id") id: String, @RequestParam("name") name: String): ModelAndView = {
    print("接收到的请求参数--> " + "id =" + id + " name=" + name)
    mav.setViewName("index")
    mav
  }

  @RequestMapping(value = Array("scala/index/view.html"), method = Array(RequestMethod.GET))
  def PaeseParams(mav: ModelAndView): ModelAndView = {
    mav.setViewName("index")
    mav
  }

  @RequestMapping(value = Array("scala/view/data.html"),method = Array(RequestMethod.GET))
  def viewAndData(mav:ModelAndView):ModelAndView = {
    mav.setViewName("index")
    mav.addObject("name","zjcscut")
    mav
  }


}
