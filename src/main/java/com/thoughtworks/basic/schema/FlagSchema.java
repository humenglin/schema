package com.thoughtworks.basic.schema;

public abstract class FlagSchema {

    public abstract String getFlag();

    public abstract ValueType getValueType();

    public abstract Object getDefaultValue();

    public abstract Object parseValue(String value);
}
