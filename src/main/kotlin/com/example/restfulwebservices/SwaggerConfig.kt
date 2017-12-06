package com.example.restfulwebservices

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.VendorExtension
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.ArrayList

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
    }

    companion object {
        val DEFAULT_CONTACT = Contact(
                "NEEL Erwan",
                "http://www.neelerwan.fr",
                "erwan.neel@orange.com"
        )
        val DEFAULT_API_INFO = ApiInfo(
                "Awesome API Title",
                "Awesome API Documentation",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                ArrayList()
        )
        val DEFAULT_PRODUCES_AND_CONSUMES = mutableSetOf("application/json")
    }
}