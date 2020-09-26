package com.thoughtworks.basic.schema;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SchemaTest {
    @Test
    public void should_return_right_flag_schemas_given_init_schema() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));

        Assert.assertEquals(3, schema.getFlagSchemas().size());
        Assert.assertEquals(CONSTANTS.FLAG_L, schema.getFlagSchemas().get(0).getFlag());
        Assert.assertEquals(ValueType.BOOLEAN, schema.getFlagSchemas().get(0).getValueType());
        Assert.assertEquals(CONSTANTS.FLAG_P, schema.getFlagSchemas().get(1).getFlag());
        Assert.assertEquals(ValueType.INTEGER, schema.getFlagSchemas().get(1).getValueType());
        Assert.assertEquals(CONSTANTS.FLAG_D, schema.getFlagSchemas().get(2).getFlag());
        Assert.assertEquals(ValueType.STRING, schema.getFlagSchemas().get(2).getValueType());
    }
}
