package curso.aws.tutorial.domain.usecase.usecasebase;

import curso.aws.tutorial.domain.model.service.FileManagerService;
import curso.aws.tutorial.domain.usecase.base.UseCase;

public class s3UseCase extends UseCase<String> {

    private FileManagerService fileManagerService;

    public s3UseCase(FileManagerService fileManagerService) {
        this.fileManagerService = fileManagerService;
    }

    public boolean executeLogicUpload(){
        return true;
    }


}
