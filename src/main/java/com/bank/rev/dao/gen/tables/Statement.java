/*
 * This file is generated by jOOQ.
 */
package com.bank.rev.dao.gen.tables;


import com.bank.rev.dao.gen.Indexes;
import com.bank.rev.dao.gen.Keys;
import com.bank.rev.dao.gen.RevDb;
import com.bank.rev.dao.gen.tables.records.StatementRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Statement extends TableImpl<StatementRecord> {

    private static final long serialVersionUID = -1959413080;

    /**
     * The reference instance of <code>REV_DB.STATEMENT</code>
     */
    public static final Statement STATEMENT = new Statement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StatementRecord> getRecordType() {
        return StatementRecord.class;
    }

    /**
     * The column <code>REV_DB.STATEMENT.ID</code>.
     */
    public final TableField<StatementRecord, Integer> ID = createField(DSL.name("ID"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.CUSTOMER_ID</code>.
     */
    public final TableField<StatementRecord, Integer> CUSTOMER_ID = createField(DSL.name("CUSTOMER_ID"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.ACCOUNT_NO</code>.
     */
    public final TableField<StatementRecord, String> ACCOUNT_NO = createField(DSL.name("ACCOUNT_NO"), org.jooq.impl.SQLDataType.CHAR(10).nullable(false), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.CCY</code>.
     */
    public final TableField<StatementRecord, String> CCY = createField(DSL.name("CCY"), org.jooq.impl.SQLDataType.CHAR(3).nullable(false), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.TXN_TIMESTAMP</code>.
     */
    public final TableField<StatementRecord, Timestamp> TXN_TIMESTAMP = createField(DSL.name("TXN_TIMESTAMP"), org.jooq.impl.SQLDataType.TIMESTAMP.precision(6), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.TXN_AMOUNT</code>.
     */
    public final TableField<StatementRecord, BigDecimal> TXN_AMOUNT = createField(DSL.name("TXN_AMOUNT"), org.jooq.impl.SQLDataType.DECIMAL(11, 2).nullable(false), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.DR_CR</code>.
     */
    public final TableField<StatementRecord, String> DR_CR = createField(DSL.name("DR_CR"), org.jooq.impl.SQLDataType.CHAR(1).nullable(false), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.NARRATION</code>.
     */
    public final TableField<StatementRecord, String> NARRATION = createField(DSL.name("NARRATION"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>REV_DB.STATEMENT.BANK_CODE</code>.
     */
    public final TableField<StatementRecord, String> BANK_CODE = createField(DSL.name("BANK_CODE"), org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * Create a <code>REV_DB.STATEMENT</code> table reference
     */
    public Statement() {
        this(DSL.name("STATEMENT"), null);
    }

    /**
     * Create an aliased <code>REV_DB.STATEMENT</code> table reference
     */
    public Statement(String alias) {
        this(DSL.name(alias), STATEMENT);
    }

    /**
     * Create an aliased <code>REV_DB.STATEMENT</code> table reference
     */
    public Statement(Name alias) {
        this(alias, STATEMENT);
    }

    private Statement(Name alias, Table<StatementRecord> aliased) {
        this(alias, aliased, null);
    }

    private Statement(Name alias, Table<StatementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Statement(Table<O> child, ForeignKey<O, StatementRecord> key) {
        super(child, key, STATEMENT);
    }

    @Override
    public Schema getSchema() {
        return RevDb.REV_DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.FK_STATEMENT_CUSTOMER_ID_INDEX_2, Indexes.PRIMARY_KEY_2);
    }

    @Override
    public Identity<StatementRecord, Integer> getIdentity() {
        return Keys.IDENTITY_STATEMENT;
    }

    @Override
    public UniqueKey<StatementRecord> getPrimaryKey() {
        return Keys.PK_STATEMENT;
    }

    @Override
    public List<UniqueKey<StatementRecord>> getKeys() {
        return Arrays.<UniqueKey<StatementRecord>>asList(Keys.PK_STATEMENT);
    }

    @Override
    public List<ForeignKey<StatementRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StatementRecord, ?>>asList(Keys.FK_STATEMENT_CUSTOMER_ID);
    }

    public Customer customer() {
        return new Customer(this, Keys.FK_STATEMENT_CUSTOMER_ID);
    }

    @Override
    public Statement as(String alias) {
        return new Statement(DSL.name(alias), this);
    }

    @Override
    public Statement as(Name alias) {
        return new Statement(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Statement rename(String name) {
        return new Statement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Statement rename(Name name) {
        return new Statement(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, String, String, Timestamp, BigDecimal, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
