package testClasses;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import test.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@ActiveProfiles("cloudx")

@ContextConfiguration(classes = {AppConfig.class})

public class MyTestsIntegration {
	
	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;
    
//    private static String URI = "/saveEntity";

//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//        
//        mockMvc.perform(get('/')).andExpect(status().isOk()).andExpect(forwardedUrl('WEB-INF/pages/index.jsp'));
//    }

    @Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
    
    
    public void addPerson() throws Exception {
    	
    	
    	String URI ="/mypath/create";
    	MvcResult result =	this.mockMvc.perform(get(URI , "/mypath/create")
    			.param("name", "TAYFUN")
    			.param("surname", "CELIK")).andExpect(status().isOk()).andReturn();
    	
    	Assert.assertEquals("Successfull", result.getResponse().getContentAsString());

    }
    
    
    @Test
    public void getPerson() throws Exception {
    	
    	String URI ="/mypath/getPerson";
    	MvcResult result =	this.mockMvc.perform(get(URI , "")
    			.param("userId", "1")
//    			.param("name", "TAYFUN")
//    			.param("surname", "CELIK")
    			).andExpect(status().isOk()).andReturn();
    	
      result.getResponse().getContentAsString();
      
      Assert.assertEquals("Successfull",result.getResponse().getContentAsString());
    }
    
    
    @Test
    public void deletePerson() throws Exception {
    	String URI ="/mypath/delete";
    	MvcResult result =	this.mockMvc.perform(get(URI , "")
    			.param("userId", "2")
    			).andExpect(status().isOk()).andReturn();
    	
      result.getResponse().getContentAsString();
      Assert.assertEquals("Successfull",result.getResponse().getContentAsString());
      
    }
    
 
    
    @Test
    public void getAllPerson() throws Exception {
    	
    	String URI ="/mypath/getAllPerson";
    	MvcResult result =	this.mockMvc.perform(get(URI , "")).andExpect(status().isOk()).andReturn();
    	
      
      Assert.assertEquals("1",result.getResponse().getContentAsString());
    }
    
}