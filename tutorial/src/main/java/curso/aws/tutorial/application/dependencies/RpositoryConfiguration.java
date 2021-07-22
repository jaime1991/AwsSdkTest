package curso.aws.tutorial.application.dependencies;


import curso.aws.tutorial.domain.model.repository.PersonRepository;
import curso.aws.tutorial.infrestructure.repository.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;


@Configuration
public class RpositoryConfiguration {

    @Bean
    public DynamoDbEnhancedAsyncClient dynamoDbAsyncClient(
            @Value("${aws.config.endpoint}") String endPoint,
            @Value("${aws.config.region}") String region,
            @Value("${aws.config.accesskey}") String accessKey,
            @Value("${aws.config.secretkey}") String secretkey
    ) {
        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(DynamoDbAsyncClient.builder()
                        .region(Region.of(region))
                        .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretkey)))
                        .build())
                .build();
    }

    @Bean
    public PersonRepository personRepository(@Qualifier("dynamoDbAsyncClient") DynamoDbEnhancedAsyncClient dynamoDBMapper) {
        return new PersonRepositoryImpl(dynamoDBMapper, "person");
    }

}