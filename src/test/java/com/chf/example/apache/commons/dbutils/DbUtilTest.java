package com.chf.example.apache.commons.dbutils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.DatabaseUnitils;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.dbunit.datasetloadstrategy.impl.CleanInsertLoadStrategy;
import org.unitils.reflectionassert.ReflectionAssert;

import com.chf.example.domain.AppInfo;

@DataSet(value = { "DbUtilTest.xml" }, loadStrategy = CleanInsertLoadStrategy.class)
public class DbUtilTest extends UnitilsJUnit4 {

    @TestDataSource
    private DataSource dataSource;

    private DbUtil dbUtil;

    @Before
    public void setup() {
        if (dataSource == null) {
            dataSource = DatabaseUnitils.getDataSource();
        }
        if (dbUtil == null) {
            dbUtil = new DbUtil(dataSource);
        }
    }

    @Ignore
    @Test
    public void testQuery() throws SQLException {
    }

    @Test
    @ExpectedDataSet("expectedData.xml")
    public void testUpdate() throws SQLException {

        dbUtil.update("insert into t_appinfo values (3,'des','name','ver')");
    }

    @Test
    public void testQueryBeanList() throws SQLException {

        List<AppInfo> expectedList = new ArrayList<>();

        expectedList.add(new AppInfo(1L, "app1", "ver1", "app1"));
        expectedList.add(new AppInfo(2L, "app2", "ver2", "app2"));

        List<AppInfo> appInfoList = dbUtil.queryBeanList(
                "select * from t_appinfo", AppInfo.class);

        ReflectionAssert.assertLenientEquals(expectedList, appInfoList);

    }

}
