package es.a2m.calendar.config;

import java.util.Locale;
import java.util.TimeZone;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	
    @Bean(name = "localeResolver")
    public LocaleResolver getCookieLocaleResolver(){
    	CookieLocaleResolver slr = new CookieLocaleResolver();
        slr.setDefaultLocale(new Locale("es_ES"));
        TimeZone defaultTimeZone = TimeZone.getDefault();  //Default time zone for the system
        slr.setDefaultTimeZone(defaultTimeZone);
        return slr;
    }
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("resources/i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        //messageSource.setFallbackToSystemLocale(false);
        //messageSource.setCacheSeconds(3600); //Refresh cache once per hour  
        return messageSource;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    

    //Static resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
	    	.addResourceHandler("/static/**")
	    	.addResourceLocations("resources/static/");  
                     
        registry
	    	.addResourceHandler("/resources/**")
	    	.addResourceLocations("resources/");  
      
	}
    
    //Error pages
	
	//FIXME: configure
//    @Bean
//    public ConfigurableServletWebServerFactory containerCustomizer() {
//        return new ConfigurableServletWebServerFactory() {
//            public void customize(ConfigurableServletWebServerFactory container) {
//            	
//            	container.setPort(8443);
//            	container.setSessionTimeout(30, TimeUnit.MINUTES);
//     
//            	ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/400");
//                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401"); ///resources/static/404.html
//                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
//                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
//     
//                container.addErrorPages(error400Page, error401Page, error404Page, error500Page);
//            }
//
//        };
//  
//    }
    
	@Bean
	  public ConfigurableServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
	        @Override
	        protected void postProcessContext(Context context) {
	          SecurityConstraint securityConstraint = new SecurityConstraint();
	          securityConstraint.setUserConstraint("CONFIDENTIAL");
	          SecurityCollection collection = new SecurityCollection();
	          collection.addPattern("/*");
	          securityConstraint.addCollection(collection);
	          context.addConstraint(securityConstraint);
	        }
	      };
	    
	    tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
	    return tomcat;
	  }
	  
	  private Connector initiateHttpConnector() {
	    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	    connector.setScheme("http");
	    connector.setPort(8080);
	    connector.setSecure(false);
	    connector.setRedirectPort(8443);
	    
	    return connector;
	  }

}
