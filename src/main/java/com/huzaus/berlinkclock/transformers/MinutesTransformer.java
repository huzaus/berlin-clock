package com.huzaus.berlinkclock.transformers;

import static org.apache.commons.lang3.StringUtils.repeat;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class MinutesTransformer implements TimeUnitTransformer {

    private final TimeUnitValidator validator = new TimeUnitValidator(0, 59);

    @Override
    public String apply(Integer minutes) {
        validator.accept(minutes);
        return printMajorRow(minutes / 5) + "\n" + printMinorRow(minutes % 5);
    }

    private String printMinorRow(Integer bulbs) {
        return rightPad(repeat('Y', bulbs), 4, 'O');
    }

    private String printMajorRow(Integer bulbs) {
        return rightPad(repeat("YYR", bulbs / 3) +
                repeat('Y', bulbs % 3), 11, 'O');
    }

}
