package com.dark.knight.learn.pool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.*;

/**
 * Created by win on 2018/6/13 0013.
 */
public class ConnectionPool implements Pool{
    /**
     * 此类主要实现数据库连接池
     *
     */
    private int coreSize;

    private int currentSize;

    private BlockingQueue<Connection> connectionPool;

    private DataSource dataSource;

    public ConnectionPool(int coreSize) {
        this.coreSize = coreSize;
        this.connectionPool = new LinkedBlockingQueue<>();
    }

    @Override
    public Connection getConnection() throws Exception {
        Connection connection;
        if (coreSize > currentSize) {
            connection = dataSource.getConnection();
            currentSize++;
        } else if (connectionPool.size() > 0) {
            connection = connectionPool.take();
            currentSize--;
        } else {
            throw new RuntimeException("no free connection to use");
        }

        return connection;
    }
    

    @Override
    public Connection getConnection(long timeout) throws Exception{
        return connectionPool.poll(timeout, TimeUnit.MILLISECONDS);
    }

    @Override
    public void closeConnection(Connection connection) {
        if (connectionPool.size() < coreSize) {
            connectionPool.offer(connection);
        } else {
            try {
                connection.close();
            } catch (Exception exception) {
                // log
            }
        }

    }
}
