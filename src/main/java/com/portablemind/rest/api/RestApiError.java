package com.portablemind.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.client.HttpStatusCodeException;
import util.JacksonUtils;

import java.util.UUID;

/**
 * Created by Mateusz on 30.09.2015.
 */
/**
 * This represents a standard REST api error.
 *
 * See http://blog.apigee.com/detail/restful_api_design_what_about_errors/ for the rationale behind this class.
 *
 * @author Adib Saikali
 *
 */
public class RestApiError
{
    private final int httpStatus;
    private UUID apiCode;
    private String userMessage;
    private String developerMessage;

    @JsonCreator
    public RestApiError(@JsonProperty("httpStatus") RestApiHttpStatus httpStatus)
    {
        this.httpStatus = httpStatus.getStatusCode();
    }

    public static RestApiError fromHttpStatusCodeException(HttpStatusCodeException e)
    {
        String responseBody = e.getResponseBodyAsString();
        return JacksonUtils.fromJSON(responseBody, RestApiError.class);
    }

    @Override
    public String toString()
    {
        return JacksonUtils.toJSON(this);
    }

    public int getHttpStatus()
    {
        return httpStatus;
    }

    public UUID getApiCode()
    {
        return apiCode;
    }

    public RestApiError setApiCode(UUID apiCode)
    {
        this.apiCode = apiCode;
        return this;
    }

    public String getUserMessage()
    {
        return userMessage;
    }

    public RestApiError setUserMessage(String userMessage)
    {
        this.userMessage = userMessage;
        return this;
    }

    public String getDeveloperMessage()
    {
        return developerMessage;
    }

    public RestApiError setDeveloperMessage(String developerMessage)
    {
        this.developerMessage = developerMessage;
        return this;
    }
}
