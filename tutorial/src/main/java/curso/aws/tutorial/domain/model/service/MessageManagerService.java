package curso.aws.tutorial.domain.model.service;

import curso.aws.tutorial.domain.usecase.base.applicationevents.Message;

public interface MessageManagerService {

    boolean sendMessage(Message message);

}
