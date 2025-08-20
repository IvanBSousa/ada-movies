package tech.ada.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import tech.ada.exception.TitleAlreadyExistsException;

@Provider
public class TitleAlreadyExistsHandler implements ExceptionMapper<TitleAlreadyExistsException> {

    @Override
    public Response toResponse(TitleAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}
