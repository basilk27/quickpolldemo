package com.mbsystems.quickpolldemo.entities;

public enum Admin {
    YES("yes"),
    NO("no");

    private String type;

    private Admin( String type ) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
