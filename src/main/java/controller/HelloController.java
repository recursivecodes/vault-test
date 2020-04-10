package controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import vault.test.Config;

@Controller("/hello")
public class HelloController {

    private Config config;

    public HelloController(
            Config config
    ) {
        this.config = config;
    }

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Get("/secret")
    public HttpResponse getSecret() {
        return HttpResponse.ok(config);
    }
}