package com.github.kayllon.douglas.command.exception;

public class CommandException extends RuntimeException {

    public CommandException(final String message) {
        super(message);
    }

    public CommandException(final String message,
                            final Throwable cause) {
        super(message, cause);
    }

}
