package exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import java.util.Objects;

public class EntityErrorDetails {

    private String title;
    private HttpStatus status;
    private List<String> errors;
    private LocalDateTime date;

    public EntityErrorDetails(HttpStatus status, String title, List<String> errors) {
        this.title = title;
        this.status = status;
        this.errors = errors;
        this.date = LocalDateTime.now();
    }

    public EntityErrorDetails(HttpStatus status, String title, String error) {
        this.title = title;
        this.status = status;
        errors = Arrays.asList(error);
        this.date = LocalDateTime.now();
    }


    public EntityErrorDetails() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public EntityErrorDetails title(String title) {
        setTitle(title);
        return this;
    }

    public EntityErrorDetails status(HttpStatus status) {
        setStatus(status);
        return this;
    }

    public EntityErrorDetails errors(List<String> errors) {
        setErrors(errors);
        return this;
    }

    public EntityErrorDetails date(LocalDateTime date) {
        setDate(date);
        return this;
    }
}
