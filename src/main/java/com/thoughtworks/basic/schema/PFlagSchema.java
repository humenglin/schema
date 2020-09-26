package com.thoughtworks.basic.schema;

public class PFlagSchema extends FlagSchema {
    private final String flag = CONSTANTS.FLAG_P;
    private final ValueType valueType = ValueType.INTEGER;

    public String getFlag() {
        return this.flag;
    }

    public ValueType getValueType() {
        return this.valueType;
    }
}
