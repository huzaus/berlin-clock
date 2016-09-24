package com.huzaus.berlinkclock.transformers

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class TimeUnitValidatorSpec extends Specification {

    @Subject
    TimeUnitValidator timeUnitValidator = new TimeUnitValidator(0, 59);

    def "Should throw IllegalArgumentException when argument = '#argument'"() {
        when:
        timeUnitValidator.accept(argument)
        then:
        thrown(IllegalArgumentException)
        where:
        argument << [null, -1, 60]

    }

}
