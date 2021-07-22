package curso.aws.tutorial.domain.usecase.base;

import curso.aws.tutorial.domain.usecase.base.exceptions.UseCaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

public abstract class Handler<T> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Mono<ServerResponse> executeLogic(Supplier<T> function, String accion) {
        try {
            logger.info("Comienza ejecucion del caso  de uso para la accion: {}", accion);
            T result = function.get();
            logger.info("Finaliza ejecucion del caso  de uso para la accion: {}", accion);
            return ServerResponse.ok().body(result, result.getClass());
        } catch (RuntimeException ex) {
            String message = ex.getMessage();
            logger.error("Ha ocurrido un error inesperado ejecutando el caso de uso, para la accion: ".concat(accion) + ", error:" + message, ex);
            throw new UseCaseException("Ha ocurrido un error ejecutando el caso de uso error:".concat(message));
        }
    }
}
