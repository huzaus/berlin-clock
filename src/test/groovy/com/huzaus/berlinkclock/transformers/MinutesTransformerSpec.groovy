package com.huzaus.berlinkclock.transformers

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class MinutesTransformerSpec extends Specification {

    @Subject
    MinutesTransformer minutesTransformer = new MinutesTransformer();

    def "Should throw IllegalArgumentException when argument = '#argument'"() {
        when:
        minutesTransformer.apply(argument)
        then:
        thrown(IllegalArgumentException)
        where:
        argument << [null, -1, 60]
    }

    def "Should transform '#minutes' -> '#result' "() {
        expect:
        minutesTransformer.apply(minutes) == result
        where:
        minutes || result
        0       || "OOOOOOOOOOO\nOOOO"
        1       || "OOOOOOOOOOO\nYOOO"
        2       || "OOOOOOOOOOO\nYYOO"
        3       || "OOOOOOOOOOO\nYYYO"
        4       || "OOOOOOOOOOO\nYYYY"
        5       || "YOOOOOOOOOO\nOOOO"
        10      || "YYOOOOOOOOO\nOOOO"
        15      || "YYROOOOOOOO\nOOOO"
        20      || "YYRYOOOOOOO\nOOOO"
        25      || "YYRYYOOOOOO\nOOOO"
        30      || "YYRYYROOOOO\nOOOO"
        38      || "YYRYYRYOOOO\nYYYO"
        45      || "YYRYYRYYROO\nOOOO"
        50      || "YYRYYRYYRYO\nOOOO"
        59      || "YYRYYRYYRYY\nYYYY"

    }
}
