package com.huzaus.berlinkclock;

import com.huzaus.berlinkclock.transformers.HoursTransformer;
import com.huzaus.berlinkclock.transformers.MinutesTransformer;
import com.huzaus.berlinkclock.transformers.SecondsTransformer;
import com.huzaus.berlinkclock.transformers.TimeUnitTransformer;

import java.time.LocalTime;

import static java.time.LocalTime.parse;

public class BerlinClock implements Clock {

    private final TimeUnitTransformer secondsTransformer = new SecondsTransformer();
    private final TimeUnitTransformer minutesTransformer = new MinutesTransformer();
    private final TimeUnitTransformer hoursTransformer = new HoursTransformer();


    @Override
    public String apply(String time) {
        LocalTime localTime = parse(time);
        return secondsTransformer.apply(localTime.getSecond()) + "\n" +
                hoursTransformer.apply(localTime.getHour()) + "\n" +
                minutesTransformer.apply(localTime.getMinute());
    }
}
