package app.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans {
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mm = new ModelMapper();
    mm.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    // Skip properties with null value
    mm.getConfiguration().setPropertyCondition(u -> u.getSource() != null);
    return mm;
  }
}
