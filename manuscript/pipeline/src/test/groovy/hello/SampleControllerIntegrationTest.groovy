package hello

import groovy.util.logging.Slf4j
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * REST integration test of the SampleController object.
 */
@Slf4j
@WebAppConfiguration
@IntegrationTest
@ContextConfiguration( classes = Application, loader = SpringApplicationContextLoader )
class SampleControllerIntegrationTest extends Specification {
    def 'exercise the / endpoint'() {
        given: 'valid REST template'
        def template = new RestTemplate()

        when: 'the / endpoint is called'
        ResponseEntity<String> response = template.getForEntity( new URI( 'http://localhost:8080/' ), String )

        then: 'hello is returned'
        response.statusCode == HttpStatus.OK
        response.body == 'Hello, World!'
    }
}
