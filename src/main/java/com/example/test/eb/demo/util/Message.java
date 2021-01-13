package com.example.test.eb.demo.util;

public class Message<T> {

    private boolean success;
    private String desc;
    private T data;

    public Message() {
    }

    public Message(boolean success, String desc, T data) {
        this.success = success;
        this.desc = desc;
        this.data = data;
    }

    public static <T> Message<T> fail(String message, T data) {
        return new Message<>(false, message, data);
    }

    public static <T> Message<T> fail(T data) {
        return new Message<>(false, null, data);
    }

    public static <T> Message<T> fail(String message) {
        return new Message<>(false, message, null);
    }

    public static <T> Message<T> success(String message, T data) {
        return new Message<>(true, message, data);
    }

    public static <T> Message<T> success(T data) {
        return new Message<>(true, null, data);
    }

    public static <T> Message<T> success(String message) {
        return new Message<>(true, message, null);
    }

    public boolean getSuccess() {
        return success;
    }

    public String getDesc() {
        return desc;
    }

    public T getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setData(T data) {
        this.data = data;
    }
}
