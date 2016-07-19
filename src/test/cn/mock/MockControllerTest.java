package cn.mock;

import cn.zjc.scala.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhangjinci
 * @version 2016/7/19 13:26
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MockControllerTest  extends AbstractContextControllerTests{

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        HelloWorldController hello = new HelloWorldController();
        mockMvc = MockMvcBuilders.standaloneSetup(hello).build();
    }

    @Test
    public void readJson() throws Exception{
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("scala/index.html").accept(MediaType.APPLICATION_JSON)
        .param("id","1").param("name","zjcscut"));
        MvcResult mvcResult = resultActions.andReturn();
        Object result  = mvcResult.getAsyncResult();
        ModelAndView modelAndView = mvcResult.getModelAndView();
        System.out.println("请求的视图为为:--- " +modelAndView.getViewName());
//        assertEquals("redirect:null", modelAndView.getViewName());
        System.out.println("请求的结果为:--- " + result);
    }

}
