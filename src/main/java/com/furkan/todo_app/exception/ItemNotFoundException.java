package com.furkan.todo_app.exception;

public class ItemNotFoundException extends Throwable {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
