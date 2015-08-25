package com.chf.example.apache.commons.dbutils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.chf.example.domain.AppInfo;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Main {

    public static void main(String[] args) throws Exception {

        // DataSource dataSource = getMysqlDataSource();
        DataSource dataSource = getDbcpDataSource();

        DbUtil dbUtil = new DbUtil(dataSource);
        test(dbUtil);
    }

    public static void test(DbUtil dbUtil) throws SQLException {
        print(dbUtil.query("select * from t_appinfo"));

        System.out.println(dbUtil
                .update("insert into t_appinfo values (4,'a','b','c')"));

        print(dbUtil.query("select * from t_appinfo"));

        System.out.println(dbUtil
                .update("update t_appinfo set appname='hihi' where id = 4"));

        print(dbUtil.query("select * from t_appinfo"));

        System.out.println(dbUtil.update("delete from t_appinfo where id = 4"));

        print(dbUtil.query("select * from t_appinfo"));

        print1(dbUtil.queryBeanList("select * from t_appinfo", AppInfo.class));
    }

    protected static DataSource getMysqlDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUrl("jdbc:mysql://192.168.10.72:3306/graypublish");
        dataSource.setUser("root");
        dataSource.setPassword("huawei");

        return dataSource;
    }

    private static DataSource getDbcpDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.10.72:3306/graypublish");
        dataSource.setUsername("root");
        dataSource.setPassword("huawei");

        return dataSource;
    }

    public static void print(List<Object[]> results) {
        for (Object[] objs : results) {
            System.out.println(Arrays.toString(objs));
        }
    }

    public static <T> void print1(List<T> results) {
        for (T t : results) {
            System.out.println(t);
        }
    }
}
