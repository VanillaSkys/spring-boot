package com.example.demo.exception;

public class UserException extends BaseException {
    public UserException(String code) {
        super("user." + code);
    }

    public static UserException usernameIsNull() {
        return new UserException("username.null");
    }

    public static UserException passwordIsNull() {
        return new UserException("password.null");
    }

    public static UserException usernameIsEmpty() {
        return new UserException("username.empty");
    }

    public static UserException passwordIsEmpty() {
        return new UserException("password.empty");
    }

    public static UserException usernameIsExists() {
        return new UserException("username.exists");
    }

    public static UserException usernameNotFound() {
        return new UserException("username.not_found");
    }

    public static UserException usernameOrPasswordIncorrect() {
        return new UserException("username_or_password.incorrect");
    }
}
