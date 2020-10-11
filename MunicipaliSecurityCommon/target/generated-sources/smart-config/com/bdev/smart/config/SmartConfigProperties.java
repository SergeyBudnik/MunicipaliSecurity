package com.bdev.smart.config;

import com.bdev.smart.config.SmartConfig;

import com.bdev.smart.config.data.SmartConfigValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class SmartConfigProperties {
    private static ProdH2SmartConfig prodH2SmartConfig = new ProdH2SmartConfig();
    private static ProdMysqlSmartConfig prodMysqlSmartConfig = new ProdMysqlSmartConfig();
    private static ProdPostgresSmartConfig prodPostgresSmartConfig = new ProdPostgresSmartConfig();
    private static TestH2SmartConfig testH2SmartConfig = new TestH2SmartConfig();
    private static TestMysqlSmartConfig testMysqlSmartConfig = new TestMysqlSmartConfig();
    private static TestPostgresSmartConfig testPostgresSmartConfig = new TestPostgresSmartConfig();

    public static SmartConfig getConfig(String env, String db) {
        if (env.equals("prod") && db.equals("h2")) {
            return prodH2SmartConfig;
        }

        if (env.equals("prod") && db.equals("mysql")) {
            return prodMysqlSmartConfig;
        }

        if (env.equals("prod") && db.equals("postgres")) {
            return prodPostgresSmartConfig;
        }

        if (env.equals("test") && db.equals("h2")) {
            return testH2SmartConfig;
        }

        if (env.equals("test") && db.equals("mysql")) {
            return testMysqlSmartConfig;
        }

        if (env.equals("test") && db.equals("postgres")) {
            return testPostgresSmartConfig;
        }

        throw new RuntimeException();
    }

    private static class ProdH2SmartConfig implements SmartConfig {
        private SmartConfigValue<Long> connectionDatabaseLocalPort = new SmartConfigValue("connectionDatabaseLocalPort", 3307L);
        private SmartConfigValue<Long> connectionDatabaseRemotePort = new SmartConfigValue("connectionDatabaseRemotePort", 3306L);
        private SmartConfigValue<String> connectionHost = new SmartConfigValue("connectionHost", "");
        private SmartConfigValue<String> connectionPassword = new SmartConfigValue("connectionPassword", "");
        private SmartConfigValue<Long> connectionPort = new SmartConfigValue("connectionPort", 22L);
        private SmartConfigValue<String> connectionUsername = new SmartConfigValue("connectionUsername", "");
        private SmartConfigValue<String> databaseConnectionReleaseMode = new SmartConfigValue("databaseConnectionReleaseMode", "on_close");
        private SmartConfigValue<String> databaseDialect = new SmartConfigValue("databaseDialect", "org.hibernate.dialect.MySQLDialect");
        private SmartConfigValue<String> databaseDriver = new SmartConfigValue("databaseDriver", "org.h2.Driver");
        private SmartConfigValue<String> databaseFormatSql = new SmartConfigValue("databaseFormatSql", "false");
        private SmartConfigValue<String> databaseIdNewGeneratorMappings = new SmartConfigValue("databaseIdNewGeneratorMappings", "false");
        private SmartConfigValue<Long> databaseMaxActive = new SmartConfigValue("databaseMaxActive", 15000L);
        private SmartConfigValue<Long> databaseMaxPoolSize = new SmartConfigValue("databaseMaxPoolSize", 1L);
        private SmartConfigValue<String> databasePassword = new SmartConfigValue("databasePassword", "");
        private SmartConfigValue<Boolean> databaseRemoteConnection = new SmartConfigValue("databaseRemoteConnection", false);
        private SmartConfigValue<String> databaseShowSql = new SmartConfigValue("databaseShowSql", "false");
        private SmartConfigValue<String> databaseStartupAction = new SmartConfigValue("databaseStartupAction", "update");
        private SmartConfigValue<String> databaseUrl = new SmartConfigValue("databaseUrl", "");
        private SmartConfigValue<String> databaseUsername = new SmartConfigValue("databaseUsername", "");
        private SmartConfigValue<String> version = new SmartConfigValue("version", "1.0.0");
        private final List<SmartConfigValue> ALL_PROPERTIES = Arrays.asList(
            databaseStartupAction,
            databaseRemoteConnection,
            databaseMaxActive,
            databaseShowSql,
            databaseDialect,
            databaseIdNewGeneratorMappings,
            connectionPort,
            version,
            connectionDatabaseRemotePort,
            databaseFormatSql,
            databaseMaxPoolSize,
            connectionHost,
            connectionUsername,
            databaseConnectionReleaseMode,
            connectionDatabaseLocalPort,
            connectionPassword,
            databaseDriver,
            databasePassword,
            databaseUsername,
            databaseUrl);

        public SmartConfigValue<Long> getConnectionDatabaseLocalPort() {
            return connectionDatabaseLocalPort;
        }

        public SmartConfigValue<Long> getConnectionDatabaseRemotePort() {
            return connectionDatabaseRemotePort;
        }

        public SmartConfigValue<String> getConnectionHost() {
            return connectionHost;
        }

        public SmartConfigValue<String> getConnectionPassword() {
            return connectionPassword;
        }

        public SmartConfigValue<Long> getConnectionPort() {
            return connectionPort;
        }

        public SmartConfigValue<String> getConnectionUsername() {
            return connectionUsername;
        }

        public SmartConfigValue<String> getDatabaseConnectionReleaseMode() {
            return databaseConnectionReleaseMode;
        }

        public SmartConfigValue<String> getDatabaseDialect() {
            return databaseDialect;
        }

        public SmartConfigValue<String> getDatabaseDriver() {
            return databaseDriver;
        }

        public SmartConfigValue<String> getDatabaseFormatSql() {
            return databaseFormatSql;
        }

        public SmartConfigValue<String> getDatabaseIdNewGeneratorMappings() {
            return databaseIdNewGeneratorMappings;
        }

        public SmartConfigValue<Long> getDatabaseMaxActive() {
            return databaseMaxActive;
        }

        public SmartConfigValue<Long> getDatabaseMaxPoolSize() {
            return databaseMaxPoolSize;
        }

        public SmartConfigValue<String> getDatabasePassword() {
            return databasePassword;
        }

        public SmartConfigValue<Boolean> getDatabaseRemoteConnection() {
            return databaseRemoteConnection;
        }

        public SmartConfigValue<String> getDatabaseShowSql() {
            return databaseShowSql;
        }

        public SmartConfigValue<String> getDatabaseStartupAction() {
            return databaseStartupAction;
        }

        public SmartConfigValue<String> getDatabaseUrl() {
            return databaseUrl;
        }

        public SmartConfigValue<String> getDatabaseUsername() {
            return databaseUsername;
        }

        public SmartConfigValue<String> getVersion() {
            return version;
        }

        public final <T> Optional<SmartConfigValue<T>> findPropertyByName(String propertyName) {
            for (int i = 0; i < ALL_PROPERTIES.size(); i++) {
                if (ALL_PROPERTIES.get(i).isNameSuitable(propertyName)) {
                    return Optional.of(ALL_PROPERTIES.get(i));
                }
            }

            return Optional.empty();
        }
    }

    private static class ProdMysqlSmartConfig implements SmartConfig {
        private SmartConfigValue<Long> connectionDatabaseLocalPort = new SmartConfigValue("connectionDatabaseLocalPort", 3307L);
        private SmartConfigValue<Long> connectionDatabaseRemotePort = new SmartConfigValue("connectionDatabaseRemotePort", 3306L);
        private SmartConfigValue<String> connectionHost = new SmartConfigValue("connectionHost", "");
        private SmartConfigValue<String> connectionPassword = new SmartConfigValue("connectionPassword", "");
        private SmartConfigValue<Long> connectionPort = new SmartConfigValue("connectionPort", 22L);
        private SmartConfigValue<String> connectionUsername = new SmartConfigValue("connectionUsername", "");
        private SmartConfigValue<String> databaseConnectionReleaseMode = new SmartConfigValue("databaseConnectionReleaseMode", "on_close");
        private SmartConfigValue<String> databaseDialect = new SmartConfigValue("databaseDialect", "org.hibernate.dialect.MySQLDialect");
        private SmartConfigValue<String> databaseDriver = new SmartConfigValue("databaseDriver", "com.mysql.jdbc.Driver");
        private SmartConfigValue<String> databaseFormatSql = new SmartConfigValue("databaseFormatSql", "false");
        private SmartConfigValue<String> databaseIdNewGeneratorMappings = new SmartConfigValue("databaseIdNewGeneratorMappings", "false");
        private SmartConfigValue<Long> databaseMaxActive = new SmartConfigValue("databaseMaxActive", 15000L);
        private SmartConfigValue<Long> databaseMaxPoolSize = new SmartConfigValue("databaseMaxPoolSize", 1L);
        private SmartConfigValue<String> databasePassword = new SmartConfigValue("databasePassword", "");
        private SmartConfigValue<Boolean> databaseRemoteConnection = new SmartConfigValue("databaseRemoteConnection", false);
        private SmartConfigValue<String> databaseShowSql = new SmartConfigValue("databaseShowSql", "false");
        private SmartConfigValue<String> databaseStartupAction = new SmartConfigValue("databaseStartupAction", "update");
        private SmartConfigValue<String> databaseUrl = new SmartConfigValue("databaseUrl", "");
        private SmartConfigValue<String> databaseUsername = new SmartConfigValue("databaseUsername", "");
        private SmartConfigValue<String> version = new SmartConfigValue("version", "1.0.0");
        private final List<SmartConfigValue> ALL_PROPERTIES = Arrays.asList(
            databaseStartupAction,
            databaseRemoteConnection,
            databaseMaxActive,
            databaseShowSql,
            databaseDialect,
            databaseIdNewGeneratorMappings,
            connectionPort,
            version,
            connectionDatabaseRemotePort,
            databaseFormatSql,
            databaseMaxPoolSize,
            connectionHost,
            connectionUsername,
            databaseConnectionReleaseMode,
            connectionDatabaseLocalPort,
            connectionPassword,
            databaseDriver,
            databasePassword,
            databaseUsername,
            databaseUrl);

        public SmartConfigValue<Long> getConnectionDatabaseLocalPort() {
            return connectionDatabaseLocalPort;
        }

        public SmartConfigValue<Long> getConnectionDatabaseRemotePort() {
            return connectionDatabaseRemotePort;
        }

        public SmartConfigValue<String> getConnectionHost() {
            return connectionHost;
        }

        public SmartConfigValue<String> getConnectionPassword() {
            return connectionPassword;
        }

        public SmartConfigValue<Long> getConnectionPort() {
            return connectionPort;
        }

        public SmartConfigValue<String> getConnectionUsername() {
            return connectionUsername;
        }

        public SmartConfigValue<String> getDatabaseConnectionReleaseMode() {
            return databaseConnectionReleaseMode;
        }

        public SmartConfigValue<String> getDatabaseDialect() {
            return databaseDialect;
        }

        public SmartConfigValue<String> getDatabaseDriver() {
            return databaseDriver;
        }

        public SmartConfigValue<String> getDatabaseFormatSql() {
            return databaseFormatSql;
        }

        public SmartConfigValue<String> getDatabaseIdNewGeneratorMappings() {
            return databaseIdNewGeneratorMappings;
        }

        public SmartConfigValue<Long> getDatabaseMaxActive() {
            return databaseMaxActive;
        }

        public SmartConfigValue<Long> getDatabaseMaxPoolSize() {
            return databaseMaxPoolSize;
        }

        public SmartConfigValue<String> getDatabasePassword() {
            return databasePassword;
        }

        public SmartConfigValue<Boolean> getDatabaseRemoteConnection() {
            return databaseRemoteConnection;
        }

        public SmartConfigValue<String> getDatabaseShowSql() {
            return databaseShowSql;
        }

        public SmartConfigValue<String> getDatabaseStartupAction() {
            return databaseStartupAction;
        }

        public SmartConfigValue<String> getDatabaseUrl() {
            return databaseUrl;
        }

        public SmartConfigValue<String> getDatabaseUsername() {
            return databaseUsername;
        }

        public SmartConfigValue<String> getVersion() {
            return version;
        }

        public final <T> Optional<SmartConfigValue<T>> findPropertyByName(String propertyName) {
            for (int i = 0; i < ALL_PROPERTIES.size(); i++) {
                if (ALL_PROPERTIES.get(i).isNameSuitable(propertyName)) {
                    return Optional.of(ALL_PROPERTIES.get(i));
                }
            }

            return Optional.empty();
        }
    }

    private static class ProdPostgresSmartConfig implements SmartConfig {
        private SmartConfigValue<Long> connectionDatabaseLocalPort = new SmartConfigValue("connectionDatabaseLocalPort", 3307L);
        private SmartConfigValue<Long> connectionDatabaseRemotePort = new SmartConfigValue("connectionDatabaseRemotePort", 3306L);
        private SmartConfigValue<String> connectionHost = new SmartConfigValue("connectionHost", "");
        private SmartConfigValue<String> connectionPassword = new SmartConfigValue("connectionPassword", "");
        private SmartConfigValue<Long> connectionPort = new SmartConfigValue("connectionPort", 22L);
        private SmartConfigValue<String> connectionUsername = new SmartConfigValue("connectionUsername", "");
        private SmartConfigValue<String> databaseConnectionReleaseMode = new SmartConfigValue("databaseConnectionReleaseMode", "on_close");
        private SmartConfigValue<String> databaseDialect = new SmartConfigValue("databaseDialect", "org.hibernate.dialect.PostgreSQLDialect");
        private SmartConfigValue<String> databaseDriver = new SmartConfigValue("databaseDriver", "org.postgresql.Driver");
        private SmartConfigValue<String> databaseFormatSql = new SmartConfigValue("databaseFormatSql", "false");
        private SmartConfigValue<String> databaseIdNewGeneratorMappings = new SmartConfigValue("databaseIdNewGeneratorMappings", "false");
        private SmartConfigValue<Long> databaseMaxActive = new SmartConfigValue("databaseMaxActive", 15000L);
        private SmartConfigValue<Long> databaseMaxPoolSize = new SmartConfigValue("databaseMaxPoolSize", 1L);
        private SmartConfigValue<String> databasePassword = new SmartConfigValue("databasePassword", "");
        private SmartConfigValue<Boolean> databaseRemoteConnection = new SmartConfigValue("databaseRemoteConnection", false);
        private SmartConfigValue<String> databaseShowSql = new SmartConfigValue("databaseShowSql", "false");
        private SmartConfigValue<String> databaseStartupAction = new SmartConfigValue("databaseStartupAction", "update");
        private SmartConfigValue<String> databaseUrl = new SmartConfigValue("databaseUrl", "");
        private SmartConfigValue<String> databaseUsername = new SmartConfigValue("databaseUsername", "");
        private SmartConfigValue<String> version = new SmartConfigValue("version", "1.0.0");
        private final List<SmartConfigValue> ALL_PROPERTIES = Arrays.asList(
            databaseStartupAction,
            databaseRemoteConnection,
            databaseMaxActive,
            databaseShowSql,
            databaseDialect,
            databaseIdNewGeneratorMappings,
            connectionPort,
            version,
            connectionDatabaseRemotePort,
            databaseFormatSql,
            databaseMaxPoolSize,
            connectionHost,
            connectionUsername,
            databaseConnectionReleaseMode,
            connectionDatabaseLocalPort,
            connectionPassword,
            databaseDriver,
            databasePassword,
            databaseUsername,
            databaseUrl);

        public SmartConfigValue<Long> getConnectionDatabaseLocalPort() {
            return connectionDatabaseLocalPort;
        }

        public SmartConfigValue<Long> getConnectionDatabaseRemotePort() {
            return connectionDatabaseRemotePort;
        }

        public SmartConfigValue<String> getConnectionHost() {
            return connectionHost;
        }

        public SmartConfigValue<String> getConnectionPassword() {
            return connectionPassword;
        }

        public SmartConfigValue<Long> getConnectionPort() {
            return connectionPort;
        }

        public SmartConfigValue<String> getConnectionUsername() {
            return connectionUsername;
        }

        public SmartConfigValue<String> getDatabaseConnectionReleaseMode() {
            return databaseConnectionReleaseMode;
        }

        public SmartConfigValue<String> getDatabaseDialect() {
            return databaseDialect;
        }

        public SmartConfigValue<String> getDatabaseDriver() {
            return databaseDriver;
        }

        public SmartConfigValue<String> getDatabaseFormatSql() {
            return databaseFormatSql;
        }

        public SmartConfigValue<String> getDatabaseIdNewGeneratorMappings() {
            return databaseIdNewGeneratorMappings;
        }

        public SmartConfigValue<Long> getDatabaseMaxActive() {
            return databaseMaxActive;
        }

        public SmartConfigValue<Long> getDatabaseMaxPoolSize() {
            return databaseMaxPoolSize;
        }

        public SmartConfigValue<String> getDatabasePassword() {
            return databasePassword;
        }

        public SmartConfigValue<Boolean> getDatabaseRemoteConnection() {
            return databaseRemoteConnection;
        }

        public SmartConfigValue<String> getDatabaseShowSql() {
            return databaseShowSql;
        }

        public SmartConfigValue<String> getDatabaseStartupAction() {
            return databaseStartupAction;
        }

        public SmartConfigValue<String> getDatabaseUrl() {
            return databaseUrl;
        }

        public SmartConfigValue<String> getDatabaseUsername() {
            return databaseUsername;
        }

        public SmartConfigValue<String> getVersion() {
            return version;
        }

        public final <T> Optional<SmartConfigValue<T>> findPropertyByName(String propertyName) {
            for (int i = 0; i < ALL_PROPERTIES.size(); i++) {
                if (ALL_PROPERTIES.get(i).isNameSuitable(propertyName)) {
                    return Optional.of(ALL_PROPERTIES.get(i));
                }
            }

            return Optional.empty();
        }
    }

    private static class TestH2SmartConfig implements SmartConfig {
        private SmartConfigValue<Long> connectionDatabaseLocalPort = new SmartConfigValue("connectionDatabaseLocalPort", 3307L);
        private SmartConfigValue<Long> connectionDatabaseRemotePort = new SmartConfigValue("connectionDatabaseRemotePort", 3306L);
        private SmartConfigValue<String> connectionHost = new SmartConfigValue("connectionHost", "");
        private SmartConfigValue<String> connectionPassword = new SmartConfigValue("connectionPassword", "");
        private SmartConfigValue<Long> connectionPort = new SmartConfigValue("connectionPort", 22L);
        private SmartConfigValue<String> connectionUsername = new SmartConfigValue("connectionUsername", "");
        private SmartConfigValue<String> databaseConnectionReleaseMode = new SmartConfigValue("databaseConnectionReleaseMode", "on_close");
        private SmartConfigValue<String> databaseDialect = new SmartConfigValue("databaseDialect", "org.hibernate.dialect.MySQLDialect");
        private SmartConfigValue<String> databaseDriver = new SmartConfigValue("databaseDriver", "org.h2.Driver");
        private SmartConfigValue<String> databaseFormatSql = new SmartConfigValue("databaseFormatSql", "false");
        private SmartConfigValue<String> databaseIdNewGeneratorMappings = new SmartConfigValue("databaseIdNewGeneratorMappings", "false");
        private SmartConfigValue<Long> databaseMaxActive = new SmartConfigValue("databaseMaxActive", 15000L);
        private SmartConfigValue<Long> databaseMaxPoolSize = new SmartConfigValue("databaseMaxPoolSize", 1L);
        private SmartConfigValue<String> databasePassword = new SmartConfigValue("databasePassword", "");
        private SmartConfigValue<Boolean> databaseRemoteConnection = new SmartConfigValue("databaseRemoteConnection", false);
        private SmartConfigValue<String> databaseShowSql = new SmartConfigValue("databaseShowSql", "false");
        private SmartConfigValue<String> databaseStartupAction = new SmartConfigValue("databaseStartupAction", "create-drop");
        private SmartConfigValue<String> databaseUrl = new SmartConfigValue("databaseUrl", "");
        private SmartConfigValue<String> databaseUsername = new SmartConfigValue("databaseUsername", "");
        private SmartConfigValue<String> version = new SmartConfigValue("version", "1.0.0");
        private final List<SmartConfigValue> ALL_PROPERTIES = Arrays.asList(
            databaseStartupAction,
            databaseRemoteConnection,
            databaseMaxActive,
            databaseShowSql,
            databaseDialect,
            databaseIdNewGeneratorMappings,
            connectionPort,
            version,
            connectionDatabaseRemotePort,
            databaseFormatSql,
            databaseMaxPoolSize,
            connectionHost,
            connectionUsername,
            databaseConnectionReleaseMode,
            connectionDatabaseLocalPort,
            connectionPassword,
            databaseDriver,
            databasePassword,
            databaseUsername,
            databaseUrl);

        public SmartConfigValue<Long> getConnectionDatabaseLocalPort() {
            return connectionDatabaseLocalPort;
        }

        public SmartConfigValue<Long> getConnectionDatabaseRemotePort() {
            return connectionDatabaseRemotePort;
        }

        public SmartConfigValue<String> getConnectionHost() {
            return connectionHost;
        }

        public SmartConfigValue<String> getConnectionPassword() {
            return connectionPassword;
        }

        public SmartConfigValue<Long> getConnectionPort() {
            return connectionPort;
        }

        public SmartConfigValue<String> getConnectionUsername() {
            return connectionUsername;
        }

        public SmartConfigValue<String> getDatabaseConnectionReleaseMode() {
            return databaseConnectionReleaseMode;
        }

        public SmartConfigValue<String> getDatabaseDialect() {
            return databaseDialect;
        }

        public SmartConfigValue<String> getDatabaseDriver() {
            return databaseDriver;
        }

        public SmartConfigValue<String> getDatabaseFormatSql() {
            return databaseFormatSql;
        }

        public SmartConfigValue<String> getDatabaseIdNewGeneratorMappings() {
            return databaseIdNewGeneratorMappings;
        }

        public SmartConfigValue<Long> getDatabaseMaxActive() {
            return databaseMaxActive;
        }

        public SmartConfigValue<Long> getDatabaseMaxPoolSize() {
            return databaseMaxPoolSize;
        }

        public SmartConfigValue<String> getDatabasePassword() {
            return databasePassword;
        }

        public SmartConfigValue<Boolean> getDatabaseRemoteConnection() {
            return databaseRemoteConnection;
        }

        public SmartConfigValue<String> getDatabaseShowSql() {
            return databaseShowSql;
        }

        public SmartConfigValue<String> getDatabaseStartupAction() {
            return databaseStartupAction;
        }

        public SmartConfigValue<String> getDatabaseUrl() {
            return databaseUrl;
        }

        public SmartConfigValue<String> getDatabaseUsername() {
            return databaseUsername;
        }

        public SmartConfigValue<String> getVersion() {
            return version;
        }

        public final <T> Optional<SmartConfigValue<T>> findPropertyByName(String propertyName) {
            for (int i = 0; i < ALL_PROPERTIES.size(); i++) {
                if (ALL_PROPERTIES.get(i).isNameSuitable(propertyName)) {
                    return Optional.of(ALL_PROPERTIES.get(i));
                }
            }

            return Optional.empty();
        }
    }

    private static class TestMysqlSmartConfig implements SmartConfig {
        private SmartConfigValue<Long> connectionDatabaseLocalPort = new SmartConfigValue("connectionDatabaseLocalPort", 3307L);
        private SmartConfigValue<Long> connectionDatabaseRemotePort = new SmartConfigValue("connectionDatabaseRemotePort", 3306L);
        private SmartConfigValue<String> connectionHost = new SmartConfigValue("connectionHost", "");
        private SmartConfigValue<String> connectionPassword = new SmartConfigValue("connectionPassword", "");
        private SmartConfigValue<Long> connectionPort = new SmartConfigValue("connectionPort", 22L);
        private SmartConfigValue<String> connectionUsername = new SmartConfigValue("connectionUsername", "");
        private SmartConfigValue<String> databaseConnectionReleaseMode = new SmartConfigValue("databaseConnectionReleaseMode", "on_close");
        private SmartConfigValue<String> databaseDialect = new SmartConfigValue("databaseDialect", "org.hibernate.dialect.MySQLDialect");
        private SmartConfigValue<String> databaseDriver = new SmartConfigValue("databaseDriver", "com.mysql.jdbc.Driver");
        private SmartConfigValue<String> databaseFormatSql = new SmartConfigValue("databaseFormatSql", "false");
        private SmartConfigValue<String> databaseIdNewGeneratorMappings = new SmartConfigValue("databaseIdNewGeneratorMappings", "false");
        private SmartConfigValue<Long> databaseMaxActive = new SmartConfigValue("databaseMaxActive", 15000L);
        private SmartConfigValue<Long> databaseMaxPoolSize = new SmartConfigValue("databaseMaxPoolSize", 1L);
        private SmartConfigValue<String> databasePassword = new SmartConfigValue("databasePassword", "");
        private SmartConfigValue<Boolean> databaseRemoteConnection = new SmartConfigValue("databaseRemoteConnection", false);
        private SmartConfigValue<String> databaseShowSql = new SmartConfigValue("databaseShowSql", "false");
        private SmartConfigValue<String> databaseStartupAction = new SmartConfigValue("databaseStartupAction", "create-drop");
        private SmartConfigValue<String> databaseUrl = new SmartConfigValue("databaseUrl", "");
        private SmartConfigValue<String> databaseUsername = new SmartConfigValue("databaseUsername", "");
        private SmartConfigValue<String> version = new SmartConfigValue("version", "1.0.0");
        private final List<SmartConfigValue> ALL_PROPERTIES = Arrays.asList(
            databaseStartupAction,
            databaseRemoteConnection,
            databaseMaxActive,
            databaseShowSql,
            databaseDialect,
            databaseIdNewGeneratorMappings,
            connectionPort,
            version,
            connectionDatabaseRemotePort,
            databaseFormatSql,
            databaseMaxPoolSize,
            connectionHost,
            connectionUsername,
            databaseConnectionReleaseMode,
            connectionDatabaseLocalPort,
            connectionPassword,
            databaseDriver,
            databasePassword,
            databaseUsername,
            databaseUrl);

        public SmartConfigValue<Long> getConnectionDatabaseLocalPort() {
            return connectionDatabaseLocalPort;
        }

        public SmartConfigValue<Long> getConnectionDatabaseRemotePort() {
            return connectionDatabaseRemotePort;
        }

        public SmartConfigValue<String> getConnectionHost() {
            return connectionHost;
        }

        public SmartConfigValue<String> getConnectionPassword() {
            return connectionPassword;
        }

        public SmartConfigValue<Long> getConnectionPort() {
            return connectionPort;
        }

        public SmartConfigValue<String> getConnectionUsername() {
            return connectionUsername;
        }

        public SmartConfigValue<String> getDatabaseConnectionReleaseMode() {
            return databaseConnectionReleaseMode;
        }

        public SmartConfigValue<String> getDatabaseDialect() {
            return databaseDialect;
        }

        public SmartConfigValue<String> getDatabaseDriver() {
            return databaseDriver;
        }

        public SmartConfigValue<String> getDatabaseFormatSql() {
            return databaseFormatSql;
        }

        public SmartConfigValue<String> getDatabaseIdNewGeneratorMappings() {
            return databaseIdNewGeneratorMappings;
        }

        public SmartConfigValue<Long> getDatabaseMaxActive() {
            return databaseMaxActive;
        }

        public SmartConfigValue<Long> getDatabaseMaxPoolSize() {
            return databaseMaxPoolSize;
        }

        public SmartConfigValue<String> getDatabasePassword() {
            return databasePassword;
        }

        public SmartConfigValue<Boolean> getDatabaseRemoteConnection() {
            return databaseRemoteConnection;
        }

        public SmartConfigValue<String> getDatabaseShowSql() {
            return databaseShowSql;
        }

        public SmartConfigValue<String> getDatabaseStartupAction() {
            return databaseStartupAction;
        }

        public SmartConfigValue<String> getDatabaseUrl() {
            return databaseUrl;
        }

        public SmartConfigValue<String> getDatabaseUsername() {
            return databaseUsername;
        }

        public SmartConfigValue<String> getVersion() {
            return version;
        }

        public final <T> Optional<SmartConfigValue<T>> findPropertyByName(String propertyName) {
            for (int i = 0; i < ALL_PROPERTIES.size(); i++) {
                if (ALL_PROPERTIES.get(i).isNameSuitable(propertyName)) {
                    return Optional.of(ALL_PROPERTIES.get(i));
                }
            }

            return Optional.empty();
        }
    }

    private static class TestPostgresSmartConfig implements SmartConfig {
        private SmartConfigValue<Long> connectionDatabaseLocalPort = new SmartConfigValue("connectionDatabaseLocalPort", 3307L);
        private SmartConfigValue<Long> connectionDatabaseRemotePort = new SmartConfigValue("connectionDatabaseRemotePort", 3306L);
        private SmartConfigValue<String> connectionHost = new SmartConfigValue("connectionHost", "");
        private SmartConfigValue<String> connectionPassword = new SmartConfigValue("connectionPassword", "");
        private SmartConfigValue<Long> connectionPort = new SmartConfigValue("connectionPort", 22L);
        private SmartConfigValue<String> connectionUsername = new SmartConfigValue("connectionUsername", "");
        private SmartConfigValue<String> databaseConnectionReleaseMode = new SmartConfigValue("databaseConnectionReleaseMode", "on_close");
        private SmartConfigValue<String> databaseDialect = new SmartConfigValue("databaseDialect", "org.hibernate.dialect.PostgreSQLDialect");
        private SmartConfigValue<String> databaseDriver = new SmartConfigValue("databaseDriver", "org.postgresql.Driver");
        private SmartConfigValue<String> databaseFormatSql = new SmartConfigValue("databaseFormatSql", "false");
        private SmartConfigValue<String> databaseIdNewGeneratorMappings = new SmartConfigValue("databaseIdNewGeneratorMappings", "false");
        private SmartConfigValue<Long> databaseMaxActive = new SmartConfigValue("databaseMaxActive", 15000L);
        private SmartConfigValue<Long> databaseMaxPoolSize = new SmartConfigValue("databaseMaxPoolSize", 1L);
        private SmartConfigValue<String> databasePassword = new SmartConfigValue("databasePassword", "");
        private SmartConfigValue<Boolean> databaseRemoteConnection = new SmartConfigValue("databaseRemoteConnection", false);
        private SmartConfigValue<String> databaseShowSql = new SmartConfigValue("databaseShowSql", "false");
        private SmartConfigValue<String> databaseStartupAction = new SmartConfigValue("databaseStartupAction", "create-drop");
        private SmartConfigValue<String> databaseUrl = new SmartConfigValue("databaseUrl", "");
        private SmartConfigValue<String> databaseUsername = new SmartConfigValue("databaseUsername", "");
        private SmartConfigValue<String> version = new SmartConfigValue("version", "1.0.0");
        private final List<SmartConfigValue> ALL_PROPERTIES = Arrays.asList(
            databaseStartupAction,
            databaseRemoteConnection,
            databaseMaxActive,
            databaseShowSql,
            databaseDialect,
            databaseIdNewGeneratorMappings,
            connectionPort,
            version,
            connectionDatabaseRemotePort,
            databaseFormatSql,
            databaseMaxPoolSize,
            connectionHost,
            connectionUsername,
            databaseConnectionReleaseMode,
            connectionDatabaseLocalPort,
            connectionPassword,
            databaseDriver,
            databasePassword,
            databaseUsername,
            databaseUrl);

        public SmartConfigValue<Long> getConnectionDatabaseLocalPort() {
            return connectionDatabaseLocalPort;
        }

        public SmartConfigValue<Long> getConnectionDatabaseRemotePort() {
            return connectionDatabaseRemotePort;
        }

        public SmartConfigValue<String> getConnectionHost() {
            return connectionHost;
        }

        public SmartConfigValue<String> getConnectionPassword() {
            return connectionPassword;
        }

        public SmartConfigValue<Long> getConnectionPort() {
            return connectionPort;
        }

        public SmartConfigValue<String> getConnectionUsername() {
            return connectionUsername;
        }

        public SmartConfigValue<String> getDatabaseConnectionReleaseMode() {
            return databaseConnectionReleaseMode;
        }

        public SmartConfigValue<String> getDatabaseDialect() {
            return databaseDialect;
        }

        public SmartConfigValue<String> getDatabaseDriver() {
            return databaseDriver;
        }

        public SmartConfigValue<String> getDatabaseFormatSql() {
            return databaseFormatSql;
        }

        public SmartConfigValue<String> getDatabaseIdNewGeneratorMappings() {
            return databaseIdNewGeneratorMappings;
        }

        public SmartConfigValue<Long> getDatabaseMaxActive() {
            return databaseMaxActive;
        }

        public SmartConfigValue<Long> getDatabaseMaxPoolSize() {
            return databaseMaxPoolSize;
        }

        public SmartConfigValue<String> getDatabasePassword() {
            return databasePassword;
        }

        public SmartConfigValue<Boolean> getDatabaseRemoteConnection() {
            return databaseRemoteConnection;
        }

        public SmartConfigValue<String> getDatabaseShowSql() {
            return databaseShowSql;
        }

        public SmartConfigValue<String> getDatabaseStartupAction() {
            return databaseStartupAction;
        }

        public SmartConfigValue<String> getDatabaseUrl() {
            return databaseUrl;
        }

        public SmartConfigValue<String> getDatabaseUsername() {
            return databaseUsername;
        }

        public SmartConfigValue<String> getVersion() {
            return version;
        }

        public final <T> Optional<SmartConfigValue<T>> findPropertyByName(String propertyName) {
            for (int i = 0; i < ALL_PROPERTIES.size(); i++) {
                if (ALL_PROPERTIES.get(i).isNameSuitable(propertyName)) {
                    return Optional.of(ALL_PROPERTIES.get(i));
                }
            }

            return Optional.empty();
        }
    }
}
