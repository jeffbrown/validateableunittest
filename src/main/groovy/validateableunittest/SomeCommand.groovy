package validateableunittest

import grails.validation.Validateable

class SomeCommand implements Validateable {
    int length

    static constraints = {
        length range: 1..10, validator: { val ->
            val % 2 == 0
        }
    }
}
