package com.thoughtworks.basic.schema;

public class DFlagSchema extends FlagSchema {
    private final String flag = CONSTANTS.FLAG_D;
    private final ValueType valueType = ValueType.STRING;

    public String getFlag() {
        return this.flag;
    }

    public ValueType getValueType() {
        return this.valueType;
    }
}
