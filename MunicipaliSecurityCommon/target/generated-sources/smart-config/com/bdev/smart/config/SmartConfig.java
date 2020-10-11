package com.bdev.smart.config;

import com.bdev.smart.config.data.SmartConfigValue;

import java.util.List;
import java.util.Optional;


public interface SmartConfig {
    <T> Optional<SmartConfigValue<T>> findPropertyByName(String propertyName);

    SmartConfigValue<Long> getConnectionDatabaseLocalPort();

    SmartConfigValue<Long> getConnectionDatabaseRemotePort();

    SmartConfigValue<String> getConnectionHost();

    SmartConfigValue<String> getConnectionPassword();

    SmartConfigValue<Long> getConnectionPort();

    SmartConfigValue<String> getConnectionUsername();

    SmartConfigValue<String> getDatabaseConnectionReleaseMode();

    SmartConfigValue<String> getDatabaseDialect();

    SmartConfigValue<String> getDatabaseDriver();

    SmartConfigValue<String> getDatabaseFormatSql();

    SmartConfigValue<String> getDatabaseIdNewGeneratorMappings();

    SmartConfigValue<Long> getDatabaseMaxActive();

    SmartConfigValue<Long> getDatabaseMaxPoolSize();

    SmartConfigValue<String> getDatabasePassword();

    SmartConfigValue<Boolean> getDatabaseRemoteConnection();

    SmartConfigValue<String> getDatabaseShowSql();

    SmartConfigValue<String> getDatabaseStartupAction();

    SmartConfigValue<String> getDatabaseUrl();

    SmartConfigValue<String> getDatabaseUsername();

    SmartConfigValue<String> getVersion();
}
