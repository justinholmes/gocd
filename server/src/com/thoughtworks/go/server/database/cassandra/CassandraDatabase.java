package com.thoughtworks.go.server.database.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolOptions;
import com.datastax.driver.core.Session;
import org.springframework.stereotype.Component;

@Component
public class CassandraDatabase {
    private static final Cluster cluster = cassandraConnectionFactory();

    public static Session getConnection() {
        return cluster.connect();
    }

    private static Cluster cassandraConnectionFactory() {
        return Cluster.builder()
                .addContactPoints("localhost")
                .build();
    }
}
