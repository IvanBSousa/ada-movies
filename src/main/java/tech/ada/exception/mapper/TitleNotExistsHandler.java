package tech.ada.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import tech.ada.exception.TitleNotExistsException;

@Provider
public class TitleNotExistsHandler implements ExceptionMapper<TitleNotExistsException> {

    @Override
    public Response toResponse(TitleNotExistsException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }
}
