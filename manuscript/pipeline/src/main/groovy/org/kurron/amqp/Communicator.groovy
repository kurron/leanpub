package org.kurron.amqp

import groovy.transform.Canonical
import org.kurron.account.Account
import org.kurron.customer.Customer

/**
 * Simple class just to showcase JDepend.
 */
@Canonical
class Communicator {
    List<Account> loadAccounts() { [] }
    List<Customer> loadCustomers() { [] }
}
