package com.huzaus.berlinkclock.transformers

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class SecondsTransformerSpec extends Specification {

    @Subject
    SecondsTransformer secondsTransformer = new SecondsTransformer();

    def "Should throw IllegalArgumentException when argument is '#argument'"() {
        when:
        secondsTransformer.apply(argument)
        then:
        thrown(IllegalArgumentException)
        where:
        argument << [null, -1, 60]
    }

    def "Should transform '#argument' -> '#result'"() {
        expect:
        secondsTransformer.apply(argument) == result
        where:
        argument || result
        0        || 'O'
        10       || 'O'
        34       || 'O'
        1        || 'R'
        13       || 'R'
        37       || 'R'
        59       || 'R'
    }
}
