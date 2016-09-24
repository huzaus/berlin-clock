package com.huzaus.berlinkclock.transformers

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class HoursTransformerSpec extends Specification {

    @Subject
    HoursTransformer hoursTransformer = new HoursTransformer()

    def "Should throw IllegalArgumentException when argument = '#argument'"() {
        when:
        hoursTransformer.apply(argument)
        then:
        thrown(IllegalArgumentException)
        where:
        argument << [null, -1, 24]
    }

    def "Should transform '#hours' -> '#result'"() {
        expect:
        hoursTransformer.apply(hours) == result
        where:
        hours || result
        0     || 'OOOO\nOOOO'
        1     || 'OOOO\nROOO'
        2     || 'OOOO\nRROO'
        3     || 'OOOO\nRRRO'
        4     || 'OOOO\nRRRR'
        5     || 'ROOO\nOOOO'
        10    || 'RROO\nOOOO'
        15    || 'RRRO\nOOOO'
        20    || 'RRRR\nOOOO'
        17    || 'RRRO\nRROO'
        23    || 'RRRR\nRRRO'
    }

}
