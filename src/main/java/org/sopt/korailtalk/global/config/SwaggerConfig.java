package org.sopt.korailtalk.global.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${app.server.url}")
	private String serverUrl;

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.addServersItem(new Server().url(serverUrl))
			.info(apiInfo());
	}

	@Bean
	public GroupedOpenApi v1Api() {
		return GroupedOpenApi.builder()
			.group("v1")
			.pathsToMatch("/api/v1/**")
			.pathsToExclude("/api/v1/admin/**")
			.build();
	}

	@Bean
	public GroupedOpenApi adminApi() {
		return GroupedOpenApi.builder()
			.group("admin")
			.pathsToMatch("/api/v1/admin/**")
			.build();
	}

	private Info apiInfo() {
		return new Info()
			.title("DIVE SOPT Colab KorailTalk API")
			.description("DIVE SOPT 합동세미나 코레일톡 팀 API")
			.version("1.0.0");

	}
}
