package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan({ "test", "test.controller" })
@EnableWebMvc
//@ImportResource("classpath:\\spring.xml")
public class AppConfig extends WebMvcConfigurerAdapter{// 

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
// if  we use AddPersonServlet.class enable this method and @EnableWebMvc annotation need to be removed	
//  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
	  
//	  public void addResourceHandlers(ResourceHandlerRegistry registry) {  
//	        // I tried these many combinations separately 
//
//	        ResourceHandlerRegistration resourceRegistration = registry
//	            .addResourceHandler("resources/**");
//	        resourceRegistration.addResourceLocations("/resources/**");
//	        registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
//	        registry.addResourceHandler("/img/**").addResourceLocations("/img/**");
//	        registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
//	        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/"); 
//	              // do the classpath works with the directory under webapp?
//	     } 
	   
}