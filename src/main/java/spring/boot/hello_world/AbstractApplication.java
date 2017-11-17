package spring.boot.hello_world;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

public abstract class AbstractApplication {
    /**
     * <p>配置重定向</p> 
     * @author ldg123456
     * @date 2017年11月15日 下午10:35:21
     * @return
     * @see
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(this.httpConnector());
        return tomcat;
    }

    @Bean
    public abstract Connector httpConnector();/* {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        // Connector监听的http的端口号
        connector.setPort(8080);
        connector.setSecure(false);
        // 监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(1990);
        return connector;
    }*/
}
