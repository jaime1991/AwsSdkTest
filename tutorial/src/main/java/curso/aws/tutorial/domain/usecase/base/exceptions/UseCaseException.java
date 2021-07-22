package curso.aws.tutorial.domain.usecase.base.exceptions;

public class UseCaseException extends  RuntimeException {

    public  UseCaseException(String message){
        super(message);
    }

}
