package curso.aws.tutorial.infrestructure.service;

import curso.aws.tutorial.domain.model.service.MessageManagerService;
import curso.aws.tutorial.domain.usecase.base.applicationevents.Message;
//import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;

public class MessageManagerServiceImpl implements MessageManagerService {

    private String queue;
   // private QueueMessagingTemplate queueMessagingTemplate;
/*
    public MessageManagerServiceImpl(String queue, QueueMessagingTemplate queueMessagingTemplate) {
        this.queue = queue;
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

 */

    @Override
    public boolean sendMessage(Message message) {
        //queueMessagingTemplate.convertAndSend(queue, message);
        return true;
    }
}
