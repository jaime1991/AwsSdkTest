package curso.aws.tutorial.infrestructure.repository;

import curso.aws.tutorial.domain.model.repository.PersonRepository;
import curso.aws.tutorial.domain.model.valueobjects.Person;
import curso.aws.tutorial.infrestructure.repository.dao.PersonDao;
import curso.aws.tutorial.infrestructure.repository.mapper.MapperFactory;
import curso.aws.tutorial.infrestructure.repository.mapper.PersonMapperDao;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Objects;

public class PersonRepositoryImpl implements PersonRepository {

    private DynamoDbEnhancedAsyncClient dynamoDbAsyncClient;
    private PersonMapperDao mapperDao;
    private String tableName;

    public PersonRepositoryImpl(DynamoDbEnhancedAsyncClient dynamoDbAsyncClient, String tableName) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
        this.tableName = tableName;
        this.mapperDao = MapperFactory.PERSONA_MAPPER_DAO;
    }

    @Override
    public Mono<Person> getPersonById(String id) {
        return Mono.fromFuture(dynamoDbAsyncClient.table(tableName, TableSchema.fromBean(PersonDao.class))
                .getItem(r -> r.key(Key.builder()
                        .partitionValue(id)
                        .build()
                )).thenApply(asyncResult -> Objects.nonNull(asyncResult)
                        ? mapperDao.map(asyncResult)
                        : null));
    }

    @Override
    public curso.aws.tutorial.domain.model.valueobjects.Person savePerson(curso.aws.tutorial.domain.model.valueobjects.Person person) {
        PersonDao personDao = mapperDao.map(person);
        //dynamoDbAsyncClient.save(personDao);
        return mapperDao.map(personDao);
    }
}
