package com.thoughtworks.basic.schema;

public class Args {
    private Schema schema;

    public Args(Schema schema) {
        this.schema = schema;
    }

    public Object getValueOf(String flag) {
        return FlagSchemaFactory.getOf(flag).getDefaultValue();
    }
}
