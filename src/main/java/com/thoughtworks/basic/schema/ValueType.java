package com.thoughtworks.basic.schema;

public enum ValueType {
    BOOLEAN(false),
    INTEGER(0),
    STRING("");

    private Object defaultValue;

    ValueType(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }
}
