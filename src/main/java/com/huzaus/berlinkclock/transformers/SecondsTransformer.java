package com.huzaus.berlinkclock.transformers;

public class SecondsTransformer implements TimeUnitTransformer {

    private final TimeUnitValidator validator = new TimeUnitValidator(0, 59);

    public String apply(Integer seconds) {
        validator.accept(seconds);
        return seconds % 2 != 0 ? "R" : "O";
    }

}
