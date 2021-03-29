package app.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralBeans {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
