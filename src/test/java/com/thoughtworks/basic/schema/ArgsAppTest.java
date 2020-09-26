package com.thoughtworks.basic.schema;

import com.thoughtworks.basic.schema.exception.IllegalArgException;
import com.thoughtworks.basic.schema.exception.NoSuchFlagException;
import com.thoughtworks.basic.schema.exception.RepeatFlagException;
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

    @Test
    public void should_return_flag_value_when_parse_args_given_a_args_app() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = "-l true -p 8080 -d /usr/logs";
        argsApp.parse(args);

        Object lValue = argsApp.getValueOf("l");
        Object pValue = argsApp.getValueOf("p");
        Object dValue = argsApp.getValueOf("d");

        Assert.assertEquals(true, lValue);
        Assert.assertEquals(8080, pValue);
        Assert.assertEquals("/usr/logs", dValue);
    }

    @Test
    public void should_return_flag_value_when_parse_args_given_a_args_app_and_only_l_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = " -l  true    ";
        argsApp.parse(args);

        Object lValue = argsApp.getValueOf("l");
        Object pValue = argsApp.getValueOf("p");
        Object dValue = argsApp.getValueOf("d");

        Assert.assertEquals(true, lValue);
        Assert.assertEquals(0, pValue);
        Assert.assertEquals("", dValue);
    }

    @Test
    public void should_return_flag_value_when_parse_args_given_a_args_app_and_only_p_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = " -p   8080   ";
        argsApp.parse(args);

        Object lValue = argsApp.getValueOf("l");
        Object pValue = argsApp.getValueOf("p");
        Object dValue = argsApp.getValueOf("d");

        Assert.assertEquals(false, lValue);
        Assert.assertEquals(8080, pValue);
        Assert.assertEquals("", dValue);
    }

    @Test
    public void should_return_flag_value_when_parse_args_given_a_args_app_and_only_d_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = "  -d   /usr/logs  ";
        argsApp.parse(args);

        Object lValue = argsApp.getValueOf("l");
        Object pValue = argsApp.getValueOf("p");
        Object dValue = argsApp.getValueOf("d");

        Assert.assertEquals(false, lValue);
        Assert.assertEquals(0, pValue);
        Assert.assertEquals("/usr/logs", dValue);
    }

    @Test
    public void should_return_flag_value_when_parse_args_given_a_args_app_and_only_has_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = "-l -p  -d ";
        argsApp.parse(args);

        Object lValue = argsApp.getValueOf("l");
        Object pValue = argsApp.getValueOf("p");
        Object dValue = argsApp.getValueOf("d");

        Assert.assertEquals(false, lValue);
        Assert.assertEquals(0, pValue);
        Assert.assertEquals("", dValue);
    }

    @Test(expected = RepeatFlagException.class)
    public void should_throw_repeat_flag_exception_when_parse_args_given_a_args_app_and_only_has_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = "-l -l true -p 8080 -d /usr/logs";
        argsApp.parse(args);
    }

    @Test(expected = NoSuchFlagException.class)
    public void should_throw_no_such_flag_exception_when_parse_args_given_a_args_app_and_error_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = "-l-p true -p 8080 -d /usr/logs";
        argsApp.parse(args);
    }

    @Test(expected = NoSuchFlagException.class)
    public void should_throw_no_such_flag_exception_when_parse_args_given_a_args_app_and_no_flag() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = "- true";
        argsApp.parse(args);
    }

    @Test(expected = IllegalArgException.class)
    public void should_throw_Illegal_Arg_exception_when_parse_args_given_a_args_app_and_error_value() {
        Schema schema = new Schema(Arrays.asList(new LFlagSchema(), new PFlagSchema(), new DFlagSchema()));
        ArgsApp argsApp = new ArgsApp(schema);

        String args = "-l tr ue";
        argsApp.parse(args);
    }
}
