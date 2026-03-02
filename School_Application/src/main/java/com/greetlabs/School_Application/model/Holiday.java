package com.greetlabs.School_Application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.lang.reflect.Type;

@Data
public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FESTIVAL,FEDERAL
    }

    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public String getReason() {
        return reason;
    }

    public Type getType() {
        return type;
    }


}
