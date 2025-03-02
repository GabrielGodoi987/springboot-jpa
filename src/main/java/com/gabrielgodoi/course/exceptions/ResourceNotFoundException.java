package com.gabrielgodoi.course.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not founded: id: " + id);
    }
}
