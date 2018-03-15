package hello;

import java.util.List;

import io.crnk.core.engine.document.ErrorData;
import io.crnk.core.engine.error.ErrorResponse;
import io.crnk.core.engine.error.ExceptionMapper;
import io.crnk.core.repository.response.JsonApiResponse;
import org.springframework.stereotype.Component;

@Component
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    public static final int HTTP_ERROR_CODE = 400;

    @Override
    public ErrorResponse toErrorResponse(BadRequestException cve) {
        ErrorData error = ErrorData.builder().setDetail(cve.getMessage()).build();
        return ErrorResponse.builder().setStatus(HTTP_ERROR_CODE).setSingleErrorData(error).build();
    }

    @Override
    public BadRequestException fromErrorResponse(ErrorResponse errorResponse) {
        JsonApiResponse response = errorResponse.getResponse();
        List<ErrorData> errors = (List<ErrorData>) response.getEntity();
        StringBuilder message = new StringBuilder();
        for (ErrorData error : errors) {
            String title = error.getDetail();
            message.append(title);
        }
        return new BadRequestException(message.toString());
    }

    @Override
    public boolean accepts(ErrorResponse errorResponse) {
        return errorResponse.getHttpStatus() == HTTP_ERROR_CODE;
    }
}