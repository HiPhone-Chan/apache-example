package com.chf.fixed.mysql;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.unitils.dbunit.DbUnitModule;
import org.unitils.dbunit.util.DbUnitDatabaseConnection;

public class MySqlDbUnitModule extends DbUnitModule {

    @Override
    public DbUnitDatabaseConnection getDbUnitDatabaseConnection(
            final String schemaName) {

        DbUnitDatabaseConnection connection = super
                .getDbUnitDatabaseConnection(schemaName);

        connection.getConfig().setProperty(
                DatabaseConfig.PROPERTY_METADATA_HANDLER,
                new MySqlMetadataHandler());
        return connection;
    }
}
