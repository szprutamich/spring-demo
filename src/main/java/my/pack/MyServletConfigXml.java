package my.pack;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

@Configuration
@ImportResource("classpath:servlet.xml")
@Conditional(XmlConfiguration.class)
public class MyServletConfigXml extends WebMvcConfigurerAdapter {

    @PostConstruct
    private void post() {
        System.out.println("MyServlerConfigXml");
    }
}
