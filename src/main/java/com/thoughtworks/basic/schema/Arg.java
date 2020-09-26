package com.thoughtworks.basic.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arg {
    private String flag;
    private String value;
    private FlagSchema flagSchema;

    public Arg(String argPair, FlagSchema flagSchema) {
        this.flagSchema = flagSchema;
        parseValue(argPair);
    }

    private void parseValue(String argPair) {
        List<String> argPairList = Arrays.asList(argPair.trim().split(CONSTANTS.SPILT_FLAG_AND_VALUE));
        List<String> argValue = new ArrayList<>(argPairList.subList(1, argPairList.size()));
        if (isArgValid(argValue)) {
            this.flag = argPairList.get(0);
            this.value = argPairList.get(1);
        }
    }

    private boolean isArgValid(List<String> argValue) {
        if (argValue.size() > 1) {
            return false;
        }
        return true;
    }

    public String getFlag() {
        return flag;
    }

    public Object parseValue() {
        return flagSchema.parseValue(this.value);
    }
}
