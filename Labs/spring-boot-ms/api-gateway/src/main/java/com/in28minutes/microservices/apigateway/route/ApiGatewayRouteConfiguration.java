package com.in28minutes.microservices.apigateway.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayRouteConfiguration {

    private Logger logger = LoggerFactory.getLogger(ApiGatewayRouteConfiguration.class);

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locator) {
        logger.info("inside custom routing api gateway...");
        return locator.routes()
                .route(predicateSpec -> predicateSpec.path("/get").uri("http://httpbing.org:80"))
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**")
                        .filters(f -> f.addRequestHeader("Myheader", "durga"))
                        .uri("lb://CURRENCY-EXCHANGE"))//name registered with eureka
                .route(predicateSpec -> predicateSpec.path("/currency-conversion/**").uri("lb://CURRENCY-CONVERSION"))
                .route(predicateSpec -> predicateSpec.path("/currency-conversion-feign/**").uri("lb://CURRENCY-CONVERSION"))
                .build();
    }
}
