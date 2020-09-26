package com.thoughtworks.basic.schema;

public class LFlagSchema extends FlagSchema {
    private final String flag = CONSTANTS.FLAG_L;
    private final ValueType valueType = ValueType.BOOLEAN;

    public String getFlag() {
        return this.flag;
    }

    public ValueType getValueType() {
        return this.valueType;
    }

    public Object getDefaultValue() {
        return valueType.getDefaultValue();
    }
}
