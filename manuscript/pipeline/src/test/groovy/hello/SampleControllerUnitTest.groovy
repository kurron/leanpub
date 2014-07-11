package hello

import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

/**
 * Unit test of the SampleController object.
 */
@Slf4j
class SampleControllerUnitTest extends Specification {

    def 'exercise GET'() {
        given: 'valid subject under test'
        def sut = standaloneSetup( new SampleController() ).build()

        when: 'the endpoint is called with GET'
        def result = sut.perform( get( '/' )  ).andReturn()

        then: 'hello is returned'
        result.response.status == HttpStatus.OK.value()
        result.response.contentAsString == 'Hello, World!'
    }

    def 'exercise POST'() {
        given: 'valid subject under test'
        def sut = standaloneSetup( new SampleController() ).build()

        when: 'the endpoint is called with POST'
        def result = sut.perform( post( '/' )  ).andReturn()

        then: 'method is denied'
        result.response.status == HttpStatus.METHOD_NOT_ALLOWED.value()
    }
}
