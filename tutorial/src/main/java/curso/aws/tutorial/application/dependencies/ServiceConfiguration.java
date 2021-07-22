package curso.aws.tutorial.application.dependencies;
/*
import curso.aws.tutorial.domain.model.service.MessageManagerService;
import curso.aws.tutorial.infrestructure.service.MessageManagerServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public MessageManagerService messageManagerService(@Value("${aws.config.sqsQueue}") String queue,
                                                       @Qualifier("queueMessagingTemplate") QueueMessagingTemplate queueMessagingTemplate) {
        return new MessageManagerServiceImpl(queue, queueMessagingTemplate);
    }

}

 */
