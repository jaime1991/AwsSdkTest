package curso.aws.tutorial.application.dependencies;

import curso.aws.tutorial.domain.model.repository.PersonRepository;
import curso.aws.tutorial.domain.usecase.commandhandlers.DynamoCommandHandler;
import curso.aws.tutorial.domain.usecase.commandhandlers.SqsCommandHandler;
import curso.aws.tutorial.domain.usecase.usecasebase.DynamoUseCase;
import curso.aws.tutorial.domain.usecase.usecasebase.SqsUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public DynamoUseCase dynamoUseCase(@Qualifier("personRepository") PersonRepository personRepository) {
        return new DynamoUseCase(personRepository);
    }

    @Bean
    public DynamoCommandHandler dynamoCommandHandler(@Qualifier("dynamoUseCase") DynamoUseCase useCase) {
        return new DynamoCommandHandler(useCase);
    }

    @Bean
    public SqsUseCase sqsUseCase() {
        //@Qualifier("messageManagerService") MessageManagerService messageManagerService
        return new SqsUseCase(null);
    }

    @Bean
    public SqsCommandHandler sqsCommandHandler(@Qualifier("sqsUseCase") SqsUseCase useCase){
        return new SqsCommandHandler(useCase);
    }

}