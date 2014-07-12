package org.kurron.account

import groovy.transform.Canonical
import org.kurron.amqp.Communicator

/**
 * Simple class just to showcase JDepend.
 */
@Canonical
class Account {
    String number
    String status

    private final Communicator communicator

    Account( Communicator aCommunicator ) {
        communicator = aCommunicator
    }

    List<Account> loadAll() {
        communicator.loadAccounts()
    }
}
