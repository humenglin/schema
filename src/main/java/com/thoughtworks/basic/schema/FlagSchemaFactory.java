package com.thoughtworks.basic.schema;

import com.thoughtworks.basic.schema.exception.NoSuchFlagException;

public class FlagSchemaFactory {

    public static FlagSchema getOf(String flag) {
        if (CONSTANTS.FLAG_L.equals(flag)) {
            return new LFlagSchema();
        } else if (CONSTANTS.FLAG_P.equals(flag)) {
            return new PFlagSchema();
        } else if (CONSTANTS.FLAG_D.equals(flag)) {
            return new DFlagSchema();
        }
        throw new NoSuchFlagException();
    }
}
