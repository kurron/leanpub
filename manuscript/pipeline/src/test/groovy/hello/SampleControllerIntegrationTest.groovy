package hello

import groovy.util.logging.Slf4j
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Unroll

/**
 * REST integration test of the SampleController object.
 */
@Slf4j
@WebAppConfiguration
@IntegrationTest
@ContextConfiguration( classes = Application, loader = SpringApplicationContextLoader )
class SampleControllerIntegrationTest extends Specification {

    @Unroll( 'exercise REST endpoint #uri' )
    def 'exercise REST endpoint'() {
        given: 'valid REST template'
        def template = new TestRestTemplate()

        when: 'the endpoint is called'
        log.debug( 'Calling endpoint {}', uri )
        ResponseEntity<String> response = template.getForEntity( new URI( uri ), String )

        then: 'hello is returned'
        response.statusCode == HttpStatus.OK
        response.body == 'Hello, World!'

        where: 'the endpoint changes'
        uri << ['http://localhost:8080/', 'http://localhost:8080/java']
    }
}
