package curso.aws.tutorial.domain.usecase.commandhandlers;

import curso.aws.tutorial.domain.usecase.base.Handler;
import curso.aws.tutorial.domain.usecase.usecasebase.SqsUseCase;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class SqsCommandHandler extends Handler<String> {

    private SqsUseCase sqsUseCase;

    public SqsCommandHandler(SqsUseCase sqsUseCase) {
        this.sqsUseCase = sqsUseCase;
    }

    public Mono<ServerResponse> sendMessage(ServerRequest serverRequest) {
        Mono<String> rawMessage = serverRequest.bodyToMono(String.class);
        return rawMessage.flatMap(message -> ServerResponse.ok()
                .body(Mono.just(sqsUseCase.executeLogicSendEvent(message)), String.class));
    }

}
