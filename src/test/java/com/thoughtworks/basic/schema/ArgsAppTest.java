package com.thoughtworks.basic.schema;

import com.thoughtworks.basic.schema.exception.NoSuchFlagException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArgsAppTest {
    @Test
    public void should_return_default_value_when_init_ArgsApp() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        Object lValue = argsApp.getValueOf("l");
        Object pValue = argsApp.getValueOf("p");
        Object dValue = argsApp.getValueOf("d");

        Assert.assertEquals(false, lValue);
        Assert.assertEquals(0, pValue);
        Assert.assertEquals("", dValue);
    }

    @Test(expected = NoSuchFlagException.class)
    public void should_throw_no_such_flag_exception_given_a_error_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        argsApp.getValueOf("q");
    }
}
