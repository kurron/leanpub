package hello

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Simple REST controller to show off Spring Boot and the build process.
 */
@Slf4j
@SuppressWarnings( 'GroovyUnusedDeclaration' )
@RestController
class SampleController {

    @RequestMapping( value = '/', method = RequestMethod.GET )
    String handleGet() {
        log.debug( 'hello called' )
        'Hello, World!'
    }
}
