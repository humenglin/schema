package com.thoughtworks.basic.schema;

public interface FlagSchema {

    String getFlag();

    ValueType getValueType();

    Object getDefaultValue();

    Object parseValue(String value);
}
