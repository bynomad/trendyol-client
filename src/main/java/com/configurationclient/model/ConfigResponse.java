package com.configurationclient.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class ConfigResponse implements Serializable {

    private UUID id;
    private String applicationName;
    private String name;
    private String type;
    private String value;
    private byte isActive;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }


    public <T> T getValueAs(Class<T> clazz) {
        if (getValue() == null || getType() == null) return null;

        if (clazz.isInstance(Boolean.class)) {
            System.out.println("Booleannn");
            return (T) Boolean.valueOf(getValue());
        } else if (clazz.isInstance(String.class)) {
            System.out.println("String");
            return (T) getValue();
        } else if (clazz.isInstance(Integer.class)) {
            System.out.println("Integer");
            return (T) Integer.valueOf(getValue());
        } else if (clazz.isInstance(BigDecimal.class)) {
            System.out.println("BigDecimal");
            return (T) Double.valueOf(getValue());
        }

        return (T) getValue();
    }
}
