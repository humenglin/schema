package com.thoughtworks.basic.schema;

import com.thoughtworks.basic.schema.exception.NoSuchFlagException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private Schema schema;
    private String args;
    private List<Arg> argPairs = new ArrayList<>();

    public Args(Schema schema) {
        this.schema = schema;
    }

    public Args(String args, Schema schema) {
        this.args = args;
        this.schema = schema;
        parse(args);
    }

    private void parse(String args) {
        List<String> argItems = spiltToArgs(args);
        for (String argPair : argItems) {
            String flag = Arrays.asList(argPair.trim().split(CONSTANTS.SPILT_FLAG_AND_VALUE)).get(0);
            if (isStartWithFlag(flag) && isFlagDistinct(flag)) {
                argPairs.add(new Arg(argPair, FlagSchemaFactory.getOf(flag)));
            }
        }
    }

    private boolean isStartWithFlag(String flag) {
        boolean isStartWithFlag = true;
        try {
            FlagSchemaFactory.getOf(flag);
        } catch (NoSuchFlagException e) {
            isStartWithFlag = false;
        }
        return isStartWithFlag;

    }

    private boolean isFlagDistinct(String flag) {
        for (Arg arg: argPairs) {
            if (arg.getFlag().equals(flag)) {
                return false;
            }
        }
        return true;
    }

    private List<String> spiltToArgs(String args) {
        List<String> argsList = Arrays.asList(args.trim().split(CONSTANTS.FLAG_SPILT));
        return new ArrayList<>(argsList).stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
    }

    public Object getValueOf(String flag) {
        if (CollectionUtils.isEmpty(argPairs)) {
            return FlagSchemaFactory.getOf(flag).getDefaultValue();
        }

        for (Arg arg : argPairs) {
            if (flag.equals(arg.getFlag())) {
                return arg.parseValue();
            } else {
                continue;
            }
        }

        return FlagSchemaFactory.getOf(flag).getDefaultValue();
    }
}
