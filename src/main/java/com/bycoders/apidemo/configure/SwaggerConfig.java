package com.bycoders.apidemo.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo()
            );
  }

  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    return new WebMvcConfigurer()
    {
      @Override
      public void addResourceHandlers( ResourceHandlerRegistry registry )
      {
        registry.addResourceHandler( "swagger-ui.html" ).addResourceLocations( "classpath:/META-INF/resources/" );
        registry.addResourceHandler( "/webjars/**" ).addResourceLocations( "classpath:/META-INF/resources/webjars/" );
      }
    };
  }

  private ApiInfo apiInfo(){
    return new ApiInfo("API demonstração byCoders",
            "Est API é utilizada para simular o back-end de um app de importação de arquivos",
            "versao 1.0",
            "",
            new Contact("Deivide Duarte", "https://www.linkedin.com/in/deivideduarte/", "deivideduarte@outlook.com"),
            "Apenas para uso de demonstração",
            "",
            Collections.emptyList()
    );
  }

}
