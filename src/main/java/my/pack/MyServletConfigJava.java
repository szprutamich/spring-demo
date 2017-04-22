package my.pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@ComponentScan(useDefaultFilters = false,
        basePackages = {"my.pack"},
        includeFilters = @ComponentScan.Filter(Controller.class))
@Conditional(JavaConfiguration.class)
public class MyServletConfigJava extends WebMvcConfigurationSupport {

    @PostConstruct
    private void post() {
        System.out.println("MyServlerConfigJava");
    }

    @Bean
    public MyInterceptor apiV2AliasesInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.APPLICATION_XML)
                .favorPathExtension(false)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useJaf(false)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        addDefaultHttpMessageConverters(converters);
        converters.add(new MyMessageConverter());
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiV2AliasesInterceptor()).addPathPatterns("/api/**");
    }
}
