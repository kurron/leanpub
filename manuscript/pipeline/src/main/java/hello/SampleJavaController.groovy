package hello

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Simple REST controller to show off Spring Boot and the build process.
 */
@SuppressWarnings( 'GroovyUnusedDeclaration' )
@RestController
public class SampleJavaController {
    private static final Logger log = LoggerFactory.getLogger( SampleJavaController.class );

    @RequestMapping( "/java" )
    public String hello() {
        log.debug( "hello called" );
        return "Hello, World!";
    }
}
