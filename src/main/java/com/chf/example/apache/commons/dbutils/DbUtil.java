package com.chf.example.apache.commons.dbutils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DbUtil {

    private DataSource dataSource;

    public DbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * for insert update or delete statement
     * 
     * @param sql
     * @return
     * @throws SQLException
     */
    public int update(String sql) throws SQLException {
        QueryRunner run = new QueryRunner(dataSource);
        return run.update(sql);
    }

    /**
     * for select statement
     * 
     * @param sql
     * @return
     * @throws SQLException
     */
    public List<Object[]> query(String sql) throws SQLException {

        ResultSetHandler<List<Object[]>> h = new ResultSetHandler<List<Object[]>>() {
            public List<Object[]> handle(ResultSet rs) throws SQLException {

                List<Object[]> resultList = new ArrayList<>();

                while (rs.next()) {
                    ResultSetMetaData meta = rs.getMetaData();
                    int cols = meta.getColumnCount();
                    Object[] result = new Object[cols];

                    for (int i = 0; i < cols; i++) {
                        result[i] = rs.getObject(i + 1);
                    }
                    resultList.add(result);
                }

                return resultList;
            }
        };

        QueryRunner run = new QueryRunner(dataSource);
        return run.query(sql, h);

    }

    public <T> List<T> queryBeanList(String sql, Class<T> type)
            throws SQLException {
        QueryRunner run = new QueryRunner(dataSource);
        ResultSetHandler<List<T>> h = new BeanListHandler<T>(type);
        return run.query(sql, h);
    }

}
