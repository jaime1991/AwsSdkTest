package curso.aws.tutorial.domain.usecase.commandhandlers;

import curso.aws.tutorial.domain.model.valueobjects.Person;
import curso.aws.tutorial.domain.usecase.base.Handler;
import curso.aws.tutorial.domain.usecase.usecasebase.DynamoUseCase;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class DynamoCommandHandler extends Handler<Mono<Person>> {

    private DynamoUseCase dynamoUseCase;

    public DynamoCommandHandler(DynamoUseCase dynamoUseCase) {
        this.dynamoUseCase = dynamoUseCase;
    }

    public Mono<ServerResponse> getPerson(ServerRequest serverRequest) {
        return executeLogic(() -> {
            String id = serverRequest.pathVariable("id");
            return dynamoUseCase.executeLogicGetPerson(id);
        }, " get Person by id");
    }

    public Mono<ServerResponse> savePerson(ServerRequest serverRequest) {
        Mono<Person> personMono = serverRequest.bodyToMono(Person.class);
        return personMono.flatMap(person -> ServerResponse.ok()
                .body(Mono.just(dynamoUseCase.executeLogicSavePerson(person)), Person.class));
    }
}
