package hello

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

/**
 * This is the main entry into the application.  If we are running from the command-line using embedded Tomcat, the main() will be invoked.
 * If we are running inside a Servlet 3.0 container, then the configure() methods called.
 **/
@SuppressWarnings( 'GrMethodMayBeStatic' )
@EnableAutoConfiguration
@ComponentScan( ['hello'] )
@Slf4j
class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder builder ) {
        log.info( '--- Running inside provided web container. ----' )
        builder.sources( Application ).web( true ).headless( true )
    }

    /**
     * Called to start the entire application.  Typically, java -jar foo.jar.
     * @param args any arguments to the program.
     */
    static void main( String[] args ) {
        log.info( '--- Running embedded web container ----' )
        SpringApplication.run( Application, args )
    }
}
