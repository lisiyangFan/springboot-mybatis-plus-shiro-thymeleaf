package com.example.mybatisplustest.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

  /**
   * 如果Spring Boot提供的Sping MVC不符合要求，则可以通过一个配置类（注解有@Configuration的类） 加上@EnableWebMvc注解来实现完全自己控制的MVC配置。
   * 当然，通常情况下，Spring Boot的自动配置是符合我们大多数需求的。在你既需要保留Spring Boot提供的便利， 有需要增加自己的额外的配置的时候，可以定义一个配置类并继承WebMvcConfigurerAdapter,无需使用@EnableWebMvc注解。
   * 这里我们提到这个WebMvcConfigurerAdapter这个类，重写这个类中的方法可以让我们增加额外的配置 自定义资源映射addResourceHandlers
   * 比如，我们想自定义静态资源映射目录的话，只需重写addResourceHandlers方法即可。 通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径。
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .paths(Predicates.not(PathSelectors.regex("/error"))).build();//暂时不知道error是啥玩意儿
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("这是文档标题").description("这是副标题  API文档").version("这里是版本1.0")
        .build();
  }
}

