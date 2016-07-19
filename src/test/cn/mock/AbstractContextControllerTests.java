package cn.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhangjinci
 * @version 2016/7/19 13:25
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),
		@ContextConfiguration(name = "child", locations = {"classpath:dispatcher-servlet.xml", "classpath:spring-activiti.xml"})
})
public class AbstractContextControllerTests {


	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}


	@Test
	public void testView() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/scala/index.html")
				.param("id", "1")
				.param("name", "zjcscut"))
//				.andExpect(MockMvcResultMatchers.view().name("user/view"))
//				.andExpect(MockMvcResultMatchers.model().attributeExists("user"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		System.out.println(result);
	}
}
