package com.huzaus.berlinkclock.transformers;

import static org.apache.commons.lang3.StringUtils.repeat;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class HoursTransformer implements TimeUnitTransformer {

    private TimeUnitValidator validator = new TimeUnitValidator(0, 23);

    @Override
    public String apply(Integer hours) {
        validator.accept(hours);
        return printRow(hours / 5) + "\n" + printRow(hours % 5);
    }

    private String printRow(int bulbs) {
        return rightPad(repeat('R', bulbs), 4, 'O');
    }
}
