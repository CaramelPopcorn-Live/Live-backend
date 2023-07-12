package com.live.livebackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Live Rest Api Document",
                description = "API Document",
                version = "v1.0.0",
                license = @License(
                        name = "Apache License Version 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        tags = {
                @Tag(name = "User", description = "사용자 기능"),
                @Tag(name = "Admin", description = "관리자 태그")
        }
)
@Configuration
public class SpringDocConfig {
}
