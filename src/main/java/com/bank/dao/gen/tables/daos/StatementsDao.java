/*
 * This file is generated by jOOQ.
 */
package com.bank.dao.gen.tables.daos;


import com.bank.dao.gen.tables.Statements;
import com.bank.dao.gen.tables.records.StatementsRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class StatementsDao extends DAOImpl<StatementsRecord, com.bank.dao.gen.tables.pojos.Statements, Integer> {

    /**
     * Create a new StatementsDao without any configuration
     */
    public StatementsDao() {
        super(Statements.STATEMENTS, com.bank.dao.gen.tables.pojos.Statements.class);
    }

    /**
     * Create a new StatementsDao with an attached configuration
     */
    public StatementsDao(Configuration configuration) {
        super(Statements.STATEMENTS, com.bank.dao.gen.tables.pojos.Statements.class, configuration);
    }

    @Override
    public Integer getId(com.bank.dao.gen.tables.pojos.Statements object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>ID BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Statements.STATEMENTS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ID IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchById(Integer... values) {
        return fetch(Statements.STATEMENTS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>ID = value</code>
     */
    public com.bank.dao.gen.tables.pojos.Statements fetchOneById(Integer value) {
        return fetchOne(Statements.STATEMENTS.ID, value);
    }

    /**
     * Fetch records that have <code>CUSTOMER_ID BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfCustomerId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Statements.STATEMENTS.CUSTOMER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>CUSTOMER_ID IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByCustomerId(Integer... values) {
        return fetch(Statements.STATEMENTS.CUSTOMER_ID, values);
    }

    /**
     * Fetch records that have <code>ACCOUNT_NO BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfAccountNo(String lowerInclusive, String upperInclusive) {
        return fetchRange(Statements.STATEMENTS.ACCOUNT_NO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ACCOUNT_NO IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByAccountNo(String... values) {
        return fetch(Statements.STATEMENTS.ACCOUNT_NO, values);
    }

    /**
     * Fetch records that have <code>CCY BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfCcy(String lowerInclusive, String upperInclusive) {
        return fetchRange(Statements.STATEMENTS.CCY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>CCY IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByCcy(String... values) {
        return fetch(Statements.STATEMENTS.CCY, values);
    }

    /**
     * Fetch records that have <code>TXN_TIMESTAMP BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfTxnTimestamp(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(Statements.STATEMENTS.TXN_TIMESTAMP, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>TXN_TIMESTAMP IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByTxnTimestamp(Timestamp... values) {
        return fetch(Statements.STATEMENTS.TXN_TIMESTAMP, values);
    }

    /**
     * Fetch records that have <code>TXN_VALUE_TIMESTAMP BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfTxnValueTimestamp(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(Statements.STATEMENTS.TXN_VALUE_TIMESTAMP, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>TXN_VALUE_TIMESTAMP IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByTxnValueTimestamp(Timestamp... values) {
        return fetch(Statements.STATEMENTS.TXN_VALUE_TIMESTAMP, values);
    }

    /**
     * Fetch records that have <code>TXN_AMOUNT BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfTxnAmount(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Statements.STATEMENTS.TXN_AMOUNT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>TXN_AMOUNT IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByTxnAmount(BigDecimal... values) {
        return fetch(Statements.STATEMENTS.TXN_AMOUNT, values);
    }

    /**
     * Fetch records that have <code>DR_CR BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfDrCr(String lowerInclusive, String upperInclusive) {
        return fetchRange(Statements.STATEMENTS.DR_CR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>DR_CR IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByDrCr(String... values) {
        return fetch(Statements.STATEMENTS.DR_CR, values);
    }

    /**
     * Fetch records that have <code>NARRATION BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfNarration(String lowerInclusive, String upperInclusive) {
        return fetchRange(Statements.STATEMENTS.NARRATION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>NARRATION IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByNarration(String... values) {
        return fetch(Statements.STATEMENTS.NARRATION, values);
    }

    /**
     * Fetch records that have <code>BANK_CODE BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchRangeOfBankCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(Statements.STATEMENTS.BANK_CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>BANK_CODE IN (values)</code>
     */
    public List<com.bank.dao.gen.tables.pojos.Statements> fetchByBankCode(String... values) {
        return fetch(Statements.STATEMENTS.BANK_CODE, values);
    }
}
