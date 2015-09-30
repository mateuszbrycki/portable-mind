package com.portablemind.rest.api.exceptions;

import com.portablemind.rest.api.RestApiException;
import com.portablemind.rest.api.RestApiHttpStatus;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class ResourceNotFoundRestApiException extends RestApiException
{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundRestApiException()
    {
        super(RestApiHttpStatus.NOT_FOUND);
    }
}