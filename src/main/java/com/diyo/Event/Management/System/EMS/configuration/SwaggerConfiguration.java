package com.diyo.Event.Management.System.EMS.configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI().info(new Info().title("Event Management System").version("1.0.0"));
    }
    @Bean
    public GroupedOpenApi httpApi(){
        return GroupedOpenApi.builder().group("http").pathsToMatch("/**").build();
    }

}
