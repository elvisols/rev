/*
 * This file is generated by jOOQ.
 */
package com.bank.dao.gen;


import com.bank.dao.gen.tables.Accounts;
import com.bank.dao.gen.tables.Customers;
import com.bank.dao.gen.tables.Statements;
import com.bank.dao.gen.tables.Transfers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RevDb extends SchemaImpl {

    private static final long serialVersionUID = 1085621883;

    /**
     * The reference instance of <code>REV_DB</code>
     */
    public static final RevDb REV_DB = new RevDb();

    /**
     * The table <code>REV_DB.ACCOUNTS</code>.
     */
    public final Accounts ACCOUNTS = com.bank.dao.gen.tables.Accounts.ACCOUNTS;

    /**
     * The table <code>REV_DB.CUSTOMERS</code>.
     */
    public final Customers CUSTOMERS = com.bank.dao.gen.tables.Customers.CUSTOMERS;

    /**
     * The table <code>REV_DB.STATEMENTS</code>.
     */
    public final Statements STATEMENTS = com.bank.dao.gen.tables.Statements.STATEMENTS;

    /**
     * The table <code>REV_DB.TRANSFERS</code>.
     */
    public final Transfers TRANSFERS = com.bank.dao.gen.tables.Transfers.TRANSFERS;

    /**
     * No further instances allowed
     */
    private RevDb() {
        super("REV_DB", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.S_ACCOUNT_ID,
            Sequences.S_CUSTOMER_ID,
            Sequences.S_STATEMENT_ID);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Accounts.ACCOUNTS,
            Customers.CUSTOMERS,
            Statements.STATEMENTS,
            Transfers.TRANSFERS);
    }
}
