package com.microservices.currencyconversionservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Slf4j
@Configuration
@EnableWebFlux
@ComponentScan({"com.microservices.currencyconversionservice"})
@EnableAutoConfiguration(exclude = WebMvcAutoConfiguration.class)
public class CurrencyConversionRouter {

    /*@Bean
    public RouterFunction<?> routerFunction(final CurrencyConversionHandler handler) {

        return RouterFunctions.route(RequestPredicates.GET("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}"), handler::calculateCurrencyConversionFeign);
    }*/
}
