/*package spring.boot.hello_world;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {WebClientAutoConfiguration.class})
public class Application2 extends AbstractApplication{
    public static void main(String[] args) {
//        new SpringApplicationBuilder(Application2.class,"--server.port=1991").bannerMode(Banner.Mode.CONSOLE).run(args);
        SpringApplication.run(Application2.class, "--server.port=1991");
    }

    @Bean
    @Override
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        // Connector监听的http的端口号
        connector.setPort(8081);
        connector.setSecure(false);
        // 监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(1991);
        return connector;
    }
}
*/