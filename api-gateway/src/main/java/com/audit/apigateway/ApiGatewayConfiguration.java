package com.audit.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@CrossOrigin(origins = "*")
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator router(RouteLocatorBuilder builder) {

		return builder.routes()

				.route(p -> p.path("/audit-checklist/**").uri("lb://audit-checklist"))
				.route(p -> p.path("/audit-severity/**").uri("lb://audit-severity"))
				.route(p -> p.path("/**").uri("lb://auth-service"))

				.build();
	}

//	@Bean
//	public CorsWebFilter corsWebFilter() {
//		final CorsConfiguration corsConfig = new CorsConfiguration();
//		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
//		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST"));
//
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfig);
//		return new CorsWebFilter(source);
//	}
}
