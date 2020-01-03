/*
 * This file is generated by jOOQ.
 */
package com.bank.dao.gen.tables.records;


import com.bank.dao.gen.tables.Statements;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


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
public class StatementsRecord extends UpdatableRecordImpl<StatementsRecord> implements Record10<Integer, Integer, String, String, Timestamp, Timestamp, BigDecimal, String, String, String> {

    private static final long serialVersionUID = 398573286;

    /**
     * Setter for <code>REV_DB.STATEMENTS.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.CUSTOMER_ID</code>.
     */
    public void setCustomerId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.CUSTOMER_ID</code>.
     */
    public Integer getCustomerId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.ACCOUNT_NO</code>.
     */
    public void setAccountNo(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.ACCOUNT_NO</code>.
     */
    public String getAccountNo() {
        return (String) get(2);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.CCY</code>.
     */
    public void setCcy(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.CCY</code>.
     */
    public String getCcy() {
        return (String) get(3);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.TXN_TIMESTAMP</code>.
     */
    public void setTxnTimestamp(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.TXN_TIMESTAMP</code>.
     */
    public Timestamp getTxnTimestamp() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.TXN_VALUE_TIMESTAMP</code>.
     */
    public void setTxnValueTimestamp(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.TXN_VALUE_TIMESTAMP</code>.
     */
    public Timestamp getTxnValueTimestamp() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.TXN_AMOUNT</code>.
     */
    public void setTxnAmount(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.TXN_AMOUNT</code>.
     */
    public BigDecimal getTxnAmount() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.DR_CR</code>.
     */
    public void setDrCr(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.DR_CR</code>.
     */
    public String getDrCr() {
        return (String) get(7);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.NARRATION</code>.
     */
    public void setNarration(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.NARRATION</code>.
     */
    public String getNarration() {
        return (String) get(8);
    }

    /**
     * Setter for <code>REV_DB.STATEMENTS.BANK_CODE</code>.
     */
    public void setBankCode(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>REV_DB.STATEMENTS.BANK_CODE</code>.
     */
    public String getBankCode() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, Integer, String, String, Timestamp, Timestamp, BigDecimal, String, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, Integer, String, String, Timestamp, Timestamp, BigDecimal, String, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Statements.STATEMENTS.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Statements.STATEMENTS.CUSTOMER_ID;
    }

    @Override
    public Field<String> field3() {
        return Statements.STATEMENTS.ACCOUNT_NO;
    }

    @Override
    public Field<String> field4() {
        return Statements.STATEMENTS.CCY;
    }

    @Override
    public Field<Timestamp> field5() {
        return Statements.STATEMENTS.TXN_TIMESTAMP;
    }

    @Override
    public Field<Timestamp> field6() {
        return Statements.STATEMENTS.TXN_VALUE_TIMESTAMP;
    }

    @Override
    public Field<BigDecimal> field7() {
        return Statements.STATEMENTS.TXN_AMOUNT;
    }

    @Override
    public Field<String> field8() {
        return Statements.STATEMENTS.DR_CR;
    }

    @Override
    public Field<String> field9() {
        return Statements.STATEMENTS.NARRATION;
    }

    @Override
    public Field<String> field10() {
        return Statements.STATEMENTS.BANK_CODE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getCustomerId();
    }

    @Override
    public String component3() {
        return getAccountNo();
    }

    @Override
    public String component4() {
        return getCcy();
    }

    @Override
    public Timestamp component5() {
        return getTxnTimestamp();
    }

    @Override
    public Timestamp component6() {
        return getTxnValueTimestamp();
    }

    @Override
    public BigDecimal component7() {
        return getTxnAmount();
    }

    @Override
    public String component8() {
        return getDrCr();
    }

    @Override
    public String component9() {
        return getNarration();
    }

    @Override
    public String component10() {
        return getBankCode();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getCustomerId();
    }

    @Override
    public String value3() {
        return getAccountNo();
    }

    @Override
    public String value4() {
        return getCcy();
    }

    @Override
    public Timestamp value5() {
        return getTxnTimestamp();
    }

    @Override
    public Timestamp value6() {
        return getTxnValueTimestamp();
    }

    @Override
    public BigDecimal value7() {
        return getTxnAmount();
    }

    @Override
    public String value8() {
        return getDrCr();
    }

    @Override
    public String value9() {
        return getNarration();
    }

    @Override
    public String value10() {
        return getBankCode();
    }

    @Override
    public StatementsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public StatementsRecord value2(Integer value) {
        setCustomerId(value);
        return this;
    }

    @Override
    public StatementsRecord value3(String value) {
        setAccountNo(value);
        return this;
    }

    @Override
    public StatementsRecord value4(String value) {
        setCcy(value);
        return this;
    }

    @Override
    public StatementsRecord value5(Timestamp value) {
        setTxnTimestamp(value);
        return this;
    }

    @Override
    public StatementsRecord value6(Timestamp value) {
        setTxnValueTimestamp(value);
        return this;
    }

    @Override
    public StatementsRecord value7(BigDecimal value) {
        setTxnAmount(value);
        return this;
    }

    @Override
    public StatementsRecord value8(String value) {
        setDrCr(value);
        return this;
    }

    @Override
    public StatementsRecord value9(String value) {
        setNarration(value);
        return this;
    }

    @Override
    public StatementsRecord value10(String value) {
        setBankCode(value);
        return this;
    }

    @Override
    public StatementsRecord values(Integer value1, Integer value2, String value3, String value4, Timestamp value5, Timestamp value6, BigDecimal value7, String value8, String value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StatementsRecord
     */
    public StatementsRecord() {
        super(Statements.STATEMENTS);
    }

    /**
     * Create a detached, initialised StatementsRecord
     */
    public StatementsRecord(Integer id, Integer customerId, String accountNo, String ccy, Timestamp txnTimestamp, Timestamp txnValueTimestamp, BigDecimal txnAmount, String drCr, String narration, String bankCode) {
        super(Statements.STATEMENTS);

        set(0, id);
        set(1, customerId);
        set(2, accountNo);
        set(3, ccy);
        set(4, txnTimestamp);
        set(5, txnValueTimestamp);
        set(6, txnAmount);
        set(7, drCr);
        set(8, narration);
        set(9, bankCode);
    }
}
