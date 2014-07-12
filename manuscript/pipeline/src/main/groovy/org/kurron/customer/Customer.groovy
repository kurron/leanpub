package org.kurron.customer

import groovy.transform.Canonical
import org.kurron.amqp.Communicator

/**
 * Simple class just to showcase JDepend.
 */
@Canonical
class Customer {
    String name
    String address

    private final Communicator communicator

    Customer( Communicator aCommunicator ) {
        communicator = aCommunicator
    }

    List<Customer> loadAll() {
        communicator.loadCustomers()
    }

}
