package com.blog_app.exception;

public class ResourceNotFoundException  extends  RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }

    public ResourceNotFoundException(){
        super("Resource Not Found");
    }
}
