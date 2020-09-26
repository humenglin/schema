package com.thoughtworks.basic.schema;

import java.util.List;

public class Schema {
    private List<FlagSchema> flagSchemas;

    public Schema(List<FlagSchema> flagSchemas) {
        this.flagSchemas = flagSchemas;
    }

    public List<FlagSchema> getFlagSchemas() {
        return flagSchemas;
    }
}
