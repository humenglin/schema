package com.thoughtworks.basic.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> argPairItems = new ArrayList<>(argPairList).stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<String> argValue = new ArrayList<>(argPairItems.subList(1, argPairItems.size()));
        if (isArgValid(argValue)) {
            this.flag = argPairItems.get(0);
            this.value = argValue.size() == 1 ? argPairItems.get(1) : flagSchema.getDefaultValue().toString();
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
