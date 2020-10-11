package acropollis.municipali.security.common.config;

import com.bdev.smart.config.SmartConfig;
import com.bdev.smart.config.SmartConfigProperties;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.util.List;

public class PropertiesConfig {
    public static SmartConfig config;

    static {
        Config instanceConfig = getInstanceConfig();

        config = SmartConfigProperties.getConfig(
                instanceConfig.getString("env"),
                instanceConfig.getString("db")
        );

        config.getDatabaseRemoteConnection().override(instanceConfig.getBoolean("database.remoteConnection"));

        if (config.getDatabaseRemoteConnection().getValue()) {
            config.getConnectionHost().override(instanceConfig.getString("connection.host"));
            config.getConnectionUsername().override(instanceConfig.getString("connection.username"));
            config.getConnectionPassword().override(instanceConfig.getString("connection.password"));
        }

        config.getDatabaseUrl().override(instanceConfig.getString("database.url"));
        config.getDatabaseUsername().override(instanceConfig.getString("database.username"));
        config.getDatabasePassword().override(instanceConfig.getString("database.password"));
    }

    private static Config getInstanceConfig() {
        String configHome = System.getenv("CONFIG_HOME");

        if (configHome == null) {
            configHome = System.getProperty("CONFIG_HOME");
        }

        String configFilePath =
                configHome +
                        File.separator + "municipali-security" +
                        File.separator + "application.conf";

        return ConfigFactory.parseFile(new File(configFilePath));
    }
}
