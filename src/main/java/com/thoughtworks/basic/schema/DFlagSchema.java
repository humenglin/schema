package com.thoughtworks.basic.schema;

public class DFlagSchema implements FlagSchema {
    private final String flag = CONSTANTS.FLAG_D;
    private final ValueType valueType = ValueType.STRING;

    @Override
    public String getFlag() {
        return this.flag;
    }

    @Override
    public ValueType getValueType() {
        return this.valueType;
    }

    @Override
    public Object getDefaultValue() {
        return valueType.getDefaultValue();
    }

    @Override
    public Object parseValue(String value) {
        return value;
    }
}
