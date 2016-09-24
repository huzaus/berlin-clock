package com.huzaus.berlinkclock

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import java.time.format.DateTimeParseException

@Unroll
class BerlinClockSpec extends Specification {

    @Subject
    BerlinClock clock = new BerlinClock();

    def "Should throw '#exception' when argument = '#argument'"() {
        when:
        clock.apply(argument)
        then:
        thrown(exception)
        where:
        argument        || exception
        null            || NullPointerException
        ""              || DateTimeParseException
        "random string" || DateTimeParseException
        "24:59:59"      || DateTimeParseException
    }

    def "Should transform '#input' -> '#output'"() {
        expect:
        clock.apply(input) == output
        where:
        input      || output
        '00:00:00' || 'O\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO'
        '13:45:21' || 'R\nRROO\nRRRO\nYYRYYRYYROO\nOOOO'
        '19:13:44' || 'O\nRRRO\nRRRR\nYYOOOOOOOOO\nYYYO'
        '23:59:59' || 'R\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY'
    }
}
