package com.fiap.hackathon.usecase.misc.exception;

public class WorkingHourMessageListenerException extends DomainException {

    public WorkingHourMessageListenerException() {
        super("An exception was thrown during the execution of the SQS listener of Working Hour Queue and Message will be still available in Queue.");
    }
    public WorkingHourMessageListenerException(Throwable exception) {
        super("An exception was thrown during the execution of the SQS listener of Working Hour Queue and Message will be still available in Queue.", exception);
    }
}
