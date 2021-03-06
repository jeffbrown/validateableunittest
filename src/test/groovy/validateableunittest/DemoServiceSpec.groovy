package validateableunittest

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class DemoServiceSpec extends Specification implements ServiceUnitTest<DemoService>, DataTest {

    @Unroll("length #someLength should have caused validate() to return #shouldBeValid")
    void 'test age constraint'() {
        expect:
        new SomeCommand(length: someLength).validate() == shouldBeValid

        where:
        someLength | shouldBeValid
        -1         | false
        0          | false
        1          | false
        2          | true
        3          | false
        4          | true
        7          | false
        8          | true
        9          | false
        10         | true
        11         | false
        12         | false
    }
}
