package curso.aws.tutorial.domain.usecase.usecasebase;

import curso.aws.tutorial.domain.model.service.MessageManagerService;
import curso.aws.tutorial.domain.usecase.base.UseCase;
import curso.aws.tutorial.domain.usecase.base.applicationevents.Message;

import java.util.UUID;

public class SqsUseCase extends UseCase<String> {

    private MessageManagerService messageManagerService;

    public SqsUseCase(MessageManagerService messageManagerService) {
        this.messageManagerService = messageManagerService;
    }

    public String executeLogicSendEvent(String content) {
      return null;
        /*
        return executeUseCase(() -> messageManagerService.sendMessage(buildMessage(content))
                ? "The message was send"
                : "Was not possible send the message", " send message ");
    */
    }


    private Message buildMessage(String content){
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setContent(content);
        return message;
    }
}
