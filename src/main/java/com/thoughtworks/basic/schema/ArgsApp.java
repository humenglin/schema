package com.thoughtworks.basic.schema;

public class ArgsApp {
    private Schema schema;
    private Args args;

    public ArgsApp(Schema schema) {
        this.schema = schema;
        this.args = new Args(schema);
    }

    public Object getValueOf(String flag) {
        return args.getValueOf(flag);
    }

}
