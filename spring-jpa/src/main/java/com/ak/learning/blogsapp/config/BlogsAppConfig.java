package com.ak.learning.blogsapp.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableWebMvc
@ComponentScan("com.ak.learning.blogsapp")
public class BlogsAppConfig extends WebMvcConfigurerAdapter {

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    Optional<HttpMessageConverter<?>> converterFound =
        converters.stream().filter( c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();

    if (converterFound.isPresent()) {
      AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) converterFound.get();
      converter.getObjectMapper()
          .enable(SerializationFeature.INDENT_OUTPUT)
          .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    } else {
      super.extendMessageConverters(converters);
    }
  }

  /**
   * By default spring treats anything after a dot (in the URL) as an extension.
   * This method tells Spring to take the full path to include anything after
   * the dot as well. We need this to enable findByEmail use case
   * @param configurer
   */
  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.setUseSuffixPatternMatch(false);
  }
}
