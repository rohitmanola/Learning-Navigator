package com.crio.learningnavigator.exception;

import java.time.LocalDateTime;

public class ResourceNotFoundException extends RuntimeException
{
    private final LocalDateTime timestamp;
    private final long studentId;
    private final ErrorCode errorCode;

    public ResourceNotFoundException(ErrorCode errorCode, long studentId) {
        super(errorCode.getMessage(studentId));
        this.timestamp = LocalDateTime.now();
        this.studentId = studentId;
        this.errorCode = errorCode;
    }

}