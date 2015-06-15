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

@Configuration// Marks this class as configuration// Specifies which package to scan
@ComponentScan("test")// Enables Spring's annotations
//@EnableTransactionManagement
//@EnableWebMvc
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
//  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
	  
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {  
	        // I tried these many combinations separately.

	        ResourceHandlerRegistration resourceRegistration = registry
	            .addResourceHandler("resources/**");
	        resourceRegistration.addResourceLocations("/resources/**");
	        registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
	        registry.addResourceHandler("/img/**").addResourceLocations("/img/**");
	        registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
	        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/"); 
	              // do the classpath works with the directory under webapp?
	     } 
	  
//	  @Override
//	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/resources/**")
//	      .addResourceLocations("/", "classpath:/src/main/resources/");
//	  }
	  
//	  @Override
//	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	  	if (!registry.hasMappingForPattern("/webjars/**")) {
//	  		registry.addResourceHandler("/webjars/**").addResourceLocations(
//	  				"classpath:/META-INF/resources/webjars/");
//	  	}
//	  	if (!registry.hasMappingForPattern("/**")) {
//	  		registry.addResourceHandler("/**").addResourceLocations(
//	  				RESOURCE_LOCATIONS);
//	  	}
//	  }
 
//	   @Override
//	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	    }
}