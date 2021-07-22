package curso.aws.tutorial.domain.model.service;

import curso.aws.tutorial.domain.model.valueobjects.FileModel;

public interface FileManagerService {

    boolean uploadFile(FileModel model);

}
