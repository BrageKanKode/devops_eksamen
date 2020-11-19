package com.example.devops_eksamen

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@SpringBootApplication
class Application{

    @Bean
    fun swaggerApi(): Docket {
        return Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("API for Cards-Collections")
                .description("REST service to handle the card collections owned by users")
                .version("1.0")
                .build()
    }
}


fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
