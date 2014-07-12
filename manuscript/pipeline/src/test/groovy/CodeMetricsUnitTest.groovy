
import static org.junit.Assert.assertEquals

import jdepend.framework.DependencyConstraint
import jdepend.framework.JDepend
import jdepend.framework.JavaPackage
import spock.lang.Specification

/**
 * Automated test using JDepend to analyze dependencies.
 */
class CodeMetricsUnitTest extends Specification {

    private final jdepend = new JDepend()

    void setup() {
        String main = "${System.getProperty( 'user.dir' )}/manuscript/pipeline/build/classes/main"
        try {
            jdepend.addDirectory( main )
        }
        catch ( Exception e ) {
            e.printStackTrace()
        }
    }

    def 'verify package dependencies' () {

        given: 'valid operating constraints'
        def constraint = new DependencyConstraint()
        def customer = constraint.addPackage( 'org.kurron.customer' )
        def account = constraint.addPackage( 'org.kurron.account' )
        def amqp = constraint.addPackage( 'org.kurron.amqp' )

        customer.dependsUpon( amqp )
        account.dependsUpon( amqp )

        when: 'the packages are analyzed'
        jdepend.analyze()

        then: 'the dependencies match the constraints'
        jdepend.dependencyMatch( constraint )
    }

    def 'detect package cycles' () {

        when: 'the packages are analyzed'
        jdepend.analyze()

        then: 'no circular dependencies are detected'
        !jdepend.containsCycles()
    }

    def 'detect non-conforming distances' () {

        given: 'distance parameters'
        double ideal = 0.0
        double tolerance = 0.5

        when: 'the packages are analyzed'
        def results = jdepend.analyze()

        then: 'no circular dependencies are detected'
        results.each { JavaPackage it ->
            String offender = "Distance exceeded:  ${it.name}"
            assertEquals( offender, ideal, it.distance(), tolerance)
        }
    }
}
