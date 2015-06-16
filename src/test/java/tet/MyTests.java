package tet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder ;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MyTests {
	
    private MockMvcRequestBuilders  mockMvc;

    @Autowired
    private WebApplicationContext wac;
    


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        
        mockMvc.perform(get('/')).andExpect(status().isOk()).andExpect(forwardedUrl('WEB-INF/pages/index.jsp'));
    }


    @Test
    public void test() {
    	
        mockMvc.perform( post(URI, "form").param("key1", "value1").param("key2", "value2") ).andExpect(status().isOk());
    }
    
     
    MockMvcBuilders.standaloneSetup(controller).build().
                perform(post("/foo/create").requestAttr("user", user)
    
}