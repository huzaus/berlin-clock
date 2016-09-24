package com.huzaus.berlinkclock.transformers;

import java.util.function.Consumer;

public class TimeUnitValidator implements Consumer<Integer> {

    private final int minValue;
    private final int maxValue;

    public TimeUnitValidator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void accept(Integer timeUnit) {
        if (timeUnit == null || minValue > timeUnit || timeUnit > maxValue) {
            throw new IllegalArgumentException("The argument value should not be null " +
                    "and should be in range " + minValue + ".." + maxValue +
                    ". Argument value is " + timeUnit);
        }

    }
}
