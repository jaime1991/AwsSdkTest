package curso.aws.tutorial.application.dependencies;
/*
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver;

import java.util.Collections;

@Configuration
public class SqsConfiguration {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync( @Value("${aws.config.region}") String region,
                                          @Value("${aws.config.accesskey}") String accesskey,
                                          @Value("${aws.config.secretkey}") String secretkey) {
        return AmazonSQSAsyncClientBuilder.standard().withRegion(region)
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey, secretkey)))
                .build();
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(@Qualifier("amazonSQSAsync") final AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

    //configuration for simple messages
    @Bean
    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(AmazonSQSAsync amazonSqs) {
        SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
        factory.setAmazonSqs(amazonSqs);
        factory.setAutoStartup(true);
        factory.setMaxNumberOfMessages(5);
        factory.setWaitTimeOut(10);
        return factory;
    }

    /* Configuration for AWS Event messages
    public QueueMessageHandlerFactory queueMessageHandlerFactory(@Qualifier("objectMapper") final ObjectMapper mapper, @Qualifier("amazonSQSAsync") final AmazonSQSAsync amazonSQSAsync){
        SimpleMessageListenerContainerFactory
        final QueueMessageHandlerFactory queueHandlerFactory =
                new QueueMessageHandlerFactory();
        queueHandlerFactory.setAmazonSqs(amazonSQSAsync);
        queueHandlerFactory.setArgumentResolvers(Collections.singletonList(
                new PayloadMethodArgumentResolver(jackson2MessageConverter(mapper))
        ));
        return queueHandlerFactory;
    }

    private MessageConverter jackson2MessageConverter(final ObjectMapper mapper){
        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(mapper);
        return converter;
    }

}
*/
