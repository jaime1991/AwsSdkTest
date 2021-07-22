package curso.aws.tutorial.application.entrypoints;

import curso.aws.tutorial.domain.usecase.commandhandlers.DynamoCommandHandler;
import curso.aws.tutorial.domain.usecase.commandhandlers.S3CommandHandler;
import curso.aws.tutorial.domain.usecase.commandhandlers.SqsCommandHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> buildRouterFunction(@Qualifier("dynamoCommandHandler") DynamoCommandHandler dynamoCommandHandler,
                                                              @Qualifier("sqsCommandHandler") SqsCommandHandler sqsCommandHandler,
                                                              @Qualifier("s3CommandHandler") S3CommandHandler s3CommandHandler) {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/version"),
                        (serverRequest) -> ServerResponse.ok().body(Mono.just("0.0.1"), String.class)
                )
                .andRoute(
                        RequestPredicates.GET("/getPerson/{id}"),
                        dynamoCommandHandler::getPerson
                )
                .andRoute(
                        RequestPredicates.POST("/savePerson").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        dynamoCommandHandler::savePerson
                )
                .andRoute(
                        RequestPredicates.POST("/sendMessage"),
                        sqsCommandHandler::sendMessage
                )
                .andRoute(
                        RequestPredicates.POST("/sendMessage"),
                        sqsCommandHandler::sendMessage
                );
    }

}
