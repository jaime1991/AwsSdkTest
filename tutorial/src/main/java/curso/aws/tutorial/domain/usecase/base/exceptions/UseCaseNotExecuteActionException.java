package curso.aws.tutorial.domain.usecase.base.exceptions;

public class UseCaseNotExecuteActionException extends RuntimeException {


    public UseCaseNotExecuteActionException(String message){
        super(message);
    }
}
