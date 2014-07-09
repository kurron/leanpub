package hello

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Simple REST controller to show off Spring Boot and the build process.
 */
@RestController
class SampleController {

    @RequestMapping( '/' )
    String hello() {
        'Hello, world!'
    }
}
