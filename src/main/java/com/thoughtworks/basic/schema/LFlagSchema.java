package com.thoughtworks.basic.schema;

public class LFlagSchema implements FlagSchema {
    private final String flag = CONSTANTS.FLAG_L;
    private final ValueType valueType = ValueType.BOOLEAN;

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
        return Boolean.valueOf(value);
    }
}
