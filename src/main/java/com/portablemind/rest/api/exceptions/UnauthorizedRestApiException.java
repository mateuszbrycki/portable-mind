package com.portablemind.rest.api.exceptions;

import com.portablemind.rest.api.RestApiException;
import com.portablemind.rest.api.RestApiHttpStatus;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class UnauthorizedRestApiException extends RestApiException
{
    private static final long serialVersionUID = 1L;

    public UnauthorizedRestApiException()
    {
        super(RestApiHttpStatus.UNAUTHORIZED);
    }
}