package com.imemyself.course.exception;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public StandardError timestamp(Instant timestamp) {
        setTimestamp(timestamp);
        return this;
    }

    public StandardError status(Integer status) {
        setStatus(status);
        return this;
    }

    public StandardError error(String error) {
        setError(error);
        return this;
    }

    public StandardError message(String message) {
        setMessage(message);
        return this;
    }

    public StandardError path(String path) {
        setPath(path);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " timestamp='" + getTimestamp() + "'" +
                ", status='" + getStatus() + "'" +
                ", error='" + getError() + "'" +
                ", message='" + getMessage() + "'" +
                ", path='" + getPath() + "'" +
                "}";
    }

}
