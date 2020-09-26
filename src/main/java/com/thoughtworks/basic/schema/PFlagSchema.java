package com.thoughtworks.basic.schema;

public class PFlagSchema implements FlagSchema {
    private final String flag = CONSTANTS.FLAG_P;
    private final ValueType valueType = ValueType.INTEGER;

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
        return Integer.parseInt(value);
    }
}
