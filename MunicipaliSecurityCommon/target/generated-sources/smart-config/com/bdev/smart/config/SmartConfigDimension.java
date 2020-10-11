package com.bdev.smart.config;

public class SmartConfigDimension {
    public interface DB {
        static final String H2 = "H2";
        static final String MYSQL = "MYSQL";
        static final String POSTGRES = "POSTGRES";
    }

    public interface ENV {
        static final String PROD = "PROD";
        static final String TEST = "TEST";
    }
}
