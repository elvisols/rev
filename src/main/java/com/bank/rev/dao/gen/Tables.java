/*
 * This file is generated by jOOQ.
 */
package com.bank.rev.dao.gen;


import com.bank.rev.dao.gen.tables.Account;
import com.bank.rev.dao.gen.tables.Customer;
import com.bank.rev.dao.gen.tables.Statement;
import com.bank.rev.dao.gen.tables.Transfer;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in REV_DB
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>REV_DB.ACCOUNT</code>.
     */
    public static final Account ACCOUNT = Account.ACCOUNT;

    /**
     * The table <code>REV_DB.CUSTOMER</code>.
     */
    public static final Customer CUSTOMER = Customer.CUSTOMER;

    /**
     * The table <code>REV_DB.STATEMENT</code>.
     */
    public static final Statement STATEMENT = Statement.STATEMENT;

    /**
     * The table <code>REV_DB.TRANSFER</code>.
     */
    public static final Transfer TRANSFER = Transfer.TRANSFER;
}
