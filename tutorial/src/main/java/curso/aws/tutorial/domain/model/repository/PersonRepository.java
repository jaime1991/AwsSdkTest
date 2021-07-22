package curso.aws.tutorial.domain.model.repository;

import curso.aws.tutorial.domain.model.valueobjects.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Person> getPersonById(String id);

    Person savePerson(Person id);

}
