package curso.aws.tutorial.domain.usecase.usecasebase;

import curso.aws.tutorial.domain.model.repository.PersonRepository;
import curso.aws.tutorial.domain.model.valueobjects.Person;
import curso.aws.tutorial.domain.usecase.base.UseCase;
import reactor.core.publisher.Mono;

public class DynamoUseCase extends UseCase<Person> {

    private PersonRepository personRepository;

    public DynamoUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<Person> executeLogicGetPerson(String id) {
        return executeUseCase(() -> personRepository.getPersonById(id)," get Person Use Case with id " + id);
    }

    public Person executeLogicSavePerson(Person person) {
        //return executeUseCase(() -> personRepository.savePerson(person)," save Person Use Case with name " + person.getName());
        return null;
    }
}
