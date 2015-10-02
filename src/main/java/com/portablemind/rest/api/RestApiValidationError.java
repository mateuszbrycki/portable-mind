package com.portablemind.rest.api;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class RestApiValidationError
{
    private String fieldName;
    private String message;

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}