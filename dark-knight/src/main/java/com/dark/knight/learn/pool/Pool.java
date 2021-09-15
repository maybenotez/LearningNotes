package com.dark.knight.learn.pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by win on 2018/6/13 0013.
 */
public interface Pool {


    Connection getConnection() throws SQLException, InterruptedException, Exception;

    Connection getConnection(long timeout) throws Exception;

    void closeConnection(Connection connection);


}
