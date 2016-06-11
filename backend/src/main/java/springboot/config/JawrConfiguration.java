package springboot.config;

import com.github.dtrunk90.thymeleaf.jawr.JawrDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by aurelijus on 16.6.11.
 */
@Configuration
public class JawrConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public JawrDialect jawrDialect(){
        return new JawrDialect();
    }

}
