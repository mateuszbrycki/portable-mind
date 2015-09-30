package com.portablemind.rest.api;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class RestApiException extends RuntimeException {

    private final RestApiError restApiError;

    public RestApiException(RestApiError restApiError) {
        this.restApiError = restApiError;
    }

    public RestApiException(RestApiHttpStatus httpStatus)
    {
        this.restApiError = new RestApiError(httpStatus);
    }

    public RestApiException userMessage(String userMessage)
    {
        this.restApiError.setUserMessage(userMessage);
        return this;
    }

    public RestApiError getRestApiError() {
        return restApiError ;
    }

}
