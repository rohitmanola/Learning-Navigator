package com.crio.learningnavigator.exception;

public enum ErrorCode
{
    STUDENT_NOT_FOUND("Student not found."),
    EXAM_NOT_FOUND("Exam not found."),
    INVALID_SCORE("Invalid score for user with ID '%s'."),
    SUBJECT_NOT_FOUND("Subject not found"),
    STUDENT_NOT_ENROLL("Student must enroll in the subject before registering for the exam");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(long userId) {
        return String.format(message, userId);
    }
}