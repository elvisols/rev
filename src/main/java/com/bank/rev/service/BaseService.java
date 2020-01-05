package com.bank.rev.service;

import com.bank.rev.util.Config;
import org.jooq.Configuration;

import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BaseService {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final Lock readLock = readWriteLock.readLock();
    final Lock writeLock = readWriteLock.writeLock();
    protected static Configuration config;

    public BaseService() {
        try {
            config = Config.getInstance().getConfiguration();
        } catch (SQLException e) { e.getMessage(); }
    }
}
