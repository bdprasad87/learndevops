package com.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public Mono<CurrencyExchange> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        logger.info("retrieveExchangeValue called with {} to {}", from, to);

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if (currencyExchange == null) {
            throw new RuntimeException("Unable to Find data for " + from + " to " + to);
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return Mono.just(currencyExchange);
    }

    @GetMapping("/currency-exchange/webflux/mono")
    public Mono<String> mono() {
        Mono<String> mono = Mono.just("mono data");
        Mono<String> mono1 = Mono.empty();
        return mono;
    }

    @GetMapping("/currency-exchange/webflux/flux")
    public Flux<String> flux() {
        Flux<String> flux1 = Flux.just("D", "U", "R", "G", "A");
        Flux<String> flux2 = Flux.fromArray(new String[]{"A", "B", "C"});
        Flux<String> flux3 = Flux.fromIterable(Arrays.asList("D", "U", "R", "G", "A"));
        flux1.subscribe();
        return flux1.delayElements(Duration.ofSeconds(1)).log();
    }
}