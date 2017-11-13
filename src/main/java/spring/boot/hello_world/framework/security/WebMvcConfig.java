package spring.boot.hello_world.framework.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		logger.info("开始执行mvcConfig");
        registry.addViewController("/login").setViewName("login");
    }

}
