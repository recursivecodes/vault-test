package controller;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.env.Environment;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import vault.test.Config;

@Controller("/hello")
public class HelloController {

    private String secretOne;
    private String foo;
    private String valueSecretOne;
    private String dbPassword;
    private Environment environment;
    private Config config;

    public HelloController(
            @Property(name = "secrets.one") String secretOne,
            @Property(name = "SECRET_ONE") String foo,
            @Property(name = "datasources.default.password") String dbPassword,
            @Value("${SECRET_TWO}") String valueSecretOne,
            Config config,
            Environment environment
    ) {
        this.secretOne = secretOne;
        this.foo = foo;
        this.valueSecretOne = valueSecretOne;
        this.dbPassword = dbPassword;
        this.environment = environment;
        this.config = config;
    }

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Get("/secret")
    public HttpResponse getSecret() {
        return HttpResponse.ok(
            CollectionUtils.mapOf(
                    "1",
                    secretOne,
                    "foo",
                    foo,
                    "secret two using @Value",
                    valueSecretOne,
                    "2",
                    config.getTwo(),
                    "3",
                    config.isThree(),
                    "4",
                    config.getFour(),
                    "5",
                    config.getFive()
            )
        );
    }
}